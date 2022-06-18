package com.carinsurance.springboot.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.carinsurance.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
 
	long countById(Integer id);
	
}
