package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
