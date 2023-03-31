package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.TripBooking;
import com.masai.reopsitory.AdminDao;
import com.masai.reopsitory.CustomerRepository;
import com.masai.reopsitory.TripBookingRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CustomerRepository CustRepo;
	
	@Autowired
	private TripBookingRepo tripBookingRepo;
	
	@Override
	public Admin saveAdmin(Admin admin)throws AdminException {
		System.out.println(admin);
		return adminDao.save(admin);
	}

	@Override
	public Admin delete(Integer id)throws AdminException {
		Admin existingAdmin = adminDao.findById(id).orElseThrow(()->new AdminException("Invalid Id"));
		adminDao.delete(existingAdmin);
		return existingAdmin;
	}

	@Override
	public Admin update(Admin admin) throws AdminException {
		Optional<Admin> opt = adminDao.findById(admin.getAdminID());
		if(opt.isPresent()) {
			return adminDao.save(admin);
		}
		throw new AdminException("Invalid Id");
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminException {
		Optional<Customer> opt = CustRepo.findById(customerid);
		if(opt.isPresent()) {
			List<TripBooking> trips = tripBookingRepo.findAll();
			return trips;
		}
		throw new AdminException("Invalid id");
	}

	@Override
	public List<TripBooking> getTripsDriverwise() throws AdminException{
		List<TripBooking> list = tripBookingRepo.findByDriverAsc();
		if(list.size()>0) {
			return list;
		}else {
			throw new AdminException("No Trips Found");
		}
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() throws AdminException {
		List<TripBooking> list = tripBookingRepo.findByCustomeridAsc();
		if(list.size()>0) {
			return list;
		}else {
			throw new AdminException("No Trips Found");
		}
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminException {
		List<TripBooking> list = tripBookingRepo.findByFromDateTimeAsc();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new AdminException("No Trips Found");
		}
	}

	@Override
	public List<TripBooking> getTripsDatewiseAndCustomerHandler(Integer customerId,LocalDate date) throws AdminException {
		List<TripBooking> list = tripBookingRepo.findByCustomerIdAndFromDateTime(customerId,date);
		if(list.size()>0) {
			return list;
		}else {
			throw new AdminException("No trips found for customer id "+customerId+" and date : "+date);
		}
			
	}
	
	

}
