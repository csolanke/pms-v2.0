package com.learnwithchandra.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithchandra.dto.StockDTO;
import com.learnwithchandra.entities.Stock;
import com.learnwithchandra.mapper.StockMapper;
import com.learnwithchandra.service.StockService;

@RestController
@RequestMapping("/pms/v1")
public class  PMSController 
{

private StockMapper stockMapper;

private StockService stockservice;


public PMSController(StockMapper stockMapper, StockService stockService)
{
	this.stockMapper=stockMapper;
	this.stockservice=stockService;
	
}

@GetMapping("/fetch-holdings")
public ResponseEntity<List<Stock> > getAllHoldings()
{
   
	return new ResponseEntity<>(Arrays.asList(
			new Stock(1, "Action construction Limited", 199.0, 50, "2024-01-01", 200000.0, 23000000.0,
					"cup with handle breakut"),
			new Stock(1, "Banari Sugar", 299.0, 50, "2024-02-01", 200000.0, 23000000.0, "cup with handle breakut"),
			new Stock(1, "Sanghavi Movers", 399.0, 50, "2024-01-03", 100000.0, 24000000.0, "Multi year breakout"),
			new Stock(1, "TIINDIA", 499.0, 50, "2024-04-01", 300000.0, 25000000.0, "Symmetrical Triagle pattern"),
			new Stock(1, "United Spirits", 599.0, 50, "2024-05-01", 400000.0, 26000000.0, "Ascending trinage pattern"),
			new Stock(0, "ABRFL", 599.0, 50, "2024-05-01", 400000.0, 26000000.0, "Ascending trinage pattern")),
			HttpStatus.OK);
    
}



@GetMapping("/fetch-real-holdings")
public ResponseEntity<List<Stock>> getListRealHoldings(){
	
	return new  ResponseEntity<>(stockservice.getAllPortfolioStocks(),HttpStatus.OK);
}


@PostMapping("/stock")
public ResponseEntity<StockDTO> addNewStockToHoldings(@RequestBody StockDTO stockDto){
	
	  Stock stock =stockMapper.dtoTOEntity(stockDto);
	  
	  stockservice.addStock(stock);
	
	return new ResponseEntity<>(stockDto,HttpStatus.CREATED);
}







	
	
	
	
	

}
