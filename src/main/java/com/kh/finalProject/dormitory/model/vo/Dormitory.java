package com.kh.finalProject.dormitory.model.vo;

import java.sql.Date;

public class Dormitory implements java.io.Serializable{
	private String dormitoryApplyNo;
	private String sdeptName;
	private String memberId;
	private String dorApplyYear;
	private String dorApplySemester;
	private String memberKname;
	private String memberNo;
	private String postNum;
	private String address;
	private String addressDetail;
	private String emerPhone;
	private String email;
	private String parentPhone;
	private String parentTel;
	private String bank;
	private String accountNo;
	private String dormCondition;
	private String smoking;
	private String basicLife;
	private String dormitoryName;
	private String dorApplyDate;
	private String aggrementStatus;
	
	public Dormitory() {}

	public Dormitory(String dormitoryApplyNo, String sdeptName, String memberId, String dorApplyYear,
			String dorApplySemester, String memberKname, String memberNo, String postNum, String address,
			String addressDetail, String emerPhone, String email, String parentPhone, String parentTel, String bank,
			String accountNo, String dormCondition, String smoking, String basicLife, String dormitoryName,
			String dorApplyDate, String aggrementStatus) {
		super();
		this.dormitoryApplyNo = dormitoryApplyNo;
		this.sdeptName = sdeptName;
		this.memberId = memberId;
		this.dorApplyYear = dorApplyYear;
		this.dorApplySemester = dorApplySemester;
		this.memberKname = memberKname;
		this.memberNo = memberNo;
		this.postNum = postNum;
		this.address = address;
		this.addressDetail = addressDetail;
		this.emerPhone = emerPhone;
		this.email = email;
		this.parentPhone = parentPhone;
		this.parentTel = parentTel;
		this.bank = bank;
		this.accountNo = accountNo;
		this.dormCondition = dormCondition;
		this.smoking = smoking;
		this.basicLife = basicLife;
		this.dormitoryName = dormitoryName;
		this.dorApplyDate = dorApplyDate;
		this.aggrementStatus = aggrementStatus;
	}

	public String getDormitoryApplyNo() {
		return dormitoryApplyNo;
	}

	public void setDormitoryApplyNo(String dormitoryApplyNo) {
		this.dormitoryApplyNo = dormitoryApplyNo;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDorApplyYear() {
		return dorApplyYear;
	}

	public void setDorApplyYear(String dorApplyYear) {
		this.dorApplyYear = dorApplyYear;
	}

	public String getDorApplySemester() {
		return dorApplySemester;
	}

	public void setDorApplySemester(String dorApplySemester) {
		this.dorApplySemester = dorApplySemester;
	}

	public String getMemberKname() {
		return memberKname;
	}

	public void setMemberKname(String memberKname) {
		this.memberKname = memberKname;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getEmerPhone() {
		return emerPhone;
	}

	public void setEmerPhone(String emerPhone) {
		this.emerPhone = emerPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getParentTel() {
		return parentTel;
	}

	public void setParentTel(String parentTel) {
		this.parentTel = parentTel;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getDormCondition() {
		return dormCondition;
	}

	public void setDormCondition(String dormCondition) {
		this.dormCondition = dormCondition;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getBasicLife() {
		return basicLife;
	}

	public void setBasicLife(String basicLife) {
		this.basicLife = basicLife;
	}

	public String getDormitoryName() {
		return dormitoryName;
	}

	public void setDormitoryName(String dormitoryName) {
		this.dormitoryName = dormitoryName;
	}

	public String getDorApplyDate() {
		return dorApplyDate;
	}

	public void setDorApplyDate(String dorApplyDate) {
		this.dorApplyDate = dorApplyDate;
	}

	public String getAggrementStatus() {
		return aggrementStatus;
	}

	public void setAggrementStatus(String aggrementStatus) {
		this.aggrementStatus = aggrementStatus;
	}

	@Override
	public String toString() {
		return "Dormitory [dormitoryApplyNo=" + dormitoryApplyNo + ", sdeptName=" + sdeptName + ", memberId=" + memberId
				+ ", dorApplyYear=" + dorApplyYear + ", dorApplySemester=" + dorApplySemester + ", memberKname="
				+ memberKname + ", memberNo=" + memberNo + ", postNum=" + postNum + ", address=" + address
				+ ", addressDetail=" + addressDetail + ", emerPhone=" + emerPhone + ", email=" + email
				+ ", parentPhone=" + parentPhone + ", parentTel=" + parentTel + ", bank=" + bank + ", accountNo="
				+ accountNo + ", dormCondition=" + dormCondition + ", smoking=" + smoking + ", basicLife=" + basicLife
				+ ", dormitoryName=" + dormitoryName + ", dorApplyDate=" + dorApplyDate + ", aggrementStatus="
				+ aggrementStatus + "]";
	}

	
	
}
