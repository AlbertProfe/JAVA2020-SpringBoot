package com.example.shopExemple.boot.rest.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopExemple.boot.model.Customer;
import com.example.shopExemple.boot.service.CustomerService;

@RestController
@RequestMapping("/webapi")
public class CustomerRestController {

	@Autowired
	CustomerService service;
	
	
	@GetMapping("/customers")
	public Iterable<Customer> findAll() {

		return service.findAll();
	}
	
	
	

}
