package com.kh.finalProject.studentInfo.model.vo;

public class SecondMajor implements java.io.Serializable{
	private String applyCode;
	private String majorCheck;
	private String majorStatus;
	private int studentNo;
	private String sdeptCode;
	private String applyDate;
	private String sdeptName;
	private String collegeCode;
	private String collegeName;
	
	public SecondMajor() {}

	public SecondMajor(String applyCode, String majorCheck, String majorStatus, int studentNo, String sdeptCode,
			String applyDate, String sdeptName, String collegeCode, String collegeName) {
		super();
		this.applyCode = applyCode;
		this.majorCheck = majorCheck;
		this.majorStatus = majorStatus;
		this.studentNo = studentNo;
		this.sdeptCode = sdeptCode;
		this.applyDate = applyDate;
		this.sdeptName = sdeptName;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getMajorCheck() {
		return majorCheck;
	}

	public void setMajorCheck(String majorCheck) {
		this.majorCheck = majorCheck;
	}

	public String getMajorStatus() {
		return majorStatus;
	}

	public void setMajorStatus(String majorStatus) {
		this.majorStatus = majorStatus;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getSdeptCode() {
		return sdeptCode;
	}

	public void setSdeptCode(String sdeptCode) {
		this.sdeptCode = sdeptCode;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "SecondMajor [applyCode=" + applyCode + ", majorCheck=" + majorCheck + ", majorStatus=" + majorStatus
				+ ", studentNo=" + studentNo + ", sdeptCode=" + sdeptCode + ", applyDate=" + applyDate + ", sdeptName="
				+ sdeptName + ", collegeCode=" + collegeCode + ", collegeName=" + collegeName + "]";
	}

	
	
}
