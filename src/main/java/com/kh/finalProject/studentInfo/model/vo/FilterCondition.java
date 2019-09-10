package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;

public class FilterCondition implements Serializable{
	private String college;
	private String sdeptName;
	private String grade;
	private String studentStatus;
	
	public FilterCondition() {}

	public FilterCondition(String college, String sdeptName, String grade, String studentStatus) {
		super();
		this.college = college;
		this.sdeptName = sdeptName;
		this.grade = grade;
		this.studentStatus = studentStatus;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	@Override
	public String toString() {
		return "FilterCondition [college=" + college + ", sdeptName=" + sdeptName + ", grade=" + grade
				+ ", studentStatus=" + studentStatus + "]";
	}

	
	

}
