package com.kh.finalProject.professor.message.model.service;

import java.util.List;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.vo.MessageVO;


public interface MessageService {


	List<MessageVO> selectmessageList(String memberId, PageInfo pi) throws ClassManagementSelectListException;

	List<MessageVO> selectsendMessageList(String memberId);

	List<Member> selectMemberList();

	int getListCount(String memberId);

	void sendMessage(MessageVO messageVO);

	
}