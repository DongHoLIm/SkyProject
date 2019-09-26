package com.kh.finalProject.lectureEvaluation.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

@Repository
public class LectureEvaluationDaoImpl implements LectureEvaluationDao{

	@Override
	public int em_LectureEvalOpenListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("LectureEvaluation.LectureEvalOpenListCount");
	}

	@Override
	public ArrayList<LectureEvaluation> em_LectureEvalOpenList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<LectureEvaluation> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("LectureEvaluation.LectureEvalOpenList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int em_LectureEvaluationInsert(SqlSessionTemplate sqlSession, LectureEvaluation lev) {
		return sqlSession.insert("LectureEvaluation.em_LectureEvaluationInsert", lev);
	}

	@Override
	public int em_LectureEvalOpenListCount2(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("LectureEvaluation.LectureEvalOpenListCount2");
	}

	@Override
	public ArrayList<LectureEvaluation> em_LectureEvalOpenList2(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<LectureEvaluation> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("LectureEvaluation.LectureEvalOpenList2", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}




}
