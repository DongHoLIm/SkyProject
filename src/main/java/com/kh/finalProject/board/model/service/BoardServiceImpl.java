package com.kh.finalProject.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.dao.BoardDao;
import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDao bd;

	@Override
	public int getListCount() {
		
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
	public Board selectOneBoard(int boardNo) {
		
		bd.updateCount(sqlSession, boardNo);
		
		return bd.selectOneBoard(sqlSession, boardNo);
	}

	
}
