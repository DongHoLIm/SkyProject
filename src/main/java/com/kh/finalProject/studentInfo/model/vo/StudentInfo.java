package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class StudentInfo implements Serializable{
	private String studentNo;		//학번
	private String kName;			//한글이름
	private String eName;			//영문이름
	private String memberNo;		//주민번호
	private String phone;			//연락처
	private String email;			//이메일
	private String address;			//주소
	private String studentStatus; 	//학적상태
	private String college;			//단과대학
	private String sdeptName;		//학과
	private int grade;				//학년
	private String enrolType;		//입학구분
	private Date enrolDate;			//입학일자
	private int enroleGrade;		//입학학년
	private int enrolNo;			//수험번호
	private String secondMajor;		//다전공여부
	private double avgScore;		//평균학점
	private Date graduatedDate;		//졸업일자
	private String degreeNo;		//학위등록번호
	private String degreeName;		//학위명
	private String graduatedNo;		//졸업증서번호
	private String bank;			//은행명
	private String accountNo;		//계좌번호
	
	
	public StudentInfo() {}


	public StudentInfo(String studentNo, String kName, String eName, String memberNo, String phone, String email,
			String address, String studentStatus, String college, String sdeptName, int grade, String enrolType,
			Date enrolDate, int enroleGrade, int enrolNo, String secondMajor, double avgScore, Date graduatedDate,
			String degreeNo, String degreeName, String graduatedNo, String bank, String accountNo) {
		super();
		this.studentNo = studentNo;
		this.kName = kName;
		this.eName = eName;
		this.memberNo = memberNo;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.studentStatus = studentStatus;
		this.college = college;
		this.sdeptName = sdeptName;
		this.grade = grade;
		this.enrolType = enrolType;
		this.enrolDate = enrolDate;
		this.enroleGrade = enroleGrade;
		this.enrolNo = enrolNo;
		this.secondMajor = secondMajor;
		this.avgScore = avgScore;
		this.graduatedDate = graduatedDate;
		this.degreeNo = degreeNo;
		this.degreeName = degreeName;
		this.graduatedNo = graduatedNo;
		this.bank = bank;
		this.accountNo = accountNo;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getkName() {
		return kName;
	}


	public void setkName(String kName) {
		this.kName = kName;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStudentStatus() {
		return studentStatus;
	}


	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getSdeptName() {
		return sdeptName;
	}


	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getEnrolType() {
		return enrolType;
	}


	public void setEnrolType(String enrolType) {
		this.enrolType = enrolType;
	}


	public Date getEnrolDate() {
		return enrolDate;
	}


	public void setEnrolDate(Date enrolDate) {
		this.enrolDate = enrolDate;
	}


	public int getEnroleGrade() {
		return enroleGrade;
	}


	public void setEnroleGrade(int enroleGrade) {
		this.enroleGrade = enroleGrade;
	}


	public int getEnrolNo() {
		return enrolNo;
	}


	public void setEnrolNo(int enrolNo) {
		this.enrolNo = enrolNo;
	}


	public String getSecondMajor() {
		return secondMajor;
	}


	public void setSecondMajor(String secondMajor) {
		this.secondMajor = secondMajor;
	}


	public double getAvgScore() {
		return avgScore;
	}


	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}


	public Date getGraduatedDate() {
		return graduatedDate;
	}


	public void setGraduatedDate(Date graduatedDate) {
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


	@Override
	public String toString() {
		return "StudentInfo [studentNo=" + studentNo + ", kName=" + kName + ", eName=" + eName + ", memberNo="
				+ memberNo + ", phone=" + phone + ", email=" + email + ", address=" + address + ", studentStatus="
				+ studentStatus + ", college=" + college + ", sdeptName=" + sdeptName + ", grade=" + grade
				+ ", enrolType=" + enrolType + ", enrolDate=" + enrolDate + ", enroleGrade=" + enroleGrade
				+ ", enrolNo=" + enrolNo + ", secondMajor=" + secondMajor + ", avgScore=" + avgScore
				+ ", graduatedDate=" + graduatedDate + ", degreeNo=" + degreeNo + ", degreeName=" + degreeName
				+ ", graduatedNo=" + graduatedNo + ", bank=" + bank + ", accountNo=" + accountNo + "]";
	}


	
	
	

	
	
}

