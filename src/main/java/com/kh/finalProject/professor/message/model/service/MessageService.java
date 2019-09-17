package com.kh.finalProject.professor.message.model.service;

import java.util.List;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.vo.MessageVO;


public interface MessageService {


	List<MessageVO> selectmessageList(String memberId);

	List<MessageVO> selectsendMessageList(String memberId);

	List<Member> selectMemberList();
	
}
