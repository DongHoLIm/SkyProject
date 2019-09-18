package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;

public class Graduation implements Serializable{
	private String studentNo;			//학번
	private String graduationCode; 		//졸업인증 코드
	private String sDeptCode;			//학과코드
	private String division;			//인증구분(교내/학과)
	private String graduationName;		//인증명
	private String graduationContent;	//인증내용
	private String check;				//인증여부
	private String graduationInfo;		//학생인증내용
	private String sdeptName;			//학과이름
	private String college;				//단과대이름
	
	public Graduation() {}

	public Graduation(String studentNo, String graduationCode, String sDeptCode, String division, String graduationName,
			String graduationContent, String check, String graduationInfo, String sdeptName, String college) {
		super();
		this.studentNo = studentNo;
		this.graduationCode = graduationCode;
		this.sDeptCode = sDeptCode;
		this.division = division;
		this.graduationName = graduationName;
		this.graduationContent = graduationContent;
		this.check = check;
		this.graduationInfo = graduationInfo;
		this.sdeptName = sdeptName;
		this.college = college;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getGraduationCode() {
		return graduationCode;
	}

	public void setGraduationCode(String graduationCode) {
		this.graduationCode = graduationCode;
	}

	public String getsDeptCode() {
		return sDeptCode;
	}

	public void setsDeptCode(String sDeptCode) {
		this.sDeptCode = sDeptCode;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGraduationName() {
		return graduationName;
	}

	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}

	public String getGraduationContent() {
		return graduationContent;
	}

	public void setGraduationContent(String graduationContent) {
		this.graduationContent = graduationContent;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getGraduationInfo() {
		return graduationInfo;
	}

	public void setGraduationInfo(String graduationInfo) {
		this.graduationInfo = graduationInfo;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Graduation [studentNo=" + studentNo + ", graduationCode=" + graduationCode + ", sDeptCode=" + sDeptCode
				+ ", division=" + division + ", graduationName=" + graduationName + ", graduationContent="
				+ graduationContent + ", check=" + check + ", graduationInfo=" + graduationInfo + ", sdeptName="
				+ sdeptName + ", college=" + college + "]";
	}

	
}
