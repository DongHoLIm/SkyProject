package com.kh.finalProject.dormitory.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

public interface DormitoryDao {

	ArrayList<Dormitory> userDormitory(SqlSessionTemplate sqlSession, String studentNo) throws DormitoryException;

}
