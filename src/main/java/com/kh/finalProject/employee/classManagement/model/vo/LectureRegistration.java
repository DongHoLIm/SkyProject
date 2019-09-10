package com.kh.finalProject.employee.classManagement.model.vo;

public class LectureRegistration implements java.io.Serializable{
	private String openSubCode;
	private int studentMax;
	private int studentCount;
	private int openYear;
	private int openSemester;
	private String professorNo;
	private String closeCheck;
	private String closeReason;
	private String buildingName;
	private String roomName;
	private String dayInfo;
	private String timeInfo;
	
	public LectureRegistration() {}

	public LectureRegistration(String openSubCode, int studentMax, int studentCount, int openYear, int openSemester,
			String professorNo, String closeCheck, String closeReason, String buildingName, String roomName,
			String dayInfo, String timeInfo) {
		super();
		this.openSubCode = openSubCode;
		this.studentMax = studentMax;
		this.studentCount = studentCount;
		this.openYear = openYear;
		this.openSemester = openSemester;
		this.professorNo = professorNo;
		this.closeCheck = closeCheck;
		this.closeReason = closeReason;
		this.buildingName = buildingName;
		this.roomName = roomName;
		this.dayInfo = dayInfo;
		this.timeInfo = timeInfo;
	}

	public String getOpenSubCode() {
		return openSubCode;
	}

	public void setOpenSubCode(String openSubCode) {
		this.openSubCode = openSubCode;
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

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	@Override
	public String toString() {
		return "LectureRegistration [openSubCode=" + openSubCode + ", studentMax=" + studentMax + ", studentCount="
				+ studentCount + ", openYear=" + openYear + ", openSemester=" + openSemester + ", professorNo="
				+ professorNo + ", closeCheck=" + closeCheck + ", closeReason=" + closeReason + ", buildingName="
				+ buildingName + ", roomName=" + roomName + ", dayInfo=" + dayInfo + ", timeInfo=" + timeInfo + "]";
	}

	
		
}
