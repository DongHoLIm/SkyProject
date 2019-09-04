package com.kh.finalProject.classmanagement.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.classmanagement.model.dao.ClassDao;
import com.kh.finalProject.classmanagement.model.vo.Inquiry;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ClassDao cd;
	
	@Override
	public String courseInquiry(Inquiry i) {
		
		return cd.courseInquiry(sqlSession, i);
	}

}
