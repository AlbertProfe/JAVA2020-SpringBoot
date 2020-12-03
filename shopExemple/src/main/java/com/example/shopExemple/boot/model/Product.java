package com.example.shopExemple.boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "BRAND")
	private String brand;
	@Column(name = "MADEIN")
	private String madein;
	@Column(name = "PRICE")
	private double price;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JsonIgnore private List<Order> orders;
	private List<OrderDetail> ordersDetail;

	public Product() {
	}

	public Product(Long id, String name, String brand, String madein, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<OrderDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(List<OrderDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

}
