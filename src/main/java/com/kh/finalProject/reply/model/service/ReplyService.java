package com.kh.finalProject.reply.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.reply.model.exception.ReplyDeleteException;
import com.kh.finalProject.reply.model.exception.ReplyInsertException;
import com.kh.finalProject.reply.model.exception.ReplySelectException;
import com.kh.finalProject.reply.model.exception.ReplyUpdateException;
import com.kh.finalProject.reply.model.vo.Reply;

public interface ReplyService {

	int insertFreeBoardRP(Reply rp) throws ReplyInsertException;

	int freeBoardRPListCount(int boardNo) throws ReplySelectException;

	ArrayList<Reply> selectfreeBoardRPList(PageInfo pi, int boardNo) throws ReplySelectException;

	int deleteFreeBoardRP(Reply rp) throws ReplyDeleteException;

	int updateFreeBoardRP(Reply rp) throws ReplyUpdateException;
	
}
