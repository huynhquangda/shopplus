package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
