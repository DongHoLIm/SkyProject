package com.kh.finalProject.professor.message.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.dao.MessageDao;
import com.kh.finalProject.professor.message.model.vo.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MessageVO> selectmessageList(String memberId) {
		return messageDao.selectmessageList(sqlSession, memberId);
	}

	@Override
	public List<MessageVO> selectsendMessageList(String memberId) {
	
		return messageDao.selectsendMessageList(sqlSession, memberId);
	}

	@Override
	public List<Member> selectMemberList() {
		return messageDao.selectMemberList(sqlSession);
	}

}
