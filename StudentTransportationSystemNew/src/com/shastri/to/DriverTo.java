package com.shastri.to;

import java.io.InputStream;

import javax.servlet.http.Part;

public class DriverTo {

	private int driverID;
	private String dName;

	private String dEmail;
	private String driverPass;
	private String dActive;

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getDriverPass() {
		return driverPass;
	}

	public void setDriverPass(String driverPass) {
		this.driverPass = driverPass;
	}

	

	public String getdActive() {
		return dActive;
	}

	public void setdActive(String dActive) {
		this.dActive = dActive;
	}

	@Override
	public String toString() {
		return "DriverTo [driverID=" + driverID + ", dName=" + dName
				+ ", dEmail=" + dEmail + ", driverPass=" + driverPass
				+ ", dActive=" + dActive + "]";
	}

}
