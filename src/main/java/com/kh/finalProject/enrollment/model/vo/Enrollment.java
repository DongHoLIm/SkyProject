package com.kh.finalProject.enrollment.model.vo;

public class Enrollment implements java.io.Serializable{
	private String studentNo;
	private int enrollYear;
	private int enrollSemester;
	private int tuition;
	
	public Enrollment() {}

	public Enrollment(String studentNo, int enrollYear, int enrollSemester, int tuition) {
		super();
		this.studentNo = studentNo;
		this.enrollYear = enrollYear;
		this.enrollSemester = enrollSemester;
		this.tuition = tuition;
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

	@Override
	public String toString() {
		return "Enrollment [studentNo=" + studentNo + ", enrollYear=" + enrollYear + ", enrollSemester="
				+ enrollSemester + ", tuition=" + tuition + "]";
	}

	
	
	

}
