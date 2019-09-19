package com.kh.finalProject.employee.classManagement.model.vo;

public class OpenSubject implements java.io.Serializable{
	private String openSubCode;
	private String subName;
	private String sdeptName;
	private String professorName;
	private String professorNo;
	private int subGrade;
	private String completeType; 
	private int studentMax;
	private String roomName;
	private String buildingName;
	private String dayInfo;
	private String timeInfo;
	private int enrolType;
	private String studentNo;
	
	public OpenSubject() {}

	public OpenSubject(String openSubCode, String subName, String sdeptName, String professorName, String professorNo,
			int subGrade, String completeType, int studentMax, String roomName, String buildingName, String dayInfo,
			String timeInfo, int enrolType, String studentNo) {
		super();
		this.openSubCode = openSubCode;
		this.subName = subName;
		this.sdeptName = sdeptName;
		this.professorName = professorName;
		this.professorNo = professorNo;
		this.subGrade = subGrade;
		this.completeType = completeType;
		this.studentMax = studentMax;
		this.roomName = roomName;
		this.buildingName = buildingName;
		this.dayInfo = dayInfo;
		this.timeInfo = timeInfo;
		this.enrolType = enrolType;
		this.studentNo = studentNo;
	}

	public String getOpenSubCode() {
		return openSubCode;
	}

	public void setOpenSubCode(String openSubCode) {
		this.openSubCode = openSubCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public int getSubGrade() {
		return subGrade;
	}

	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}

	public String getCompleteType() {
		return completeType;
	}

	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}

	public int getStudentMax() {
		return studentMax;
	}

	public void setStudentMax(int studentMax) {
		this.studentMax = studentMax;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getDayInfo() {
		return dayInfo;
	}

	public void setDayInfo(String dayInfo) {
		this.dayInfo = dayInfo;
	}

	public String getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(String timeInfo) {
		this.timeInfo = timeInfo;
	}

	public int getEnrolType() {
		return enrolType;
	}

	public void setEnrolType(int enrolType) {
		this.enrolType = enrolType;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	@Override
	public String toString() {
		return "OpenSubject [openSubCode=" + openSubCode + ", subName=" + subName + ", sdeptName=" + sdeptName
				+ ", professorName=" + professorName + ", professorNo=" + professorNo + ", subGrade=" + subGrade
				+ ", completeType=" + completeType + ", studentMax=" + studentMax + ", roomName=" + roomName
				+ ", buildingName=" + buildingName + ", dayInfo=" + dayInfo + ", timeInfo=" + timeInfo + ", enrolType="
				+ enrolType + ", studentNo=" + studentNo + "]";
	}

}
