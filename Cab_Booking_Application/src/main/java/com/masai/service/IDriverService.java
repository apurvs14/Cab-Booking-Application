package com.masai.service;

import java.util.List;
import java.util.function.Supplier;

import com.masai.exception.DriverNotFoundException;
import com.masai.model.Driver;

public interface IDriverService {
    
	public Supplier<Driver> insertDriver(Driver d);
	
	public Supplier<Driver> updateDriver(Driver d) ; 
	
	public Supplier<Driver> deleteDriver(Driver d);  
	
	public List<Driver> viewBestDrivers();
	
	public Driver viewDriver(int driverID);
	
}
