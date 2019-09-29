package com.kh.finalProject.lectureEvaluation.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.dao.LectureEvaluationDao;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

@Service
public class LectureEvaluationServiceImpl implements LectureEvaluationService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired	
	private LectureEvaluationDao ld;

	@Override
	public int em_LectureEvalOpenListCount() {
		return ld.em_LectureEvalOpenListCount(sqlSession);
	}

	@Override
	public ArrayList<LectureEvaluation> em_LectureEvalOpenList(PageInfo pi) {
		return ld.em_LectureEvalOpenList(sqlSession, pi);
	}

	@Override
	public int em_LectureEvaluationOpen(LectureEvaluation lev) {
		return ld.em_LectureEvaluationOpen(sqlSession, lev);
	}
	
	@Override
	public int em_LectureEvalOpenListCount2() {
		return ld.em_LectureEvalOpenListCount2(sqlSession);
	}

	@Override
	public ArrayList<LectureEvaluation> em_LectureEvalOpenList2(PageInfo pi) {
		return ld.em_LectureEvalOpenList2(sqlSession, pi);
	}

	@Override
	public int em_LectureEvaluationClose(LectureEvaluation lev) {
		return ld.em_LectureEvaluationClose(sqlSession, lev);
	}

	@Override
	public int st_LectureEvaluationListCount(String studentNo) {
		return ld.st_LectureEvaluationListCount(sqlSession, studentNo);
	}

	@Override
	public ArrayList<LectureEvaluation> st_LectureEvaluationList(PageInfo pi, String studentNo) {
		return ld.st_LectureEvaluationList(sqlSession, pi, studentNo);
	}

	@Override
	public int st_LectureEvaluationInsert(LectureEvaluation lev) {
		
		int result = ld.st_LectureEvaluationInsert(sqlSession, lev);
		
		if(result > 0) {
			ld.st_LectureEvaluationCountUpdate(sqlSession, lev);
		}
		
		return result; 
	}

	@Override
	public int pro_LectureEvaluationListCount(String professorNo) {
		return ld.pro_LectureEvaluationListCount(sqlSession, professorNo);
	}

	@Override
	public ArrayList<LectureEvaluation> pro_LectureEvaluationList(PageInfo pi, String professorNo) {
		return ld.pro_LectureEvaluationList(sqlSession, pi, professorNo);
	}




}
