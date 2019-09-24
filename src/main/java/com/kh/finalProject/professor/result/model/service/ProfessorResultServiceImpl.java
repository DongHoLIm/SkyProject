package com.kh.finalProject.professor.result.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.dao.ProfessorResultDao;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;
import com.kh.finalProject.professor.result.model.vo.SubjectScheduler;

@Service
public class ProfessorResultServiceImpl implements ProfessorResultService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private ProfessorResultDao pd;
	
	@Override
	public ArrayList<ProfessorResult> subList(Member loginInfo) {
		// TODO Auto-generated method stub
		return pd.subList(sqlSession,loginInfo);
	}

	@Override
	public ArrayList<StudentResult> studentList(String opensubCode) {
		// TODO Auto-generated method stub
		return pd.studentList(sqlSession,opensubCode);
	}

	@Override
	public SubjectScheduler subSch(String opensubCode) {
		
		return pd.subSch(sqlSession,opensubCode);
	}

}
