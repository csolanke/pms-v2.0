package com.learnwithchandra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnwithchandra.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long>{
	
	

}
