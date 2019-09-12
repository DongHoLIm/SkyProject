package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.studentInfo.model.dao.StudentInfoDao;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private StudentInfoDao sd;

	@Override
	public StudentInfo basicInfo(String userId) {
		
		return sd.basicInfo(sqlSession,userId);
	}

	@Override
	public StudentInfo stuInfo(String userId) {
		
		return sd.stuInfo(sqlSession,userId);
	}

	@Override
	public int getListCount() throws StudentInfoSelectListException {
		
		return sd.getListCount(sqlSession);
	}

	@Override
	public ArrayList<StudentInfo> selectStudentList(PageInfo pi) throws StudentInfoSelectListException {
		
		return sd.selectStudentList(sqlSession,pi);
	}

	@Override
	public int getFilterListCount(FilterCondition fc) throws StudentInfoSelectListException {
		
		return sd.getFilterListCount(sqlSession,fc);
	}

	@Override
	public ArrayList<StudentInfo> selectFilterStudent(FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException {
		
		return sd.selectFilterStudent(sqlSession,fc,pi);
	}

	@Override
	public ArrayList selectCollegeFilter(String col) throws StudentInfoSelectListException {
		
		return sd.selectCollegeFilter(sqlSession,col);
	}

	@Override
	public ArrayList selectcollege() throws StudentInfoSelectListException {
		
		return sd.selectCollege(sqlSession);
	}

	@Override
	public ArrayList selectSdeptList() throws StudentInfoSelectListException {
		
		return sd.selectSdeptList(sqlSession);
	}

	

	
	
	
	

}
