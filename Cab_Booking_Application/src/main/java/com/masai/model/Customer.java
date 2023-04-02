package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
public class Customer extends AbstractUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + "]";
	}
	
	
}
