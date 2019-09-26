package com.kh.finalProject.lectureEvaluation.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

@Repository
public class LectureEvaluationDaoImpl implements LectureEvaluationDao{

	@Override
	public int selectLectureEvalOpenListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("LectureEvaluation.selectLectureEvalOpenListCount");
	}
	
	@Override
	public ArrayList<LectureEvaluation> selectLectureEvalOpenList(SqlSessionTemplate sqlSession, PageInfo pi) throws LectureEvaluationSelectListException {		
		ArrayList<LectureEvaluation> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("LectureEvaluation.selectLectureEvalOpenList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
			throw new LectureEvaluationSelectListException("강의평가 대상 리스트 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int stSelectLectureEvalOpenListCount(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("LectureEvaluation.stSelectLectureEvalOpenListCount", studentNo);
	}

	@Override
	public ArrayList<LectureEvaluation> stSelectLectureEvalOpenList(SqlSessionTemplate sqlSession, String studentNo) {
		return (ArrayList) sqlSession.selectList("LectureEvaluation.stSelectLectureEvalOpenList", studentNo);
	}

	@Override
	public ArrayList<LectureEvaluation> questionList(SqlSessionTemplate sqlSession) {
		return  (ArrayList) sqlSession.selectList("LectureEvaluation.questionList");
	}


}
