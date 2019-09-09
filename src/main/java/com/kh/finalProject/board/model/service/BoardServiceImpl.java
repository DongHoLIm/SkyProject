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


	

	
}
