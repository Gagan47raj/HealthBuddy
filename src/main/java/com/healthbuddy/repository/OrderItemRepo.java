package com.healthbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbuddy.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
