package com.kh.finalProject.dormitory.model.vo;

import java.sql.Date;

public class Dormitory implements java.io.Serializable{
	private String dormitoryApplyNo;
	private String studentNo;
	private int dorApplyYear;
	private int dorApplySemester;
	private Date dorApplyDate;
	private String aggrementStatus;
	private String memberKname;
	
	public Dormitory() {}

	public Dormitory(String dormitoryApplyNo, String studentNo, int dorApplyYear, int dorApplySemester,
			Date dorApplyDate, String aggrementStatus, String memberKname) {
		super();
		this.dormitoryApplyNo = dormitoryApplyNo;
		this.studentNo = studentNo;
		this.dorApplyYear = dorApplyYear;
		this.dorApplySemester = dorApplySemester;
		this.dorApplyDate = dorApplyDate;
		this.aggrementStatus = aggrementStatus;
		this.memberKname = memberKname;
	}

	public String getDormitoryApplyNo() {
		return dormitoryApplyNo;
	}

	public void setDormitoryApplyNo(String dormitoryApplyNo) {
		this.dormitoryApplyNo = dormitoryApplyNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getDorApplyYear() {
		return dorApplyYear;
	}

	public void setDorApplyYear(int dorApplyYear) {
		this.dorApplyYear = dorApplyYear;
	}

	public int getDorApplySemester() {
		return dorApplySemester;
	}

	public void setDorApplySemester(int dorApplySemester) {
		this.dorApplySemester = dorApplySemester;
	}

	public Date getDorApplyDate() {
		return dorApplyDate;
	}

	public void setDorApplyDate(Date dorApplyDate) {
		this.dorApplyDate = dorApplyDate;
	}

	public String getAggrementStatus() {
		return aggrementStatus;
	}

	public void setAggrementStatus(String aggrementStatus) {
		this.aggrementStatus = aggrementStatus;
	}

	public String getMemberKname() {
		return memberKname;
	}

	public void setMemberKname(String memberKname) {
		this.memberKname = memberKname;
	}

	@Override
	public String toString() {
		return "Dormitory [dormitoryApplyNo=" + dormitoryApplyNo + ", studentNo=" + studentNo + ", dorApplyYear="
				+ dorApplyYear + ", dorApplySemester=" + dorApplySemester + ", dorApplyDate=" + dorApplyDate
				+ ", aggrementStatus=" + aggrementStatus + ", memberKname=" + memberKname + "]";
	}

	

	
	
}
