package com.Aryan_003.DAO;

import java.util.List;

import com.Aryan_003.Entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public Customer getCustomer(int id);

	public void saveCustomer(Customer customer);

	public void deleteCustomer(int id);
}
