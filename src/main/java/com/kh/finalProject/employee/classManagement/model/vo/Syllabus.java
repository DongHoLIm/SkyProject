package com.kh.finalProject.employee.classManagement.model.vo;

public class Syllabus {
	private String opensubCode;
	private int middleMxam;
	private int finalExam;
	private int homeWork;
	private int attendDance;

	
	public Syllabus() {}
	
	public Syllabus(String opensubCode, int middleMxam, int finalExam, int homeWork, int attendDance) {
		super();
		this.opensubCode = opensubCode;
		this.middleMxam = middleMxam;
		this.finalExam = finalExam;
		this.homeWork = homeWork;
		this.attendDance = attendDance;
	}

	public String getOpensubCode() {
		return opensubCode;
	}

	public void setOpensubCode(String opensubCode) {
		this.opensubCode = opensubCode;
	}

	public int getMiddleMxam() {
		return middleMxam;
	}

	public void setMiddleMxam(int middleMxam) {
		this.middleMxam = middleMxam;
	}

	public int getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}

	public int getHomeWork() {
		return homeWork;
	}

	public void setHomeWork(int homeWork) {
		this.homeWork = homeWork;
	}

	public int getAttendDance() {
		return attendDance;
	}

	public void setAttendDance(int attendDance) {
		this.attendDance = attendDance;
	}

	@Override
	public String toString() {
		return "Syllabus [opensubCode=" + opensubCode + ", middleMxam=" + middleMxam + ", finalExam=" + finalExam
				+ ", homeWork=" + homeWork + ", attendDance=" + attendDance + "]";
	}

	
	
	
}
