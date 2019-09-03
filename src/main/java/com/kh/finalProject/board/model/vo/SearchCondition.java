package com.kh.finalProject.board.model.vo;

public class SearchCondition implements java.io.Serializable{
	private String writer;
	private String writeDept;
	private String title;
	
	public SearchCondition() {}

	public SearchCondition(String writer, String writeDept, String title) {
		super();
		this.writer = writer;
		this.writeDept = writeDept;
		this.title = title;
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

	@Override
	public String toString() {
		return "SearchCondition [writer=" + writer + ", writeDept=" + writeDept + ", title=" + title + "]";
	}
	
	
}
