package com.kh.finalProject.enrollment.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

public interface EnrollmentDao {

	ArrayList<Enrollment> userEnrollment(SqlSessionTemplate sqlSession, String studentNo) throws EnrollmentException;
	//public List<Enrollment> getList(SqlSessionTemplate sqlSession);
}
