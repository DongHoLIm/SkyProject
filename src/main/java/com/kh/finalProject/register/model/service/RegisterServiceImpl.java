package com.kh.finalProject.register.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.kh.finalProject.register.model.dao.RegisterDao;
import com.kh.finalProject.register.model.vo.Register;

public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private RegisterDao rd;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public Register registerStudent(Register r) {
		Register registerInfomation = rd.registerStudent(sqlSession, r);
		
		return registerInfomation;
	}
}
