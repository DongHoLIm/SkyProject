package com.kh.finalProject.board.model.vo;

public class SearchCondition implements java.io.Serializable{
	private String memberId;
	private String writer;
	private String writeDept;
	private String title;
	private String all;
	private String normal;
	private String schol;
	private String schedule;
	private String event;
	private String praise;
	private String free;
	private String proof;
	private String account;
	private String school;
	private String studentNo;
	private String originSdept;
	private String majorCheck;
	private String sdeptName;
	private String status;
	private String memberKName;
	private String dropNo;
	private String studentName;
	
	public SearchCondition() {}

	public SearchCondition(String memberId, String writer, String writeDept, String title, String all, String normal,
			String schol, String schedule, String event, String praise, String free, String proof, String account,
			String school) {
		super();
		this.memberId = memberId;
		this.writer = writer;
		this.writeDept = writeDept;
		this.title = title;
		this.all = all;
		this.normal = normal;
		this.schol = schol;
		this.schedule = schedule;
		this.event = event;
		this.praise = praise;
		this.free = free;
		this.proof = proof;
		this.account = account;
		this.school = school;
	}

	public SearchCondition(String memberId, String writer, String writeDept, String title, String all, String normal,
			String schol, String schedule, String event, String praise, String free, String proof, String account,
			String school, String studentNo, String originSdept, String majorCheck, String sdeptName, String status,
			String memberKName, String dropNo, String studentName) {
		super();
		this.memberId = memberId;
		this.writer = writer;
		this.writeDept = writeDept;
		this.title = title;
		this.all = all;
		this.normal = normal;
		this.schol = schol;
		this.schedule = schedule;
		this.event = event;
		this.praise = praise;
		this.free = free;
		this.proof = proof;
		this.account = account;
		this.school = school;
		this.studentNo = studentNo;
		this.originSdept = originSdept;
		this.majorCheck = majorCheck;
		this.sdeptName = sdeptName;
		this.status = status;
		this.memberKName = memberKName;
		this.dropNo = dropNo;
		this.studentName = studentName;
	}
	
	

	public String getDropNo() {
		return dropNo;
	}

	public void setDropNo(String dropNo) {
		this.dropNo = dropNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMemberKName() {
		return memberKName;
	}

	public void setMemberKName(String memberKName) {
		this.memberKName = memberKName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getOriginSdept() {
		return originSdept;
	}

	public void setOriginSdept(String originSdept) {
		this.originSdept = originSdept;
	}

	public String getMajorCheck() {
		return majorCheck;
	}

	public void setMajorCheck(String majorCheck) {
		this.majorCheck = majorCheck;
	}

	public String getSdeptName() {
		return sdeptName;
	}

	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDept() {
		return writeDept;
	}

	public void setWriteDept(String writeDept) {
		this.writeDept = writeDept;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getSchol() {
		return schol;
	}

	public void setSchol(String schol) {
		this.schol = schol;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getPraise() {
		return praise;
	}

	public void setPraise(String praise) {
		this.praise = praise;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "SearchCondition [memberId=" + memberId + ", writer=" + writer + ", writeDept=" + writeDept + ", title="
				+ title + ", all=" + all + ", normal=" + normal + ", schol=" + schol + ", schedule=" + schedule
				+ ", event=" + event + ", praise=" + praise + ", free=" + free + ", proof=" + proof + ", account="
				+ account + ", school=" + school + ", studentNo=" + studentNo + ", originSdept=" + originSdept
				+ ", majorCheck=" + majorCheck + ", sdeptName=" + sdeptName + ", status=" + status + ", memberKName="
				+ memberKName + ", dropNo=" + dropNo + ", studentName=" + studentName + "]";
	}

	
	
	
	
}
