package com.example.BootH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping("/library")
	public String showBooks (Model model) {
		
			
		model.addAttribute("library", service.findAll());
		return "books/library";
	}
}
