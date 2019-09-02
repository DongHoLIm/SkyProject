package com.kh.finalProject.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.Writer;

public interface BoardDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectnNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(SqlSessionTemplate sqlSession, String memberId);
	
}
