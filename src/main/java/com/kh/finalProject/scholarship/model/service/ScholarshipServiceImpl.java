package com.kh.finalProject.scholarship.model.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.finalProject.scholarship.model.dao.ScholarshipDao;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ScholarshipDao sd;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public List<Scholarship> beforeScholarshipData(Scholarship scholarship) throws ScholarshipException {
		
		return sd.beforeScholarshipData(sqlSession, scholarship);
	}
	
	@Override
	public ArrayList<Scholarship> userScholarship(String studentNo) throws ScholarshipException {
		
		return sd.userScholarship(sqlSession, studentNo);
	}

	@Override
	public ArrayList<Scholarship> userScholarshipApply(String studentNo) throws ScholarshipException {
		
		return sd.userScholarshipApply(sqlSession, studentNo);	
		
	}

	@Override
	public void insertScholarship(Scholarship scholarship) {
		sd.insertScholarship(sqlSession, scholarship);
	}

	@Override
	public List<Scholarship> beforeScholarData(String studentNo) throws ScholarshipException {
		
		return sd.beforeScholarData(sqlSession, studentNo);
	}

	@Override
	public ArrayList<Scholarship> stScholarship() throws ScholarshipException {
		return sd.stScholarship(sqlSession);
	}

	@Override
	public List<Scholarship> stSearchScholarData() throws ScholarshipException {
		return sd.stSearchScholarData(sqlSession);
	}

	@Override
	public List<Scholarship> stSearchScholarshipData(Scholarship scholarship) throws ScholarshipException {
		return sd.stSearchScholarshipData(sqlSession, scholarship);
	}

	@Override
	public void updateScholarship() {
		sd.updateScholarship(sqlSession);
	}

	@Override
	public ArrayList<Scholarship> stRecieveScholarship() throws ScholarshipException {
		return sd.stRecieveScholarship(sqlSession);
	}

	@Override
	public List<Scholarship> stSearchScholarshipInfo() throws ScholarshipException {
		return sd.stSearchScholarshipInfo(sqlSession);
	}

}
