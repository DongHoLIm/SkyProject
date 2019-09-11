package com.kh.finalProject.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.dao.BoardDao;
import com.kh.finalProject.board.model.exception.BoardDeleteException;
import com.kh.finalProject.board.model.exception.BoardInsertException;
import com.kh.finalProject.board.model.exception.BoardSearchException;
import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.exception.BoardSelectOneException;
import com.kh.finalProject.board.model.exception.BoardUpdateException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDao bd;	

	@Override
	public int getListCount() throws BoardSelectListException{
		
		return bd.getListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectnNoticeList(PageInfo pi) throws BoardSelectListException {
		
		return bd.selectnNoticeList(sqlSession, pi);
	}

	@Override
	public Writer selectWriterInfo(String memberId) {
		
		return bd.selectWriterInfo(sqlSession, memberId);
	}

	@Override
	public Board selectOneBoard(int boardNo) throws BoardSelectOneException{
		
		bd.updateCount(sqlSession, boardNo);
		
		return bd.selectOneBoard(sqlSession, boardNo);
	}
	
	@Override
	public UploadFile selectUploadFile(int boardNo) throws BoardSelectOneException{
		return bd.selectUploadFile(sqlSession, boardNo);
	}

	@Override
	public int insertnNoticewithFile(Board b, UploadFile uf) throws BoardInsertException{				
		 
		int result = bd.insertnNotice(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertNormalNotice(sqlSession, b);			
			
			bd.insertNoticeFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int insertnNotice(Board b) throws BoardInsertException{
		int result = bd.insertnNotice(sqlSession, b);
		
		if(result > 0) {
			bd.insertNormalNotice(sqlSession, b);
		}
		
		return result;
	}

	@Override
	public int deleteNotice(String boardNo) throws BoardDeleteException{
		
		return bd.deleteNotice(sqlSession, boardNo);
	}

	@Override
	public int getSearchResultListCount(SearchCondition sc) throws BoardSearchException{
		return bd.getSearchResultListCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo spi) throws BoardSearchException {
		return bd.selectSearchResultList(sqlSession, sc, spi);
	}

	@Override
	public int updatenNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException{
		
		int result = bd.updatenNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateNormalNotice(sqlSession, b);
			
			bd.updatenNoticeFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updatenNotice(Board b) throws BoardUpdateException {
		int result = bd.updatenNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateNormalNotice(sqlSession, b);
		}
		return result;
	}

	@Override
	public int sNoticeListCount() throws BoardSelectListException{
		return bd.sNoticeListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectsNoticeList(PageInfo pi) {
		
		return bd.selectsNoticeList(sqlSession, pi);
	}

	@Override
	public Board selectsNoticeOne(int boardNo) throws BoardSelectOneException {
		
		bd.updateCount(sqlSession, boardNo);
		
		return bd.selectsNoticeOne(sqlSession, boardNo);
	}

	@Override
	public int insertsNoticewithFile(Board b, UploadFile uf) throws BoardInsertException{				
		 
		int result = bd.insertsNotice(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertscholNotice(sqlSession, b);			
			
			bd.insertNoticeFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int insertsNotice(Board b) throws BoardInsertException{
		int result = bd.insertsNotice(sqlSession, b);
		
		if(result > 0) {
			bd.insertscholNotice(sqlSession, b);
		}
		
		return result;
	}

	@Override
	public int updatesNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException {
		int result = bd.updatesNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateScholNotice(sqlSession, b);
			
			bd.updatesNoticeFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updatesNotice(Board b) throws BoardUpdateException {
		int result = bd.updatesNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateScholNotice(sqlSession, b);
		}
		return result;
	}

	@Override
	public int SearchsNoticeResultCount(SearchCondition sc) throws BoardSearchException {
		return bd.SearchsNoticeResultCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> SearchsNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return bd.SearchsNoticeResultList(sqlSession, sc, pi);
	}

	@Override
	public int selectacNoticeCount() {
		return bd.selectacNoticeCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectacNoticeList(PageInfo pi) throws BoardSelectListException {
		return  bd.selectacNoticeList(sqlSession, pi);
	}

	@Override
	public int SearchacNoticeResultCount(SearchCondition sc) throws BoardSearchException {
		return bd.SearchacNoticeResultCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> SearchacNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return bd.SearchacNoticeResultList(sqlSession, sc, pi);
	}

	@Override
	public int selectacNoticeMonthCount(String month) {
		return bd.selectacNoticeMonthCount(sqlSession, month);
	}

	@Override
	public ArrayList<Board> selectacNoticeMonthList(PageInfo pi, String month) {
		return bd.selectacNoticeMonthList(sqlSession, month, pi);
	}

	@Override
	public Board selectacNoticeOne(int boardNo) throws BoardSelectOneException {
		
			bd.updateCount(sqlSession, boardNo);
		
		return bd.selectacNoticeOne(sqlSession, boardNo);
	}

	@Override
	public int updateacNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException {
		int result = bd.updateacNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateSchoolSchedule(sqlSession, b);
			
			bd.updateacNoticeFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updateacNotice(Board b) throws BoardUpdateException {
		int result = bd.updateacNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateSchoolSchedule(sqlSession, b);
		}
		return result;
	}

	@Override
	public int insertacNoticewithFile(Board b, UploadFile uf) throws BoardInsertException {
		int result = bd.insertacNotice(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertSchoolSchedule(sqlSession, b);			
			
			bd.insertNoticeFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int insertacNotice(Board b) {
		int result = bd.insertacNotice(sqlSession, b);
		
		if(result > 0) {
			bd.insertSchoolSchedule(sqlSession, b);
		}
		
		return result;
	}

	@Override
	public int selecteNoticeCount() throws BoardSelectListException {
		return bd.eNoticeListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selecteNoticeList(PageInfo pi) throws BoardSelectListException {
		return bd.selecteNoticeList(sqlSession, pi);
	}

	@Override
	public int SearcheNoticeResultCount(SearchCondition sc) throws BoardSearchException {
		return bd.SearcheNoticeResultCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> SearcheNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return bd.SearcheNoticeResultList(sqlSession, sc, pi);
	}

	@Override
	public Board selecteNoticeOne(int boardNo) throws BoardSelectOneException {
			bd.updateCount(sqlSession, boardNo);
		
		return bd.selecteNoticeOne(sqlSession, boardNo);
	}

	@Override
	public int inserteNoticewithFile(Board b, UploadFile uf) throws BoardInsertException {
		int result = bd.inserteNotice(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertEvent(sqlSession, b);			
			
			bd.insertNoticeFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int inserteNotice(Board b) throws BoardInsertException {
		int result = bd.inserteNotice(sqlSession, b);
		
		if(result > 0) {
			bd.insertEvent(sqlSession, b);
		}
		
		return result;
	}

	@Override
	public int updateeNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException {
		int result = bd.updateeNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateEvent(sqlSession, b);
			
			bd.updateeNoticeFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updateeNotice(Board b) throws BoardUpdateException {
		int result = bd.updateeNotice(sqlSession, b);
		
		if(result > 0) {
			bd.updateEvent(sqlSession, b);
		}
		return result;
	}

	@Override
	public int selectfreeBoardCount() throws BoardSelectListException {
		return bd.freeBoardListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectfreeBoardList(PageInfo pi) throws BoardSelectListException {
		return bd.selectfreeBoardList(sqlSession, pi);
	}

	@Override
	public int SearchefreeBoardResultCount(SearchCondition sc) throws BoardSearchException {
		return bd.SearchefreeBoardResultCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> SearchfreeBoardResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return bd.SearchfreeBoardResultList(sqlSession, sc, pi);
	}

	@Override
	public Board selectfreeBoardOne(int boardNo) throws BoardSelectOneException {
		bd.updateCount(sqlSession, boardNo);
		
		return bd.selectfreeBoardOne(sqlSession, boardNo);
	}

	@Override
	public int insertfreeBoardwithFile(Board b, UploadFile uf) throws BoardInsertException {
		int result = bd.insertfreeBoard(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertFreeBoardFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int insertfreeBoard(Board b) throws BoardInsertException {
		return bd.insertfreeBoard(sqlSession, b);
	}

	@Override
	public Writer selectFreeBoardstWriter(String memberId) {
		return bd.selectFreeBoardstWriter(sqlSession, memberId);
	}

	@Override
	public int updatefreeBoardwithFile(Board b, UploadFile uf) throws BoardUpdateException {
		int result = bd.updatefreeBoard(sqlSession, b);
		
		if(result > 0) {
			
			bd.updatefreeBoardFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updatefreeBoard(Board b) throws BoardUpdateException {
		return bd.updatefreeBoard(sqlSession, b);
	}

	@Override
	public int deletefreeBoard(String boardNo) throws BoardDeleteException {
		return bd.deletefreeBoard(sqlSession, boardNo);
	}

	@Override
	public Writer selectFreeBoardproWriter(String memberId) {
		return bd.selectFreeBoardproWriter(sqlSession, memberId);
	}

	@Override
	public Writer selectFreeBoardemWriter(String memberId) {
		return bd.selectFreeBoardemWriter(sqlSession, memberId);
	}

	@Override
	public int selectpraiseBoardCount() throws BoardSelectListException {
		return bd.praiseBoardListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectpraiseBoardList(PageInfo pi) throws BoardSelectListException {
		return bd.selectpraiseBoardList(sqlSession, pi);
	}

	@Override
	public int SearchepraiseBoardResultCount(SearchCondition sc) throws BoardSearchException {
		return bd.SearchepraiseBoardResultCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> SearchpraiseBoardResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return bd.SearchpraiseBoardResultList(sqlSession, sc, pi);
	}

	@Override
	public Board selectpraiseBoardOne(int boardNo) throws BoardSelectOneException {
		bd.updateCount(sqlSession, boardNo);
		
		return bd.selectpraiseBoardOne(sqlSession, boardNo);
	}

	@Override
	public Writer selectpraiseBoardstWriter(String memberId) {
		return bd.selectpraiseBoardstWriter(sqlSession, memberId);
	}

	@Override
	public int insertpraiseBoardwithFile(Board b, UploadFile uf) throws BoardInsertException {
		int result = bd.insertpraiseBoard(sqlSession, b);
		
		if(result > 0) {			
			
			bd.insertpraiseBoardFile(sqlSession, uf);
		}
		 
		return result;
	}

	@Override
	public int insertpraiseBoard(Board b) throws BoardInsertException {
		return bd.insertpraiseBoard(sqlSession, b);
	}

	@Override
	public int updatepraiseBoardwithFile(Board b, UploadFile uf) throws BoardUpdateException {
		int result = bd.updatepraiseBoard(sqlSession, b);
		
		if(result > 0) {
			
			bd.updatepraiseBoardFile(sqlSession, uf);
		}
		return result;
	}

	@Override
	public int updatepraiseBoard(Board b) throws BoardUpdateException {
		return bd.updatepraiseBoard(sqlSession, b);
	}

	@Override
	public int deletepraiseBoard(String boardNo) throws BoardDeleteException {
		return bd.deletepraiseBoard(sqlSession, boardNo);
	}

	@Override
	public int searchMyBoardListCount(String memberId) throws BoardSelectListException {
		return bd.searchMyBoardListCount(sqlSession, memberId);
	}

	@Override
	public ArrayList<Board> searchMyBoardList(PageInfo pi, String memberId) throws BoardSelectListException {
		return bd.searchMyBoardList(sqlSession, pi, memberId);
	}

	@Override
	public int searchMyBoardSearchListCount(SearchCondition sc) throws BoardSearchException {
		return bd.searchMyBoardSearchListCount(sqlSession, sc);
	}

	@Override
	public ArrayList<Board> searchMyBoardSearchList(SearchCondition sc, PageInfo pi) throws BoardSearchException {
		return  bd.searchMyBoardSearchList(sqlSession, sc, pi);
	}

	@Override
	public int searchMyBoardDelete(String boardNo) throws BoardDeleteException {
		return bd.searchMyBoardDelete(sqlSession, boardNo);
	}


	

	
}
