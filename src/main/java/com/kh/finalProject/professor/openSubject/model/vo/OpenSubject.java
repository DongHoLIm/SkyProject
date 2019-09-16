package com.kh.finalProject.professor.openSubject.model.vo;

public class OpenSubject {

	private int opensubCode;
	private int studentMax;
	private int studentCount;
	private int openYear;
	private int openSemester;
	private String professorNo;
	private String closeCheck;
	private String closeReason;
	private String roomCode;
	private String dayInfo;
	private String timeInfo;
	private String completeType;
	private int subGrade;
	private String roomName;
	private String buildingName;
	private String subName;
	
	public OpenSubject() {}

	public OpenSubject(int opensubCode, int studentMax, int studentCount, int openYear, int openSemester,
			String professorNo, String closeCheck, String closeReason, String roomCode, String dayInfo, String timeInfo,
			String completeType, int subGrade, String roomName, String buildingName, String subName) {
		super();
		this.opensubCode = opensubCode;
		this.studentMax = studentMax;
		this.studentCount = studentCount;
		this.openYear = openYear;
		this.openSemester = openSemester;
		this.professorNo = professorNo;
		this.closeCheck = closeCheck;
		this.closeReason = closeReason;
		this.roomCode = roomCode;
		this.dayInfo = dayInfo;
		this.timeInfo = timeInfo;
		this.completeType = completeType;
		this.subGrade = subGrade;
		this.roomName = roomName;
		this.buildingName = buildingName;
		this.subName = subName;
	}

	public int getOpensubCode() {
		return opensubCode;
	}

	public void setOpensubCode(int opensubCode) {
		this.opensubCode = opensubCode;
	}

	public int getStudentMax() {
		return studentMax;
	}

	public void setStudentMax(int studentMax) {
		this.studentMax = studentMax;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
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

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public String getCloseCheck() {
		return closeCheck;
	}

	public void setCloseCheck(String closeCheck) {
		this.closeCheck = closeCheck;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
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

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "OpenSubject [opensubCode=" + opensubCode + ", studentMax=" + studentMax + ", studentCount="
				+ studentCount + ", openYear=" + openYear + ", openSemester=" + openSemester + ", professorNo="
				+ professorNo + ", closeCheck=" + closeCheck + ", closeReason=" + closeReason + ", roomCode=" + roomCode
				+ ", dayInfo=" + dayInfo + ", timeInfo=" + timeInfo + ", completeType=" + completeType + ", subGrade="
				+ subGrade + ", roomName=" + roomName + ", buildingName=" + buildingName + ", subName=" + subName + "]";
	}


	
	
	
	
	
}
