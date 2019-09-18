package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoService {

	StudentInfo basicInfo(String studentNo);

	StudentInfo stuInfo(String studentNo);

	int getListCount() throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectStudentList(PageInfo pi) throws StudentInfoSelectListException;

	int getFilterListCount(FilterCondition fc) throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectFilterStudent(FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException ;

	ArrayList selectCollegeFilter(String college) throws StudentInfoSelectListException;

	ArrayList selectcollege() throws StudentInfoSelectListException;

	ArrayList selectSdeptList() throws StudentInfoSelectListException;

	StudentInfo personInfoManage(String userId);

	int changePersonalInfo(StudentInfo si);

	int insertSecondMajor(SecondMajor sm);

	ArrayList<SecondMajor> selectSecondMajor(SecondMajor sm);

	ArrayList<SecondMajor> selectSecondMajor(String userId);

	ArrayList<Graduation> selectGraduationCondition(String userId) throws StudentInfoSelectListException;

	ArrayList<SecondMajor> selectSecondMajorList(PageInfo pi);

	int selectSecondMajorListCount();

	int SuccessSecondMajor(SecondMajor sm);

	int selectSecondMajorSuccessListCount();

	ArrayList<SecondMajor> selectSecondMajorSuccessList(PageInfo pi);

	SecondMajor smInfo(String studentNo);

	int searchSecondMajorApplyCount(SearchCondition sc);

	ArrayList<SecondMajor> searchSecondMajorApplyList(SearchCondition sc, PageInfo pi);

	ArrayList<Graduation> selectGraduationSchool();

	int searchSecondMajorApplyCount2(SearchCondition sc);

	ArrayList<SecondMajor> searchSecondMajorApplyList2(SearchCondition sc, PageInfo pi);

	ChangeMajor cmInfo(String studentNo);

	int insertChangeMajor(ChangeMajor cm);

	ChangeMajor selectChangeMajor(ChangeMajor cm);

}
