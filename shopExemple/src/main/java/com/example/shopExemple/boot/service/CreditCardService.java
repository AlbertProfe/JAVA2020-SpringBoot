package com.example.shopExemple.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopExemple.boot.model.CreditCard;
import com.example.shopExemple.boot.repository.CreditCardRepository;


@Service
public class CreditCardService {

	@Autowired
	CreditCardRepository repository;


	public Iterable<CreditCard> findAll() {

		return repository.findAll();
	}

	public void insertCreditCard (CreditCard creditcard) {

		repository.save(creditcard);
	}

}
