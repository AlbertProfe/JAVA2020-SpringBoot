package com.example.shopExemple.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.shopExemple.boot.model.OrderShop;

public interface OrderShopRepository extends CrudRepository<OrderShop, Long> {

}
