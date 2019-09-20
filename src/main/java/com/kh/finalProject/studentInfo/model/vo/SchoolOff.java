package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class SchoolOff implements Serializable{
	private String studentNo;			//학번
	private String applyNo;				//휴학신청번호
	private Date applyDate;				//휴학신청날짜
	private String offStart;			//휴학시작학기
	private String offType;				//휴학구분
	private String offReason;			//휴학사유
	private String offTerm;				//희망휴학기간(1학기/2학기)
	private String offTermT;			//휴학기간(년도학기 - 년도학기)
	private String returnDate;			//복학예정학기
	private Date enlistmentDate;		//입대일자
	private Date demobilizationDate;	//전역예정
	private String requiredDoc;			//제출서류경로
	private String offStatus;			//처리상태
	private String phone;				//연락처
	
	public SchoolOff() {}

	public SchoolOff(String studentNo, String applyNo, Date applyDate, String offStart, String offType,
			String offReason, String offTerm, String offTermT, String returnDate, Date enlistmentDate,
			Date demobilizationDate, String requiredDoc, String offStatus, String phone) {
		super();
		this.studentNo = studentNo;
		this.applyNo = applyNo;
		this.applyDate = applyDate;
		this.offStart = offStart;
		this.offType = offType;
		this.offReason = offReason;
		this.offTerm = offTerm;
		this.offTermT = offTermT;
		this.returnDate = returnDate;
		this.enlistmentDate = enlistmentDate;
		this.demobilizationDate = demobilizationDate;
		this.requiredDoc = requiredDoc;
		this.offStatus = offStatus;
		this.phone = phone;
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

	public String getOffTermT() {
		return offTermT;
	}

	public void setOffTermT(String offTermT) {
		this.offTermT = offTermT;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SchoolOff [studentNo=" + studentNo + ", applyNo=" + applyNo + ", applyDate=" + applyDate + ", offStart="
				+ offStart + ", offType=" + offType + ", offReason=" + offReason + ", offTerm=" + offTerm
				+ ", offTermT=" + offTermT + ", returnDate=" + returnDate + ", enlistmentDate=" + enlistmentDate
				+ ", demobilizationDate=" + demobilizationDate + ", requiredDoc=" + requiredDoc + ", offStatus="
				+ offStatus + ", phone=" + phone + "]";
	}

	
	

}
