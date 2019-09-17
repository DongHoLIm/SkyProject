package com.kh.finalProject.scholarship.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

@Repository
public class ScholarshipDaoImpl implements ScholarshipDao{

	@Override
	public ArrayList<Scholarship> beforeScholarshipData(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException {
		System.out.println("장학금 조회 dao 들어옴");
		
		ArrayList<Scholarship> beforeScholarship = null;
		
		beforeScholarship = (ArrayList) sqlSession.selectList("Scholarship.beforeScholarshipApplyInfo", studentNo);
		
		if(beforeScholarship == null) {
			throw new ScholarshipException("정보가 존재하지 않습니다.");
		}
		
		return beforeScholarship;
	}
	
	@Override
	public ArrayList<Scholarship> userScholarship(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException {
		ArrayList<Scholarship> memberScholarship = null;
		
		memberScholarship = (ArrayList) sqlSession.selectList("Scholarship.ScholarshipCheck", studentNo);
		
		if(memberScholarship == null) {
			throw new ScholarshipException("정보가 존재하지 않습니다.");
		}
		
		return memberScholarship;
	}

	@Override
	public ArrayList<Scholarship> userScholarshipApply(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException {
		ArrayList<Scholarship> memberScholarshipApply = null;
		
		memberScholarshipApply = (ArrayList) sqlSession.selectList("Scholarship.showScholarshipApplyView", studentNo);
		
		if(memberScholarshipApply == null) {
			throw new ScholarshipException("신청에 실패했습니다.");
		}
		
		return memberScholarshipApply;
	}

	@Override
	public void insertScholarship(SqlSessionTemplate sqlSession, Scholarship scholarship) {
		
		System.out.println("들어옴");
		
		sqlSession.insert("Scholarship.add", scholarship);
	}


}
