package com.learnwithchandra.mapper;

import org.springframework.stereotype.Component;

import com.learnwithchandra.dto.StockDTO;
import com.learnwithchandra.entities.Stock;

@Component
public class StockMapper {
	
	
	
public Stock dtoTOEntity(StockDTO dto) {
	
	if(dto!=null) {
		Stock stock = new Stock();
		      
		stock.setID(dto.getId());
		stock.setAmountInvested(dto.getAmountInvested());
		stock.setCurrentValueOfInvestment(dto.getCurrentValueOfInvestment());
		stock.setName(dto.getName());
		stock.setPricePurchased(dto.getPricePurchased());
		stock.setPurchaseDate(dto.getPurchaseDate());
		stock.setPurchaseStrategy(dto.getPurchaseStrategy());
		stock.setQuantityPurchased(dto.getQuantityPurchased());
		
		return stock;
		
	}
	
	return null;
	
}
	
	

}
