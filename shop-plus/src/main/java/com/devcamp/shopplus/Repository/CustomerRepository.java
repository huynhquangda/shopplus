package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
