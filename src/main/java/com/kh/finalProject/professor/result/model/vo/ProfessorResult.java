package com.kh.finalProject.professor.result.model.vo;

public class ProfessorResult implements java.io.Serializable {
	 private String opensubCode;
	 private String subName;
	 private String completeType;
	 private int subGrade;
	 private String roomName;
	 private String buildingName;
	 private String dayInfo;
	 private String timeInfo;
	 private int openYear;
	 private int openSemester;
	 
	 public ProfessorResult() {}

	

	public ProfessorResult(String opensubCode, String subName, String completeType, int subGrade, String roomName,
			String buildingName, String dayInfo, String timeInfo, int openYear, int openSemester) {
		super();
		this.opensubCode = opensubCode;
		this.subName = subName;
		this.completeType = completeType;
		this.subGrade = subGrade;
		this.roomName = roomName;
		this.buildingName = buildingName;
		this.dayInfo = dayInfo;
		this.timeInfo = timeInfo;
		this.openYear = openYear;
		this.openSemester = openSemester;
	}



	public String getOpensubCode() {
		return opensubCode;
	}



	public void setOpensubCode(String opensubCode) {
		this.opensubCode = opensubCode;
	}



	public String getSubName() {
		return subName;
	}



	public void setSubName(String subName) {
		this.subName = subName;
	}



	public String getCompleteType() {
		return completeType;
	}



	public void setCompleteType(String completeType) {
		this.completeType = completeType;
	}



	public int getSubGrade() {
		return subGrade;
	}



	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
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



	public int getOpenYear() {
		return openYear;
	}



	public void setOpenYear(int openYear) {
		this.openYear = openYear;
	}



	public int getOpenSemester() {
		return openSemester;
	}



	public void setOpenSemester(int openSemester) {
		this.openSemester = openSemester;
	}



	@Override
	public String toString() {
		return "ProfessorResult [opensubCode=" + opensubCode + ", subName=" + subName + ", completeType=" + completeType
				+ ", subGrade=" + subGrade + ", roomName=" + roomName + ", buildingName=" + buildingName + ", dayInfo="
				+ dayInfo + ", timeInfo=" + timeInfo + ", openYear=" + openYear + ", openSemester=" + openSemester
				+ "]";
	}
	
	
	 
}
