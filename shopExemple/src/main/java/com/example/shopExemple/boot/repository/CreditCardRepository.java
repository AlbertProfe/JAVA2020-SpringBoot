package com.example.shopExemple.boot.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.shopExemple.boot.model.CreditCard;


public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

	CreditCard findById(long id);
}