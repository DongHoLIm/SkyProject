package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.dao.StudentInfoDao;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.DropOut;
import com.kh.finalProject.studentInfo.model.vo.Explusion;
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
	
	@Override
	public int ChangeMajorListCount() {
		return sd.ChangeMajorListCount(sqlSession);
	}
	
	@Override
	public ArrayList<ChangeMajor> ChangeMajorList(PageInfo pi) {
		return sd.ChangeMajorList(sqlSession, pi);
	}

	@Override
	public int ChangeMajorListCount2() {
		return sd.ChangeMajorListCount2(sqlSession);
	}

	@Override
	public ArrayList<ChangeMajor> ChangeMajorList2(PageInfo pi) {
		return sd.ChangeMajorList2(sqlSession, pi);
	}

	@Override
	public int ChangeMajorEnroll(ChangeMajor cm) {
		int result = sd.ChangeMajorEnroll(sqlSession, cm);
		
		if(result > 0) {
			sd.ChangeMajorEnrollStudentInfo(sqlSession, cm);
		}
		return result;
	}

	@Override
	public int ChangeMajorReject(ChangeMajor cm) {
		return sd.ChangeMajorReject(sqlSession, cm);
	}

	@Override
	public ArrayList<ChangeMajor> searchChangeMajor(SearchCondition sc) {
		return sd.searchChangeMajor(sqlSession, sc);
	}

	@Override
	public ArrayList<ChangeMajor> searchChangeMajor2(SearchCondition sc) {
		return sd.searchChangeMajor2(sqlSession, sc);
	}

	@Override
	public ArrayList<Graduation> selectGraduationMajor() {

		return sd.selectGraduationMajor(sqlSession);
	}

	@Override
	public Graduation selectGraduationMaDetail(String code) {

		return sd.selectGraduationMaDetail(sqlSession,code);
	}   

	@Override
	public int ExplusionListCount() {
		return sd.ExplusionListCount(sqlSession);
	}

	@Override
	public ArrayList<Explusion> ExplusionList(PageInfo pi) {
		return sd.ExplusionList(sqlSession, pi);
	}

	@Override
	public int ExplusionListCount2() {
		return sd.ExplusionListCount2(sqlSession);
	}

	@Override
	public ArrayList<Explusion> ExplusionList2(PageInfo pi) {
		return sd.ExplusionList2(sqlSession, pi);
	}

	@Override
	public int ExplusionEnroll(Explusion exp) {
		int result = sd.ExplusionEnroll(sqlSession, exp);
		
		if(result > 0) {
			sd.ExplusionUpdateStudent(sqlSession, exp);
		}
		return result; 
	}

	@Override
	public ArrayList<Explusion> searchExplusion(SearchCondition sc) {
		return sd.searchExplusion(sqlSession, sc);
	}

	@Override
	public ArrayList<Explusion> searchExplusion2(SearchCondition sc) {
		return sd.searchExplusion2(sqlSession, sc);
	}

	@Override
	public Explusion expInfo(String studentNo) {
		return sd.expInfo(sqlSession,studentNo);
	}

	@Override
	public int updateGraduationSc(Graduation gd) {

		return sd.updateGraduationSc(sqlSession,gd);
	}

	@Override
	public int updateGraduationMa(Graduation gd) {

		return sd.updateGraduationMa(sqlSession, gd);
	}

	@Override
	public DropOut doInfo(String studentNo) {
		return sd.doInfo(sqlSession, studentNo);
	}

	@Override
	public int insertDropOut(DropOut dpo) {
		return sd.insertDropOut(sqlSession, dpo);
	}

	@Override
	public ArrayList<DropOut> selectDropOut(DropOut dpo) {
		return sd.selectDropOut(sqlSession, dpo);
	}

	@Override
	public ArrayList<DropOut> selectDropOut(String studentNo) {
		return sd.selectDropOut(sqlSession, studentNo);
	}

	@Override
	public int pro_dropOutListCount(String pdeptCode) {
		return sd.pro_dropOutListCount(sqlSession, pdeptCode);
	}

	@Override
	public ArrayList<DropOut> pro_dropOutList(PageInfo pi, String pdeptCode) {
		return sd.pro_dropOutList(sqlSession, pi, pdeptCode);
	}

	@Override
	public DropOut selectProInfo(String professorNo) {
		return sd.selectProInfo(sqlSession, professorNo);
	}

	@Override
	public int pro_dropOutListCount2(String pdeptCode) {
		return sd.pro_dropOutListCount2(sqlSession, pdeptCode);
	}

	@Override
	public ArrayList<DropOut> pro_dropOutList2(PageInfo pi, String pdeptCode) {
		return sd.pro_dropOutList2(sqlSession, pi, pdeptCode);
	}

	@Override
	public int pro_DropOutEnroll(DropOut dpo) {
		return sd.pro_DropOutEnroll(sqlSession, dpo);
	}

	@Override
	public ArrayList<DropOut> searchDropOut(SearchCondition sc) {
		return sd.searchDropOut(sqlSession, sc);
	}

	@Override
	public ArrayList<DropOut> searchDropOut2(SearchCondition sc) {
		return sd.searchDropOut2(sqlSession, sc);
	}

	@Override
	public int em_dropOutListCount() {
		return sd.em_dropOutListCount(sqlSession);
	}

	@Override
	public ArrayList<DropOut> em_dropOutList(PageInfo pi) {
		return sd.em_dropOutList(sqlSession, pi);
	}

	@Override
	public int em_dropOutListCount2() {
		return sd.em_dropOutListCount2(sqlSession);
	}

	@Override
	public ArrayList<DropOut> em_dropOutList2(PageInfo pi) {
		return sd.em_dropOutList2(sqlSession, pi);
	}

	@Override
	public int em_DropOutEnroll(DropOut dpo) {
		int result = sd.em_DropOutEnroll(sqlSession, dpo);
		
		if(result > 0) {
			sd.dropOutStudentInfoUpdate(sqlSession, dpo);
		}
		return result;
	}

	@Override
	public ArrayList<DropOut> searchDropOut3(SearchCondition sc) {
		return sd.searchDropOut3(sqlSession, sc);
	}

	@Override
	public ArrayList<DropOut> searchDropOut4(SearchCondition sc) {
		return sd.searchDropOut4(sqlSession, sc);
	}

	@Override
	public int em_DropOutReject(DropOut dpo) {
		return sd.em_DropOutReject(sqlSession, dpo);
	}

	@Override
	public DropOut dpoInfo(String studentNo) {
		return sd.dpoInfo(sqlSession,studentNo);
	}

}

