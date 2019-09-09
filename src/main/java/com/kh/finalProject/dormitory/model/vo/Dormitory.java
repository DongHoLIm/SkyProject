package com.kh.finalProject.dormitory.model.vo;

public class Dormitory implements java.io.Serializable{
	private int year;
	private int semester;
	private String status;
	private String applyCode;
	private String studentNo;
	
	public Dormitory() {}

	public Dormitory(int year, int semester, String status, String applyCode, String studentNo) {
		super();
		this.year = year;
		this.semester = semester;
		this.status = status;
		this.applyCode = applyCode;
		this.studentNo = studentNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	@Override
	public String toString() {
		return "Dormitory [year=" + year + ", semester=" + semester + ", status=" + status + ", applyCode=" + applyCode
				+ ", studentNo=" + studentNo + "]";
	}
	
	
}
