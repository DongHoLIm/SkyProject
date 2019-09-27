package com.kh.finalProject.lectureEvaluation.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

public interface LectureEvaluationDao {

	int em_LectureEvalOpenListCount(SqlSessionTemplate sqlSession);

	ArrayList<LectureEvaluation> em_LectureEvalOpenList(SqlSessionTemplate sqlSession, PageInfo pi);

	int em_LectureEvaluationOpen(SqlSessionTemplate sqlSession, LectureEvaluation lev);

	int em_LectureEvalOpenListCount2(SqlSessionTemplate sqlSession);

	ArrayList<LectureEvaluation> em_LectureEvalOpenList2(SqlSessionTemplate sqlSession, PageInfo pi);

	int em_LectureEvaluationClose(SqlSessionTemplate sqlSession, LectureEvaluation lev);

	int st_LectureEvaluationListCount(SqlSessionTemplate sqlSession, String studentNo);

	ArrayList<LectureEvaluation> st_LectureEvaluationList(SqlSessionTemplate sqlSession, PageInfo pi, String studentNo);

	int st_LectureEvaluationInsert(SqlSessionTemplate sqlSession, LectureEvaluation lev);

	int st_LectureEvaluationCountUpdate(SqlSessionTemplate sqlSession, LectureEvaluation lev);

	int pro_LectureEvaluationListCount(SqlSessionTemplate sqlSession, String professorNo);

	ArrayList<LectureEvaluation> pro_LectureEvaluationList(SqlSessionTemplate sqlSession, PageInfo pi, String professorNo);




	
}
