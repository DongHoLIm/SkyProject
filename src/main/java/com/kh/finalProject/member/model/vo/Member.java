package com.kh.finalProject.member.model.vo;

import java.util.ArrayList;

public class Member implements java.io.Serializable{
	private String memberId;
	private String memberPwd;
	private String memberKName;
	private String memberEName;
	private String memberNo;
	private String phone;
	private String email;
	private String address;
	private String memberStatus;
	private String loginCheck;
	private ArrayList<Member> list;
	
	public Member() {}
	
	

	public Member(String memberId, String memberPwd, String memberKName, String memberEName, String memberNo,
			String phone, String email, String address, String memberStatus, String loginCheck) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberKName = memberKName;
		this.memberEName = memberEName;
		this.memberNo = memberNo;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.memberStatus = memberStatus;
		this.loginCheck = loginCheck;
	}



	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getMemberEName() {
		return memberEName;
	}

	public void setMemberEName(String memberEName) {
		this.memberEName = memberEName;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(String loginCheck) {
		this.loginCheck = loginCheck;
	}
	


	public ArrayList<Member> getList() {
		return list;
	}



	public void setList(ArrayList<Member> list) {
		this.list = list;
	}



	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberKName=" + memberKName
				+ ", memberEName=" + memberEName + ", memberNo=" + memberNo + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", memberStatus=" + memberStatus + ", loginCheck=" + loginCheck + ", list="
				+ list + "]";
	}




	
	
}
