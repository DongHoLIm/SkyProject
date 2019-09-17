package com.kh.finalProject.professor.message.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.vo.MessageVO;

public interface MessageDao {

	public List<MessageVO> selectmessageList(SqlSessionTemplate sqlSession, String memberId);

	public List<MessageVO> selectsendMessageList(SqlSessionTemplate sqlSession, String memberId);

	public List<Member> selectMemberList(SqlSessionTemplate sqlSession);

}
