package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.reopsitory.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		
		boolean exists = customerRepository.existsById(customer.getCustomerID());
		
		if(exists) {
			
			throw new CustomerException("Customer with id " +customer.getCustomerID()+ " already exists");
			
		} else {
			
			return customerRepository.save(customer);
			
		}
		
	
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		boolean exists = customerRepository.existsById(customer.getCustomerID());
		
		if(exists) {
			
			throw new CustomerException("Customer with id " +customer.getCustomerID()+ " already exists");
			
		} else {
			
			return customerRepository.save(customer);
			
		}
		
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer with id " +customerId+ " does not exist"));
		
		customerRepository.delete(customer);
		
		return customer;
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer with id " +customerId+ " does not exist"));
		
		// TODO Auto-generated method stub
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		
		List<Customer> customers = customerRepository.findAll();
		
		if(customers.isEmpty()) {
			
			throw new CustomerException("No Customers to show");
			
		} else {
			
			return customers;
			
		}
		
		
	}

	@Override
	public Customer validateCustomer(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
