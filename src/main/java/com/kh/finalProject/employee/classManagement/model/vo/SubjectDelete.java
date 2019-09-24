package com.kh.finalProject.employee.classManagement.model.vo;

public class SubjectDelete {
	private String subCode;
	private String deleteDate;
	private String reason;
	public SubjectDelete(String subCode, String deleteDate, String reason) {
		super();
		this.subCode = subCode;
		this.deleteDate = deleteDate;
		this.reason = reason;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
