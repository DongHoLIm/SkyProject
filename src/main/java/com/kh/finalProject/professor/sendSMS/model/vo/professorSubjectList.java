package com.kh.finalProject.professor.sendSMS.model.vo;

public class professorSubjectList implements java.io.Serializable {
	private String subCode;
	private String subName;
	private String professorNo;
	
	public professorSubjectList() {}
	
	public professorSubjectList(String subCode, String subName, String professorNo) {
		super();
		this.subCode = subCode;
		this.subName = subName;
		this.professorNo = professorNo;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getProfessorNo() {
		return professorNo;
	}
	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}
	@Override
	public String toString() {
		return "professorSubjectList [subCode=" + subCode + ", subName=" + subName + ", professorNo=" + professorNo
				+ "]";
	}
	
}
