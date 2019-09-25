package com.kh.finalProject.professor.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public ModelAndView Inbox (ModelAndView mav, HttpSession session) {
		//현재 로그인하고 있는 멤버 객체 담아와 아이디를 뽑아옴
		Member member = (Member) session.getAttribute("loginUser");
		String memberId = member.getMemberId();
		//현재 로그인 하고 있는 유저가 받은 메세지 리스트만 받아오기
		List<MessageVO> messageList = messageService.selectmessageList(memberId);
		mav.addObject("messageList", messageList);
		mav.setViewName("professor/class/inbox");
		
		return mav;
		
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
	@ResponseBody
	   public String sendMessage(HttpSession session, String tmp, String title ,String content) throws JsonProcessingException {
			System.out.println("들어왔니");
			Member member = (Member) session.getAttribute("loginUser");
			String memberId = member.getMemberId();
	      String[] list = tmp.split(",");

	      for (int i = 0; i < list.length; i++) {
	         System.out.println(list[i]);
	       //  messageService.sendMessage(VO)
	         
	         System.out.println(list[i]);
	         System.out.println(title);
	         System.out.println(content);
	         System.out.println(memberId);
	      }

	      Map<String, Object> result = new HashMap<String, Object>();
	      result.put("result", "success");
	      return new ObjectMapper().writeValueAsString(result);

	   }
}
