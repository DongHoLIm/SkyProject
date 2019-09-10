package com.kh.finalProject.reply.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.reply.model.dao.ReplyDao;
import com.kh.finalProject.reply.model.exception.ReplyInsertException;
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
}
