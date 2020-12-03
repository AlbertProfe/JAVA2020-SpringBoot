package com.example.shopExemple.boot.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopExemple.boot.model.OrderDetail;
import com.example.shopExemple.boot.model.OrderShop;
import com.example.shopExemple.boot.repository.OrderDetailRepository;


@Service
public class OrderDetailService {

	@Autowired
	OrderDetailRepository repository;

	public Iterable<OrderDetail> findAll() {

		return repository.findAll();
	}

	public void insertOrderDetail(OrderDetail order) {

		repository.save(order);
	}

	public Optional<OrderDetail> findById(long id) {

		return repository.findById(id);
	}
}