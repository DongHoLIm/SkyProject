package com.kh.finalProject.professor.stuInfo.model.vo;

public class stuInfoVo implements java.io.Serializable{
	private String memberId;
	private String memberKName;
	private String memberEName;
	private String memberNo;
	private String stuStatus;
	private String grade;
	private String enroldate;
	
	public stuInfoVo(){}
	
	public stuInfoVo(String memberId, String memberKName, String memberEName, String memberNo, String stuStatus,
			String grade, String enroldate) {
		super();
		this.memberId = memberId;
		this.memberKName = memberKName;
		this.memberEName = memberEName;
		this.memberNo = memberNo;
		this.stuStatus = stuStatus;
		this.grade = grade;
		this.enroldate = enroldate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getStuStatus() {
		return stuStatus;
	}
	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEnroldate() {
		return enroldate;
	}
	public void setEnroldate(String enroldate) {
		this.enroldate = enroldate;
	}
	@Override
	public String toString() {
		return "stuInfoVo [memberId=" + memberId + ", memberKName=" + memberKName + ", memberEName=" + memberEName
				+ ", memberNo=" + memberNo + ", stuStatus=" + stuStatus + ", grade=" + grade + ", enroldate="
				+ enroldate + "]";
	}
	
}
