package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;


@Service
public interface CustomerService {

	
	public Customer insertCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;
	
	public List<Customer> viewAllCustomers()throws CustomerException;
	
	public Customer validateCustomer(String username,String password)throws CustomerException;
	
	
}





