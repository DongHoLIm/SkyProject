package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class StudentInfo implements Serializable{
	private String studentNo;
	private String studentStatus;
	private String sdeptCode;
	private int grade;
	private String secondMajor;
	private double avgScore;
	private Date graduatedDate;
	private String degreeNo;
	private String degreeName;
	private String graduatedNo;
	private String bank;
	private String accountNo;
	
	public StudentInfo() {}

	public StudentInfo(String studentNo, String studentStatus, String sdeptCode, int grade, String secondMajor,
			double avgScore, Date graduatedDate, String degreeNo, String degreeName, String graduatedNo, String bank,
			String accountNo) {
		super();
		this.studentNo = studentNo;
		this.studentStatus = studentStatus;
		this.sdeptCode = sdeptCode;
		this.grade = grade;
		this.secondMajor = secondMajor;
		this.avgScore = avgScore;
		this.graduatedDate = graduatedDate;
		this.degreeNo = degreeNo;
		this.degreeName = degreeName;
		this.graduatedNo = graduatedNo;
		this.bank = bank;
		this.accountNo = accountNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getSdeptCode() {
		return sdeptCode;
	}

	public void setSdeptCode(String sdeptCode) {
		this.sdeptCode = sdeptCode;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSecondMajor() {
		return secondMajor;
	}

	public void setSecondMajor(String secondMajor) {
		this.secondMajor = secondMajor;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public String getDegreeNo() {
		return degreeNo;
	}

	public void setDegreeNo(String degreeNo) {
		this.degreeNo = degreeNo;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getGraduatedNo() {
		return graduatedNo;
	}

	public void setGraduatedNo(String graduatedNo) {
		this.graduatedNo = graduatedNo;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentNo=" + studentNo + ", studentStatus=" + studentStatus + ", sdeptCode=" + sdeptCode
				+ ", grade=" + grade + ", secondMajor=" + secondMajor + ", avgScore=" + avgScore + ", graduatedDate="
				+ graduatedDate + ", degreeNo=" + degreeNo + ", degreeName=" + degreeName + ", graduatedNo="
				+ graduatedNo + ", bank=" + bank + ", accountNo=" + accountNo + "]";
	}
	
	
	

	
	
}

