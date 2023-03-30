package com.masai.service;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.masai.exception.TripNotFound;
import com.masai.model.TripBooking;

import com.masai.reopsitory.TripBookingRepo;


@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private TripBookingRepo tripBookingrepo;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking)  {
		// TODO Auto-generated method stub
		
		TripBooking trip=tripBookingrepo.save(tripBooking);
	
		return trip;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripNotFound {
		// TODO Auto-generated method stub
			Optional<TripBooking> trip=tripBookingrepo.findById(tripBooking.getTripBookingID());
			if(trip.isPresent()) {
				
				trip.get().setFromLocation(tripBooking.getFromLocation());
				        trip.get().setToLocation(tripBooking.getToLocation());
				        trip.get().setCustomer(tripBooking.getCustomer());
				        trip.get().setBill(tripBooking.getBill());
				        trip.get().setCustomer(tripBooking.getCustomer());
				        trip.get().setDistanceInKM(tripBooking.getDistanceInKM());
				        trip.get().setDriver(tripBooking.getDriver());
				        trip.get().setFromDateTime(tripBooking.getFromDateTime());
				        trip.get().setToDateTime(tripBooking.getToDateTime());
				        trip.get().setPricePerKM(tripBooking.getPricePerKM());
				        trip.get().setStatus(tripBooking.isStatus());
				        trip.get().setTripBookingID(tripBooking.getTripBookingID());
				        return trip.get();
				    }
			
		
		return null;
	}

	@Override
	public TripBooking deleteTripooking(int tripBookingld) {
		// TODO Auto-generated method stub
		Optional<TripBooking>trip=tripBookingrepo.findById(tripBookingld);
		if(!trip.isPresent()) {
			throw new TripNotFound("No trip avaliable for given id");
		}
		else {
			tripBookingrepo.delete(trip.get());
			return trip.get();
		}
	}

	@Override
	public TripBooking calculateBill(int customerld) {
		// TODO Auto-generated method stub
		Optional<TripBooking> tripBookingOptional = tripBookingrepo.findById(customerld);
	    if (tripBookingOptional.isPresent()) {
	        TripBooking tripBooking = tripBookingOptional.get();
	        float distance = tripBooking.getDistanceInKM();
	        float price=tripBooking.getPricePerKM();
	       
	        float fare = price*distance;
	        tripBooking.setBill(fare);
	        tripBookingrepo.save(tripBooking);
	        return tripBooking;
	    }
	        else {
	        	throw new TripNotFound("you Have not book any trip please book");
	        	
	        }
		
	
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerld) {
		// TODO Auto-generated method stub
		
		Optional<List<TripBooking>> trips=tripBookingrepo.findByCustomer(customerld);
		
		if(trips.get().isEmpty()) throw new TripNotFound("Trips not found for this customer");
	
	return  trips.get();
	}

}
