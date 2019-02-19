package com.shastri.to;

import java.io.InputStream;

import javax.servlet.http.Part;

public class ECPTO {
	private long slNo;
	private String patientName;
	private String kgc;
	private String name;
	private String address;
	private String emailId;
	private long mobileNumber;
	private Part profilePic;
	private InputStream profilePicContent;

	public long getSlNo() {
		return slNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getKgc() {
		return kgc;
	}

	public void setKgc(String kgc) {
		this.kgc = kgc;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

}
