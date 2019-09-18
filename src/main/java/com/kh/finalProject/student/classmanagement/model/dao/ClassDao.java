package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

public interface ClassDao {


	ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession);

	ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession);

	ArrayList<OpenSubject> selectSubject(SqlSessionTemplate sqlSession, OpenSubject os);

	ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession, OpenSubject os);

	ArrayList<OpenSubject> selectSearchgwamok(SqlSessionTemplate sqlSession, String gwamok);

	ArrayList<OpenSubject> selectProfessor(SqlSessionTemplate sqlSession, String professor);

	ArrayList<OpenSubject> seletProGwamok(SqlSessionTemplate sqlSession, OpenSubject os);

	void insertCourseApply(SqlSessionTemplate sqlSession, String[] subCode, SubjectApply sa);

	ArrayList<SubjectApply> selectMySugang(SqlSessionTemplate sqlSession, SubjectApply sa);

}
