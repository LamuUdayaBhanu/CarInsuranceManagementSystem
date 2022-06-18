package com.carinsurance.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carinsurance.springboot.entity.Car;
import com.carinsurance.springboot.entity.Customer;
import com.carinsurance.springboot.service.CarNotFoundException;
import com.carinsurance.springboot.service.CarService;
import com.carinsurance.springboot.service.CustomerNotFoundException;

@Controller
public class CarController {
	
	@Autowired
	private CarService cs;
	
	@GetMapping("/cars")
	public String showCarList(Model model) {
		List<Car> listCars = cs.ListAll();
		model.addAttribute("listCars",listCars);
		return "cars";
	}	
	
	@GetMapping("/cars/new")
	public String showNewForm(Model model) {
		model.addAttribute("car",new Car());
		model.addAttribute("pageTitle","Add New Car Details");
		return "car_form";
	}
	
	@PostMapping("/cars/save")
	public String saveCar(Car car,RedirectAttributes ra) {
		cs.save(car);
		ra.addFlashAttribute("message","new cutomer car details added successfully");
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		try {
			Car car=cs.get(id);
			model.addAttribute("car", car);
			model.addAttribute("pageTitle","Edit Car (ID:"+id+")");
			return "car_form";
		}catch(CarNotFoundException e) {
			ra.addFlashAttribute("string",e.getMessage());
			return "redirect:/cars";
		}
	}
	
	@GetMapping("/cars/delete/{id}")
	public String deleteCar(@PathVariable("id") Integer id, RedirectAttributes ra) {
		try {
			cs.delete(id);
			ra.addFlashAttribute("message","The Customer ID " + id + " has been deleted.");
		}
		catch(CarNotFoundException e) {
			ra.addFlashAttribute("string",e.getMessage());
		}
		return "redirect:/cars";
	}
	
}
