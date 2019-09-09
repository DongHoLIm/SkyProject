package com.kh.finalProject.employee.classManagement.model.vo;

public class DepartmentProfessor implements java.io.Serializable{
	private String professorNo;
	private String professorName;
	
	public DepartmentProfessor() {}

	public DepartmentProfessor(String professorNo, String professorName) {
		super();
		this.professorNo = professorNo;
		this.professorName = professorName;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	@Override
	public String toString() {
		return "DepartmentProfessor [professorNo=" + professorNo + ", professorName=" + professorName + "]";
	}
	
	
}
