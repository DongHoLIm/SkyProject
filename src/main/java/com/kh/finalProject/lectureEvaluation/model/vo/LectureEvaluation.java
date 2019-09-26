package com.kh.finalProject.lectureEvaluation.model.vo;

public class LectureEvaluation implements java.io.Serializable{
	private String evalCode;
	private String questionNo;
	private String answer;
	private String studentNo;
	private String classCode;
	private String subCode;
	private String subName;
	private String openYear;
	private String openSemester;
	private String studentCount;
	private String professorNo;
	private String memberKName;
	private String pdeptName;
	private String questionCode;
	private String questionNo2;
	private String questionContent;
	
	public LectureEvaluation() {}

	public LectureEvaluation(String evalCode, String questionNo, String answer, String studentNo, String classCode,
			String subCode, String subName, String openYear, String openSemester, String studentCount,
			String professorNo, String memberKName, String pdeptName, String questionCode, String questionNo2,
			String questionContent) {
		super();
		this.evalCode = evalCode;
		this.questionNo = questionNo;
		this.answer = answer;
		this.studentNo = studentNo;
		this.classCode = classCode;
		this.subCode = subCode;
		this.subName = subName;
		this.openYear = openYear;
		this.openSemester = openSemester;
		this.studentCount = studentCount;
		this.professorNo = professorNo;
		this.memberKName = memberKName;
		this.pdeptName = pdeptName;
		this.questionCode = questionCode;
		this.questionNo2 = questionNo2;
		this.questionContent = questionContent;
	}

	public String getEvalCode() {
		return evalCode;
	}

	public void setEvalCode(String evalCode) {
		this.evalCode = evalCode;
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getOpenYear() {
		return openYear;
	}

	public void setOpenYear(String openYear) {
		this.openYear = openYear;
	}

	public String getOpenSemester() {
		return openSemester;
	}

	public void setOpenSemester(String openSemester) {
		this.openSemester = openSemester;
	}

	public String getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(String studentCount) {
		this.studentCount = studentCount;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getPdeptName() {
		return pdeptName;
	}

	public void setPdeptName(String pdeptName) {
		this.pdeptName = pdeptName;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getQuestionNo2() {
		return questionNo2;
	}

	public void setQuestionNo2(String questionNo2) {
		this.questionNo2 = questionNo2;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Override
	public String toString() {
		return "LectureEvaluation [evalCode=" + evalCode + ", questionNo=" + questionNo + ", answer=" + answer
				+ ", studentNo=" + studentNo + ", classCode=" + classCode + ", subCode=" + subCode + ", subName="
				+ subName + ", openYear=" + openYear + ", openSemester=" + openSemester + ", studentCount="
				+ studentCount + ", professorNo=" + professorNo + ", memberKName=" + memberKName + ", pdeptName="
				+ pdeptName + ", questionCode=" + questionCode + ", questionNo2=" + questionNo2 + ", questionContent="
				+ questionContent + "]";
	}		
	
	
}
