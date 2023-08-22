package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.ProductLine;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

}
