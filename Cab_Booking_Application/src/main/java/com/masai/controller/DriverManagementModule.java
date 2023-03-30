package com.masai.controller;


import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverNotFoundException;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.reopsitory.DriverRepository;
import com.masai.service.IDriverService;

@RestController
@RequestMapping("/drivers")
public class DriverManagementModule {

	@Autowired
	private IDriverService driverService;
//	private ICabService cabService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Driver> getDriverByID(@RequestParam("id") int id)
	{
		Driver d=driverService.viewDriver(id);  
		
		
		
		return new ResponseEntity<Driver>(d,HttpStatus.OK);
	}
	
//	@PutMapping("/updateDriverIDOfCab/{driverID}") 
//	public ResponseEntity<Driver> updateDriverIDOfCab(@RequestBody @PathVariable int driverID){
//		
//		Driver d = driverService.viewDriver(driverID); 
//		
//		Cab c = d.getCab(); 
//		
//		
//		
//		cabService.save(c);
//		
//		
//	}
	
	
	@GetMapping("/bestDriverList") 
	public ResponseEntity<List<Driver>> getBestDrivers()  
	{
		List<Driver> bestDriverList=driverService.viewBestDrivers(); 
		
		return new ResponseEntity<List<Driver>>(bestDriverList,HttpStatus.OK);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Driver> registerDriverHandler(@RequestBody Driver d){
		
	    Supplier<Driver> supplier = driverService.insertDriver(d); 
	    
	    Driver savedDriver = supplier.get(); 
	    
	    return new ResponseEntity<>(savedDriver,HttpStatus.CREATED);
	    
	}
	
	
	@PutMapping("/updateDriverRating/{id}/{updatedRating}")
	public ResponseEntity<Driver> updateDriverRating(@RequestBody @PathVariable("id") int id, @PathVariable("updatedRating") float rating){
		
		  Driver d = driverService.viewDriver(id); 
		  
		  if(d==null) {
			  throw new DriverNotFoundException("Driver does not exist...");
		  }
		  
		  d.setRating(rating);
		  
		  Supplier<Driver> supplier = driverService.insertDriver(d); 
		  
	
		 return new ResponseEntity<Driver>(supplier.get(),HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updateDriversCabDetails/updateRatePerKm/{driverID}/{rate}") 
	public ResponseEntity<Driver> updateDriverCabRate(@RequestBody @PathVariable("driverID") int id, @PathVariable("rate") float rate) 
	{
		Driver d = driverService.viewDriver(id); 
		
		if(d==null) {
			throw new DriverNotFoundException("Driver does not exist with given ID: "+id);
		}
		
		Cab c = d.getCab();  
		
		c.setPerKmRate(rate); 
		
		//this insertDriverMethod as already existed in the table, updates the driver object. Using CascadeType.ALL, we get Cab details persisted
		Supplier<Driver> supplier = driverService.insertDriver(d); 
		
		return new ResponseEntity<Driver>(supplier.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteDriver/{id}") 
	public ResponseEntity<Driver> deleteDriver(@PathVariable int driverID){
		Supplier<Driver> supplier = driverService.deleteDriver(driverService.viewDriver(driverID)); 
		
		Driver d = supplier.get(); 
		
		if(d == null) {
			throw new DriverNotFoundException("Driver does not exist with given ID: "+driverID);
		}
		
		
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	
}
