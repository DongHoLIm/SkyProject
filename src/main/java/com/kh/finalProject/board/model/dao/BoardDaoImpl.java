package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
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
	
	@Override
	public UploadFile selectUploadFile(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.selectOne("UploadFile.selectUploadFile", boardNo);
	}

	@Override
	public int insertnNotice(SqlSessionTemplate sqlSession, Board b) {	
		
		return sqlSession.insert("Board.insertnNotice", b);
	}

	@Override
	public int insertNormalNotice(SqlSessionTemplate sqlSession, Board b) {
		
		return sqlSession.insert("Board.insertNormalNotice", b);
	}
	
	@Override
	public int insertnNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {		
		
		return sqlSession.insert("UploadFile.insertnNoticeFile", uf);
	}

	@Override
	public int deletenNotice(SqlSessionTemplate sqlSession, String boardNo) {
		
		return sqlSession.update("Board.deletenNotice", boardNo);
	}

	@Override
	public int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		
		return sqlSession.selectOne("Board.selectSearchResultCount", sc);
	}

	@Override
	public ArrayList<Board> selectSearchResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectSearchResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public int updatenNotice(SqlSessionTemplate sqlSession, Board b) {		
		
		return sqlSession.update("Board.updatenNotice", b);
	}

	@Override
	public int updatenNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		
		return sqlSession.update("UploadFile.updatenNoticeFile", uf);
	}

	@Override
	public int updateNormalNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updateNormalNotice", b);
	}

	



	
}
