package com.kh.finalProject.enrollment.model.vo;

public class Enrollment implements java.io.Serializable{
	private String studentNo;
	private int enrollYear;
	private int enrollSemester;
	private int tuition;
	private String payStatus;
	private int payAmount;
	
	private int schoAmount;
	
	public Enrollment() {}

	public Enrollment(String studentNo, int enrollYear, int enrollSemester, int tuition, String payStatus,
			int payAmount, int schoAmount) {
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

	public int getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(int enrollYear) {
		this.enrollYear = enrollYear;
	}

	public int getEnrollSemester() {
		return enrollSemester;
	}

	public void setEnrollSemester(int enrollSemester) {
		this.enrollSemester = enrollSemester;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
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
		return "Enrollment [studentNo=" + studentNo + ", enrollYear=" + enrollYear + ", enrollSemester="
				+ enrollSemester + ", tuition=" + tuition + ", payStatus=" + payStatus + ", payAmount=" + payAmount
				+ ", schoAmount=" + schoAmount + "]";
	}

	

}
