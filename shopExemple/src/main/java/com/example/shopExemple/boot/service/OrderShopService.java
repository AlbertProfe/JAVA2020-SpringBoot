package com.example.shopExemple.boot.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopExemple.boot.model.OrderShop;

import com.example.shopExemple.boot.repository.OrderShopRepository;


@Service
public class OrderShopService {

	@Autowired
	OrderShopRepository repository;

	public Iterable<OrderShop> findAll() {

		return repository.findAll();
	}

	public void insertOrder (OrderShop order) {

		repository.save(order);
	}

	public Optional<OrderShop> findById(long id) {

		return repository.findById(id);
	}
		
	public void setStatusOrderShop(HttpSession session) {

		Optional<OrderShop> orderShopFound = this.findById((Long) session.getAttribute("idShop"));

		if (orderShopFound.isPresent()) {

			OrderShop orderShopStatusUpdate = orderShopFound.get();
			orderShopStatusUpdate.setStatusShop(session.getAttribute("status").toString());

			this.insertOrder(orderShopStatusUpdate);

		}

	}

}