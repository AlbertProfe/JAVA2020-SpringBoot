package com.example.shopExemple.boot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	
	 	  
	  @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private Date date;
		private String status;

		
		
}
