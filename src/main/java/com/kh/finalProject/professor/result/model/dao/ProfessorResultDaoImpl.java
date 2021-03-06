package com.kh.finalProject.professor.result.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;
import com.kh.finalProject.professor.result.model.vo.SubjectScheduler;
@Repository
public class ProfessorResultDaoImpl implements ProfessorResultDao{

	@Override
	public ArrayList<ProfessorResult> subList(SqlSessionTemplate sqlSession, Member loginInfo) {
		ArrayList<ProfessorResult> list = (ArrayList) sqlSession.selectList("professorResult.subList",loginInfo);
		return list;
	}

	@Override
	public ArrayList<StudentResult> studentList(SqlSessionTemplate sqlSession, String opensubCode) {
		ArrayList<StudentResult> stulist = (ArrayList) sqlSession.selectList("professorResult.stuList", opensubCode);
		return stulist;
	}

	@Override
	public SubjectScheduler subSch(SqlSessionTemplate sqlSession, String opensubCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("professorResult.subScheduler", opensubCode);
	}

	@Override
	public int resultInsertStu(SqlSessionTemplate sqlSession, StudentResult sr) {
		
		return sqlSession.update("professorResult.resultInsertStu",sr);
	}

}
