package com.example.BootH2;


public class Book {

	private String title;
	private String ISBN;
	private int pages;
	private int year;
	private String author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String Title) {
		this.title = Title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(String title, String ISBN, int pages) {
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
	}
	public Book() {
		super();
	}
	public Book(String title, String iSBN, int pages, int year, String author) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.pages = pages;
		this.year = year;
		this.author = author;
	}
	
	
	
	
}
