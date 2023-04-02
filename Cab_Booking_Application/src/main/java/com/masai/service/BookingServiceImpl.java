package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TripNotFound;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.TripBooking;
import com.masai.reopsitory.CustomerRepository;
import com.masai.reopsitory.DriverRepository;
import com.masai.reopsitory.TripBookingRepo;


@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private TripBookingRepo tripBookingrepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private DriverRepository driverRepo;
	
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking,Integer driverId,Integer customerId)  {
		// TODO Auto-generated method stub
		
		Optional<Driver> driver=driverRepo.findById(driverId);
		
		
		if(driver.isPresent()) {
			tripBooking.setDriver(driver.get());
		}
		else throw new TripNotFound("No cab available");
		
		Optional<Customer> customer =customerRepo.findById(customerId);
		if(customer.isPresent()) {
			tripBooking.setCustomer(customer.get());
			
		}
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
	public String calculateBill(int customerld) {
		// TODO Auto-generated method stub
		Optional<Customer> tripBookingOptional = customerRepo.findById(customerld);
	    if (tripBookingOptional.isPresent()) {
	        List<TripBooking> list = tripBookingOptional.get().getTripBookings();
	        float totalBill=0;
	        System.out.println(list);
	        for(TripBooking trip:list)
	        {
	        	totalBill+=trip.getBill();
	        
		        
	        }
	       
	      
	       // tripBookingrepo.save(tripBooking);
	        return  "Total Bill: "+totalBill;
	    }
	        else {
	        	throw new TripNotFound("you Have not book any trip please book");  }
		
	
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerld)  {
		// TODO Auto-generated method stub
		
			Optional<Customer>customer=customerRepo.findById(customerld);
			
		if(customer.isPresent())
		{
			List<TripBooking>trips=customer.get().getTripBookings();
			return trips;
		}
		 throw new TripNotFound("No record found");
			
	
	}

}
