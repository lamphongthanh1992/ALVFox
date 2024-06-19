package com.basic.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.dao.UserDAO;
import com.basic.entities.User;
import com.basic.repository.UserRepository;
import com.basic.utils.GetPropertiesUtils;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/login")
	public String viewHomePage(Model model,HttpServletRequest request) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("User") User user, Model model, HttpServletRequest request,@RequestParam(name="currentPage",required=false) String currentPage) {
		HttpSession session = request.getSession();
		List<User> userData1 = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if (userData1.isEmpty()) {
			model.addAttribute("errorMessage", "Invalid User Or Password");
			return "login";
		} else {
			session.setAttribute("user", userData1.get(0));
			if ((currentPage == null) || (currentPage.equals("null"))) {
				return "redirect:index.html";
			} else { 
				return "redirect:" + currentPage;
			}
		}
	}

	@RequestMapping("/register")
	public String register(Model model) {
		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("User") User user, Model model, HttpServletRequest request) {
		try {
			User userResult = userRepository.save(user);
			if(userResult == null) {
				model.addAttribute("message", "Cannot Create User");
				return "register";
			} else {
				return "redirect:login";
			}
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("message", "Duplicate Username or Email");
			return "register";
		} 
		

	}

}
