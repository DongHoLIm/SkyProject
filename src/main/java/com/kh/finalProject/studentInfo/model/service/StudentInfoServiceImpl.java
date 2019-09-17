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
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private StudentInfoDao sd;

	@Override
	public StudentInfo basicInfo(String studentNo) {
		
		return sd.basicInfo(sqlSession,studentNo);
	}

	@Override
	public StudentInfo stuInfo(String studentNo) {
		
		return sd.stuInfo(sqlSession,studentNo);
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

	@Override
	public StudentInfo personInfoManage(String userId) {
		
		return sd.personInfoManage(sqlSession,userId);
	}

	@Override
	public int changePersonalInfo(StudentInfo si) {
		
		int result = 0;
		
		int result1 = sd.changePeronalInfo(sqlSession,si);
		
		int result2 = sd.changeStudentInfo(sqlSession,si);
		
		int result3 = sd.changeParentsInfo(sqlSession,si);
		
		if(result1>0 && result2>0 && result3>0) {
			result=1;
		}else {
			result=-1;
		}
		
		return result;
		
	}

	@Override
	public int insertSecondMajor(SecondMajor sm) {
		return sd.insertSecondMajor(sqlSession, sm);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajor(SecondMajor sm) {
		return sd.selectSecondMajor(sqlSession, sm);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajor(String userId) {
		return sd.selectSecondMajor(sqlSession, userId);
	}
}

	

	
	
	
	


