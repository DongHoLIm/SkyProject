package com.kh.finalProject.dormitory.model.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Dormitory> beforeDormitoryData() throws DormitoryException {
		return dd.beforeDormitoryData(sqlSession);
	}

	@Override
	public List<Dormitory> beforeDormData(Dormitory dor) throws DormitoryException {
		return dd.beforeDormData(sqlSession, dor);
	}

	@Override
	public ArrayList<Dormitory> empDormitory() throws DormitoryException {
		return dd.empDormitory(sqlSession);
	}

	@Override
	public ArrayList<Dormitory> empApplyDormitory() throws DormitoryException {
		return dd.empApplyDormitory(sqlSession);
	}

	@Override
	public void updateDormitory() {
		dd.updateDormitory(sqlSession);
		
	}

}
