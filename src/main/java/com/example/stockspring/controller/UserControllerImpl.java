package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.stockspring.model.User;
import com.example.stockspring.service.UserService;

@Controller
public class UserControllerImpl {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/usersignup", method= RequestMethod.GET)
	public String getUserForm(ModelMap model) {
		User user=new User();
		model.addAttribute("user",user);
		return "userSignup";
		
	}
	
	@RequestMapping(value="/usersignup", method= RequestMethod.POST)
	public String formHandler(@Valid User user,Model model)throws SQLException{
		userService.insertUser(user);
		return "userLogin";
		
	}

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin(ModelMap model,HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		int id=(int)session.getAttribute("userId");
		String password=(String)session.getAttribute("password");
		return null;
		
	}
}
