package com.basic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.dao.SalesDAO;
import com.basic.dao.UserDAO;
import com.basic.entities.Sale;
import com.basic.entities.User;
import com.basic.utils.GetPropertiesUtils;

@Controller
//@RequestMapping("/api/v1/sessions")
public class BasicController {
	
	@Autowired
	private SalesDAO dao;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private GetPropertiesUtils properties;

	@RequestMapping(value={"", "index.html"})
	public String viewHomePage(Model model, @RequestParam(required=false) String method, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(method != null && method.equals("logout")){	
			request.getSession().setAttribute("user",null);
		}
		
		System.out.println("test");
		System.out.println("test: " + properties.getTitle());
//		List<Sale> listSale = dao.list();
//		List<User> listUser = userDAO.list();
//		User user = userDAO.findUser("lamphongthanh1992", "123");
//		model.addAttribute("listSale", listSale);
		
		model.addAttribute("properties", properties);
		return "index";
	}
	  
}
