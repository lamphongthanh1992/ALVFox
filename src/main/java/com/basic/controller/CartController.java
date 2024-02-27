package com.basic.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basic.entities.User;
import com.basic.utils.GetPropertiesUtils;


@Controller
public class CartController {
	
	@Autowired
	private GetPropertiesUtils properties;
	
	public String checkisAlreadyLogin(User userData, String currentPage,Model model, HttpSession session) {
		if (userData != null) {
	
			if ((currentPage == null) || (currentPage.equals("null"))) {
				return "redirect:index.html";
			} else { 
				System.out.println("redirtectPage2: "+currentPage);
				return "redirect:" + currentPage;
			}
		}
		
		model.addAttribute("errorMessage", "Invalid User Or Password");
		return "login";
	}
	
	@RequestMapping("/cart")
	public String viewHomePage(Model model, HttpServletRequest request) {
		model.addAttribute("properties", properties);
		HttpSession session = request.getSession();
		User userData = (User)session.getAttribute("user");
		
		/*
		 * if (userData != null) { return "cart"; } else { return }
		 */
		return "cart";
	}
}
