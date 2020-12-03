package com.example.shopExemple.boot.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDORDERDETAIL")
	private Long idOrderDetail;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERSHOP_ID_FK", nullable = true)
	@JsonIgnore
	private OrderShop orderShop;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID_FK", nullable = true)
	@JsonIgnore
	private Product product;

	public OrderDetail() {};

	public OrderDetail(Long idOrderDetail, int quantity, OrderShop orderShop, Product product) {
		super();
		this.idOrderDetail = idOrderDetail;
		this.quantity = quantity;
		this.orderShop = orderShop;
		this.product = product;
	}


	@Override
	public String toString() {
		return "OrderDetail [idOrderDetail=" + idOrderDetail + ", quantity=" + quantity + ", orderShop=" + orderShop
				+ ", product=" + product + "]";
	}


	public Long getIdOrderDetail() {
		return idOrderDetail;
	}


	public void setIdOrderDetail(Long idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public OrderShop getOrderShop() {
		return orderShop;
	}


	public void setOrderShop(OrderShop orderShop) {
		this.orderShop = orderShop;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
}
