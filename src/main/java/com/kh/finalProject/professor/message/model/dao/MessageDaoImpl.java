package com.kh.finalProject.professor.message.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.vo.MessageVO;

@Repository
public class MessageDaoImpl implements MessageDao{


	@Override
	public List<MessageVO> selectmessageList(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectList("Message.selectMessageList", memberId);
	}

	@Override
	public List<MessageVO> selectsendMessageList(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectList("Message.selectsendMessageList", memberId);
	}

	@Override
	public List<Member> selectMemberList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("Message.selectMemberList");
	}
	

}
