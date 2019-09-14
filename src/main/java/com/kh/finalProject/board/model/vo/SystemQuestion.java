package com.kh.finalProject.board.model.vo;

public class SystemQuestion implements java.io.Serializable{
	private int questionNo;
	private String questionType;
	private String questionTitle;
	private String questionContent;
	private String questionWriter;
	private String questionDate;
	private String questionStatus;
	private int questionCount;
	private String memberId;
	
	private int answerNo;
	private String answerTitle;
	private String answerContent;
	private String answerWriteDept;
	private String answerWriter;
	private String answerDate;
	private String answerStatus;
	private int answerCount;
	private int answerGroup;
	private int answerStep;
	private int answerIndent;
	
	public SystemQuestion() {}

	public SystemQuestion(int questionNo, String questionType, String questionTitle, String questionContent,
			String questionWriter, String questionDate, String questionStatus, int questionCount, String memberId,
			int answerNo, String answerTitle, String answerContent, String answerWriteDept, String answerWriter,
			String answerDate, String answerStatus, int answerCount, int answerGroup, int answerStep,
			int answerIndent) {
		super();
		this.questionNo = questionNo;
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionWriter = questionWriter;
		this.questionDate = questionDate;
		this.questionStatus = questionStatus;
		this.questionCount = questionCount;
		this.memberId = memberId;
		this.answerNo = answerNo;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerWriteDept = answerWriteDept;
		this.answerWriter = answerWriter;
		this.answerDate = answerDate;
		this.answerStatus = answerStatus;
		this.answerCount = answerCount;
		this.answerGroup = answerGroup;
		this.answerStep = answerStep;
		this.answerIndent = answerIndent;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionWriter() {
		return questionWriter;
	}

	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerWriteDept() {
		return answerWriteDept;
	}

	public void setAnswerWriteDept(String answerWriteDept) {
		this.answerWriteDept = answerWriteDept;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public int getAnswerGroup() {
		return answerGroup;
	}

	public void setAnswerGroup(int answerGroup) {
		this.answerGroup = answerGroup;
	}

	public int getAnswerStep() {
		return answerStep;
	}

	public void setAnswerStep(int answerStep) {
		this.answerStep = answerStep;
	}

	public int getAnswerIndent() {
		return answerIndent;
	}

	public void setAnswerIndent(int answerIndent) {
		this.answerIndent = answerIndent;
	}

	@Override
	public String toString() {
		return "SystemQusetion [questionNo=" + questionNo + ", questionType=" + questionType + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", questionWriter=" + questionWriter
				+ ", questionDate=" + questionDate + ", questionStatus=" + questionStatus + ", questionCount="
				+ questionCount + ", memberId=" + memberId + ", answerNo=" + answerNo + ", answerTitle=" + answerTitle
				+ ", answerContent=" + answerContent + ", answerWriteDept=" + answerWriteDept + ", answerWriter="
				+ answerWriter + ", answerDate=" + answerDate + ", answerStatus=" + answerStatus + ", answerCount="
				+ answerCount + ", answerGroup=" + answerGroup + ", answerStep=" + answerStep + ", answerIndent="
				+ answerIndent + "]";
	}
	
	
	
}
