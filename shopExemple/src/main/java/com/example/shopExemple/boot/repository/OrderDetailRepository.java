package com.example.shopExemple.boot.repository;



import org.springframework.data.repository.CrudRepository;

import com.example.shopExemple.boot.model.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

}
