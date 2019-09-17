package com.kh.finalProject.professor.sendSMS.model.vo;

import java.sql.Date;

public class SendSMSList implements java.io.Serializable{
	private String memberId;
	private String studentKName;
	private String SMSmessage;
	private String sendDate;
	private int memberCount;
	
	public SendSMSList() {}
	
	public SendSMSList(String memberId, String studentKName, String sMSmessage, String sendDate, int memberCount) {
		super();
		this.memberId = memberId;
		this.studentKName = studentKName;
		SMSmessage = sMSmessage;
		this.sendDate = sendDate;
		this.memberCount = memberCount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStudentKName() {
		return studentKName;
	}

	public void setStudentKName(String studentKName) {
		this.studentKName = studentKName;
	}

	public String getSMSmessage() {
		return SMSmessage;
	}

	public void setSMSmessage(String sMSmessage) {
		SMSmessage = sMSmessage;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "SendSMSList [memberId=" + memberId + ", studentKName=" + studentKName + ", SMSmessage=" + SMSmessage
				+ ", sendDate=" + sendDate + ", memberCount=" + memberCount + "]";
	}
	
	
}
