package com.example.shopExemple.boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderShop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDSHOP")
	private Long idShop;
	@Column(name = "TIMESTAMPSHOP")
	private String timeStampShop;
	@Column(name = "STATUSSHOP")
	private String statusShop;
	@Column(name = "SESSIONORDERSHOP")
	private String sessionOrderShop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID_FK", nullable = true)
	@JsonIgnore
	private Customer customer;

	@OneToMany(mappedBy = "orderShop", fetch = FetchType.LAZY)
	// @JsonIgnore 
	private List<OrderDetail> ordersDetail;

	public OrderShop() {
	}

	public OrderShop(Long idShop, String timeStampShop, String statusShop, String idSessionShop, Customer customer) {
		super();
		this.idShop = idShop;
		this.timeStampShop = timeStampShop;
		this.statusShop = statusShop;
		this.sessionOrderShop = idSessionShop;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderShop [idShop=" + idShop + ", timeStampShop=" + timeStampShop + ", statusShop=" + statusShop
				+ ", idSessionShop=" + sessionOrderShop + ", customer=" + customer + "]";
	}

	public Long getIdShop() {
		return idShop;
	}

	public void setIdShop(Long idShop) {
		this.idShop = idShop;
	}

	public String getTimeStampShop() {
		return timeStampShop;
	}

	public void setTimeStampShop(String timeStampShop) {
		this.timeStampShop = timeStampShop;
	}

	public String getStatusShop() {
		return statusShop;
	}

	public void setStatusShop(String statusShop) {
		this.statusShop = statusShop;
	}

	public String getIdSessionShop() {
		return sessionOrderShop;
	}

	public void setIdSessionShop(String idSessionShop) {
		this.sessionOrderShop = idSessionShop;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSessionOrderShop() {
		return sessionOrderShop;
	}

	public void setSessionOrderShop(String sessionOrderShop) {
		this.sessionOrderShop = sessionOrderShop;
	}

	public List<OrderDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(List<OrderDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	
}
