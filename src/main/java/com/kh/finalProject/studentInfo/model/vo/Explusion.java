package com.kh.finalProject.studentInfo.model.vo;

public class Explusion implements java.io.Serializable{
	private String explusionNo;
	private String explusionDate;
	private String explusionReason;
	private String studentNo;
	private String collegeCode;
	private String collegeName;
	private String sdeptCode;
	private String sdeptName;
	private int grade;
	private String memberKName;
	private String seStudentNo;
	private String warnStudentNo;
	private String osStudentNo;
	
	public Explusion() {}

	public Explusion(String explusionNo, String explusionDate, String explusionReason, String studentNo,
			String collegeCode, String collegeName, String sdeptCode, String sdeptName, int grade, String memberKName,
			String seStudentNo, String warnStudentNo, String osStudentNo) {
		super();
		this.explusionNo = explusionNo;
		this.explusionDate = explusionDate;
		this.explusionReason = explusionReason;
		this.studentNo = studentNo;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.sdeptCode = sdeptCode;
		this.sdeptName = sdeptName;
		this.grade = grade;
		this.memberKName = memberKName;
		this.seStudentNo = seStudentNo;
		this.warnStudentNo = warnStudentNo;
		this.osStudentNo = osStudentNo;
	}

	public String getExplusionNo() {
		return explusionNo;
	}

	public void setExplusionNo(String explusionNo) {
		this.explusionNo = explusionNo;
	}

	public String getExplusionDate() {
		return explusionDate;
	}

	public void setExplusionDate(String explusionDate) {
		this.explusionDate = explusionDate;
	}

	public String getExplusionReason() {
		return explusionReason;
	}

	public void setExplusionReason(String explusionReason) {
		this.explusionReason = explusionReason;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getSeStudentNo() {
		return seStudentNo;
	}

	public void setSeStudentNo(String seStudentNo) {
		this.seStudentNo = seStudentNo;
	}

	public String getWarnStudentNo() {
		return warnStudentNo;
	}

	public void setWarnStudentNo(String warnStudentNo) {
		this.warnStudentNo = warnStudentNo;
	}

	public String getOsStudentNo() {
		return osStudentNo;
	}

	public void setOsStudentNo(String osStudentNo) {
		this.osStudentNo = osStudentNo;
	}

	@Override
	public String toString() {
		return "Explusion [explusionNo=" + explusionNo + ", explusionDate=" + explusionDate + ", explusionReason="
				+ explusionReason + ", studentNo=" + studentNo + ", collegeCode=" + collegeCode + ", collegeName="
				+ collegeName + ", sdeptCode=" + sdeptCode + ", sdeptName=" + sdeptName + ", grade=" + grade
				+ ", memberKName=" + memberKName + ", seStudentNo=" + seStudentNo + ", warnStudentNo=" + warnStudentNo
				+ ", osStudentNo=" + osStudentNo + "]";
	}	
	
}
