package com.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.dao.SalesDAO;
import com.basic.entities.Sale;
import com.basic.utils.GetPropertiesUtils;

@Controller
//@RequestMapping("/api/v1/sessions")
public class BasicController {
	
	@Autowired
	private SalesDAO dao;
	@Autowired
	private GetPropertiesUtils properties;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("test");
		System.out.println("test: " + properties.getTitle());
		List<Sale> listSale = dao.list();
		model.addAttribute("listSale", listSale);
		model.addAttribute("properties", properties);
		return "index";
	}
	  
}
