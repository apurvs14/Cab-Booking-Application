package com.masai.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.TripBooking;
import com.masai.reopsitory.AdminDao;
import com.masai.reopsitory.CustomerRepository;
import com.masai.reopsitory.DriverRepository;
import com.masai.reopsitory.TripBookingRepo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerRepository CustRepo;

	@Autowired
	private TripBookingRepo tripBookingRepo;

	@Autowired
	private DriverRepository Drepo;

	@Override
	public Admin saveAdmin(Admin admin) throws AdminException {
		System.out.println(admin);
		return adminDao.save(admin);
	}

	@Override
	public Admin delete(Integer id) throws AdminException {
		Admin existingAdmin = adminDao.findById(id).orElseThrow(() -> new AdminException("Invalid Id"));
		adminDao.delete(existingAdmin);
		return existingAdmin;
	}

	@Override
	public Admin update(Admin admin) throws AdminException {
		Optional<Admin> opt = adminDao.findById(admin.getAdminID());
		if (opt.isPresent()) {
			return adminDao.save(admin);
		}
		throw new AdminException("Invalid Id");
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminException {
		Optional<Customer> opt = CustRepo.findById(customerid);
		if (opt.isPresent()) {
			List<TripBooking> trips = opt.get().getTripBookings();
			return trips;
		}
		throw new AdminException("Invalid id");
	}

	@Override
	public List<TripBooking> getTripsDriverwise() throws AdminException {
		List<Driver> list = Drepo.findAll();
		List<TripBooking> ls = new ArrayList<>();
		for (Driver d : list) {
			ls.addAll(d.getTripBookings());
		}
		if (ls.isEmpty()) {
			throw new AdminException("No Trips Found");
		} else {
			return ls;
		}
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() throws AdminException {
		List<Customer> list = CustRepo.findAll();
		List<TripBooking> tripBook = new ArrayList<>();
		for (Customer ls : list) {
			tripBook.addAll(ls.getTripBookings());
		}
		if (tripBook.isEmpty()) {
			throw new AdminException("No Trips Found");
		} else {
			return tripBook;
		}
	}

	@Override
	public List<TripBooking> getTripsDatewise(LocalDateTime date) throws AdminException {
		
		List<TripBooking> trips = tripBookingRepo.findByFromDateTime(date);
		if (trips.isEmpty()) {
			throw new AdminException("No trips found");
		}
		return trips;
	}

	@Override
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId,LocalDateTime date) throws AdminException {
		List<TripBooking> list = CustRepo.findById(customerId).get().getTripBookings();
		List<TripBooking> ls = new ArrayList();
		for(TripBooking l:list) {
			if(date.equals(l.getFromDateTime())) {
				ls.add(l);
				
			}
		}
		if(!ls.isEmpty()) {
			return ls;
		}else {
			throw new AdminException("No trips found for customer id "+customerId+" and date : "+date);
		}
			
	}

}
