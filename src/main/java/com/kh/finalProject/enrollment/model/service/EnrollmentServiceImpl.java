package com.kh.finalProject.enrollment.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.finalProject.enrollment.model.dao.EnrollmentDao;
import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private EnrollmentDao ed;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public Enrollment userEnrollment(String studentNo) throws EnrollmentException {
		
		Enrollment memberEnrollment = ed.userEnrollment(sqlSession, studentNo);
		
		return memberEnrollment;
	}

}
