package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.dao.ClassManagementDao;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

@Service
public class ClassManagementServiceImpl implements ClassManagementService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ClassManagementDao cmd;
	
	@Override
	public int getListCount() {
		
		return cmd.getListCount(sqlSession);
	}

	@Override
	public ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException {
		
		return cmd.selctSubjectList(sqlSession, pi);
	}


	@Override
	public LectureOpen selectOneSubject(String subCode) {
		return cmd.seletOneSubject(sqlSession, subCode);
	}

	@Override
	public ArrayList<DepartmentProfessor> selectProfessorList(String sdeptName) throws ClassManagementSelectListException {
		return cmd.selectProfessorList(sqlSession, sdeptName);
	}

	@Override
	public ArrayList<ClassRoomInformation> selectClassRoomList() {
		return cmd.selectClassRoomList(sqlSession);
	}

	@Override
	public int insertCourseOffered(LectureRegistration lr) {
		
		return cmd.insertCourseOffered(sqlSession, lr);
	}

	@Override
	public int updateSubject(String subCode) {
		
		return cmd.updateSubject(sqlSession, subCode);
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubjectList() {

		return cmd.selectOpenSubjectList(sqlSession);
	}

	@Override
	public void updateOpenSubject(String[] subCode) {

		cmd.updateOpenSubject(sqlSession, subCode);
	}

	@Override
	public ArrayList<OpenSubject> selectPreliminaryOpenSubjectList() {
		
		return cmd.selectPreliminaryOpenSubjectList(sqlSession);
	}

	@Override
	public void updateFinishOpenSubject(String[] subCode) {
		cmd.updateFinishOpenSubject(sqlSession, subCode);
		
	}

	@Override
	public ArrayList<OpenSubject> selectFinishOpenSubjectList() {
		
		return cmd.selectFinishOpenSubjectList(sqlSession);
	}

	@Override
	public void closeFinishOpenSubject(String[] subCode) {
		cmd.updateCloseFinishOpenSubject(sqlSession, subCode);
		
	}

	@Override
	public void updateSubjectApply() {
		cmd.updateSubjectApply(sqlSession);
		
	}

	@Override
	public ArrayList<SubjectApply> selectUpdateList() {

		return cmd.selectUpdateList(sqlSession);
	}

	@Override
	public void insertSubApplyDone(String[] code) {
		
		cmd.insertSubApplyDone(sqlSession, code);
	}
}
