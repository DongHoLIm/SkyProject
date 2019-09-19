package com.kh.finalProject.professor.openSubject.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

@Repository
public class OpenSubjectImplDao implements OpenSubjectDao{

	@Override
	public List<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession) {
		
		
		
		return sqlSession.selectList("OpenSubject.selectOpenSubjectList");
	
	}

	@Override
	public OpenSubject seletOneSubject(SqlSessionTemplate sqlSession, String subCode) {
		
		return sqlSession.selectOne("OpenSubject.selectOpenSubject", subCode);
	}
	

}
