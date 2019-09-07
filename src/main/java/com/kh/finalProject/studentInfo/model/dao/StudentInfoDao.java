package com.kh.finalProject.studentInfo.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoDao {

	StudentInfo basicInfo(SqlSessionTemplate sqlSession, String userId);

	StudentInfo stuInfo(SqlSessionTemplate sqlSession, String userId);

	

}
