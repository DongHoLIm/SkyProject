package com.kh.finalProject.classmanagement.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.classmanagement.model.vo.Inquiry;

public interface ClassDao {

	String courseInquiry(SqlSessionTemplate sqlSession, Inquiry i);

}
