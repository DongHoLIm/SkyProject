package com.kh.finalProject.professor.result.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;
import com.kh.finalProject.professor.result.model.vo.SubjectScheduler;

public interface ProfessorResultDao {

	ArrayList<ProfessorResult> subList(SqlSessionTemplate sqlSession, Member loginInfo);

	ArrayList<StudentResult> studentList(SqlSessionTemplate sqlSession, String opensubCode);

	SubjectScheduler subSch(SqlSessionTemplate sqlSession, String opensubCode);

	int resultInsertStu(SqlSessionTemplate sqlSession, StudentResult sr);

}
