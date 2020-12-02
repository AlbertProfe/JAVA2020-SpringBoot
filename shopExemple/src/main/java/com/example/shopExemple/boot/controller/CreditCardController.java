package com.example.shopExemple.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shopExemple.boot.service.CreditCardService;
import com.example.shopExemple.boot.service.CustomerService;
import com.example.shopExemple.boot.model.CreditCard;
import com.example.shopExemple.boot.model.Customer;



@Controller
@RequestMapping("/creditcards")
public class CreditCardController {

	@Autowired
	CreditCardService service;
	//@Autowired
	@Autowired
	CustomerService serviceCustomer;

	@RequestMapping("/show")
	public String showCreditCards (Model model) {

		model.addAttribute("cards", service.findAll());
		return "shoping/cards.html";
	}
	
	
	@RequestMapping("/addCreditCard")
	public String addCreditCard(Model model) {
		
		model.addAttribute("clients", serviceCustomer.findAll());
		
		return "shoping/addCard.html";
	}

	//@RequestMapping("/insertCreditCard")
	@RequestMapping(value = "/insertCreditCard", method = RequestMethod.POST)
	public String insertCreditCard(CreditCard creditCard, Model model,
			 @RequestParam("idCustomer") Long id) {
		
		System.out.println(id);
		
		Optional<Customer> foundCustomer = serviceCustomer.findById(id);
	

		// Search for a book with an invalid ID
		
		if (foundCustomer.isPresent()) creditCard.setCustomer(foundCustomer.get());
		else creditCard.setCustomer(null);
		
		service.insertCreditCard(creditCard);
		
		
		model.addAttribute("cards", service.findAll());
		return "shoping/cards.html";
	}
}