package com.kh.finalProject.enrollment.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao{


	@Override
	public ArrayList<Enrollment> userEnrollment(SqlSessionTemplate sqlSession, String studentNo) throws EnrollmentException {
		
//		ArrayList<Enrollment> memberEnrollment = sqlSession.selectOne("Enrollment.EnrollmentCheck",studentNo);
//		
//		if(memberEnrollment == null) {
//			throw new EnrollmentException("정보가 존재하지 않습니다.");
//		}
		
		ArrayList<Enrollment> memberEnrollment = null;
		
		memberEnrollment = (ArrayList) sqlSession.selectList("Enrollment.EnrollmentCheck", studentNo);
		
		if(memberEnrollment == null) {
			
			throw new EnrollmentException("정보가 존재하지 않습니다.");
		}
		
		return memberEnrollment;
	}

	@Override
	public List<Enrollment> beforeEnrollData(SqlSessionTemplate sqlSession) throws EnrollmentException {
		System.out.println("검색dao 들어옴 :::");
		List<Enrollment> beforeEnrollment = null;
		beforeEnrollment = (List) sqlSession.selectList("Enrollment.beforeEnroll");
		
		if(beforeEnrollment == null) {
			throw new EnrollmentException("정보가 존재하지 않습니다.");
		}
		
		return beforeEnrollment;
	}

	@Override
	public List<Enrollment> beforeEnrollmentData(SqlSessionTemplate sqlSession, Enrollment enrollment) throws EnrollmentException {
		List<Enrollment> beforeEnrollment = null;
		System.out.println("12345" + enrollment);
		beforeEnrollment = (List) sqlSession.selectList("Enrollment.beforeEnrollment", enrollment);
		
		if(beforeEnrollment == null) {
			throw new EnrollmentException("정보가 존재하지 않습니다.");
		}
		
		return beforeEnrollment;
	}

	@Override
	public ArrayList<Enrollment> stEnrollment(SqlSessionTemplate sqlSession) throws EnrollmentException {
		
		System.out.println("dao 들어옴 :::");
		ArrayList<Enrollment> memberEnrollment = null;
		
		memberEnrollment = (ArrayList) sqlSession.selectList("Enrollment.stStartEnrollment");
		
		if(memberEnrollment == null) {
			
			throw new EnrollmentException("정보가 존재하지 않습니다.");
		}
		
		return memberEnrollment;
	}

	@Override
	public void updateEnrollment(SqlSessionTemplate sqlSession) {
		
		System.out.println("결제 dao 들어옴");
		
		sqlSession.update("Enrollment.up");
		
	}

//	@Override
//	public List<Enrollment> getList(SqlSessionTemplate sqlSession) {
//		
//		return sqlSession.selectList("Enrollment.list");
//	}
}
