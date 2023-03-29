package com.masai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CabNotAvailAble;
import com.masai.model.Cab;
import com.masai.model.TripBooking;
import com.masai.reopsitory.TripRepositry;
@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	private TripRepositry tripRepositry;
	
	
	
	
	public String  createTrip(TripBooking tripBooking) {
		// TODO Auto-generated method stub
		
		TripBooking s=tripRepositry.save(tripBooking);
		
		
		return "trip created ";
	}

	

}
