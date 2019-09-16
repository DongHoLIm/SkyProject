package com.kh.finalProject.student.classmanagement.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.dao.ClassDao;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ClassDao cd;
	
	

	@Override
	public ArrayList<Sdepartment> selectSdept() {
		
		return cd.selectSdept(sqlSession);
	}



	@Override
	public ArrayList<OpenSubject> selectOpenSubject() {
		return cd.selectOpenSubject(sqlSession);
	}



	@Override
	public ArrayList<OpenSubject> selectSubject(OpenSubject os) {
		
		return cd.selectSubject(sqlSession, os);
	}



	@Override
	public ArrayList<OpenSubject> selectOpenSubject(OpenSubject os) {
		return cd.selectOpenSubject(sqlSession, os);
	}

}
