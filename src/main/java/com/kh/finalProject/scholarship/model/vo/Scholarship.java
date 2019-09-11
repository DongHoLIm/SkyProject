package com.kh.finalProject.scholarship.model.vo;

import java.sql.Date;

public class Scholarship implements java.io.Serializable{
	private int schoSemester;
	private int schoAmount;
	private String schoType;
	private String studentNo;
	
	private String schoApplyCode;
	private String schoStatus;
	private int schoYear;
	private String memberKname;
	private String sdeptCode;
	private String sdeptName;
	private String memberGender;
	private String schoApplyName;
	private String schoApplyYn;
	private Date schoApplyDate;
	private Date schoAggrementDate;
	
	public Scholarship() {}

	public Scholarship(int schoSemester, int schoAmount, String schoType, String studentNo, String schoApplyCode,
			String schoStatus, int schoYear, String memberKname, String sdeptCode, String sdeptName,
			String memberGender, String schoApplyName, String schoApplyYn, Date schoApplyDate, Date schoAggrementDate) {
		super();
		this.schoSemester = schoSemester;
		this.schoAmount = schoAmount;
		this.schoType = schoType;
		this.studentNo = studentNo;
		this.schoApplyCode = schoApplyCode;
		this.schoStatus = schoStatus;
		this.schoYear = schoYear;
		this.memberKname = memberKname;
		this.sdeptCode = sdeptCode;
		this.sdeptName = sdeptName;
		this.memberGender = memberGender;
		this.schoApplyName = schoApplyName;
		this.schoApplyYn = schoApplyYn;
		this.schoApplyDate = schoApplyDate;
		this.schoAggrementDate = schoAggrementDate;
	}

	public int getSchoSemester() {
		return schoSemester;
	}

	public void setSchoSemester(int schoSemester) {
		this.schoSemester = schoSemester;
	}

	public int getSchoAmount() {
		return schoAmount;
	}

	public void setSchoAmount(int schoAmount) {
		this.schoAmount = schoAmount;
	}

	public String getSchoType() {
		return schoType;
	}

	public void setSchoType(String schoType) {
		this.schoType = schoType;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getSchoApplyCode() {
		return schoApplyCode;
	}

	public void setSchoApplyCode(String schoApplyCode) {
		this.schoApplyCode = schoApplyCode;
	}

	public String getSchoStatus() {
		return schoStatus;
	}

	public void setSchoStatus(String schoStatus) {
		this.schoStatus = schoStatus;
	}

	public int getSchoYear() {
		return schoYear;
	}

	public void setSchoYear(int schoYear) {
		this.schoYear = schoYear;
	}

	public String getMemberKname() {
		return memberKname;
	}

	public void setMemberKname(String memberKname) {
		this.memberKname = memberKname;
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

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getSchoApplyName() {
		return schoApplyName;
	}

	public void setSchoApplyName(String schoApplyName) {
		this.schoApplyName = schoApplyName;
	}

	public String getSchoApplyYn() {
		return schoApplyYn;
	}

	public void setSchoApplyYn(String schoApplyYn) {
		this.schoApplyYn = schoApplyYn;
	}

	public Date getSchoApplyDate() {
		return schoApplyDate;
	}

	public void setSchoApplyDate(Date schoApplyDate) {
		this.schoApplyDate = schoApplyDate;
	}

	public Date getSchoAggrementDate() {
		return schoAggrementDate;
	}

	public void setSchoAggrementDate(Date schoAggrementDate) {
		this.schoAggrementDate = schoAggrementDate;
	}

	@Override
	public String toString() {
		return "Scholarship [schoSemester=" + schoSemester + ", schoAmount=" + schoAmount + ", schoType=" + schoType
				+ ", studentNo=" + studentNo + ", schoApplyCode=" + schoApplyCode + ", schoStatus=" + schoStatus
				+ ", schoYear=" + schoYear + ", memberKname=" + memberKname + ", sdeptCode=" + sdeptCode
				+ ", sdeptName=" + sdeptName + ", memberGender=" + memberGender + ", schoApplyName=" + schoApplyName
				+ ", schoApplyYn=" + schoApplyYn + ", schoApplyDate=" + schoApplyDate + ", schoAggrementDate="
				+ schoAggrementDate + "]";
	}
	
	
	
//	public Scholarship(int schoSemester, int schoAmount, String schoType, String studentNo) {
//		super();
//		this.schoSemester = schoSemester;
//		this.schoAmount = schoAmount;
//		this.schoType = schoType;
//		this.studentNo = studentNo;
//	}
//
//	public int getSchoSemester() {
//		return schoSemester;
//	}
//
//	public void setSchoSemester(int schoSemester) {
//		this.schoSemester = schoSemester;
//	}
//
//	public int getSchoAmount() {
//		return schoAmount;
//	}
//
//	public void setSchoAmount(int schoAmount) {
//		this.schoAmount = schoAmount;
//	}
//
//	public String getSchoType() {
//		return schoType;
//	}
//
//	public void setSchoType(String schoType) {
//		this.schoType = schoType;
//	}
//
//	public String getStudentNo() {
//		return studentNo;
//	}
//
//	public void setStudentNo(String studentNo) {
//		this.studentNo = studentNo;
//	}
//
//	@Override
//	public String toString() {
//		return "Scholarship [schoSemester=" + schoSemester + ", schoAmount=" + schoAmount + ", schoType=" + schoType
//				+ ", studentNo=" + studentNo + "]";
//	}
}
