package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/*NOTE: All relations are bidirectional.*/

@Entity
public class Customer extends AbstractUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="tripBookingID")
	private List<TripBooking> tripBookings = new ArrayList<>();
	
	
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
