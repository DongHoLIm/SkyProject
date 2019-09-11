package com.kh.finalProject.professor.openSubject.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.professor.openSubject.model.dao.OpenSubjectDao;
import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

@Service
public class OpenSubjectImplService implements OpenSubjectService {

	@Autowired
	OpenSubjectDao openSubjectDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<OpenSubject> selectOpenSubjectList() {
			
		
		return openSubjectDao.selectOpenSubjectList(sqlSession);
	}

}
