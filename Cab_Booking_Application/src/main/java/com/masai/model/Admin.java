package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends AbstractUser {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminID;

	
	public Admin() {
		
		
	}
	
	public Admin(String userName, String password, String address, String mobileNumber, String email, int adminID) {
		super(userName, password, address, mobileNumber, email);
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + "]";
	}
	
	
	
	
	
	
}
