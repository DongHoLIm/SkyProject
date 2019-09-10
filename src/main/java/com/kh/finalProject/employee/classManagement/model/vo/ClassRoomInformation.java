package com.kh.finalProject.employee.classManagement.model.vo;

public class ClassRoomInformation implements java.io.Serializable{
	private String buildingName;
	private String roomName;
	
	public ClassRoomInformation() {}

	public ClassRoomInformation(String buildingName, String roomName) {
		super();
		this.buildingName = buildingName;
		this.roomName = roomName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "ClassRoomInformation [buildingName=" + buildingName + ", roomName=" + roomName + "]";
	}

	
	
	
}
