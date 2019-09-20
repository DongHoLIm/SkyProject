package com.kh.finalProject.studentInfo.model.vo;

public class DropOut implements java.io.Serializable{
	private String dropNo;
	private String studentNo;
	private String professorNo;
	private String dropReason;
	private String dropDate;
	private String successDate;
	private String dropInterview;
	private String interviewDate;
	private String dropStatus;
	private int grade;
	private String collegeCode;
	private String collegeName;
	private String sdeptCode;
	private String sdeptName;
	private String pdeptCode;
	private String pdeptName;
	private String studentName;
	private String professorName;
	private String studentPhone;
	private String professorPhone;
	private String bank;
	private String accountNo;
	private String accountHolder;
	private String rejectReason;
	
	public DropOut() {}

	public DropOut(String dropNo, String studentNo, String professorNo, String dropReason, String dropDate,
			String successDate, String dropInterview, String interviewDate, String dropStatus, int grade,
			String collegeCode, String collegeName, String sdeptCode, String sdeptName, String pdeptCode,
			String pdeptName, String studentName, String professorName, String studentPhone, String professorPhone,
			String bank, String accountNo, String accountHolder, String rejectReason) {
		super();
		this.dropNo = dropNo;
		this.studentNo = studentNo;
		this.professorNo = professorNo;
		this.dropReason = dropReason;
		this.dropDate = dropDate;
		this.successDate = successDate;
		this.dropInterview = dropInterview;
		this.interviewDate = interviewDate;
		this.dropStatus = dropStatus;
		this.grade = grade;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.sdeptCode = sdeptCode;
		this.sdeptName = sdeptName;
		this.pdeptCode = pdeptCode;
		this.pdeptName = pdeptName;
		this.studentName = studentName;
		this.professorName = professorName;
		this.studentPhone = studentPhone;
		this.professorPhone = professorPhone;
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.rejectReason = rejectReason;
	}

	

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	
	public String getPdeptCode() {
		return pdeptCode;
	}

	public void setPdeptCode(String pdeptCode) {
		this.pdeptCode = pdeptCode;
	}

	public String getPdeptName() {
		return pdeptName;
	}

	public void setPdeptName(String pdeptName) {
		this.pdeptName = pdeptName;
	}

	public String getDropNo() {
		return dropNo;
	}

	public void setDropNo(String dropNo) {
		this.dropNo = dropNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public String getDropDate() {
		return dropDate;
	}

	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}

	public String getSuccessDate() {
		return successDate;
	}

	public void setSuccessDate(String successDate) {
		this.successDate = successDate;
	}

	public String getDropInterview() {
		return dropInterview;
	}

	public void setDropInterview(String dropInterview) {
		this.dropInterview = dropInterview;
	}

	public String getDropStatus() {
		return dropStatus;
	}

	public void setDropStatus(String dropStatus) {
		this.dropStatus = dropStatus;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getSdeptCode() {
		return sdeptCode;
	}

	public void setSdeptCode(String sdeptCode) {
		this.sdeptCode = sdeptCode;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getProfessorPhone() {
		return professorPhone;
	}

	public void setProfessorPhone(String professorPhone) {
		this.professorPhone = professorPhone;
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

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "DropOut [dropNo=" + dropNo + ", studentNo=" + studentNo + ", professorNo=" + professorNo
				+ ", dropReason=" + dropReason + ", dropDate=" + dropDate + ", successDate=" + successDate
				+ ", dropInterview=" + dropInterview + ", interviewDate=" + interviewDate + ", dropStatus=" + dropStatus
				+ ", grade=" + grade + ", collegeCode=" + collegeCode + ", collegeName=" + collegeName + ", sdeptCode="
				+ sdeptCode + ", sdeptName=" + sdeptName + ", pdeptCode=" + pdeptCode + ", pdeptName=" + pdeptName
				+ ", studentName=" + studentName + ", professorName=" + professorName + ", studentPhone=" + studentPhone
				+ ", professorPhone=" + professorPhone + ", bank=" + bank + ", accountNo=" + accountNo
				+ ", accountHolder=" + accountHolder + ", rejectReason=" + rejectReason + "]";
	}
	
	
	
}
