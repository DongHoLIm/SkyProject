package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoDao {

	StudentInfo basicInfo(SqlSessionTemplate sqlSession, String studentNo);

	StudentInfo stuInfo(SqlSessionTemplate sqlSession, String studentNo);

	int getListCount(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectStudentList(SqlSessionTemplate sqlSession, PageInfo pi) throws StudentInfoSelectListException;

	int getFilterListCount(SqlSessionTemplate sqlSession, FilterCondition fc) throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectFilterStudent(SqlSessionTemplate sqlSession, FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException;

	ArrayList selectCollegeFilter(SqlSessionTemplate sqlSession, String col) throws StudentInfoSelectListException;

	ArrayList selectCollege(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;

	ArrayList selectSdeptList(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException;

	StudentInfo personInfoManage(SqlSessionTemplate sqlSession, String userId);

	int changePeronalInfo(SqlSessionTemplate sqlSession, StudentInfo si);

	int changeParentsInfo(SqlSessionTemplate sqlSession, StudentInfo si);

	int changeStudentInfo(SqlSessionTemplate sqlSession, StudentInfo si);

	int insertSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm);

	ArrayList<SecondMajor> selectSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm);

	ArrayList<SecondMajor> selectSecondMajor(SqlSessionTemplate sqlSession, String userId);

	ArrayList<Graduation> selectGraduationCondition(SqlSessionTemplate sqlSession, String userId) throws StudentInfoSelectListException;

	ArrayList<SecondMajor> selectSecondMajorList(SqlSessionTemplate sqlSession, PageInfo pi);

	int selectSecondMajorListCount(SqlSessionTemplate sqlSession);

	int SuccessSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm);

	int ChangeStudentInfo(SqlSessionTemplate sqlSession, SecondMajor sm);

	int selectSecondMajorSuccessListCount(SqlSessionTemplate sqlSession);

	ArrayList<SecondMajor> selectSecondMajorSuccessList(SqlSessionTemplate sqlSession, PageInfo pi);

	SecondMajor smInfo(SqlSessionTemplate sqlSession, String studentNo);

	int searchSecondMajorApplyCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<SecondMajor> searchSecondMajorApplyList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);	

	ArrayList<Graduation> selectGraduationSchool(SqlSessionTemplate sqlSession);

	int searchSecondMajorApplyCount2(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<SecondMajor> searchSecondMajorApplyList2(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	ChangeMajor cmInfo(SqlSessionTemplate sqlSession, String studentNo);

	int insertChangeMajor(SqlSessionTemplate sqlSession, ChangeMajor cm);

	ChangeMajor selectChangeMajor(SqlSessionTemplate sqlSession, ChangeMajor cm);	

	Graduation selectGraduationScDetail(SqlSessionTemplate sqlSession, String code);

	int ChangeMajorListCount(SqlSessionTemplate sqlSession);

	ArrayList<ChangeMajor> ChangeMajorList(SqlSessionTemplate sqlSession, PageInfo pi);

	int ChangeMajorListCount2(SqlSessionTemplate sqlSession);

	ArrayList<ChangeMajor> ChangeMajorList2(SqlSessionTemplate sqlSession, PageInfo pi);

	int ChangeMajorEnroll(SqlSessionTemplate sqlSession, ChangeMajor cm);

	int ChangeMajorEnrollStudentInfo(SqlSessionTemplate sqlSession, ChangeMajor cm);

	int ChangeMajorReject(SqlSessionTemplate sqlSession, ChangeMajor cm);

	ArrayList<ChangeMajor> searchChangeMajor(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<ChangeMajor> searchChangeMajor2(SqlSessionTemplate sqlSession, SearchCondition sc);



	

}
