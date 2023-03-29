package com.masai.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/*NOTE: All relations are bidirectional.*/


@Entity
public class Driver extends AbstractUser{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int driverID;
	private String licenseNo;
	
	@OneToOne(mappedBy="driver",cascade=CascadeType.ALL) 
	private Cab cab;	
	private float rating;
	
	@OneToMany
	private List<TripBooking> tripBookings = new ArrayList<>();
	
	public Driver() {
		
	}

	public Driver(String userName, String password, String address, String mobileNumber, String email, int driverID,
			String licenseNo, Cab cab, float rating) {
		super(userName, password, address, mobileNumber, email);
		this.driverID = driverID;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	
}
