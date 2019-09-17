package com.kh.finalProject.professor.sendSMS.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;

public interface professorDao {

	int studentList(SqlSessionTemplate sqlSession);

	ArrayList<StudentList> studentPageList(SqlSessionTemplate sqlSession, PageInfo pi);

	int insertSMS(SqlSessionTemplate sqlSession, StudentList sl);

}
