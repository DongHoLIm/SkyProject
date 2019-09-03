package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

public interface BoardDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectnNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(SqlSessionTemplate sqlSession, String memberId);

	int updateCount(SqlSessionTemplate sqlSession, int boardNo);

	Board selectOneBoard(SqlSessionTemplate sqlSession, int boardNo);

	int insertnNotice(SqlSessionTemplate sqlSession, Board b);

	int insertnNoticeFile(SqlSessionTemplate sqlSession, UploadFile uf);

	int insertNormalNotice(SqlSessionTemplate sqlSession, Board b);

	UploadFile selectUploadFile(SqlSessionTemplate sqlSession, int boardNo);


	
}
