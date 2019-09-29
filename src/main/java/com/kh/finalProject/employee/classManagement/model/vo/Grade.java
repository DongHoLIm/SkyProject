package com.kh.finalProject.employee.classManagement.model.vo;

public class Grade implements java.io.Serializable{
	private String gradCode;
	private String classCode;
	private String studentNo;
	private int middleScore;
	private int finalScore;
	private int workScore;
	private int attedanceScore;
	private String grade;
	private int score;
	
	public Grade() {}

	public Grade(String gradCode, String classCode, String studentNo, int middleScore, int finalScore, int workScore,
			int attedanceScore, String grade, int score) {
		super();
		this.gradCode = gradCode;
		this.classCode = classCode;
		this.studentNo = studentNo;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.workScore = workScore;
		this.attedanceScore = attedanceScore;
		this.grade = grade;
		this.score = score;
	}

	public String getGradCode() {
		return gradCode;
	}

	public void setGradCode(String gradCode) {
		this.gradCode = gradCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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

	public int getAttedanceScore() {
		return attedanceScore;
	}

	public void setAttedanceScore(int attedanceScore) {
		this.attedanceScore = attedanceScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [gradCode=" + gradCode + ", classCode=" + classCode + ", studentNo=" + studentNo
				+ ", middleScore=" + middleScore + ", finalScore=" + finalScore + ", workScore=" + workScore
				+ ", attedanceScore=" + attedanceScore + ", grade=" + grade + ", score=" + score + "]";
	}
	
	
}
