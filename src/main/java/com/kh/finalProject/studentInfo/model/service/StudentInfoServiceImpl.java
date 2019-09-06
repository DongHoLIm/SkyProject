package com.kh.finalProject.studentInfo.model.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.studentInfo.model.dao.StudentInfoDao;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private StudentInfoDao sd;

	@Override
	public HashMap<String, StudentInfo> studentInfo(String userId) {
		
		return sd.studentInfo(sqlSession,userId);
	}
	

}
