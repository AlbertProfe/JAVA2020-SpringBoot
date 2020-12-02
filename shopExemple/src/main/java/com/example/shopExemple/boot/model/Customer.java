package com.example.shopExemple.boot.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	// ...
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<CreditCard> creditCards;

	public Customer() {}
	

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<CreditCard> getCreditCard() {
		return creditCards;
	}

	
	  public void setCreditCard(List<CreditCard> creditCards) { 
		  this.creditCards = creditCards; }
	 

		/*
		 * public void addCreditCard (CreditCard creditcard) {
		 * creditCards.add(creditcard); creditcard.setCustomer(this);
		 * 
		 * }
		 */
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}