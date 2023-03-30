package com.masai.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractUser {

	private String userName;
    transient private String password;
	private String address;
	private String mobileNumber;
	private String email;
	
	public AbstractUser() {
		
	}

	public AbstractUser(String userName, String password, String address, String mobileNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractUser [ userName=" + userName + ", password=" + password + ", address="
				+ address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	
}
