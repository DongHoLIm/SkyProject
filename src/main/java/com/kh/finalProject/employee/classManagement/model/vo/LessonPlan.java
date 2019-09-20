package com.kh.finalProject.employee.classManagement.model.vo;

public class LessonPlan {
	private String opensubCode;
	private int middleExam;
	private int finalExam;
	private int homework;
	private int attendance;
	private String classGoal;
	private String evaluationPeriod;
	private String subName;
	private String timeInfo;
	private String mebmerKname;
	private String completeType;
	private String roomName;
	private int subGrade;
	private int engagement;
	
	public LessonPlan() {}

	public LessonPlan(String opensubCode, int middleExam, int finalExam, int homework, int attendance, String classGoal,
			String evaluationPeriod, String subName, String timeInfo, String mebmerKname, String completeType,
			String roomName, int subGrade, int engagement) {
		super();
		this.opensubCode = opensubCode;
		this.middleExam = middleExam;
		this.finalExam = finalExam;
		this.homework = homework;
		this.attendance = attendance;
		this.classGoal = classGoal;
		this.evaluationPeriod = evaluationPeriod;
		this.subName = subName;
		this.timeInfo = timeInfo;
		this.mebmerKname = mebmerKname;
		this.completeType = completeType;
		this.roomName = roomName;
		this.subGrade = subGrade;
		this.engagement = engagement;
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

	public int getHomework() {
		return homework;
	}

	public void setHomework(int homework) {
		this.homework = homework;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public String getClassGoal() {
		return classGoal;
	}

	public void setClassGoal(String classGoal) {
		this.classGoal = classGoal;
	}

	public String getEvaluationPeriod() {
		return evaluationPeriod;
	}

	public void setEvaluationPeriod(String evaluationPeriod) {
		this.evaluationPeriod = evaluationPeriod;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(String timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getMebmerKname() {
		return mebmerKname;
	}

	public void setMebmerKname(String mebmerKname) {
		this.mebmerKname = mebmerKname;
	}

	public String getCompleteType() {
		return completeType;
	}

	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getSubGrade() {
		return subGrade;
	}

	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}

	public int getEngagement() {
		return engagement;
	}

	public void setEngagement(int engagement) {
		this.engagement = engagement;
	}

	@Override
	public String toString() {
		return "LessonPlan [opensubCode=" + opensubCode + ", middleExam=" + middleExam + ", finalExam=" + finalExam
				+ ", homework=" + homework + ", attendance=" + attendance + ", classGoal=" + classGoal
				+ ", evaluationPeriod=" + evaluationPeriod + ", subName=" + subName + ", timeInfo=" + timeInfo
				+ ", mebmerKname=" + mebmerKname + ", completeType=" + completeType + ", roomName=" + roomName
				+ ", subGrade=" + subGrade + ", engagement=" + engagement + "]";
	}

	
	
	
	
	
	
}
