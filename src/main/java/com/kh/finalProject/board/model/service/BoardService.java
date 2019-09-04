package com.kh.finalProject.board.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;

public interface BoardService {

	int getListCount();

	ArrayList<Board> selectnNoticeList(PageInfo pi) throws BoardSelectListException;

	Writer selectWriterInfo(String memberId);

	Board selectOneBoard(int boardNo);

	int insertnNoticewithFile(Board b, UploadFile uf);

	int insertnNotice(Board b);

	UploadFile selectUploadFile(int boardNo);

	int deletenNotice(String boardNo);

	int getSearchResultListCount(SearchCondition sc);

	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi);

	int updatenNoticewithFile(Board b, UploadFile uf);

	int updatenNotice(Board b);



	
}
