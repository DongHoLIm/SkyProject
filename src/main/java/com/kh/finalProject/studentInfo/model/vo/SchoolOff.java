package com.kh.finalProject.studentInfo.model.vo;

import java.sql.Date;

public class SchoolOff {
	private String studentNo;
	private String applyNo;
	private Date applyDate;
	private String offStart;
	private String offType;
	private String offReason;
	private String offTerm;
	private String returnDate;
	private Date enlistmentDate;
	private Date demobilizationDate;
	private String requiredDoc;
	private String offStatus;
	
	public SchoolOff() {}

	public SchoolOff(String studentNo, String applyNo, Date applyDate, String offStart, String offType,
			String offReason, String offTerm, String returnDate, Date enlistmentDate, Date demobilizationDate,
			String requiredDoc, String offStatus) {
		super();
		this.studentNo = studentNo;
		this.applyNo = applyNo;
		this.applyDate = applyDate;
		this.offStart = offStart;
		this.offType = offType;
		this.offReason = offReason;
		this.offTerm = offTerm;
		this.returnDate = returnDate;
		this.enlistmentDate = enlistmentDate;
		this.demobilizationDate = demobilizationDate;
		this.requiredDoc = requiredDoc;
		this.offStatus = offStatus;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getOffStart() {
		return offStart;
	}

	public void setOffStart(String offStart) {
		this.offStart = offStart;
	}

	public String getOffType() {
		return offType;
	}

	public void setOffType(String offType) {
		this.offType = offType;
	}

	public String getOffReason() {
		return offReason;
	}

	public void setOffReason(String offReason) {
		this.offReason = offReason;
	}

	public String getOffTerm() {
		return offTerm;
	}

	public void setOffTerm(String offTerm) {
		this.offTerm = offTerm;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Date getEnlistmentDate() {
		return enlistmentDate;
	}

	public void setEnlistmentDate(Date enlistmentDate) {
		this.enlistmentDate = enlistmentDate;
	}

	public Date getDemobilizationDate() {
		return demobilizationDate;
	}

	public void setDemobilizationDate(Date demobilizationDate) {
		this.demobilizationDate = demobilizationDate;
	}

	public String getRequiredDoc() {
		return requiredDoc;
	}

	public void setRequiredDoc(String requiredDoc) {
		this.requiredDoc = requiredDoc;
	}

	public String getOffStatus() {
		return offStatus;
	}

	public void setOffStatus(String offStatus) {
		this.offStatus = offStatus;
	}

	@Override
	public String toString() {
		return "SchoolOff [studentNo=" + studentNo + ", applyNo=" + applyNo + ", applyDate=" + applyDate + ", offStart="
				+ offStart + ", offType=" + offType + ", offReason=" + offReason + ", offTerm=" + offTerm
				+ ", returnDate=" + returnDate + ", enlistmentDate=" + enlistmentDate + ", demobilizationDate="
				+ demobilizationDate + ", requiredDoc=" + requiredDoc + ", offStatus=" + offStatus + "]";
	}
	
	

}
