package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class SchoolOff implements Serializable{
	private String studentNo;			//학번
	private String applyNo;				//휴학신청번호
	private String applyDate;			//휴학신청날짜
	private String offStart;			//휴학시작학기
	private String offType;				//휴학구분
	private String offReason;			//휴학사유
	private String offTerm;				//희망휴학기간(1학기/2학기)
	private String offTermT;			//휴학기간(년도학기 - 년도학기)
	private String returnDate;			//복학예정학기
	private String enlistmentDate;		//입대일자
	private String demobilizationDate;	//전역예정
	private String offStatus;			//처리상태
	private String college;				//단과대명
	private String sdeptName;			//학과이름
	private String kName;				//이름
	
	public SchoolOff() {}

	public SchoolOff(String studentNo, String applyNo, String applyDate, String offStart, String offType,
			String offReason, String offTerm, String offTermT, String returnDate, String enlistmentDate,
			String demobilizationDate, String offStatus, String college, String sdeptName, String kName) {
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
		this.offStatus = offStatus;
		this.college = college;
		this.sdeptName = sdeptName;
		this.kName = kName;
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

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
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

	public String getEnlistmentDate() {
		return enlistmentDate;
	}

	public void setEnlistmentDate(String enlistmentDate) {
		this.enlistmentDate = enlistmentDate;
	}

	public String getDemobilizationDate() {
		return demobilizationDate;
	}

	public void setDemobilizationDate(String demobilizationDate) {
		this.demobilizationDate = demobilizationDate;
	}

	public String getOffStatus() {
		return offStatus;
	}

	public void setOffStatus(String offStatus) {
		this.offStatus = offStatus;
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

	public String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		this.kName = kName;
	}

	@Override
	public String toString() {
		return "SchoolOff [studentNo=" + studentNo + ", applyNo=" + applyNo + ", applyDate=" + applyDate + ", offStart="
				+ offStart + ", offType=" + offType + ", offReason=" + offReason + ", offTerm=" + offTerm
				+ ", offTermT=" + offTermT + ", returnDate=" + returnDate + ", enlistmentDate=" + enlistmentDate
				+ ", demobilizationDate=" + demobilizationDate + ", offStatus=" + offStatus + ", college=" + college
				+ ", sdeptName=" + sdeptName + ", kName=" + kName + "]";
	}

	

}
