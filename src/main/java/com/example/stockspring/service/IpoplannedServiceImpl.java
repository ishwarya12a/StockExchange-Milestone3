package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.IpoplannedDao;
import com.example.stockspring.model.Ipoplanned;
@Service
public class IpoplannedServiceImpl implements IpoplannedService{
	@Autowired
	private IpoplannedDao ipoplannedDao;
	@Override
	public Ipoplanned insertIpo(Ipoplanned ipoplanned) throws SQLException {
		// TODO Auto-generated method stub
		return ipoplannedDao.save(ipoplanned);
	}

	@Override
	public List<Ipoplanned> getIpoList() throws SQLException {
		// TODO Auto-generated method stub
		return ipoplannedDao.findAll();
	}

}
