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
	public ArrayList<Scholarship> userScholarship(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException {
		ArrayList<Scholarship> memberScholarship = null;
		
		memberScholarship = (ArrayList) sqlSession.selectList("Scholarship.ScholarshipCheck", studentNo);
		
		if(memberScholarship == null) {
			throw new ScholarshipException("정보가 존재하지 않습니다.");
		}
		
		return memberScholarship;
	}

	@Override
	public ArrayList<ScholarshipApply> userScholarshipApply(SqlSessionTemplate sqlSession, String studentNo) throws ScholarshipException {
		ArrayList<ScholarshipApply> memberScholarshipApply = null;
		
		memberScholarshipApply = (ArrayList) sqlSession.selectList("ScholarshipApply.showScholarshipApplyView", studentNo);
		
		if(memberScholarshipApply == null) {
			throw new ScholarshipException("신청에 실패했습니다.");
		}
		
		return memberScholarshipApply;
	}

}
