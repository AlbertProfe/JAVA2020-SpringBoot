package com.example.shopExemple.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.shopExemple.boot.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
