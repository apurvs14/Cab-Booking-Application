package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;



@Entity
public class Customer extends AbstractUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	
	@OneToMany
	private List<TripBooking> tripBookings = new ArrayList<>();
	
	
	public List<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(List<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public Customer() {
		
	}

	public Customer(String userName, String password, String address, String mobileNumber, String email,
			int customerID) {
		super(userName, password, address, mobileNumber, email);
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	
	
}
