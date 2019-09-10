package com.kh.finalProject.reply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.reply.model.vo.Reply;

public interface ReplyDao {

	int insertFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp);

}
