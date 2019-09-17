package com.kh.finalProject.scholarship.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

public interface ScholarshipDao {

	ArrayList<Scholarship> beforeScholarshipData(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException;
	
	ArrayList<Scholarship> userScholarship(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException;

	ArrayList<Scholarship> userScholarshipApply(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException;

	public void insertScholarship(SqlSessionTemplate sqlSession, Scholarship scholarship);


}
