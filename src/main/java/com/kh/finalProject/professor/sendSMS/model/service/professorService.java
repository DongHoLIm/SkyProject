package com.kh.finalProject.professor.sendSMS.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;
import com.kh.finalProject.professor.sendSMS.model.vo.professorSubjectList;

public interface professorService {

	int studentList();

	ArrayList<StudentList> studentPageList(PageInfo pi);

	int insertSMS(StudentList sl);

	ArrayList<SendSMSList> sendSMSList(SendSMSList list, PageInfo pi);

	ArrayList<StudentList> SendSMSDetail(SendSMSList sl);

	int sendSMSListCount(SendSMSList list);

	ArrayList<professorSubjectList> professorSubList(Member loginUser);

	int searchStuListSMSCount(professorSubjectList psl);

	ArrayList<StudentList> searchStuListSMS(PageInfo pi, professorSubjectList psl);

}
