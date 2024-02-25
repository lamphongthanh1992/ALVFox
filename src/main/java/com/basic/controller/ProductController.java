package com.basic.controller;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.dao.ProductDAO;
import com.basic.entities.Product;
import com.basic.utils.GetPropertiesUtils;
import com.basic.utils.TextUtils;

@Controller
public class ProductController {
	@Autowired
	private GetPropertiesUtils properties;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/allProducts")
	public String viewHomePage(Model model) {
		model.addAttribute("properties", properties);
		List<Product> list = productDAO.list();

		
		TextUtils textUtils = new TextUtils();
		model.addAttribute("listProduct",list);
		model.addAttribute("textUtils",textUtils);
		
		return "shop";
	}
}
