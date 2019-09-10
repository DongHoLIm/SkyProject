package com.kh.finalProject.employee.classManagement.model.vo;

public class LectureRegistration {
	private String openSubCode;
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
	
	public LectureRegistration() {}

	public LectureRegistration(String openSubCode, int studentMax, int studentCount, int openYear, int openSemester,
			String professorNo, String closeCheck, String closeReason, String roomCode, String dayInfo,
			String timeInfo) {
		super();
		this.openSubCode = openSubCode;
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

	@Override
	public String toString() {
		return "LectureRegistration [openSubCode=" + openSubCode + ", studentMax=" + studentMax + ", studentCount="
				+ studentCount + ", openYear=" + openYear + ", openSemester=" + openSemester + ", professorNo="
				+ professorNo + ", closeCheck=" + closeCheck + ", closeReason=" + closeReason + ", roomCode=" + roomCode
				+ ", dayInfo=" + dayInfo + ", timeInfo=" + timeInfo + "]";
	}
	
	
}