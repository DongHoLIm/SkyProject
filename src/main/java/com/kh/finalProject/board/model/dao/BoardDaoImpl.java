package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.board.model.vo.SystemQuestion;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;
import com.kh.finalProject.board.model.vo.mainDate;

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

	@Override
	public int freeBoardListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selectfreeBoardCount");
	}

	@Override
	public ArrayList<Board> selectfreeBoardList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectfreeBoardList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int SearchefreeBoardResultCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.SearchefreeBoardResultCount", sc);
	}

	@Override
	public ArrayList<Board> SearchfreeBoardResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.SearchfreeBoardResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public Board selectfreeBoardOne(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("Board.selectfreeBoardOne", boardNo);
	}

	@Override
	public int insertfreeBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.insertfreeBoard", b);
	}

	@Override
	public int insertFreeBoardFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return  sqlSession.insert("UploadFile.insertfreeBoardFile", uf);
	}

	@Override
	public Writer selectFreeBoardstWriter(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Writer.selectFreeBoardstWriter", memberId);
	}

	@Override
	public int updatefreeBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updatefreeBoard", b);
	}

	@Override
	public int updatefreeBoardFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.update("UploadFile.updatefreeBoardFile", uf);
	}

	@Override
	public int deletefreeBoard(SqlSessionTemplate sqlSession, String boardNo) {
		return sqlSession.update("Board.deletefreeBoard", boardNo);
	}

	@Override
	public Writer selectFreeBoardproWriter(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Writer.selectFreeBoardproWriter", memberId);
	}

	@Override
	public Writer selectFreeBoardemWriter(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Writer.selectFreeBoardemWriter", memberId);
	}

	@Override
	public int praiseBoardListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selectpraiseBoardCount");
	}

	@Override
	public ArrayList<Board> selectpraiseBoardList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.selectpraiseBoardList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int SearchepraiseBoardResultCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.SearchepraiseBoardResultCount", sc);
	}

	@Override
	public ArrayList<Board> SearchpraiseBoardResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.SearchpraiseBoardResultList", sc, rowBounds);
		
		return list;
	}

	@Override
	public Board selectpraiseBoardOne(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("Board.selectpraiseBoardOne", boardNo);
	}

	@Override
	public Writer selectpraiseBoardstWriter(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Writer.selectpraiseBoardstWriter", memberId);
	}

	@Override
	public int insertpraiseBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("Board.insertpraiseBoard", b);
	}

	@Override
	public int insertpraiseBoardFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.insert("UploadFile.insertpraiseBoardFile", uf);
	}

	@Override
	public int updatepraiseBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("Board.updatepraiseBoard", b);
	}

	@Override
	public int updatepraiseBoardFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.update("UploadFile.updatepraiseBoardFile", uf);
	}

	@Override
	public int deletepraiseBoard(SqlSessionTemplate sqlSession, String boardNo) {
		return sqlSession.update("Board.deletepraiseBoard", boardNo);
	}

	@Override
	public int searchMyBoardListCount(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Board.searchMyBoardListCount", memberId);
	}

	@Override
	public ArrayList<Board> searchMyBoardList(SqlSessionTemplate sqlSession, PageInfo pi, String memberId) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.searchMyBoardList", memberId, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int searchMyBoardSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.searchMyBoardSearchListCount", sc);
	}

	@Override
	public ArrayList<Board> searchMyBoardSearchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Board.searchMyBoardSearchList", sc, rowBounds);
		
		return list;
	}

	@Override
	public int searchMyBoardDelete(SqlSessionTemplate sqlSession, String boardNo) {
		return sqlSession.update("Board.searchMyBoardDelete", boardNo);
	}

	@Override
	public int systemQuestionListCount(SqlSessionTemplate sqlSession, String memberId) {
		return  sqlSession.selectOne("SystemQuestion.systemQuestionListCount", memberId);
	}

	@Override
	public ArrayList<Board> systemQuestionList(SqlSessionTemplate sqlSession, PageInfo pi, String memberId) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SystemQuestion.systemQuestionList", memberId, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public int systemQuestionSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return  sqlSession.selectOne("SystemQuestion.systemQuestionSearchListCount", sc);
	}

	@Override
	public ArrayList<Board> systemQuestionSearchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SystemQuestion.systemQuestionSearchList", sc, rowBounds);
		
		return list;
	}

	@Override
	public Writer selectSystemQuestionWriter(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectOne("Writer.selectSystemQuestionWriter", memberId);
	}

	@Override
	public int insertSystemQuestion(SqlSessionTemplate sqlSession, SystemQuestion sq) {
		return sqlSession.insert("SystemQuestion.insertSystemQuestion", sq);
	}

	@Override
	public int insertSystemQuestionFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.insert("UploadFile.insertSystemQuestionFile", uf);
	}

	@Override
	public int updateSystemQuestionCount(SqlSessionTemplate sqlSession, int questionNo) {
		return  sqlSession.update("SystemQuestion.updateSystemQuestionCount", questionNo);
	}

	@Override
	public SystemQuestion selectSystemQuestionOne(SqlSessionTemplate sqlSession, int questionNo) {
		return sqlSession.selectOne("SystemQuestion.selectSystemQuestionOne", questionNo);
	}

	@Override
	public UploadFile selectSystemQuestionFile(SqlSessionTemplate sqlSession, int questionNo) {
		return sqlSession.selectOne("UploadFile.selectSystemQuestionFile", questionNo);
	}

	@Override
	public int updateSystemQuestion(SqlSessionTemplate sqlSession, SystemQuestion sq) {
		return sqlSession.update("SystemQuestion.updateSystemQuestion", sq);
	}

	@Override
	public int updateSystemQuestionFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.update("UploadFile.updateSystemQuestionFile", uf);
	}

	@Override
	public int SystemQuestionDelete(SqlSessionTemplate sqlSession, int questionNo) {
		return  sqlSession.update("SystemQuestion.SystemQuestionDelete", questionNo);
	}

	@Override
	public int emsystemQuestionListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("SystemQuestion.emsystemQuestionListCount");
	}

	@Override
	public ArrayList<SystemQuestion> emsystemQuestionList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<SystemQuestion> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SystemQuestion.emsystemQuestionList", null, rowBounds);
		
		return list;
	}

	@Override
	public int emsystemQuestionSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("SystemQuestion.emsystemQuestionSearchListCount", sc);
	}

	@Override
	public ArrayList<SystemQuestion> emsystemQuestionSearchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<SystemQuestion> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SystemQuestion.emsystemQuestionSearchList", sc, rowBounds);
		
		return list;
	}

	@Override
	public int insertSystemQuestionAnswer(SqlSessionTemplate sqlSession, SystemQuestion sq) {
		return sqlSession.insert("SystemQuestion.insertSystemQuestionAnswer", sq);
	}

	@Override
	public int insertSystemQuestionAnswerFile(SqlSessionTemplate sqlSession, UploadFile uf) {
		return sqlSession.insert("UploadFile.insertSystemQuestionAnswerFile", uf);
	}

	@Override
	public ArrayList<Board> selectnNoticeInfo(SqlSessionTemplate sqlSession) {
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("Board.selectnNoticeInfo");
		
		return list;
	}

	@Override
	public int autoDeletenNotice(SqlSessionTemplate sqlSession, ArrayList<Board> b) {
		int result = 0;
		
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());		
		
		String[] deleteDay = new String[b.size()];
		
		for(int i = 0; i < b.size(); i++) {			
			
			deleteDay[i] = b.get(i).getDeadLine().split(" ")[0];			
			
			b.get(i).setDeadLine(deleteDay[i]);		
			
			java.sql.Date day = java.sql.Date.valueOf(b.get(i).getDeadLine());			
			
			java.util.Date utilDate = new java.util.Date(sqlDate.getDate());
			java.util.Date utilDate2 = new java.util.Date(day.getDate());
			
			int compare = utilDate.compareTo(utilDate2);			
			
			if(compare == 0) {				
				
				result = sqlSession.update("Board.autoDeletenNotice", sqlDate);
			}			
		}
		
		return result;
	}

	@Override
	public ArrayList<Board> selectsNoticeInfo(SqlSessionTemplate sqlSession) {
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("Board.selectsNoticeInfo");
		
		return list;
	}

	@Override
	public int autoDeletesNotice(SqlSessionTemplate sqlSession, ArrayList<Board> b) {
		int result = 0;
		
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());		
		
		String[] deleteDay = new String[b.size()];
		
		for(int i = 0; i < b.size(); i++) {			
			
			deleteDay[i] = b.get(i).getDeadLine().split(" ")[0];			
			
			b.get(i).setDeadLine(deleteDay[i]);		
			
			java.sql.Date day = java.sql.Date.valueOf(b.get(i).getDeadLine());			
			
			java.util.Date utilDate = new java.util.Date(sqlDate.getDate());
			java.util.Date utilDate2 = new java.util.Date(day.getDate());
			
			int compare = utilDate.compareTo(utilDate2);			
			
			if(compare == 0) {				
				
				result = sqlSession.update("Board.autoDeletesNotice", sqlDate);
			}			
		}
		
		return result;
	}

	@Override
	public ArrayList<Board> selecteNoticeInfo(SqlSessionTemplate sqlSession) {
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("Board.selecteNoticeInfo");
		
		return list;
	}

	@Override
	public int autoDeleteeNotice(SqlSessionTemplate sqlSession, ArrayList<Board> b) {
		int result = 0;
		
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());		
		
		String[] deleteDay = new String[b.size()];
		
		for(int i = 0; i < b.size(); i++) {			
			
			deleteDay[i] = b.get(i).getDeadLine().split(" ")[0];			
			
			b.get(i).setDeadLine(deleteDay[i]);		
			
			java.sql.Date day = java.sql.Date.valueOf(b.get(i).getDeadLine());			
			
			java.util.Date utilDate = new java.util.Date(sqlDate.getDate());
			java.util.Date utilDate2 = new java.util.Date(day.getDate());
			
			int compare = utilDate.compareTo(utilDate2);			
			
			if(compare == 0) {				
				
				result = sqlSession.update("Board.autoDeleteeNotice", sqlDate);
			}			
		}
		
		return result;
	}

	@Override
	public ArrayList<Board> selectaNoticeInfo(SqlSessionTemplate sqlSession) {
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("Board.selectaNoticeInfo");
		
		return list;
	}

	@Override
	public int autoDeleteaNotice(SqlSessionTemplate sqlSession, ArrayList<Board> b) {
		int result = 0;
		
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());		
		
		String[] deleteDay = new String[b.size()];
		
		for(int i = 0; i < b.size(); i++) {			
			
			deleteDay[i] = b.get(i).getDeadLine().split(" ")[0];			
			
			b.get(i).setDeadLine(deleteDay[i]);		
			
			java.sql.Date day = java.sql.Date.valueOf(b.get(i).getDeadLine());			
			
			java.util.Date utilDate = new java.util.Date(sqlDate.getDate());
			java.util.Date utilDate2 = new java.util.Date(day.getDate());
			
			int compare = utilDate.compareTo(utilDate2);			
			
			if(compare == 0) {				
				
				result = sqlSession.update("Board.autoDeleteaNotice", sqlDate);
			}			
		}
		
		return result;
	}

	@Override
	public ArrayList<Board> mainBoardList(SqlSessionTemplate sqlSession) {
		ArrayList<Board>list = (ArrayList) sqlSession.selectList("Board.mainBoardList");
		return list;
	}

	@Override
	public ArrayList<mainDate> mainDateList(SqlSessionTemplate sqlSession) {
		ArrayList<mainDate> list = (ArrayList)sqlSession.selectList("Board.mainDateList");
		return list;
	}
}
