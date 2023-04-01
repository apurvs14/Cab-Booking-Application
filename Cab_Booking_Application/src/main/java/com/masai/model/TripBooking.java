package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
public class TripBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tripBookingID;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL) // when we persist any one object(customer,driver,tripbooking), all get persisted into database at once)
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="driverID")
	private Driver driver;
	
	private float pricePerKM;
	public float getPricePerKM() {
		return pricePerKM;
	}

	public void setPricePerKM(float pricePerKM) {
		this.pricePerKM = pricePerKM;
	}

	private String fromLocation; 
	private String toLocation; 
	private LocalDateTime fromDateTime; 
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKM; 
	private float bill;
	
	
	public TripBooking() {
		
	}
	
	
	public TripBooking(int tripBookingID, Customer customer, Driver driver, float pricePerKM, String fromLocation,
			String toLocation, LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean status, float distanceInKM,
			float bill) {
		super();
		this.tripBookingID = tripBookingID;
		this.customer = customer;
		this.driver = driver;
		this.pricePerKM = pricePerKM;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKM = distanceInKM;
		this.bill = bill;
	}

	public int getTripBookingID() {
		return tripBookingID;
	}

	public void setTripBookingID(int tripBookingID) {
		this.tripBookingID = tripBookingID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKM() {
		return distanceInKM;
	}

	public void setDistanceInKM(float distanceInKM) {
		this.distanceInKM = distanceInKM;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}
	
	
	
	
	
	
}
