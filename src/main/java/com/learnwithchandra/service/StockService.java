package com.learnwithchandra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnwithchandra.entities.Stock;
import com.learnwithchandra.repository.StockRepository;

@Service
public class StockService {
	
private StockRepository stockRepository; 

public StockService(StockRepository stockRepository)
{
	this.stockRepository=stockRepository;
	
}


public Stock addStock(Stock stock) {
	
	stockRepository.save(stock);
	
	return stock;
	
	
}

public List<Stock> getAllPortfolioStocks(){
	
	return  stockRepository.findAll();
	
}



}
