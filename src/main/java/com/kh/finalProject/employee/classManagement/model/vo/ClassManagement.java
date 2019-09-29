package com.kh.finalProject.employee.classManagement.model.vo;

public class ClassManagement implements java.io.Serializable{
	private String classCode;
	private String studentNo;
	private String doneCode;
	
	public ClassManagement() {}

	public ClassManagement(String classCode, String studentNo, String doneCode) {
		super();
		this.classCode = classCode;
		this.studentNo = studentNo;
		this.doneCode = doneCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getDoneCode() {
		return doneCode;
	}

	public void setDoneCode(String doneCode) {
		this.doneCode = doneCode;
	}

	@Override
	public String toString() {
		return "ClassManagement [classCode=" + classCode + ", studentNo=" + studentNo + ", doneCode=" + doneCode + "]";
	}
	
	
}
