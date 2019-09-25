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
	public int getListCount() throws LectureEvaluationSelectListException {
		return ld.selectLectureEvalOpenListCount(sqlSession);
	}
	
	@Override
	public ArrayList<LectureEvaluation> selectLectureEvalOpenList(PageInfo pi) throws LectureEvaluationSelectListException{
		return ld.selectLectureEvalOpenList(sqlSession, pi);
	}

}
