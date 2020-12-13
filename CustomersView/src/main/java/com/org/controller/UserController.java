package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.DAO.CategoryDaoIntf;
import com.org.DAO.UserDAO;
import com.org.DAO.productDao;
import com.org.Model.Category;
import com.org.Model.Product;
import com.org.Model.UserDetail;

@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	@Autowired
	CategoryDaoIntf categoryDAO;
	@Autowired
   productDao productDAO;
   @RequestMapping("/addUser")
	public String addUsers(@RequestParam("user") String user,
		@RequestParam("name")String name, 
		@RequestParam("password")String password,
		@RequestParam("address")String address,
		@RequestParam("mobile")String mobile,
		@RequestParam("email")String email, Model m)
	
	{
	   UserDetail users=new UserDetail();
	    users.setCustomerName(user);
	    users.setUsername(name);
	    users.setPassword(password);
	    users.setAddress(address);
	    users.setEmailId(email);
	    users.setMobileNo(mobile);
	    users.setRole("user");
	    users.setEnabled(true);
	     
	    userDAO.registerUser(users);
	    System.out.println("User added");
		return "login";
	}
   
   @RequestMapping("loginSuccess")
     public String login(Model m)
     { 
	   
    	 return "productDisplay";
     }
}
