package com.kh.finalProject.professor.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.service.LessonPlanService;
import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.service.MessageService;
import com.kh.finalProject.professor.message.model.vo.MessageVO;

@Controller
public class messageController {
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("inbox.pro")
	
	public ModelAndView Inbox (ModelAndView mav, HttpSession session, HttpServletRequest request) {
		//현재 로그인하고 있는 멤버 객체 담아와 아이디를 뽑아옴
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
	    int currentPage = 1;

	      if(request.getParameter("currentPage") != null) {
	         currentPage = Integer.parseInt(request.getParameter("currentPage"));
	      }

	      int listCount;

	      try {
	         listCount = messageService.getListCount(memberId);
	         PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
	         //현재 로그인 하고 있는 유저가 받은 메세지 리스트만 받아오기
	         List<MessageVO> messageList = messageService.selectmessageList(memberId, pi);
	         mav.addObject("messageList", messageList);
	         mav.setViewName("professor/class/inbox");

	         return mav;

	      }catch (ClassManagementSelectListException e) {
	          mav.addObject("msg", e.getMessage());
	          mav.setViewName("common/errorAlert");
	          return mav;
	       }
	      
		
		
	}
	
	@RequestMapping("outbox.pro")
	public ModelAndView outbox (ModelAndView mav, HttpSession session) {
		//현재 로그인하고 있는 멤버 객체 담아와 아이디를 뽑아옴
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		//현재 로그인 하고 있는 유저가 보낸 메세지 리스트만 받아오기
		List<MessageVO> sendMessageList = messageService.selectsendMessageList(memberId);
		mav.addObject("sendMessageList", sendMessageList);
		mav.setViewName("professor/class/outbox");
		
		return mav;
		
	}
	
	@RequestMapping("message.pro")
	public ModelAndView openSendMessage (ModelAndView mav) {
		
		List<Member> memberList = messageService.selectMemberList();
		mav.addObject("memberList", memberList);
		mav.setViewName("professor/class/message");
		return mav;
		
	}
	
	
	
	
	@RequestMapping("sendMessage")
	   public ModelAndView sendMessage(HttpSession session, String tmp, String title ,String comment, ModelAndView mv) throws JsonProcessingException {
		
			Member member = (Member) session.getAttribute("loginUser");
			String memberId = member.getMemberId();
			String[] list = tmp.split(",");
			MessageVO messageVO = new MessageVO();
	     
	      for (int i = 0; i < list.length; i++) {
	         System.out.println(list[i]);
	         
	          messageVO.setMessageTitle(title);
		      messageVO.setMessageContent(comment);
		      messageVO.setReceMember(list[i]);
		      messageVO.setMemberId(memberId);
		      System.out.println(messageVO);
	         messageService.sendMessage(messageVO);
	      }
	      
	      mv.setViewName("jsonView");

	      return mv;

	   }
	
}