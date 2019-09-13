package com.kh.finalProject.member.model.vo;

public class MemberAccount implements java.io.Serializable{
	private	String classManager; 			//수업관리
	private String scholarlyManager;		//학적관리
	private String enrollManager;			//등록관리
	private String scholManager;			//장학관리
	private String dormitoryManager;		//기숙사관리
	private String boardManager;			//정보생활관리
	private String employeeNo;				//교직원정보
	
	public MemberAccount() {}
	
	public MemberAccount(String classManager, String scholarlyManager, String enrollManager, String scholManager,
			String dormitoryManager, String boardManager, String employeeNo) {
		super();
		this.classManager = classManager;
		this.scholarlyManager = scholarlyManager;
		this.enrollManager = enrollManager;
		this.scholManager = scholManager;
		this.dormitoryManager = dormitoryManager;
		this.boardManager = boardManager;
		this.employeeNo = employeeNo;
	}



	public String getClassManager() {
		return classManager;
	}



	public void setClassManager(String classManager) {
		this.classManager = classManager;
	}



	public String getScholarlyManager() {
		return scholarlyManager;
	}



	public void setScholarlyManager(String scholarlyManager) {
		this.scholarlyManager = scholarlyManager;
	}



	public String getEnrollManager() {
		return enrollManager;
	}



	public void setEnrollManager(String enrollManager) {
		this.enrollManager = enrollManager;
	}



	public String getScholManager() {
		return scholManager;
	}



	public void setScholManager(String scholManager) {
		this.scholManager = scholManager;
	}



	public String getDormitoryManager() {
		return dormitoryManager;
	}



	public void setDormitoryManager(String dormitoryManager) {
		this.dormitoryManager = dormitoryManager;
	}


	public String getBoardManager() {
		return boardManager;
	}


	public void setBoardManager(String boardManager) {
		this.boardManager = boardManager;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}


	@Override
	public String toString() {
		return "MemberAccount [classManager=" + classManager + ", scholarlyManager=" + scholarlyManager
				+ ", enrollManager=" + enrollManager + ", scholManager=" + scholManager + ", dormitoryManager="
				+ dormitoryManager + ", boardManager=" + boardManager + ", employeeNo=" + employeeNo + "]";
	}	
	
}
