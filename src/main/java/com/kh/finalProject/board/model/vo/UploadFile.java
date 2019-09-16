package com.kh.finalProject.board.model.vo;

public class UploadFile implements java.io.Serializable {
	private String fileCode;
	private int boardNo;
	private String oldName;
	private String changeName;
	private String path;
	private int questionNo;
	
	public UploadFile() {}

	public UploadFile(String fileCode, int boardNo, String oldName, String changeName, String path) {
		super();
		this.fileCode = fileCode;
		this.boardNo = boardNo;
		this.oldName = oldName;
		this.changeName = changeName;
		this.path = path;
	}	

	public UploadFile(String fileCode, String oldName, String changeName, String path, int questionNo) {
		super();
		this.fileCode = fileCode;
		this.oldName = oldName;
		this.changeName = changeName;
		this.path = path;
		this.questionNo = questionNo;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UploadFile [fileCode=" + fileCode + ", boardNo=" + boardNo + ", oldName=" + oldName + ", changeName="
				+ changeName + ", path=" + path + ", questionNo=" + questionNo + "]";
	}

	
}
