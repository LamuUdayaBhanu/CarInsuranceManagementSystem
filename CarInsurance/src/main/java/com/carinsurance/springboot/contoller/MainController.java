package com.carinsurance.springboot.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carinsurance.springboot.entity.Customer;
import com.carinsurance.springboot.repository.CustomerRepository;
import com.carinsurance.springboot.service.CustomerService;

@Controller
public class MainController {
	
	@Autowired
	private CustomerRepository cr;
	
	@GetMapping("")
	public String showHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "signup";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(Customer customer) {
		cr.save(customer);
		return "register_success";
	}
	
	@GetMapping("/search")
	public String showSearch(Customer customer) {
		return "search";
	}
}
