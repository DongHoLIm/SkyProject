package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;

public class SearchCondition implements Serializable{
	private String college;
	private String major;
	private int grade;
	private String status;
	
	public SearchCondition() {}

	public SearchCondition(String college, String major, int grade, String status) {
		super();
		this.college = college;
		this.major = major;
		this.grade = grade;
		this.status = status;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SearchCondition [college=" + college + ", major=" + major + ", grade=" + grade + ", status=" + status
				+ "]";
	}
	
	
	
	

}
