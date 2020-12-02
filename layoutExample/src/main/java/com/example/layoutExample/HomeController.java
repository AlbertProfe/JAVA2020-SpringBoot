package com.example.layoutExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

	@GetMapping("/home")
	public String index(Model model) {

		model.addAttribute("message", "Thank you for visiting.");

		return "index";
	}

	@GetMapping("/customers")
	public String customersShow() {
		
		return "customers";
	}

	@GetMapping("/products")
	public String productsShow() {
		
		return "products";
	}

	@GetMapping("/buy")
	public String buy() {
		
		return "buy";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}

}