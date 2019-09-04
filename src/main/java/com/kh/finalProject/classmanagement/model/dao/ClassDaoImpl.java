package com.kh.finalProject.classmanagement.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.classmanagement.model.vo.Inquiry;
import com.kh.finalProject.classmanagement.model.vo.courseInquiry;

@Repository
public class ClassDaoImpl implements ClassDao{

	@Override
	public String courseInquiry(SqlSessionTemplate sqlSession, Inquiry i) {
		
	
	return sqlSession.selectOne("class.courseInquiry");
		
	}

}
