package com.carinsurance.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.carinsurance.springboot.entity.*;
import com.carinsurance.springboot.service.CustomerNotFoundException;
import com.carinsurance.springboot.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cs;

	@GetMapping("/customers")
	public String showCustomerList(Model model) {
		List<Customer> listCustomers = cs.ListAll();
		model.addAttribute("listCustomers",listCustomers);
		return "customers";
		
	}
	
	@GetMapping("/customers/new")
	public String showNewForm(Model model) {
		model.addAttribute("customer",new Customer());
		model.addAttribute("pageTitle","Add New Customer");
		return "customer_form";
	}
	
	@PostMapping("/customers/save")
	public String saveCustomer(Customer customer,RedirectAttributes ra) {
		cs.save(customer);
		ra.addFlashAttribute("message","new cutomer details added successfully");
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		try {
			Customer cus=cs.get(id);
			model.addAttribute("customer", cus);
			model.addAttribute("pageTitle","Edit Customrer (ID:"+id+")");
			return "customer_form";
		}catch(CustomerNotFoundException e) {
			ra.addFlashAttribute("string",e.getMessage());
			return "redirect:/customers";
		}
	}
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id, RedirectAttributes ra) {
		try {
			cs.delete(id);
			ra.addFlashAttribute("message","The Customer ID " + id + " has been deleted.");
		}
		catch(CustomerNotFoundException e) {
			ra.addFlashAttribute("string",e.getMessage());
		}
		return "redirect:/customers";
	}
	
}
