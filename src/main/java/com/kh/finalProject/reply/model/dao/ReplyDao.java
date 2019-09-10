package com.kh.finalProject.reply.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.reply.model.vo.Reply;

public interface ReplyDao {

	int insertFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp);

	int selectFreeBoardRPListCount(SqlSessionTemplate sqlSession, int boardNo);

	ArrayList<Reply> selectFreeBoardRPListCount(SqlSessionTemplate sqlSession, PageInfo pi, int boardNo);

	int deleteFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp);

	int updateFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp);

}
