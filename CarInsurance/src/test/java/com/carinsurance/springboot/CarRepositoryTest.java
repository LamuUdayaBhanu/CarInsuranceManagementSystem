package com.carinsurance.springboot;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.carinsurance.springboot.entity.Car;
import com.carinsurance.springboot.repository.CarRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class CarRepositoryTest {

	@Autowired
	private CarRepository cr;
	
	@Test
	public void testAddNew() {
		Car car = new Car();
		car.setCar_model("Indigo");
		car.setCar_regNo("6549854247");
		car.setCategory("4 Wheeler");
		car.setChassisno("5478964445");
		car.setCost("1500");
		car.setDuration("1 Year");
		car.setExp_date("20-03-2023");
		car.setInsu_Policy("183");
		car.setReg_date("20-03-2022");
		car.setStatus("Active");
		
		
		Car savedCar = cr.save(car);
		
		Assertions.assertThat(savedCar).isNotNull();
		Assertions.assertThat(savedCar.getId()).isGreaterThan(0);

	}
}
