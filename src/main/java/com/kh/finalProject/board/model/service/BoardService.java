package com.kh.finalProject.board.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.Writer;

public interface BoardService {

	int getListCount();

	ArrayList<Board> selectnNoticeList(PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(String memberId);
	
}
