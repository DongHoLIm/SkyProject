package com.kh.finalProject.board.model.service;

import java.util.ArrayList;

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

public interface BoardService {

	int getListCount() throws BoardSelectListException;

	ArrayList<Board> selectnNoticeList(PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(String memberId);

	Board selectOneBoard(int boardNo) throws BoardSelectOneException;

	int insertnNoticewithFile(Board b, UploadFile uf) throws BoardInsertException;

	int insertnNotice(Board b) throws BoardInsertException;

	UploadFile selectUploadFile(int boardNo) throws BoardSelectOneException;

	int deleteNotice(String boardNo) throws BoardDeleteException;

	int getSearchResultListCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	int updatenNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updatenNotice(Board b) throws BoardUpdateException;

	int sNoticeListCount() throws BoardSelectListException;

	ArrayList<Board> selectsNoticeList(PageInfo pi) throws BoardSelectListException;

	Board selectsNoticeOne(int boardNo) throws BoardSelectOneException;

	int insertsNoticewithFile(Board b, UploadFile uf) throws BoardInsertException;

	int insertsNotice(Board b) throws BoardInsertException;

	int updatesNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updatesNotice(Board b) throws BoardUpdateException;

	int SearchsNoticeResultCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> SearchsNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	int selectacNoticeCount() throws BoardSelectListException;

	ArrayList<Board> selectacNoticeList(PageInfo pi) throws BoardSelectListException;

	int SearchacNoticeResultCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> SearchacNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	int selectacNoticeMonthCount(String month) throws BoardSearchException;

	ArrayList<Board> selectacNoticeMonthList(PageInfo pi, String month) throws BoardSearchException;

	Board selectacNoticeOne(int boardNo) throws BoardSelectOneException;

	int updateacNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updateacNotice(Board b) throws BoardUpdateException;

	int insertacNoticewithFile(Board b, UploadFile uf) throws BoardInsertException;

	int insertacNotice(Board b);

	int selecteNoticeCount() throws BoardSelectListException;

	ArrayList<Board> selecteNoticeList(PageInfo pi) throws BoardSelectListException;

	int SearcheNoticeResultCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> SearcheNoticeResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	Board selecteNoticeOne(int boardNo) throws BoardSelectOneException;

	int inserteNoticewithFile(Board b, UploadFile uf) throws BoardInsertException;

	int inserteNotice(Board b) throws BoardInsertException;

	int updateeNoticewithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updateeNotice(Board b) throws BoardUpdateException;

	int selectfreeBoardCount() throws BoardSelectListException;

	ArrayList<Board> selectfreeBoardList(PageInfo pi) throws BoardSelectListException;

	int SearchefreeBoardResultCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> SearchfreeBoardResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	Board selectfreeBoardOne(int boardNo) throws BoardSelectOneException;

	int insertfreeBoardwithFile(Board b, UploadFile uf) throws BoardInsertException;

	int insertfreeBoard(Board b) throws BoardInsertException;

	Writer selectFreeBoardstWriter(String memberId);

	int updatefreeBoardwithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updatefreeBoard(Board b) throws BoardUpdateException;

	int deletefreeBoard(String boardNo) throws BoardDeleteException;

	Writer selectFreeBoardproWriter(String memberId);

	Writer selectFreeBoardemWriter(String memberId);

	int selectpraiseBoardCount() throws BoardSelectListException;

	ArrayList<Board> selectpraiseBoardList(PageInfo pi) throws BoardSelectListException;

	int SearchepraiseBoardResultCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> SearchpraiseBoardResultList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	Board selectpraiseBoardOne(int boardNo) throws BoardSelectOneException;

	Writer selectpraiseBoardstWriter(String memberId);

	int insertpraiseBoardwithFile(Board b, UploadFile uf) throws BoardInsertException;

	int insertpraiseBoard(Board b) throws BoardInsertException;

	int updatepraiseBoardwithFile(Board b, UploadFile uf) throws BoardUpdateException;

	int updatepraiseBoard(Board b) throws BoardUpdateException;

	int deletepraiseBoard(String boardNo) throws BoardDeleteException;

	int searchMyBoardListCount(String memberId) throws BoardSelectListException;

	ArrayList<Board> searchMyBoardList(PageInfo pi, String memberId) throws BoardSelectListException;

	int searchMyBoardSearchListCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> searchMyBoardSearchList(SearchCondition sc, PageInfo pi) throws BoardSearchException;

	int searchMyBoardDelete(String boardNo) throws BoardDeleteException;

	int systemQuestionListCount(String memberId) throws BoardSelectListException;

	ArrayList<Board> systemQuestionList(PageInfo pi, String memberId) throws BoardSelectListException;

	int systemQuestionSearchListCount(SearchCondition sc) throws BoardSearchException;

	ArrayList<Board> systemQuestionSearchList(SearchCondition sc, PageInfo pi) throws BoardSearchException;




	
}
