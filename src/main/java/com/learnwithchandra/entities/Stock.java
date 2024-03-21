package com.learnwithchandra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
	
	@Id
	private Integer id;
	private String name;
	private Double pricePurchased;
	private Integer quantityPurchased;
	private String purchaseDate;
	private Double amountInvested;
	private Double currentValueOfInvestment;
	private String purchaseStrategy;
	
	
	public Stock () {
		super();
	}
	
	
	
	public Stock(Integer iD, String name, Double pricePurchased, Integer quantityPurchased, String purchaseDate,
			Double amountInvested, Double currentValueOfInvestment, String purchaseStrategy) {
		super();
		id = iD;
		this.name = name;
		this.pricePurchased = pricePurchased;
		this.quantityPurchased = quantityPurchased;
		this.purchaseDate = purchaseDate;
		this.amountInvested = amountInvested;
		this.currentValueOfInvestment = currentValueOfInvestment;
		this.purchaseStrategy = purchaseStrategy;
	}
	public Integer getID() {
		return id;
	}
	public void setID(Integer iD) {
		id = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPricePurchased() {
		return pricePurchased;
	}
	public void setPricePurchased(Double pricePurchased) {
		this.pricePurchased = pricePurchased;
	}
	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(Double amountInvested) {
		this.amountInvested = amountInvested;
	}
	public Double getCurrentValueOfInvestment() {
		return currentValueOfInvestment;
	}
	public void setCurrentValueOfInvestment(Double currentValueOfInvestment) {
		this.currentValueOfInvestment = currentValueOfInvestment;
	}
	public String getPurchaseStrategy() {
		return purchaseStrategy;
	}
	public void setPurchaseStrategy(String purchaseStrategy) {
		this.purchaseStrategy = purchaseStrategy;
	}
	
	

}
