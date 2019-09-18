package com.kh.finalProject.studentInfo.model.vo;

public class ChangeMajor implements java.io.Serializable{
	private String applyCode;
	private String applyDate;
	private String studentNo;
	private String changeSdept;
	private String status;
	private String doneDate;
	private String beforeMajor;
	private String reason;
	private String collegeCode;
	private String collegeName;
	private int grade;
	private Double avgScore;
	private String memberKName;
	private String changeSdeptName;
	private String beforeMajorName;
	
	public ChangeMajor() {}

	public ChangeMajor(String applyCode, String applyDate, String studentNo, String changeSdept, String status,
			String doneDate, String beforeMajor, String reason, String collegeCode, String collegeName, int grade,
			Double avgScore, String memberKName, String changeSdeptName, String beforeMajorName) {
		super();
		this.applyCode = applyCode;
		this.applyDate = applyDate;
		this.studentNo = studentNo;
		this.changeSdept = changeSdept;
		this.status = status;
		this.doneDate = doneDate;
		this.beforeMajor = beforeMajor;
		this.reason = reason;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.grade = grade;
		this.avgScore = avgScore;
		this.memberKName = memberKName;
		this.changeSdeptName = changeSdeptName;
		this.beforeMajorName = beforeMajorName;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getChangeSdept() {
		return changeSdept;
	}

	public void setChangeSdept(String changeSdept) {
		this.changeSdept = changeSdept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getBeforeMajor() {
		return beforeMajor;
	}

	public void setBeforeMajor(String beforeMajor) {
		this.beforeMajor = beforeMajor;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getChangeSdeptName() {
		return changeSdeptName;
	}

	public void setChangeSdeptName(String changeSdeptName) {
		this.changeSdeptName = changeSdeptName;
	}

	public String getBeforeMajorName() {
		return beforeMajorName;
	}

	public void setBeforeMajorName(String beforeMajorName) {
		this.beforeMajorName = beforeMajorName;
	}

	@Override
	public String toString() {
		return "ChangeMajor [applyCode=" + applyCode + ", applyDate=" + applyDate + ", studentNo=" + studentNo
				+ ", changeSdept=" + changeSdept + ", status=" + status + ", doneDate=" + doneDate + ", beforeMajor="
				+ beforeMajor + ", reason=" + reason + ", collegeCode=" + collegeCode + ", collegeName=" + collegeName
				+ ", grade=" + grade + ", avgScore=" + avgScore + ", memberKName=" + memberKName + ", changeSdeptName="
				+ changeSdeptName + ", beforeMajorName=" + beforeMajorName + "]";
	}
	
	
	
}
