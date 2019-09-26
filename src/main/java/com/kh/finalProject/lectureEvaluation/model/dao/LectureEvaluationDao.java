package com.kh.finalProject.lectureEvaluation.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

public interface LectureEvaluationDao {

	int selectLectureEvalOpenListCount(SqlSessionTemplate sqlSession);
	
	ArrayList<LectureEvaluation> selectLectureEvalOpenList(SqlSessionTemplate sqlSession, PageInfo pi) throws LectureEvaluationSelectListException;

	int stSelectLectureEvalOpenListCount(SqlSessionTemplate sqlSession, String studentNo);

	ArrayList<LectureEvaluation> stSelectLectureEvalOpenList(SqlSessionTemplate sqlSession, String studentNo);

	ArrayList<LectureEvaluation> questionList(SqlSessionTemplate sqlSession);

	
}
