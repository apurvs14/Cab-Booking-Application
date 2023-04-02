package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.reopsitory.DriverRepository;

@Service
public class IDriverServiceImpl implements IDriverService {

	@Autowired
	private DriverRepository driverRepo;
	
	
	@Override
	public Supplier<Driver> insertDriver(Driver d) {
		   
		
		Supplier<Driver> supplier = () -> {
			 return driverRepo.save(d);
		}; 
		System.out.println(d);
		
		return supplier;
	}

	@Override
	public Supplier<Driver> updateDriver(Driver d)  {
		
		Supplier<Driver> supplier = () ->{
			return d;
		}; 
		
		return supplier;
	}

	@Override
	public Supplier<Driver> deleteDriver(Driver d) {
		
		Supplier<Driver> supplier = () ->{
			return d;
		}; 
		
		return supplier;
		
	}

	@Override
	public List<Driver> viewBestDrivers() {
		
		List<Driver> drivers = driverRepo.findAll();
		
		List<Driver> filteredDrivers = new ArrayList<>();
		
		for(Driver d:drivers) {
			if(d.getRating()>=4.5) {
				filteredDrivers.add(d);
			}
		}
		
		return filteredDrivers;
	}

	@Override
	public Driver viewDriver(int driverID) {
		
		Optional<Driver> opt = driverRepo.findById(driverID); 
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
		
	}

}
