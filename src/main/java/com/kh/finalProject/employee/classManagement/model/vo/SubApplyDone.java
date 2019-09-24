package com.kh.finalProject.employee.classManagement.model.vo;

public class SubApplyDone implements java.io.Serializable{
	private String doneCode;
	private String subApplyCode;
	
	public SubApplyDone() {}

	public SubApplyDone(String doneCode, String subApplyCode) {
		super();
		this.doneCode = doneCode;
		this.subApplyCode = subApplyCode;
	}

	public String getDoneCode() {
		return doneCode;
	}

	public void setDoneCode(String doneCode) {
		this.doneCode = doneCode;
	}

	public String getSubApplyCode() {
		return subApplyCode;
	}

	public void setSubApplyCode(String subApplyCode) {
		this.subApplyCode = subApplyCode;
	}

	@Override
	public String toString() {
		return "SubApplyDone [doneCode=" + doneCode + ", subApplyCode=" + subApplyCode + "]";
	}
	
	
}
