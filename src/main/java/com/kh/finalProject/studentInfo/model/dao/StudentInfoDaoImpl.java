package com.kh.finalProject.studentInfo.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Repository
public class StudentInfoDaoImpl implements StudentInfoDao{

	@Override
	public StudentInfo basicInfo(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.SelectBasicInfo", userId);
	}

	@Override
	public StudentInfo stuInfo(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.SelectStuInfo", userId);
	}

	

}
