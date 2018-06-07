package com.Aryan_003.service;

import java.util.List;

import com.Aryan_003.Entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
}
