package com.kh.finalProject.enrollment.model.vo;

public class Enrollment implements java.io.Serializable{
	private String studentNo;
	private String enrollYear;
	private String enrollSemester;
	private String tuition;
	private String payStatus;
	private String payAmount;
	
	private String schoAmount;
	
	public Enrollment() {}

	public Enrollment(String studentNo, String enrollYear, String enrollSemester, String tuition, String payStatus,
			String payAmount, String schoAmount) {
		super();
		this.studentNo = studentNo;
		this.enrollYear = enrollYear;
		this.enrollSemester = enrollSemester;
		this.tuition = tuition;
		this.payStatus = payStatus;
		this.payAmount = payAmount;
		this.schoAmount = schoAmount;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(String enrollYear) {
		this.enrollYear = enrollYear;
	}

	public String getEnrollSemester() {
		return enrollSemester;
	}

	public void setEnrollSemester(String enrollSemester) {
		this.enrollSemester = enrollSemester;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getSchoAmount() {
		return schoAmount;
	}

	public void setSchoAmount(String schoAmount) {
		this.schoAmount = schoAmount;
	}

	@Override
	public String toString() {
		return "Enrollment [studentNo=" + studentNo + ", enrollYear=" + enrollYear + ", enrollSemester="
				+ enrollSemester + ", tuition=" + tuition + ", payStatus=" + payStatus + ", payAmount=" + payAmount
				+ ", schoAmount=" + schoAmount + "]";
	}

	

}
