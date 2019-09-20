package com.kh.finalProject.print.model.vo;

public class Print implements java.io.Serializable{
	private String college;
	private String sdeptName;
	private int grade;
	private int enrollSemester;
	private String studentNo;
	private String memberNo;
	private String memberKname;
	private int enrollYear;
	private String payStatus;
	private int payAmount;
	private int schoAmount;
	
	public Print() {}

	public Print(String college, String sdeptName, int grade, int enrollSemester, String studentNo, String memberNo,
			String memberKname, int enrollYear, String payStatus, int payAmount, int schoAmount) {
		super();
		this.college = college;
		this.sdeptName = sdeptName;
		this.grade = grade;
		this.enrollSemester = enrollSemester;
		this.studentNo = studentNo;
		this.memberNo = memberNo;
		this.memberKname = memberKname;
		this.enrollYear = enrollYear;
		this.payStatus = payStatus;
		this.payAmount = payAmount;
		this.schoAmount = schoAmount;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getEnrollSemester() {
		return enrollSemester;
	}

	public void setEnrollSemester(int enrollSemester) {
		this.enrollSemester = enrollSemester;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberKname() {
		return memberKname;
	}

	public void setMemberKname(String memberKname) {
		this.memberKname = memberKname;
	}

	public int getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(int enrollYear) {
		this.enrollYear = enrollYear;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public int getSchoAmount() {
		return schoAmount;
	}

	public void setSchoAmount(int schoAmount) {
		this.schoAmount = schoAmount;
	}

	@Override
	public String toString() {
		return "Print [college=" + college + ", sdeptName=" + sdeptName + ", grade=" + grade + ", enrollSemester="
				+ enrollSemester + ", studentNo=" + studentNo + ", memberNo=" + memberNo + ", memberKname="
				+ memberKname + ", enrollYear=" + enrollYear + ", payStatus=" + payStatus + ", payAmount=" + payAmount
				+ ", schoAmount=" + schoAmount + "]";
	}
	
	
}
