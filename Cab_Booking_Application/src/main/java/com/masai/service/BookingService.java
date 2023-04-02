package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.TripNotFound;
import com.masai.model.TripBooking;
@Service
public interface BookingService {
public TripBooking	insertTripBooking(TripBooking tripBooking,Integer driverId,Integer customerId) ;
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripNotFound;
	public TripBooking deleteTripooking(int tripBookingld) throws TripNotFound;
	public String calculateBill(int customerld) throws TripNotFound;


	public List<TripBooking>ViewAllTripsCustomer(int customerld) throws TripNotFound;
	

}
