package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

public interface ClassManagementDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<LectureOpen> selctSubjectList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen seletOneSubject(SqlSessionTemplate sqlSession, String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(SqlSessionTemplate sqlSession, String sdeptName);

}
