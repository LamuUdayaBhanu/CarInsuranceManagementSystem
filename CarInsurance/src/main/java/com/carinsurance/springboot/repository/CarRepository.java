package com.carinsurance.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carinsurance.springboot.entity.*;

public interface CarRepository extends JpaRepository<Car,Integer>{
	
	 long countById(Integer id);
}
