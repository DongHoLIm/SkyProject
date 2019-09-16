package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.board.model.vo.SystemQuestion;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

public interface BoardDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectnNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(SqlSessionTemplate sqlSession, String memberId);

	int updateCount(SqlSessionTemplate sqlSession, int boardNo);

	Board selectOneBoard(SqlSessionTemplate sqlSession, int boardNo);

	int insertnNotice(SqlSessionTemplate sqlSession, Board b);

	int insertNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int insertNormalNotice(SqlSessionTemplate sqlSession, Board b);

	UploadFile selectUploadFile(SqlSessionTemplate sqlSession, int boardNo);

	int deleteNotice(SqlSessionTemplate sqlSession, String boardNo);

	int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> selectSearchResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	int updatenNotice(SqlSessionTemplate sqlSession, Board b);

	int updatenNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int updateNormalNotice(SqlSessionTemplate sqlSession, Board b);

	int sNoticeListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectsNoticeList(SqlSessionTemplate sqlSession, PageInfo pi);

	Board selectsNoticeOne(SqlSessionTemplate sqlSession, int boardNo);

	int insertsNotice(SqlSessionTemplate sqlSession, Board b);

	int insertscholNotice(SqlSessionTemplate sqlSession, Board b);

	int updatesNotice(SqlSessionTemplate sqlSession, Board b);

	int updateScholNotice(SqlSessionTemplate sqlSession, Board b);

	int updatesNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int SearchsNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> SearchsNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	int selectacNoticeCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectacNoticeList(SqlSessionTemplate sqlSession, PageInfo pi);

	int SearchacNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> SearchacNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	int selectacNoticeMonthCount(SqlSessionTemplate sqlSession, String month);

	ArrayList<Board> selectacNoticeMonthList(SqlSessionTemplate sqlSession, String month, PageInfo pi);

	Board selectacNoticeOne(SqlSessionTemplate sqlSession, int boardNo);

	int updateacNotice(SqlSessionTemplate sqlSession, Board b);

	int updateSchoolSchedule(SqlSessionTemplate sqlSession, Board b);

	int updateacNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int insertacNotice(SqlSessionTemplate sqlSession, Board b);

	int insertSchoolSchedule(SqlSessionTemplate sqlSession, Board b);

	int eNoticeListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selecteNoticeList(SqlSessionTemplate sqlSession, PageInfo pi);

	int SearcheNoticeResultCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> SearcheNoticeResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	Board selecteNoticeOne(SqlSessionTemplate sqlSession, int boardNo);

	int inserteNotice(SqlSessionTemplate sqlSession, Board b);

	int insertEvent(SqlSessionTemplate sqlSession, Board b);

	int updateeNotice(SqlSessionTemplate sqlSession, Board b);

	int updateEvent(SqlSessionTemplate sqlSession, Board b);

	int updateeNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int freeBoardListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectfreeBoardList(SqlSessionTemplate sqlSession, PageInfo pi);

	int SearchefreeBoardResultCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> SearchfreeBoardResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	Board selectfreeBoardOne(SqlSessionTemplate sqlSession, int boardNo);

	int insertfreeBoard(SqlSessionTemplate sqlSession, Board b);

	int insertFreeBoardFile(SqlSessionTemplate sqlSession, UploadFile uf);

	Writer selectFreeBoardstWriter(SqlSessionTemplate sqlSession, String memberId);

	int updatefreeBoard(SqlSessionTemplate sqlSession, Board b);

	int updatefreeBoardFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int deletefreeBoard(SqlSessionTemplate sqlSession, String boardNo);

	Writer selectFreeBoardproWriter(SqlSessionTemplate sqlSession, String memberId);

	Writer selectFreeBoardemWriter(SqlSessionTemplate sqlSession, String memberId);

	int praiseBoardListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectpraiseBoardList(SqlSessionTemplate sqlSession, PageInfo pi);

	int SearchepraiseBoardResultCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> SearchpraiseBoardResultList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	Board selectpraiseBoardOne(SqlSessionTemplate sqlSession, int boardNo);

	Writer selectpraiseBoardstWriter(SqlSessionTemplate sqlSession, String memberId);

	int insertpraiseBoard(SqlSessionTemplate sqlSession, Board b);

	int insertpraiseBoardFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int updatepraiseBoard(SqlSessionTemplate sqlSession, Board b);

	int updatepraiseBoardFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int deletepraiseBoard(SqlSessionTemplate sqlSession, String boardNo);

	int searchMyBoardListCount(SqlSessionTemplate sqlSession, String memberId);

	ArrayList<Board> searchMyBoardList(SqlSessionTemplate sqlSession, PageInfo pi, String memberId);

	int searchMyBoardSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> searchMyBoardSearchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	int searchMyBoardDelete(SqlSessionTemplate sqlSession, String boardNo);

	int systemQuestionListCount(SqlSessionTemplate sqlSession, String memberId);

	ArrayList<Board> systemQuestionList(SqlSessionTemplate sqlSession, PageInfo pi, String memberId);

	int systemQuestionSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> systemQuestionSearchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi);

	Writer selectSystemQuestionWriter(SqlSessionTemplate sqlSession, String memberId);

	int insertSystemQuestion(SqlSessionTemplate sqlSession, SystemQuestion sq);

	int insertSystemQuestionFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int updateSystemQuestionCount(SqlSessionTemplate sqlSession, int questionNo);

	SystemQuestion selectSystemQuestionOne(SqlSessionTemplate sqlSession, int questionNo);

	UploadFile selectSystemQuestionFile(SqlSessionTemplate sqlSession, int questionNo);

	int updateSystemQuestion(SqlSessionTemplate sqlSession, SystemQuestion sq);

	int updateSystemQuestionFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int SystemQuestionDelete(SqlSessionTemplate sqlSession, int questionNo);

	int emsystemQuestionListCount(SqlSessionTemplate sqlSession);

	ArrayList<SystemQuestion> emsystemQuestionList(SqlSessionTemplate sqlSession, PageInfo pi);

	int emsystemQuestionSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<SystemQuestion> emsystemQuestionSearchList(SqlSessionTemplate sqlSession, SearchCondition sc,	PageInfo pi);

	int insertSystemQuestionAnswer(SqlSessionTemplate sqlSession, SystemQuestion sq);

	int insertSystemQuestionAnswerFile(SqlSessionTemplate sqlSession, UploadFile uf);





	
}
