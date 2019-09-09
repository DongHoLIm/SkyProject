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
	public int insertNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {		
		
		return sqlSession.insert("UploadFile.insertNoticeFile", uf);
	}

	@Override
	public int deleteNotice(SqlSessionTemplate sqlSession, String boardNo) {
		
		return sqlSession.update("Board.deleteNotice", boardNo);
	}

	@Override
	public int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		
		return sqlSession.selectOne("Board.selectSearchResultCount", sc);
	}

	@Override
	public ArrayList<Board> selectSearchResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo spi) {
		ArrayList<Board> slist = null;
		
		int offset = (spi.getCurrentPage() - 1) * spi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, spi.getLimit());
		
		slist = (ArrayList) sqlSession.selectList("Board.selectSearchResultList", sc, rowBounds);
		
		return slist;
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

	@Override
	public int sNoticeListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selectsNoticeListCount");
	}

	@Override
	public ArrayList<Board> selectsNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectsNoticeList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public Board selectsNoticeOne(SqlSessionTemplate sqlSession, int boardNo) {
		
		return sqlSession.selectOne("Board.selectsNoticeOne", boardNo);
	}

	@Override
	public int insertsNotice(SqlSessionTemplate sqlSession, Board b) {	
		
		return sqlSession.insert("Board.insertsNotice", b);
	}

	@Override
	public int insertscholNotice(SqlSessionTemplate sqlSession, Board b) {
		
		return sqlSession.insert("Board.insertscholNotice", b);
	}

	@Override
	public int updatesNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updatesNotice", b);
	}

	@Override
	public int updateScholNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updateScholNotice", b);
	}

	@Override
	public int updatesNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.update("UploadFile.updatesNoticeFile", uf);
	}

	@Override
	public int SearchsNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.SearchsNoticeResultCount", sc);
	}

	@Override
	public ArrayList<Board> SearchsNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.SearchsNoticeResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public int selectacNoticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selectacNoticeCount");
	}

	@Override
	public ArrayList<Board> selectacNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectacNoticeList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int SearchacNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.SearchacNoticeResultCount", sc);
	}

	@Override
	public ArrayList<Board> SearchacNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.SearchacNoticeResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public int selectacNoticeMonthCount(SqlSessionTemplate sqlSession, String month) {
		
		return sqlSession.selectOne("Board.selectacNoticeMonthCount", month);
	}

	@Override
	public ArrayList<Board> selectacNoticeMonthList(SqlSessionTemplate sqlSession, String month, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectacNoticeMonthList", month, rowBounds);
		
		return list;
	}

	@Override
	public Board selectacNoticeOne(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("Board.selectacNoticeOne", boardNo);
	}

	@Override
	public int updateacNotice(SqlSessionTemplate sqlSession, Board b) {
		return  sqlSession.update("Board.updateacNotice", b);	
	}


	@Override
	public int updateSchoolSchedule(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updateSchoolSchedule", b);
	}

	@Override
	public int updateacNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return  sqlSession.update("UploadFile.updateacNoticeFile", uf);
	}

	@Override
	public int insertacNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.insertacNotice", b);
	}

	@Override
	public int insertSchoolSchedule(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.insertSchoolSchedule", b);
	}

	@Override
	public int eNoticeListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selecteNoticeCount");
	}

	@Override
	public ArrayList<Board> selecteNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selecteNoticeList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int SearcheNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.SearcheNoticeResultCount", sc);
	}

	@Override
	public ArrayList<Board> SearcheNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.SearcheNoticeResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public Board selecteNoticeOne(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("Board.selecteNoticeOne", boardNo);
	}

	@Override
	public int inserteNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.inserteNotice", b);
	}

	@Override
	public int insertEvent(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.insertEvent", b);
	}

	@Override
	public int updateeNotice(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updateeNotice", b);
	}

	@Override
	public int updateEvent(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updateEvent", b);
	}

	@Override
	public int updateeNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.update("UploadFile.updateeNoticeFile", uf);
	}

}
