package com.example.stockspring.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.stockspring.model.Stockprice;

public interface StockpriceDao extends JpaRepository<Stockprice,Integer> {
	public List<Stockprice> findByCompanyCode(@Param("companyCode")int companyCode);
	@Query("select s from Stockprice s where s.date BETWEEN :fromdate AND :todate")
	 public List<Stockprice> findBydate(@Param("fromdate")Date fromdate,@Param("todate")Date todate);
	 
}
