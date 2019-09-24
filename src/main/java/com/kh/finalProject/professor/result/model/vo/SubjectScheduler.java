package com.kh.finalProject.professor.result.model.vo;

public class SubjectScheduler implements java.io.Serializable{

	private String opensubCode;
	private int middleExam;
	private int finalExam;
	private int homeWork;
	private int attendance;
	
	public SubjectScheduler() {}

	public SubjectScheduler(String opensubCode, int middleExam, int finalExam, int homeWork, int attendance) {
		super();
		this.opensubCode = opensubCode;
		this.middleExam = middleExam;
		this.finalExam = finalExam;
		this.homeWork = homeWork;
		this.attendance = attendance;
	}

	public String getOpensubCode() {
		return opensubCode;
	}

	public void setOpensubCode(String opensubCode) {
		this.opensubCode = opensubCode;
	}

	public int getMiddleExam() {
		return middleExam;
	}

	public void setMiddleExam(int middleExam) {
		this.middleExam = middleExam;
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

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "SubjectScheduler [opensubCode=" + opensubCode + ", middleExam=" + middleExam + ", finalExam="
				+ finalExam + ", homeWork=" + homeWork + ", attendance=" + attendance + "]";
	}
	
	
	
}
