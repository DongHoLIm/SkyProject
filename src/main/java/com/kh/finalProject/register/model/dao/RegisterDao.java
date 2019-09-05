package com.kh.finalProject.register.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.register.model.vo.Register;

public interface RegisterDao {
	
	Register registerStudent(SqlSessionTemplate sqlSession, Register r);
}
