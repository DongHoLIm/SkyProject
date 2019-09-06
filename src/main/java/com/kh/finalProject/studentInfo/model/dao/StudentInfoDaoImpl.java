package com.kh.finalProject.studentInfo.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Repository
public class StudentInfoDaoImpl implements StudentInfoDao{

	@Override
	public HashMap<String, StudentInfo> studentInfo(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.selectInfo", userId);
	}

}
