package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Ipoplanned;
import com.example.stockspring.service.IpoplannedService;

@Controller
public class IpoplannedControllerImpl {
	@Autowired
	private IpoplannedService ipoplannedService;
	
	@RequestMapping(value="/ipoplanned" ,method=RequestMethod.GET)
	public String getStockForm(ModelMap model) {
		Ipoplanned ipo=new Ipoplanned();
		model.addAttribute("ipo", ipo);
		return "ipoPlanned";
	}
	
	@RequestMapping(value="/ipoplanned", method=RequestMethod.POST)
	public String FormHandler(@Valid Ipoplanned ipoplanned,Model model)throws SQLException{
		ipoplannedService.insertIpo(ipoplanned);
		return "redirect:/ipoList";
		
	}
	
	@RequestMapping(value="/ipoList")
	public ModelAndView getIpoList()throws Exception{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("ipoList");
		modelview.addObject("ipoList",ipoplannedService.getIpoList());
		return modelview;
		
	}
}
