package com.kh.finalProject.professor.sendSMS.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;
import com.kh.finalProject.professor.sendSMS.model.vo.professorSubjectList;

public interface professorDao {

	int studentList(SqlSessionTemplate sqlSession);

	ArrayList<StudentList> studentPageList(SqlSessionTemplate sqlSession, PageInfo pi);

	int insertSMS(SqlSessionTemplate sqlSession, StudentList sl);

	ArrayList<SendSMSList> sendSMSList(SqlSessionTemplate sqlSession, SendSMSList list, PageInfo pi);

	ArrayList<StudentList> SendSMSDetail(SqlSessionTemplate sqlSession, SendSMSList sl);

	int sendSMSListCount(SqlSessionTemplate sqlSession, SendSMSList list);

	ArrayList<professorSubjectList> professorSubList(SqlSessionTemplate sqlSession, Member loginUser);

	int searchStuListSMSCount(SqlSessionTemplate sqlSession, professorSubjectList psl);

	ArrayList<StudentList> searchStuListSMS(SqlSessionTemplate sqlSession, PageInfo pi, professorSubjectList psl);

}
