package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoDao {

	StudentInfo basicInfo(SqlSessionTemplate sqlSession, String userId);

	StudentInfo stuInfo(SqlSessionTemplate sqlSession, String userId);

	int getListCount(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectStudentList(SqlSessionTemplate sqlSession, PageInfo pi) throws StudentInfoSelectListException;

	int getFilterListCount(SqlSessionTemplate sqlSession, FilterCondition fc) throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectFilterStudent(SqlSessionTemplate sqlSession, FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException;

	ArrayList selectCollegeFilter(SqlSessionTemplate sqlSession, String col) throws StudentInfoSelectListException;

	ArrayList selectCollege(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;

	ArrayList selectSdeptList(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;



	
	

}
