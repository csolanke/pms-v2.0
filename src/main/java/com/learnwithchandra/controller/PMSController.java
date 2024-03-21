package com.learnwithchandra.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithchandra.dto.StockDTO;
import com.learnwithchandra.entities.Stock;
import com.learnwithchandra.exceptions.StocksNotFoundException;
import com.learnwithchandra.mapper.StockMapper;
import com.learnwithchandra.service.StockService;

@RestController
@RequestMapping("/pms/v1")
public class PMSController {

	private StockMapper stockMapper;

	private StockService stockservice;

	public PMSController(StockMapper stockMapper, StockService stockService) {
		this.stockMapper = stockMapper;
		this.stockservice = stockService;

	}

	@GetMapping("/stocks")
	public ResponseEntity<List<Stock>> getListRealHoldings() {

		try {
			List<Stock> stocks = stockservice.getAllStocks();
			if (stocks.isEmpty()) {
				throw new StocksNotFoundException("There are no stocks present in portfolio");
			}
			return new ResponseEntity<>(stocks, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/stocks")
	public ResponseEntity<StockDTO> addStock(@RequestBody StockDTO stockDto) {

		Stock stock = stockMapper.dtoTOEntity(stockDto);
		try {
			stockservice.addStock(stock);
			return new ResponseEntity<>(stockDto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/stocks/{id}")
	public ResponseEntity<String> removeStockFromHoldings(@PathVariable("id") String id) {

		try {
			if (Boolean.TRUE.equals(stockservice.stockExistsById(id))) {
				stockservice.deletefromHoldings(id);
				return new ResponseEntity<>("stock with ID " + id + " deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("stock with ID " + id + " not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting stock with ID " + id + ": " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
