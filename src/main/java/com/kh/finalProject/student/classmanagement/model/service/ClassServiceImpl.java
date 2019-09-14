package com.kh.finalProject.student.classmanagement.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
