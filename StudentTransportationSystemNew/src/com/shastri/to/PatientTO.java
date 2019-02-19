package com.shastri.to;

import java.io.InputStream;

import javax.servlet.http.Part;

public class PatientTO/* implements Serializable*/{



	
	private long slNo;
	private String patientname;
	private String type;
	private String description;
	private String address;
	private String dob;
	private String emailId;
	private long mobileNumber;
	private Part profilePic;
	private InputStream profilePicContent;
	private String kgc;
	private String pakey;

	public long getSlNo() {
		return slNo;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getKgc() {
		return kgc;
	}

	public void setKgc(String kgc) {
		this.kgc = kgc;
	}

	public String getPakey() {
		return pakey;
	}

	public void setPakey(String pakey) {
		this.pakey = pakey;
	}
	
	

}
