package com.masai.service;

import java.util.List;
import java.util.function.Supplier;

import com.masai.exception.DriverException;
import com.masai.model.Driver;

public interface IDriverService {
    
	public Supplier<Driver> insertDriver(Driver d);
	
	public Driver updateDriver(Integer id,float rating)throws DriverException ; 
	
	public Driver deleteDriver(Driver d);  
	
	public List<Driver> viewBestDrivers();
	
	public Driver viewDriver(int driverID);
	
}
