package com.masai.controller;


import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.reopsitory.DriverRepository;
import com.masai.service.IDriverService;

@RestController
public class DriverManagementModule {

	@Autowired
	private IDriverService driverService;
	
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriverHandler(@RequestBody Driver d){
		
	    Supplier<Driver> supplier = driverService.insertDriver(d); 
	    
	    Driver savedDriver = supplier.get(); 
	    
	    return new ResponseEntity<>(savedDriver,HttpStatus.CREATED);
	    
	}
	
	@PutMapping("/updateDriverRating/{id}/{updatedRating}")
	public ResponseEntity<Driver> updateDriverRating(@PathVariable("id") int id, @PathVariable("updatedRating") float rating){
		
		  Driver d = driverService.viewDriver(id); 
		  
		  if(d==null) {
			  throw new DriverException("Roll number should be greater than 100");
		  }
	
		 return new ResponseEntity<Driver>(d,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
}
