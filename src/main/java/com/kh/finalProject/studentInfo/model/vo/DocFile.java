package com.kh.finalProject.studentInfo.model.vo;

import java.io.Serializable;

public class DocFile implements Serializable{
	private String fileCode;
	private int docNo;
	private String oldName;
	private String changeName;
	private String path;
	private String type;
	private String offApplyNo;
	private String diseaseCode;
	private String recoCode;
	
	public DocFile() {}

	public DocFile(String fileCode, int docNo, String oldName, String changeName, String path, String type,
			String offApplyNo, String diseaseCode, String recoCode) {
		super();
		this.fileCode = fileCode;
		this.docNo = docNo;
		this.oldName = oldName;
		this.changeName = changeName;
		this.path = path;
		this.type = type;
		this.offApplyNo = offApplyNo;
		this.diseaseCode = diseaseCode;
		this.recoCode = recoCode;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public int getDocNo() {
		return docNo;
	}

	public void setDocNo(int docNo) {
		this.docNo = docNo;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOffApplyNo() {
		return offApplyNo;
	}

	public void setOffApplyNo(String offApplyNo) {
		this.offApplyNo = offApplyNo;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getRecoCode() {
		return recoCode;
	}

	public void setRecoCode(String recoCode) {
		this.recoCode = recoCode;
	}

	@Override
	public String toString() {
		return "DocFile [fileCode=" + fileCode + ", docNo=" + docNo + ", oldName=" + oldName + ", changeName="
				+ changeName + ", path=" + path + ", type=" + type + ", offApplyNo=" + offApplyNo + ", diseaseCode="
				+ diseaseCode + ", recoCode=" + recoCode + "]";
	}

	

}
