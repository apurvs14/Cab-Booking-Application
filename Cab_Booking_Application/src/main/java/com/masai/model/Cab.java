package com.masai.model;

import jakarta.persistence.*;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cabID;
	
	private String carType;
	
	private float perKmRate; 
	
	private int driverID;
	
	public Cab() {
		
	}

	public Cab(int cabID, String carType, float perKmRate) {
		super();
		this.cabID = cabID;
		this.carType = carType;
		this.perKmRate = perKmRate;
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

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	@Override
	public String toString() {
		return "Cab [cabID=" + cabID + ", carType=" + carType + ", perKmRate=" + perKmRate +  "]";
	}
	
	
}
