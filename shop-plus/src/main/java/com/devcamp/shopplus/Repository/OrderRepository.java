package com.devcamp.shopplus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(long id);
}
