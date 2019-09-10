package com.kh.finalProject.reply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.reply.model.vo.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Override
	public int insertFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp) {
		return sqlSession.insert("Reply.insertFreeBoardRP", rp);
	}

}
