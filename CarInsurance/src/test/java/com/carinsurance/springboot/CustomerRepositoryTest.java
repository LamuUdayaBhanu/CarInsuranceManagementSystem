package com.carinsurance.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.tomcat.jni.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.carinsurance.springboot.entity.Customer;
import com.carinsurance.springboot.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddNew() {
		Customer cus = new Customer();
		cus.setName("K.Vineela");
		cus.setGender("Female");
		cus.setEmail("katuri.vineela@gmil.com");
		cus.setAddress("DivyShekthi appartment,flatno:202,near Karurvisay Bank, Gannavaram,521101");
		cus.setPhoneno("9440552374");
		
		Customer savedCustomer = cr.save(cus);
		
		Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getId());
		
		Assertions.assertThat(savedCustomer).isNotNull();
		Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
		assertThat(existCustomer.getEmail()).isEqualTo(cus.getEmail());
	}

	@Test
	public void testListAll() {
		Iterable<Customer> cus = cr.findAll();
		Assertions.assertThat(cus).hasSizeGreaterThan(0);
		
		for(Customer customer: cus) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void testUpdate() {
		Integer customerId=1;
		Optional<Customer> optionalCustomer = cr.findById(customerId);
		Customer customer1 = optionalCustomer.get();
		customer1.setEmail("Abdul123@gmail.com");
		cr.save(customer1);
		
		Customer updateCustomer = cr.findById(customerId).get();
		Assertions.assertThat(updateCustomer.getEmail()).isEqualTo("Abdul123@gmail.com");
	}
	
	/*@Test
	public void testGet() {
		Integer customerId = 3;
		Optional<Customer> optionalCustomer = cr.findById(customerId);
		Assertions.assertThat(optionalCustomer).isPresent();
		System.out.println(optionalCustomer.get());
	}
	
	@Test
	public void testDelete() {
		Integer customerId = 3;
		cr.deleteById(customerId);
		
		Optional<Customer> optionalCustomer = cr.findById(customerId);
		Assertions.assertThat(optionalCustomer).isNotPresent();
	}*/
}
	
