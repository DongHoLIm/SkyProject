package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

public interface ClassDao {


	ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession);

	ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession);

	ArrayList<OpenSubject> selectSubject(SqlSessionTemplate sqlSession, OpenSubject os);

	ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession, OpenSubject os);

	ArrayList<OpenSubject> selectSearchgwamok(SqlSessionTemplate sqlSession, String gwamok);

}
