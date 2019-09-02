package com.kh.finalProject.board.model.vo;

public class Writer {
	private String memberId;
	private String memberName;
	private String edeptName;
	
	public Writer() {}

	public Writer(String memberId, String memberName, String edeptName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.edeptName = edeptName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEdeptName() {
		return edeptName;
	}

	public void setEdeptName(String edeptName) {
		this.edeptName = edeptName;
	}

	@Override
	public String toString() {
		return "Writer [memberId=" + memberId + ", memberName=" + memberName + ", edeptName=" + edeptName + "]";
	}

	
	
}
