package com.kh.finalProject.dormitory.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.finalProject.dormitory.model.dao.DormitoryDao;
import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

@Service
public class DormitoryServiceImpl implements DormitoryService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private DormitoryDao dd;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public ArrayList<Dormitory> userDormitory(String studentNo) throws DormitoryException {
		
		return dd.userDormitory(sqlSession, studentNo);
	}

	@Override
	public void insertDormitory(Dormitory dormitory) {
		dd.insertDormitory(sqlSession, dormitory);
	}

}
