package com.devcamp.shopplus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.shopplus.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
