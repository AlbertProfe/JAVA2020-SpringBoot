package com.example.BootH2;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	static List<Book> library = new ArrayList<Book>();
	
	static {
		
		Book book1= new Book("Anna Karenina","wdcyA15-252S38",568, 1872, "Leon Tolstoi");
		Book book2= new Book("The LightHouse","oSDGA15-278912",356, 1926, "Virginia Wolf");
		Book book3= new Book("War and Peace","BAgyg15-250092",528, 1872, "Leon Tolstoi");
		Book book4= new Book("Orlando","yuplA15-340112",356, 1926, "Virginia Wolf");
		library.add(book1);
		library.add(book2);
		library.add(book3);
		library.add(book4);
	}
	
	
	public List<Book> findAll() {
		
		return library;
	}
	
	
	
}
