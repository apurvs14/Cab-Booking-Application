package com.masai.model;

import jakarta.persistence.*;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cabID;
	
	private String carType;
	
	private float perKmRate;	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="driverID")
	private Driver driver;
	
	
	public Cab() {
		
	}

	public Cab(int cabID, String carType, float perKmRate, Driver driver) {
		super();
		this.cabID = cabID;
		this.carType = carType;
		this.perKmRate = perKmRate;
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


	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
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
	
	
}
