package com.kh.finalProject.enrollment.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

public interface EnrollmentDao {

	Enrollment userEnrollment(SqlSessionTemplate sqlSession, Enrollment e, String studentNo) throws EnrollmentException;

}
