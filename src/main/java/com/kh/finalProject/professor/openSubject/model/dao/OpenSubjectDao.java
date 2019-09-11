package com.kh.finalProject.professor.openSubject.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

public interface OpenSubjectDao {

	public List<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession);

}
