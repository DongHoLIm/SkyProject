package com.kh.finalProject.professor.message.model.vo;

import java.sql.Date;

public class MessageVO {

	private String messageCode; 
	private Date sendDate;
	private String receMember; 
	private String messageTitle;
	private String messageContent;
	private Date receDate;
	private String memberId;
	
	
	public MessageVO() {}


	public MessageVO(String messageCode, Date sendDate, String receMember, String messageTitle, String messageContent,
			Date receDate, String memberId) {
		super();
		this.messageCode = messageCode;
		this.sendDate = sendDate;
		this.receMember = receMember;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.receDate = receDate;
		this.memberId = memberId;
	}


	public String getMessageCode() {
		return messageCode;
	}


	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}


	public Date getSendDate() {
		return sendDate;
	}


	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}


	public String getReceMember() {
		return receMember;
	}


	public void setReceMember(String receMember) {
		this.receMember = receMember;
	}


	public String getMessageTitle() {
		return messageTitle;
	}


	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}


	public Date getReceDate() {
		return receDate;
	}


	public void setReceDate(Date receDate) {
		this.receDate = receDate;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "MassageVO [messageCode=" + messageCode + ", sendDate=" + sendDate + ", receMember=" + receMember
				+ ", messageTitle=" + messageTitle + ", messageContent=" + messageContent + ", receDate=" + receDate
				+ ", memberId=" + memberId + "]";
	}
	
	
	
	
	

}
