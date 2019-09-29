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
	public int em_LectureEvaluationOpen(SqlSessionTemplate sqlSession, LectureEvaluation lev) {
		return sqlSession.update("LectureEvaluation.LectureEvaluationOpen", lev);
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

	@Override
	public int em_LectureEvaluationClose(SqlSessionTemplate sqlSession, LectureEvaluation lev) {
		return sqlSession.update("LectureEvaluation.LectureEvaluationClose", lev);
	}

	@Override
	public int st_LectureEvaluationListCount(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("LectureEvaluation.st_LectureEvaluationListCount", studentNo);
	}

	@Override
	public ArrayList<LectureEvaluation> st_LectureEvaluationList(SqlSessionTemplate sqlSession, PageInfo pi, String studentNo) {
		ArrayList<LectureEvaluation> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("LectureEvaluation.st_LectureEvaluationList", studentNo, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int st_LectureEvaluationInsert(SqlSessionTemplate sqlSession, LectureEvaluation lev) {
		return sqlSession.insert("LectureEvaluation.st_LectureEvaluationInsert", lev);
	}

	@Override
	public int st_LectureEvaluationCountUpdate(SqlSessionTemplate sqlSession, LectureEvaluation lev) {
		return sqlSession.update("LectureEvaluation.st_LectureEvaluationCountUpdate", lev);
	}

	@Override
	public int pro_LectureEvaluationListCount(SqlSessionTemplate sqlSession, String professorNo) {
		return sqlSession.selectOne("LectureEvaluation.pro_LectureEvaluationListCount", professorNo);
	}

	@Override
	public ArrayList<LectureEvaluation> pro_LectureEvaluationList(SqlSessionTemplate sqlSession, PageInfo pi, String professorNo) {
		ArrayList<LectureEvaluation> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("LectureEvaluation.pro_LectureEvaluationList", professorNo, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}


	




}
