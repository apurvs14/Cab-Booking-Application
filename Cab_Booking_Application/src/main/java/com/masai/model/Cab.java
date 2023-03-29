package com.masai.model;

import jakarta.persistence.*;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cabID;
	
	private String carType;
	private boolean CabAvailability=true;
	
	private final float perKmRate=10;	
	
	@OneToOne
	@JoinColumn(name="driverID")
	private Driver driver;
	
	
	public Cab() {
		
	}

	




	public Cab(int cabID, String carType, boolean cabAvailability, Driver driver) {
		super();
		this.cabID = cabID;
		this.carType = carType;
		CabAvailability = cabAvailability;
		this.driver = driver;
	}






	public int getCabID() {
		return cabID;
	}


	public void setCabID(int cabID) {
		this.cabID = cabID;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public float getPerKmRate() {
		return perKmRate;
	}


	


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Cab [cabID=" + cabID + ", carType=" + carType + ", perKmRate=" + perKmRate + ", driver=" + driver + "]";
	}

	public boolean isCabAvailability() {
		return CabAvailability;
	}

	public void setCabAvailability(boolean cabAvailability) {
		CabAvailability = cabAvailability;
	}
	
	
}
