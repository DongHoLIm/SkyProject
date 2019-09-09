package com.kh.finalProject.employee.classManagement.model.vo;

import java.sql.Date;

public class LectureOpen {
	private String subCode;
	private String subName;
	private String sdeptName;
	private String completeType;
	private int subGrade;
	private String madeDate;
	private int enrolType;


	public LectureOpen() {}


	public LectureOpen(String subCode, String subName, String sdeptName, String completeType, int subGrade,
			String madeDate, int enrolType) {
		super();
		this.subCode = subCode;
		this.subName = subName;
		this.sdeptName = sdeptName;
		this.completeType = completeType;
		this.subGrade = subGrade;
		this.madeDate = madeDate;
		this.enrolType = enrolType;
	}


	public String getSubCode() {
		return subCode;
	}


	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}


	public String getSubName() {
		return subName;
	}


	public void setSubName(String subName) {
		this.subName = subName;
	}


	public String getSdeptName() {
		return sdeptName;
	}


	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}


	public String getCompleteType() {
		return completeType;
	}


	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}


	public int getSubGrade() {
		return subGrade;
	}


	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}


	public String getMadeDate() {
		return madeDate;
	}


	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}


	public int getEnrolType() {
		return enrolType;
	}


	public void setEnrolType(int enrolType) {
		this.enrolType = enrolType;
	}


	@Override
	public String toString() {
		return "LectureOpen [subCode=" + subCode + ", subName=" + subName + ", sdeptName=" + sdeptName
				+ ", completeType=" + completeType + ", subGrade=" + subGrade + ", madeDate=" + madeDate
				+ ", enrolType=" + enrolType + "]";
	}


		
}