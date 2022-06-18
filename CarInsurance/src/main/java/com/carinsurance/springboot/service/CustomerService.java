package com.carinsurance.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carinsurance.springboot.entity.*;

import com.carinsurance.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository cr;
	
	
	
	public List<Customer> ListAll(){
		return cr.findAll();
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		cr.save(customer);
	}
	
	public Customer get(Integer id) throws CustomerNotFoundException {
		Optional<Customer> result=cr.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new CustomerNotFoundException("Could not find any car with ID"+id);
	}
	
	public void delete(Integer id) throws CustomerNotFoundException {
		long count= cr.countById(id);
		if(count == 0) {
			throw new CustomerNotFoundException("Could not find any car with ID"+id);
		}
		cr.deleteById(id);
	}
	
}
