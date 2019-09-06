package com.kh.finalProject.enrollment.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao{

	@Override
	public Enrollment userEnrollment(SqlSessionTemplate sqlSession, Enrollment e, String studentNo) throws EnrollmentException {
		
		Enrollment memberEnrollment = sqlSession.selectOne("Enrollment.EnrollmentCheck", e);
		
		if(memberEnrollment == null) {
			throw new EnrollmentException("정보가 존재하지 않습니다.");
		}
		
		return memberEnrollment;
	}

}
