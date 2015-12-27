package com.springapp.mvc;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		model.addAttribute("message", "Hello user " + userName + "!");
		return "user";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		model.addAttribute("message", "Hello admin " + userName + "!");
		return "user";
	}

}