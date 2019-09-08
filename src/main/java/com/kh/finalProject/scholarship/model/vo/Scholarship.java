package com.kh.finalProject.scholarship.model.vo;

public class Scholarship implements java.io.Serializable{
	private int schoSemester;
	private int tuition;
	private String schoType;
	private String studentNo;
	
	public Scholarship() {}
	
	public Scholarship(int schoSemester, int tuition, String schoType, String studentNo) {
		super();
		this.schoSemester = schoSemester;
		this.tuition = tuition;
		this.schoType = schoType;
		this.studentNo = studentNo;
	}

	public int getSchoSemester() {
		return schoSemester;
	}

	public void setSchoSemester(int schoSemester) {
		this.schoSemester = schoSemester;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	public String getSchoType() {
		return schoType;
	}

	public void setSchoType(String schoType) {
		this.schoType = schoType;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	@Override
	public String toString() {
		return "Scholarship [schoSemester=" + schoSemester + ", tuition=" + tuition + ", schoType=" + schoType
				+ ", studentNo=" + studentNo + "]";
	}
}
