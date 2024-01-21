package com.basic.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.entities.Sale;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("")
	public String viewHomePage(Model model) {
		System.out.println("test2");
		return "login";
	}
	
	 @RequestMapping(method = RequestMethod.POST)
	public String checkLogin() {
		System.out.println("test3");
		return "login";
	}

}
