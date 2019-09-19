package com.kh.finalProject.student.classmanagement.model.vo;

public class SubjectApply implements java.io.Serializable{
	private String openSubCode;
	private String subApplyCode;
	private String studentNo;
	private String applyType;
	private String applyDate;
	private String doneType;
	
	public SubjectApply() {}

	public SubjectApply(String openSubCode, String subApplyCode, String studentNo, String applyType, String applyDate,
			String doneType) {
		super();
		this.openSubCode = openSubCode;
		this.subApplyCode = subApplyCode;
		this.studentNo = studentNo;
		this.applyType = applyType;
		this.applyDate = applyDate;
		this.doneType = doneType;
	}

	public String getOpenSubCode() { 
		return openSubCode;
	}

	public void setOpenSubCode(String openSubCode) {
		this.openSubCode = openSubCode;
	}

	public String getSubApplyCode() {
		return subApplyCode;
	}

	public void setSubApplyCode(String subApplyCode) {
		this.subApplyCode = subApplyCode;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getDoneType() {
		return doneType;
	}

	public void setDoneType(String doneType) {
		this.doneType = doneType;
	}

	@Override
	public String toString() {
		return "SubjectApply [openSubCode=" + openSubCode + ", subApplyCode=" + subApplyCode + ", studentNo="
				+ studentNo + ", applyType=" + applyType + ", applyDate=" + applyDate + ", doneType=" + doneType + "]";
	}

}
