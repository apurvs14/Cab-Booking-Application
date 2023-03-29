package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer>insertCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer insertedCustomer = customerService.insertCustomer(customer);
		
		return new ResponseEntity<>(insertedCustomer,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer>updateCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer insertedCustomer = customerService.updateCustomer(customer);
		
		return new ResponseEntity<>(insertedCustomer,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer>deleteCustomerHandler(@PathVariable Integer id) throws CustomerException{
		
		Customer deletedCustomer = 	customerService.deleteCustomer(id);
		
		
		return new ResponseEntity<>(deletedCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer>viewCustomerHandler(@PathVariable Integer id) throws CustomerException{
		
		Customer Customer = 	customerService.viewCustomer(id);
		
		
		return new ResponseEntity<>(Customer,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>>viewAllCustomerHandler() throws CustomerException{
		
		List<Customer> Customers = customerService.viewAllCustomers();
		
		
		return new ResponseEntity<>(Customers,HttpStatus.OK);
		
	}
	
	

}















