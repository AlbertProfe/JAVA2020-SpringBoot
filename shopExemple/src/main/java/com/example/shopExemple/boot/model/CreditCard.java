package com.example.shopExemple.boot.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String typeCreditCard;
	private String numberCreditCard;
	private int loan;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID_FK", nullable = true)
	@JsonIgnore
	private Customer customer;
	
	public CreditCard() {}
	
	
	public CreditCard(Long id, String typeCreditCard, String numberCreditCard, int loan) {
		super();
		this.id = id;
		this.typeCreditCard = typeCreditCard;
		this.numberCreditCard = numberCreditCard;
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", typeCreditCard=" + typeCreditCard + ", numberCreditCard=" + numberCreditCard
				+ ", loan=" + loan + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeCreditCard() {
		return typeCreditCard;
	}

	public void setTypeCreditCard(String typeCreditCard) {
		this.typeCreditCard = typeCreditCard;
	}

	public String getNumberCreditCard() {
		return numberCreditCard;
	}

	public void setNumberCreditCard(String numberCreditCard) {
		this.numberCreditCard = numberCreditCard;
	}

	public int getLoan() {
		return loan;
	}

	public void setLoan(int loan) {
		this.loan = loan;
	}

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	



	
	

}
