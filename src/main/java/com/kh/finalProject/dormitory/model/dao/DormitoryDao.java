package com.kh.finalProject.dormitory.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

public interface DormitoryDao {

	ArrayList<Dormitory> userDormitory(SqlSessionTemplate sqlSession, String studentNo) throws DormitoryException;

	public void insertDormitory(SqlSessionTemplate sqlSession, Dormitory dormitory);

	List<Dormitory> beforeDormitoryData(SqlSessionTemplate sqlSession) throws DormitoryException;

	List<Dormitory> beforeDormData(SqlSessionTemplate sqlSession, Dormitory dor) throws DormitoryException;

	ArrayList<Dormitory> empDormitory(SqlSessionTemplate sqlSession) throws DormitoryException;

	ArrayList<Dormitory> empApplyDormitory(SqlSessionTemplate sqlSession) throws DormitoryException;

	public void updateDormitory(SqlSessionTemplate sqlSession);

}
