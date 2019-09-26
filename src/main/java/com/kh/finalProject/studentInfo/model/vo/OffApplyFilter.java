package com.kh.finalProject.studentInfo.model.vo;

public class OffApplyFilter {
	private String offType;
	private String offStatus;
	
	public OffApplyFilter() {}

	public OffApplyFilter(String offType, String offStatus) {
		super();
		this.offType = offType;
		this.offStatus = offStatus;
	}

	public String getOffType() {
		return offType;
	}

	public void setOffType(String offType) {
		this.offType = offType;
	}

	public String getOffStatus() {
		return offStatus;
	}

	public void setOffStatus(String offStatus) {
		this.offStatus = offStatus;
	}

	@Override
	public String toString() {
		return "OffApplyFilter [offType=" + offType + ", offStatus=" + offStatus + "]";
	}
	
	

}
