package com.kh.finalProject.proof.model.vo;

public class Proof {
	private String certiCode;
	private String certiName;
	private String printCode;
	private String printDate;
	private String memberId;
	private int printCount;
	
	public Proof() {}

	public Proof(String certiCode, String certiName, String printCode, String printDate, String memberId,
			int printCount) {
		super();
		this.certiCode = certiCode;
		this.certiName = certiName;
		this.printCode = printCode;
		this.printDate = printDate;
		this.memberId = memberId;
		this.printCount = printCount;
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
				+ ", printDate=" + printDate + ", memberId=" + memberId + ", printCount=" + printCount + "]";
	}
	
	
	
}
