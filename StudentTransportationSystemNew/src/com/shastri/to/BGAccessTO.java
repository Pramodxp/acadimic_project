package com.shastri.to;

public class BGAccessTO {

	private long sl;
	private String patientName;
	private String doctorName;
	private String KGCKey;
	private String paKey;
	private String date;

	public long getSl() {
		return sl;
	}

	public void setSl(long sl) {
		this.sl = sl;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getKGCKey() {
		return KGCKey;
	}

	public void setKGCKey(String kGCKey) {
		KGCKey = kGCKey;
	}

	public String getPaKey() {
		return paKey;
	}

	public void setPaKey(String paKey) {
		this.paKey = paKey;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
