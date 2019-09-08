package com.kh.finalProject.scholarship.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.finalProject.scholarship.model.dao.ScholarshipDao;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ScholarshipDao sd;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public ArrayList<Scholarship> userScholarship(String studentNo) throws ScholarshipException {
		
		return sd.userScholarship(sqlSession, studentNo);
	}

}
