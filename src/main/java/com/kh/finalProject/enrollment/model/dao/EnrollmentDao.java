package com.kh.finalProject.enrollment.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;

public interface EnrollmentDao {

	ArrayList<Enrollment> userEnrollment(SqlSessionTemplate sqlSession, String studentNo) throws EnrollmentException;
	//public List<Enrollment> getList(SqlSessionTemplate sqlSession);

	List<Enrollment> beforeEnrollData(SqlSessionTemplate sqlSession) throws EnrollmentException;

	List<Enrollment> beforeEnrollmentData(SqlSessionTemplate sqlSession, Enrollment enrollment) throws EnrollmentException;

	ArrayList<Enrollment> stEnrollment(SqlSessionTemplate sqlSession) throws EnrollmentException;

	public void updateEnrollment(SqlSessionTemplate sqlSession);
}
