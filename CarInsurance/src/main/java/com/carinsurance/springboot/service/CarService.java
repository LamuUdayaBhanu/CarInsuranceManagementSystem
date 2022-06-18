package com.carinsurance.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carinsurance.springboot.entity.Car;
import com.carinsurance.springboot.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository cr;
	
	public List<Car> ListAll(){
		return cr.findAll();
	}
	public void save(Car car) {
		// TODO Auto-generated method stub
		cr.save(car);
	}
	
	public Car get(Integer id) throws CarNotFoundException {
		Optional<Car> result=cr.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new CarNotFoundException("Could not find any car with ID"+id);
	}
	
	public void delete(Integer id) throws CarNotFoundException {
		long count= cr.countById(id);
		if(count == 0) {
			throw new CarNotFoundException("Could not find any car with ID"+id);
		}
		cr.deleteById(id);
	}
}
