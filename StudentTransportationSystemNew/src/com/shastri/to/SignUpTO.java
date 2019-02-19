package com.shastri.to;

import java.io.InputStream;

import javax.servlet.http.Part;

public class SignUpTO {
	private int pincode;
	
	private long id;
	private long mobileNumber;
	
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String password;
	private String userName;
	private String address;
	private String location;
	private String picLength;
	
	private Part profilePic;
	private InputStream profilePicContent;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;

	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;

	}

	public Part getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Part profilePic) {
		this.profilePic = profilePic;

	}

	public InputStream getProfilePicContent() {
		return profilePicContent;
	}

	public void setProfilePicContent(InputStream profilePicContent) {
		this.profilePicContent = profilePicContent;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;

	}

	public String getPicLength() {
		return picLength;
	}

	public void setPicLength(String picLength) {
		this.picLength = picLength;

	}}
