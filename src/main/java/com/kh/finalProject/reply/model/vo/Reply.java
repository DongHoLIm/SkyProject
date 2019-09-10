package com.kh.finalProject.reply.model.vo;

import java.sql.Date;

public class Reply {
	private int boardNo;
	private int cNo;
	private String cContent;
	private String cWriter;
	private String cDate;
	
	public Reply() {}

	public Reply(int boardNo, int cNo, String cContent, String cWriter, String cDate) {
		super();
		this.boardNo = boardNo;
		this.cNo = cNo;
		this.cContent = cContent;
		this.cWriter = cWriter;
		this.cDate = cDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getcWriter() {
		return cWriter;
	}

	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	@Override
	public String toString() {
		return "Reply [boardNo=" + boardNo + ", cNo=" + cNo + ", cContent=" + cContent + ", cWriter=" + cWriter
				+ ", cDate=" + cDate + "]";
	}
	
	
}
