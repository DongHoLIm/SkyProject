package com.kh.finalProject.scholarship.model.vo;

import java.sql.Date;

public class ScholarshipApply implements java.io.Serializable{
	private String schoApplyCode;
	private String schoStatus;
	private int schoYear;
	private int schoSemester;
	private String studentNo;
	private String memberKname;
	private String sdeptCode;
	private String sdeptName;
	private String memberGender;
	private String schoApplyName;
	private String schoApplyYn;
	private Date schoApplyDate;
	private Date schoAggrementDate;
	
	public ScholarshipApply() {}

	public ScholarshipApply(String schoApplyCode, String schoStatus, int schoYear, int schoSemester, String studentNo,
			String memberKname, String sdeptCode, String sdeptName, String memberGender, String schoApplyName,
			String schoApplyYn, Date schoApplyDate, Date schoAggrementDate) {
		super();
		this.schoApplyCode = schoApplyCode;
		this.schoStatus = schoStatus;
		this.schoYear = schoYear;
		this.schoSemester = schoSemester;
		this.studentNo = studentNo;
		this.memberKname = memberKname;
		this.sdeptCode = sdeptCode;
		this.sdeptName = sdeptName;
		this.memberGender = memberGender;
		this.schoApplyName = schoApplyName;
		this.schoApplyYn = schoApplyYn;
		this.schoApplyDate = schoApplyDate;
		this.schoAggrementDate = schoAggrementDate;
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

	public int getSchoSemester() {
		return schoSemester;
	}

	public void setSchoSemester(int schoSemester) {
		this.schoSemester = schoSemester;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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
		return "ScholarshipApply [schoApplyCode=" + schoApplyCode + ", schoStatus=" + schoStatus + ", schoYear="
				+ schoYear + ", schoSemester=" + schoSemester + ", studentNo=" + studentNo + ", memberKname="
				+ memberKname + ", sdeptCode=" + sdeptCode + ", sdeptName=" + sdeptName + ", memberGender="
				+ memberGender + ", schoApplyName=" + schoApplyName + ", schoApplyYn=" + schoApplyYn
				+ ", schoApplyDate=" + schoApplyDate + ", schoAggrementDate=" + schoAggrementDate + "]";
	}

}
