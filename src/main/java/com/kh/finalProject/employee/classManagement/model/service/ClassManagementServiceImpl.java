package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.dao.ClassManagementDao;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

@Service
public class ClassManagementServiceImpl implements ClassManagementService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ClassManagementDao cmd;
	
	@Override
	public int getListCount() {
		
		return cmd.getListCount(sqlSession);
	}

	@Override
	public ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException {
		
		return cmd.selctSubjectList(sqlSession, pi);
	}


	@Override
	public LectureOpen selectOneSubject(String subCode) {
		return cmd.seletOneSubject(sqlSession, subCode);
	}

}
