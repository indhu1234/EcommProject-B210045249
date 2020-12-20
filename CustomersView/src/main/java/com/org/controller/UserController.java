package com.org.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
	    users.setRole("ROLE_USER");
	    users.setEnabled(true);
	     
	    userDAO.registerUser(users);
	    System.out.println("User added");
		return "login";
	}
   
   @RequestMapping("login_success")
     public String login(HttpSession session,Model m)
     { 
	   String page="";
		System.out.println("Login success method");
		boolean loggedIn=false;
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		m.addAttribute("username",username);
	
		System.out.println("User name : "+username);

		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();

		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			System.out.println("Authority "+role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				List<Product> productList=productDAO.listProducts();
				m.addAttribute("productList", productList);
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		return page;
	   
	   //return "productDisplay";
     }
   
	@RequestMapping("/perform_logout")
	public String loggingout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}

}
