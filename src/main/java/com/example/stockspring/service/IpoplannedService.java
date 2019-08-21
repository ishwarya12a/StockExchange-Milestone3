package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Ipoplanned;


public interface IpoplannedService {
	public Ipoplanned insertIpo(Ipoplanned ipoplanned)throws SQLException;
	public List<Ipoplanned> getIpoList()throws SQLException;

}
