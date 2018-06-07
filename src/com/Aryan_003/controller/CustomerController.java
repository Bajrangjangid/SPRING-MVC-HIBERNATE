package com.Aryan_003.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Aryan_003.Entity.Customer;
import com.Aryan_003.service.CustomerService;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("list")
	public String listCustomer(Model model){
		System.out.println(customerService);
		List<Customer> customersList = customerService.getCustomers();
		
		model.addAttribute("customersList", customersList);
		
		return "customers";
	}
	
	@GetMapping("showFormForAdd")
	public String addCustomerForm(Model model){
		model.addAttribute("customer", new Customer());
		return "showFormForAdd"; 
	}
	
	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		System.out.println(customer);
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id,
			Model model){
		
		model.addAttribute("customer", 
				customerService.getCustomer(id));
		return "showFormForAdd";
	}
	
	@GetMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id){
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
}
