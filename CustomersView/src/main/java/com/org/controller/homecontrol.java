package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontrol
{  
    @RequestMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
   @RequestMapping("/login")
   public String showLogin()
   {
	   return "login";
   }
   
   @RequestMapping("/register")
   public String showRegister()
   {
	   return "Register";
   }
}
