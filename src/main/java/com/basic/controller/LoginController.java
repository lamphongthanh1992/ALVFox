package com.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.dao.UserDAO;
import com.basic.entities.User;
import com.basic.utils.GetPropertiesUtils;

@Controller
public class LoginController {

	@Autowired
	private GetPropertiesUtils properties;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/login")
	public String viewHomePage(Model model) {
		System.out.println("test2: ");
		model.addAttribute("properties", properties);
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	public String checkisAlreadyLogin(User userData, String currentPage,Model model, HttpSession session) {
		if (userData != null) {
			session.setAttribute("user", userData);
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

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("User") User user, Model model, HttpServletRequest request,@RequestParam(name="currentPage",required=false) String currentPage) {
		HttpSession session = request.getSession();
		model.addAttribute("properties", properties);
		User userData = userDAO.findUser(user.getUsername(), user.getPassword());
	
		System.out.println("redirtectPage: " + currentPage);
		return checkisAlreadyLogin(userData, currentPage, model, session);
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("properties", properties);
		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("User") User user, Model model, HttpServletRequest request) {
		model.addAttribute("properties", properties);
		int isSucess = userDAO.createUser(user);
		if (isSucess == 1) {
			return "redirect:login";
		} else {
			return "register";
		}

	}

}
