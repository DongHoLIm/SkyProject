package com.kh.finalProject.professor.sendSMS.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;

public interface professorService {

	int studentList();

	ArrayList<StudentList> studentPageList(PageInfo pi);

	int insertSMS(StudentList sl);

	ArrayList<SendSMSList> sendSMSList(SendSMSList list);

	ArrayList<StudentList> SendSMSDetail(SendSMSList sl);

}
