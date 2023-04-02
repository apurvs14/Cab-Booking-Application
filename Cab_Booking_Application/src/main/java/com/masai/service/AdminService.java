package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;

public interface AdminService {
	
	public Admin saveAdmin(Admin admin)throws AdminException;
	
	public Admin delete(Integer id)throws AdminException;
	
	public Admin update(Admin admin)throws AdminException;
	
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminException;
	
	public List<TripBooking> getTripsDriverwise()throws AdminException;
	
	public List<TripBooking> getTripsCustomerwise() throws AdminException;
	
	public List<TripBooking> getTripsDatewise(LocalDateTime date) throws AdminException;

	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId,LocalDateTime date)throws AdminException;
}
