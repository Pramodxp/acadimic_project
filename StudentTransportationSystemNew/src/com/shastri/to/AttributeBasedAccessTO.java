package com.shastri.to;

public class AttributeBasedAccessTO {
	private long pSlNo;
	private String patientname;
	private String type;
	private long dSlNo;
	private String drName;
	private String patientPermission;

	public long getpSlNo() {
		return pSlNo;
	}

	public void setpSlNo(long pSlNo) {
		this.pSlNo = pSlNo;
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

	public long getdSlNo() {
		return dSlNo;
	}

	public void setdSlNo(long dSlNo) {
		this.dSlNo = dSlNo;
	}

	

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getPatientPermission() {
		return patientPermission;
	}

	public void setPatientPermission(String patientPermission) {
		this.patientPermission = patientPermission;
	}

}
