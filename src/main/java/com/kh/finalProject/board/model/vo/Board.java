package com.kh.finalProject.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int boardNo;
	private String memberId;
	private String title;
	private String content;
	private String writer;
	private String enrollDate;
	private String status;
	private String boardType;
	private String writeDept;
	private String deadLine;
	private Date startDate;
	private Date endDate;
	private int count;
	
	public Board() {}

	public Board(int boardNo, String memberId, String title, String content, String writer, String enrollDate,
			String status, String boardType, String writeDept, String deadLine, Date startDate, Date endDate,
			int count) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
		this.status = status;
		this.boardType = boardType;
		this.writeDept = writeDept;
		this.deadLine = deadLine;
		this.startDate = startDate;
		this.endDate = endDate;
		this.count = count;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getWriteDept() {
		return writeDept;
	}

	public void setWriteDept(String writeDept) {
		this.writeDept = writeDept;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberId=" + memberId + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", enrollDate=" + enrollDate + ", status=" + status + ", boardType="
				+ boardType + ", writeDept=" + writeDept + ", deadLine=" + deadLine + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", count=" + count + "]";
	}

	
	
	
}
