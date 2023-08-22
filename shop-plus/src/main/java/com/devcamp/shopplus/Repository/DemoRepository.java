package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.demo;

public interface DemoRepository extends JpaRepository<demo, Long> {

}
