package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.StockExchange;
import com.example.stockspring.service.StockExchangeService;

@Controller
public class StockExchangeControllerImpl {
	@Autowired
	private StockExchangeService stockexchangeService;
	
	@RequestMapping(value="/stockexchange" ,method=RequestMethod.GET)
	public String getStockForm(ModelMap model) {
		StockExchange stockexchange=new StockExchange();
		model.addAttribute("stock", stockexchange);
		return "stockExchange";
	}
	
	@RequestMapping(value="/stockexchange", method=RequestMethod.POST)
	public String FormHandler(@Valid @ModelAttribute("stock")StockExchange stockexchange,BindingResult result,Model model)throws SQLException{
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "stockExchange";
		}
		stockexchangeService.insertStock(stockexchange);
		return "redirect:/stockList";
		
	}
	
	@RequestMapping(value="/stockList")
	public ModelAndView getStockList()throws Exception{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("stockexchangeList");
		modelview.addObject("stockexchangeList",stockexchangeService.getStockList());
		return modelview;
		
	}

}
