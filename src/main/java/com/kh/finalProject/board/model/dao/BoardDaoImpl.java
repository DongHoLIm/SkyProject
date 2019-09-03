package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Board.selectListCount");
	}

	@Override
	public ArrayList<Board> selectnNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) throws BoardSelectListException {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectnNoticeList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
			throw new BoardSelectListException("게시물 조회 실패!");
		}
		
		return list;
	}

	@Override
	public Writer selectWriterInfo(SqlSessionTemplate sqlSession, String memberId) {
		
		return sqlSession.selectOne("Writer.selectWriterInfo", memberId);
	}

	@Override
	public int updateCount(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.update("Board.updateBoardCount", boardNo);
	}

	@Override
	public Board selectOneBoard(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.selectOne("Board.selectBoardOne", boardNo);
	}

	
}
