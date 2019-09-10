package com.kh.finalProject.reply.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.reply.model.dao.ReplyDao;
import com.kh.finalProject.reply.model.exception.ReplyDeleteException;
import com.kh.finalProject.reply.model.exception.ReplyInsertException;
import com.kh.finalProject.reply.model.exception.ReplySelectException;
import com.kh.finalProject.reply.model.exception.ReplyUpdateException;
import com.kh.finalProject.reply.model.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ReplyDao rd;

	@Override
	public int insertFreeBoardRP(Reply rp) throws ReplyInsertException {
		return rd.insertFreeBoardRP(sqlSession, rp);
	}

	@Override
	public int freeBoardRPListCount(int boardNo) throws ReplySelectException {
		return rd.selectFreeBoardRPListCount(sqlSession, boardNo);
	}

	@Override
	public ArrayList<Reply> selectfreeBoardRPList(PageInfo pi, int boardNo) throws ReplySelectException {
		return rd.selectFreeBoardRPListCount(sqlSession, pi, boardNo);
	}

	@Override
	public int deleteFreeBoardRP(Reply rp) throws ReplyDeleteException {
		return rd.deleteFreeBoardRP(sqlSession, rp);
	}

	@Override
	public int updateFreeBoardRP(Reply rp) throws ReplyUpdateException {
		return rd.updateFreeBoardRP(sqlSession, rp);
	}
}
