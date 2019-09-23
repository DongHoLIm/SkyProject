package com.kh.finalProject.professor.result.model.vo;

public class StudentResult implements java.io.Serializable{
	private String gradeCode;
	private String studentNo;
	private String studentName;
	private String grade;
	private int middleScore;
	private int finalScore;
	private int workScore;
	private int attendanceScore;
	private int score;
	
	
	public StudentResult() {}


	public StudentResult(String gradeCode, String studentNo, String studentName, String grade, int middleScore,
			int finalScore, int workScore, int attendanceScore, int score) {
		super();
		this.gradeCode = gradeCode;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.grade = grade;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.workScore = workScore;
		this.attendanceScore = attendanceScore;
		this.score = score;
	}


	public String getGradeCode() {
		return gradeCode;
	}


	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getMiddleScore() {
		return middleScore;
	}


	public void setMiddleScore(int middleScore) {
		this.middleScore = middleScore;
	}


	public int getFinalScore() {
		return finalScore;
	}


	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}


	public int getWorkScore() {
		return workScore;
	}


	public void setWorkScore(int workScore) {
		this.workScore = workScore;
	}


	public int getAttendanceScore() {
		return attendanceScore;
	}


	public void setAttendanceScore(int attendanceScore) {
		this.attendanceScore = attendanceScore;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "StudentResult [gradeCode=" + gradeCode + ", studentNo=" + studentNo + ", studentName=" + studentName
				+ ", grade=" + grade + ", middleScore=" + middleScore + ", finalScore=" + finalScore + ", workScore="
				+ workScore + ", attendanceScore=" + attendanceScore + ", score=" + score + "]";
	}
	
	
}
