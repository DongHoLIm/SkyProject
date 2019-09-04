package com.kh.finalProject.classmanagement.model.vo;

public class Inquiry {
	private String department;
	private String Isu;
	private String subject;
	
	public Inquiry() {}

	public Inquiry(String department, String isu, String subject) {
		super();
		this.department = department;
		Isu = isu;
		this.subject = subject;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIsu() {
		return Isu;
	}

	public void setIsu(String isu) {
		Isu = isu;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Inquiry [department=" + department + ", Isu=" + Isu + ", subject=" + subject + "]";
	}
	
	
	
}
