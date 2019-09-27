package com.kh.finalProject.lectureEvaluation.model.vo;

public class LectureEvaluation implements java.io.Serializable{
	private String lectureNo;
	private String doneCode;
	private int allCount;
	private int memberCount;
	private String doneStatus;
	private String openStatus;
	private String evalCode;
	private String subName;
	private String pdeptName;
	private String professorName;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private double totalCount;
	private double avgCount;	
	private String openSubCode;
	private String studentNo;
	
	public LectureEvaluation() {}

	public LectureEvaluation(String lectureNo, String doneCode, int allCount, int memberCount, String doneStatus,
			String openStatus, String evalCode, String subName, String pdeptName, String professorName, String answer1,
			String answer2, String answer3, String answer4, String answer5, double totalCount, double avgCount,
			String openSubCode, String studentNo) {
		super();
		this.lectureNo = lectureNo;
		this.doneCode = doneCode;
		this.allCount = allCount;
		this.memberCount = memberCount;
		this.doneStatus = doneStatus;
		this.openStatus = openStatus;
		this.evalCode = evalCode;
		this.subName = subName;
		this.pdeptName = pdeptName;
		this.professorName = professorName;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.totalCount = totalCount;
		this.avgCount = avgCount;
		this.openSubCode = openSubCode;
		this.studentNo = studentNo;
	}


	


	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getOpenSubCode() {
		return openSubCode;
	}


	public void setOpenSubCode(String openSubCode) {
		this.openSubCode = openSubCode;
	}


	public String getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(String lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getDoneCode() {
		return doneCode;
	}

	public void setDoneCode(String doneCode) {
		this.doneCode = doneCode;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public String getDoneStatus() {
		return doneStatus;
	}

	public void setDoneStatus(String doneStatus) {
		this.doneStatus = doneStatus;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getEvalCode() {
		return evalCode;
	}

	public void setEvalCode(String evalCode) {
		this.evalCode = evalCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getPdeptName() {
		return pdeptName;
	}

	public void setPdeptName(String pdeptName) {
		this.pdeptName = pdeptName;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public double getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}

	public double getAvgCount() {
		return avgCount;
	}

	public void setAvgCount(double avgCount) {
		this.avgCount = avgCount;
	}

	@Override
	public String toString() {
		return "LectureEvaluation [lectureNo=" + lectureNo + ", doneCode=" + doneCode + ", allCount=" + allCount
				+ ", memberCount=" + memberCount + ", doneStatus=" + doneStatus + ", openStatus=" + openStatus
				+ ", evalCode=" + evalCode + ", subName=" + subName + ", pdeptName=" + pdeptName + ", professorName="
				+ professorName + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3
				+ ", answer4=" + answer4 + ", answer5=" + answer5 + ", totalCount=" + totalCount + ", avgCount="
				+ avgCount + ", openSubCode=" + openSubCode + ", studentNo=" + studentNo + "]";
	}


	
	
	
}
