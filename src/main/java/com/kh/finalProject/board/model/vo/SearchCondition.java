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
	
	public SearchCondition() {}

	public SearchCondition(String memberId, String writer, String writeDept, String title, String all, String normal,
			String schol, String schedule, String event, String praise, String free) {
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

	@Override
	public String toString() {
		return "SearchCondition [memberId=" + memberId + ", writer=" + writer + ", writeDept=" + writeDept + ", title="
				+ title + ", all=" + all + ", normal=" + normal + ", schol=" + schol + ", schedule=" + schedule
				+ ", event=" + event + ", praise=" + praise + ", free=" + free + "]";
	}

	

	
	
}
