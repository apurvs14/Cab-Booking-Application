package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.TripBooking;
import com.masai.service.BookingService;
@RestController
public class TripController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/tripBookings")
	public ResponseEntity<TripBooking> bookCab(@RequestBody TripBooking tripBooking){
		TripBooking trip=bookingService.insertTripBooking(tripBooking);
		return new ResponseEntity<>(trip,HttpStatus.CREATED);
		
		
		
	}
	

}
