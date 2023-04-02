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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.TripBooking;
import com.masai.service.BookingService;
@RestController
public class TripController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/tripBookings")
	public ResponseEntity<TripBooking> bookCab(@RequestBody TripBooking tripBooking,@RequestParam("driverId") Integer driverId,@RequestParam("customerId") Integer customerId){
		TripBooking trip=bookingService.insertTripBooking(tripBooking,driverId,customerId);
		return new ResponseEntity<>(trip,HttpStatus.CREATED);
		
		
		
	}
	@PutMapping("/tripBookings")
	public ResponseEntity<TripBooking> updateTripbooking(@RequestBody TripBooking tripbooking){
		TripBooking trip=bookingService.updateTripBooking(tripbooking);
		return new ResponseEntity<>(trip,HttpStatus.ACCEPTED);
	}
	@GetMapping("/tripBookings/{customerId}")
	public ResponseEntity<List<TripBooking>> findTripByCustomerId(@PathVariable int customerId){
		List<TripBooking>trips=bookingService.ViewAllTripsCustomer(customerId);
		return new ResponseEntity<>(trips,HttpStatus.OK);
	}
	
	@DeleteMapping("/tripBooking")
	public ResponseEntity<TripBooking> deleteTripBooking(@RequestParam("tripBookingId") Integer tripBookingId){
		TripBooking trip=bookingService.deleteTripooking(tripBookingId);
		return new ResponseEntity<>(trip,HttpStatus.OK);
		
	}
	@GetMapping("/bills/{customerId}")
	public ResponseEntity<String>calculateBill(@RequestParam int customerId)
	{
		String bill =bookingService.calculateBill(customerId);
		return new ResponseEntity<>(bill,HttpStatus.OK);
	}
}
