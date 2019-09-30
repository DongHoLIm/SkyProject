package com.kh.finalProject.enrollment.model.service;

import java.util.ArrayList;
import java.util.List;

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
	public ArrayList<Enrollment> userEnrollment(String studentNo) throws EnrollmentException {
		
		//ArrayList<Enrollment> memberEnrollment = ed.userEnrollment(sqlSession, studentNo);
		
		return ed.userEnrollment(sqlSession, studentNo);
	}

	@Override
	public List<Enrollment> beforeEnrollData() throws EnrollmentException {
		return ed.beforeEnrollData(sqlSession);
	}

	@Override
	public List<Enrollment> beforeEnrollmentData(Enrollment enrollment) throws EnrollmentException {
		return ed.beforeEnrollmentData(sqlSession, enrollment);
	}

	@Override
	public ArrayList<Enrollment> stEnrollment() throws EnrollmentException {
		return ed.stEnrollment(sqlSession);
	}

	@Override
	public void updateEnrollment() {
		ed.updateEnrollment(sqlSession);
		
	}

	@Override
	public ArrayList<Enrollment> empPrintEnrollment() throws EnrollmentException {
		return ed.empPrintEnrollment(sqlSession);
	}
	
//	@Override
//	public List<Enrollment> getList() {
//	
//		return enrollmentDao.getList(sqlSession);
//	}

}
