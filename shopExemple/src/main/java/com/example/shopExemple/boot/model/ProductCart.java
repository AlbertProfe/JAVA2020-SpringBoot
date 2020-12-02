package com.example.shopExemple.boot.model;


public class ProductCart {
	
	private Product product;
	private int quantity;
	
	public ProductCart() {}
		
	public ProductCart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductCart [product=" + product + ", quantity=" + quantity + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
