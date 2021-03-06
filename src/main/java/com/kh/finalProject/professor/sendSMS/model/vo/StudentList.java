package com.kh.finalProject.professor.sendSMS.model.vo;

public class StudentList implements java.io.Serializable{
	private String memberId;
	private String memberKName;
	private String phone;
	private String sdeptName;
	private String grade;
	private String message;
	
	public StudentList() {}

	public StudentList(String memberId, String memberKName, String phone, String sdeptName, String grade,
			String message) {
		super();
		this.memberId = memberId;
		this.memberKName = memberKName;
		this.phone = phone;
		this.sdeptName = sdeptName;
		this.grade = grade;
		this.message = message;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentList [memberId=" + memberId + ", memberKName=" + memberKName + ", phone=" + phone
				+ ", sdeptName=" + sdeptName + ", grade=" + grade + ", message=" + message + "]";
	}
	
}
