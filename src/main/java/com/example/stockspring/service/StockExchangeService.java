package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.StockExchange;

public interface StockExchangeService {
	public StockExchange insertStock(StockExchange stockExchange)throws SQLException;
	public List<StockExchange> getStockList()throws SQLException;
}
