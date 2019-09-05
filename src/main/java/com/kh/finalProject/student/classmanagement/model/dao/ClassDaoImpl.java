package com.kh.finalProject.student.classmanagement.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.student.classmanagement.model.vo.Inquiry;

@Repository
public class ClassDaoImpl implements ClassDao{

	@Override
	public String courseInquiry(SqlSessionTemplate sqlSession, Inquiry i) {
		
	
	return sqlSession.selectOne("class.courseInquiry");
		
	}

}
