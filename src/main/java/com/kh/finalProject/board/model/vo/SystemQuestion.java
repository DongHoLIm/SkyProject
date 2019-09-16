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
	private int originNo;
	private int groupOrd;
	private int groupLayer;
	private String originWriter;
	
	public SystemQuestion() {}

	

	public String getOriginWriter() {
		return originWriter;
	}



	public void setOriginWriter(String originWriter) {
		this.originWriter = originWriter;
	}



	public SystemQuestion(int questionNo, String questionType, String questionTitle, String questionContent,
			String questionWriter, String questionDate, String questionStatus, int questionCount, String memberId,
			int originNo, int groupOrd, int groupLayer, String originWriter) {
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
		this.originNo = originNo;
		this.groupOrd = groupOrd;
		this.groupLayer = groupLayer;
		this.originWriter = originWriter;
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

	public int getOriginNo() {
		return originNo;
	}

	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}

	public int getGroupOrd() {
		return groupOrd;
	}

	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}

	public int getGroupLayer() {
		return groupLayer;
	}

	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
	}



	@Override
	public String toString() {
		return "SystemQuestion [questionNo=" + questionNo + ", questionType=" + questionType + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", questionWriter=" + questionWriter
				+ ", questionDate=" + questionDate + ", questionStatus=" + questionStatus + ", questionCount="
				+ questionCount + ", memberId=" + memberId + ", originNo=" + originNo + ", groupOrd=" + groupOrd
				+ ", groupLayer=" + groupLayer + ", originWriter=" + originWriter + "]";
	}


	
}
