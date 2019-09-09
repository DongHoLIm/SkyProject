package com.kh.finalProject.enrollment.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

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

//	@Override
//	public List<Enrollment> getList(SqlSessionTemplate sqlSession) {
//		
//		return sqlSession.selectList("Enrollment.list");
//	}
}
