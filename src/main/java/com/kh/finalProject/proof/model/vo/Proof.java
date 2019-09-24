package com.kh.finalProject.proof.model.vo;

public class Proof {
	private String certiCode;
	private String certiName;
	private String printCode;
	private String printDate;
	private String memberId;
	private int printCount;
	private String printStatus;
	private String memberKName;
	private String memberNo;
	private String enrollDate;
	private String graduatedDate;
	private String degreeNo;
	private String degreeName;
	private String graduatedNo;
	
	public Proof() {}	
	
	public Proof(String certiCode, String certiName, String printCode, String printDate, String memberId,
			int printCount, String printStatus, String memberKName, String memberNo, String enrollDate,
			String graduatedDate, String degreeNo, String degreeName, String graduatedNo) {
		super();
		this.certiCode = certiCode;
		this.certiName = certiName;
		this.printCode = printCode;
		this.printDate = printDate;
		this.memberId = memberId;
		this.printCount = printCount;
		this.printStatus = printStatus;
		this.memberKName = memberKName;
		this.memberNo = memberNo;
		this.enrollDate = enrollDate;
		this.graduatedDate = graduatedDate;
		this.degreeNo = degreeNo;
		this.degreeName = degreeName;
		this.graduatedNo = graduatedNo;
	}


	public String getGraduatedDate() {
		return graduatedDate;
	}


	public void setGraduatedDate(String graduatedDate) {
		this.graduatedDate = graduatedDate;
	}


	public String getDegreeNo() {
		return degreeNo;
	}


	public void setDegreeNo(String degreeNo) {
		this.degreeNo = degreeNo;
	}


	public String getDegreeName() {
		return degreeName;
	}


	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}


	public String getGraduatedNo() {
		return graduatedNo;
	}


	public void setGraduatedNo(String graduatedNo) {
		this.graduatedNo = graduatedNo;
	}


	public String getMemberKName() {
		return memberKName;
	}



	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}



	public String getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}



	public String getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getPrintStatus() {
		return printStatus;
	}


	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}


	public String getCertiCode() {
		return certiCode;
	}

	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}

	public String getCertiName() {
		return certiName;
	}

	public void setCertiName(String certiName) {
		this.certiName = certiName;
	}

	public String getPrintCode() {
		return printCode;
	}

	public void setPrintCode(String printCode) {
		this.printCode = printCode;
	}

	public String getPrintDate() {
		return printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}



	@Override
	public String toString() {
		return "Proof [certiCode=" + certiCode + ", certiName=" + certiName + ", printCode=" + printCode
				+ ", printDate=" + printDate + ", memberId=" + memberId + ", printCount=" + printCount
				+ ", printStatus=" + printStatus + ", memberKName=" + memberKName + ", memberNo=" + memberNo
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
