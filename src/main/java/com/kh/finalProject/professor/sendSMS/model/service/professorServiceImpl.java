package com.kh.finalProject.professor.sendSMS.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.professor.sendSMS.model.dao.professorDao;

@Service
public class professorServiceImpl implements professorService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private professorDao pd;
	
}
