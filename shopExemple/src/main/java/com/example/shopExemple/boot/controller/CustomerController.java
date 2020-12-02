package com.example.shopExemple.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopExemple.boot.model.CreditCard;
import com.example.shopExemple.boot.model.Customer;
import com.example.shopExemple.boot.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping("/show")
	public String showCusotmers(Model model) {

		model.addAttribute("clients", service.findAll());
		return "shoping/clients.html";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer (Model model) {
		
		return "shoping/addClient.html";
	}

	@RequestMapping("/insertCustomer")
	public String insertCreditCard(Customer customer,Model model) {
		
		service.insertCustomer(customer);
			
		model.addAttribute("clients", service.findAll());
		return "shoping/clients.html";
	}
	
	
}