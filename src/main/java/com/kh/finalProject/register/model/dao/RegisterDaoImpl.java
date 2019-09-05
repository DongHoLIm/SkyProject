package com.kh.finalProject.register.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.register.model.vo.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao{

	@Override
	public Register registerStudent(SqlSessionTemplate sqlSession, Register r) {
		
		return sqlSession.selectOne("Register.selectregisterInfomation", r);
	}

}
