package com.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basic.dao.UserDAO;
import com.basic.entities.User;
import com.basic.utils.GetPropertiesUtils;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private GetPropertiesUtils properties;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("")
	public String viewHomePage(Model model) {
		System.out.println("test2");
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	 @RequestMapping(method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("User") User user, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userData = userDAO.findUser(user.getUsername(),user.getPassword());
		if (userData != null) {
			session.setAttribute("user",userData);
			model.addAttribute("properties", properties);
			return "redirect:index.html";
		} else {
			return "login";
		}
		
	}

}
