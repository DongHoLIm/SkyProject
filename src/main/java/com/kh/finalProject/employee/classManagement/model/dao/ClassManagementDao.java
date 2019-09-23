package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;

public interface ClassManagementDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<LectureOpen> selctSubjectList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen seletOneSubject(SqlSessionTemplate sqlSession, String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(SqlSessionTemplate sqlSession, String sdeptName) throws ClassManagementSelectListException;

	ArrayList<ClassRoomInformation> selectClassRoomList(SqlSessionTemplate sqlSession);

	int insertCourseOffered(SqlSessionTemplate sqlSession, LectureRegistration lr);

	int updateSubject(SqlSessionTemplate sqlSession, String subCode);

	ArrayList<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession);

	void updateOpenSubject(SqlSessionTemplate sqlSession, String[] subCode);

	ArrayList<OpenSubject> selectPreliminaryOpenSubjectList(SqlSessionTemplate sqlSession);

	void updateFinishOpenSubject(SqlSessionTemplate sqlSession, String[] subCode);

}
