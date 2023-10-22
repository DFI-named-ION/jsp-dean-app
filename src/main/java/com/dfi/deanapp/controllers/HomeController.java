package com.dfi.deanapp.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Головна");
		return "home/index";
	}
	
	@GetMapping("/about")
	public String aboutPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Про сайт");
		return "home/about";
	}
	
	@GetMapping("/contacts")
	public String contactsPage(Model model) {
		model.addAttribute("pageTitle", "DeanOffice - Контакти");
		return "home/contacts";
	}
}
