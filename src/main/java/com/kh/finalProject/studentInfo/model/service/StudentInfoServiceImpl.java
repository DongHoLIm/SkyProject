package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.studentInfo.model.dao.StudentInfoDao;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
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
  
	@Override
	public ArrayList<Graduation> selectGraduationCondition(String userId) throws StudentInfoSelectListException {
		
		return sd.selectGraduationCondition(sqlSession,userId);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajorList(PageInfo pi) {
		return sd.selectSecondMajorList(sqlSession, pi);
	}
	
	@Override
	public int selectSecondMajorListCount() {
		return sd.selectSecondMajorListCount(sqlSession);
	}

	@Override
	public int SuccessSecondMajor(SecondMajor sm) {
		int result = sd.SuccessSecondMajor(sqlSession, sm);
		
		if(result > 0) {
			sd.ChangeStudentInfo(sqlSession, sm);
		}
		return result;
	}

	@Override
	public int selectSecondMajorSuccessListCount() {
		return sd.selectSecondMajorSuccessListCount(sqlSession);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajorSuccessList(PageInfo pi) {
		return sd.selectSecondMajorSuccessList(sqlSession, pi);
	}

	@Override
	public SecondMajor smInfo(String studentNo) {
		return sd.smInfo(sqlSession, studentNo);
	}

	@Override
	public int searchSecondMajorApplyCount(SearchCondition sc) {
		return sd.searchSecondMajorApplyCount(sqlSession, sc);
	}

	@Override
	public ArrayList<SecondMajor> searchSecondMajorApplyList(SearchCondition sc, PageInfo pi) {
		return sd.searchSecondMajorApplyList(sqlSession, sc, pi);
	}

	@Override
	public ArrayList<Graduation> selectGraduationSchool() {
		
		return sd.selectGraduationSchool(sqlSession);
	}

	@Override
	public int searchSecondMajorApplyCount2(SearchCondition sc) {
		return sd.searchSecondMajorApplyCount2(sqlSession, sc);
	}

	@Override
	public ArrayList<SecondMajor> searchSecondMajorApplyList2(SearchCondition sc, PageInfo pi) {
		return sd.searchSecondMajorApplyList2(sqlSession, sc, pi);
	}

	@Override
	public ChangeMajor cmInfo(String studentNo) {
		return sd.cmInfo(sqlSession,studentNo);
	}

	@Override
	public int insertChangeMajor(ChangeMajor cm) {
		return sd.insertChangeMajor(sqlSession, cm);
	}

	@Override
	public ChangeMajor selectChangeMajor(ChangeMajor cm) {
		return sd.selectChangeMajor(sqlSession, cm);
	}

@Override
public Graduation selectGraduationScDetail(String code) {
	
	return sd.selectGraduationScDetail(sqlSession,code);
}



}

