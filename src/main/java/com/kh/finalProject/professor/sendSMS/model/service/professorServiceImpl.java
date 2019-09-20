package com.kh.finalProject.professor.sendSMS.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.dao.professorDao;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;

@Service
public class professorServiceImpl implements professorService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private professorDao pd;
	@Override
	public int studentList() {
		
		return pd.studentList(sqlSession);
	}
	@Override
	public ArrayList<StudentList> studentPageList(PageInfo pi) {
		// TODO Auto-generated method stub
		return pd.studentPageList(sqlSession,pi);
	}
	@Override
	public int insertSMS(StudentList sl) {
		// TODO Auto-generated method stub
		return pd.insertSMS(sqlSession,sl);
	}
	@Override
	public ArrayList<SendSMSList> sendSMSList(SendSMSList list,PageInfo pi) {
		// TODO Auto-generated method stub
		return pd.sendSMSList(sqlSession,list,pi);
	}
	@Override
	public ArrayList<StudentList> SendSMSDetail(SendSMSList sl) {
		// TODO Auto-generated method stub
		return pd.SendSMSDetail(sqlSession,sl);
	}
	@Override
	public int sendSMSListCount(SendSMSList list) {
		// TODO Auto-generated method stub
		return pd.sendSMSListCount(sqlSession,list);
	}
	
}
