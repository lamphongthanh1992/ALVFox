package com.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.utils.GetPropertiesUtils;

@Controller
public class BasicController {

	@Autowired
	private GetPropertiesUtils properties;

	@RequestMapping(value={"", "index.html"})
	public String viewHomePage(Model model, @RequestParam(required=false) String method, HttpServletRequest request) {

		if(method != null && method.equals("logout")){	
			request.getSession().setAttribute("user",null);
		}
		
		System.out.println("test: " + properties.getTitle());
		model.addAttribute("properties", properties);
		
		return "index";
	}
	  
}
