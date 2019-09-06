package com.kh.finalProject.studentInfo.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoDao {

	HashMap<String, StudentInfo> studentInfo(SqlSessionTemplate sqlSession, String userId);

}
