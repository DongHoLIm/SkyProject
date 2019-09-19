package com.kh.finalProject.student.classmanagement.model.vo;

public class Sdepartment implements java.io.Serializable{
	private String sdeptCode;
	private String sdeptName;
	private String collegeCode;
	
	public Sdepartment() {}

	public Sdepartment(String sdeptCode, String sdeptName, String collegeCode) {
		super();
		this.sdeptCode = sdeptCode;
		this.sdeptName = sdeptName;
		this.collegeCode = collegeCode;
	}

	public String getSdeptCode() {
		return sdeptCode;
	}

	public void setSdeptCode(String sdeptCode) {
		this.sdeptCode = sdeptCode;
	} 

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	@Override
	public String toString() {
		return "Sdepartment [sdeptCode=" + sdeptCode + ", sdeptName=" + sdeptName + ", collegeCode=" + collegeCode
				+ "]";
	}
	
	
}