package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.DropOut;
import com.kh.finalProject.studentInfo.model.vo.Explusion;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.SchoolOff;
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

	Graduation selectGraduationScDetail(String code);

	int ChangeMajorListCount();

	ArrayList<ChangeMajor> ChangeMajorList(PageInfo pi);

	int ChangeMajorListCount2();

	ArrayList<ChangeMajor> ChangeMajorList2(PageInfo pi);

	int ChangeMajorEnroll(ChangeMajor cm);

	int ChangeMajorReject(ChangeMajor cm);

	ArrayList<ChangeMajor> searchChangeMajor(SearchCondition sc);

	ArrayList<ChangeMajor> searchChangeMajor2(SearchCondition sc);

	ArrayList<Graduation> selectGraduationMajor();

	Graduation selectGraduationMaDetail(String code);

	int ExplusionListCount();

	ArrayList<Explusion> ExplusionList(PageInfo pi);

	int ExplusionListCount2();

	ArrayList<Explusion> ExplusionList2(PageInfo pi);

	int ExplusionEnroll(Explusion exp);

	ArrayList<Explusion> searchExplusion(SearchCondition sc);

	ArrayList<Explusion> searchExplusion2(SearchCondition sc);

	Explusion expInfo(String studentNo);

	int updateGraduationSc(Graduation gd);

	int updateGraduationMa(Graduation gd);

	DropOut doInfo(String studentNo);

	int insertDropOut(DropOut dpo);

	ArrayList<DropOut> selectDropOut(DropOut dpo);

	ArrayList<DropOut> selectDropOut(String studentNo);

	int pro_dropOutListCount(String pdeptCode);

	ArrayList<DropOut> pro_dropOutList(PageInfo pi, String pdeptCode);

	DropOut selectProInfo(String professorNo);

	int pro_dropOutListCount2(String pdeptCode);

	ArrayList<DropOut> pro_dropOutList2(PageInfo pi, String pdeptCode);

	int pro_DropOutEnroll(DropOut dpo);

	ArrayList<DropOut> searchDropOut(SearchCondition sc);

	ArrayList<DropOut> searchDropOut2(SearchCondition sc);

	int em_dropOutListCount();

	ArrayList<DropOut> em_dropOutList(PageInfo pi);

	int em_dropOutListCount2();

	ArrayList<DropOut> em_dropOutList2(PageInfo pi);

	int em_DropOutEnroll(DropOut dpo);

	ArrayList<DropOut> searchDropOut3(SearchCondition sc);

	ArrayList<DropOut> searchDropOut4(SearchCondition sc);

	int em_DropOutReject(DropOut dpo);

	DropOut dpoInfo(String studentNo);

	ArrayList<SchoolOff> selectSchoolOff(String userId);

	int schoolOffApply(SchoolOff so);
  
}
