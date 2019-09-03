package com.kh.finalProject.member.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	@Autowired
	private MemberService ms;
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	//비밀번호 (암호화 비처리 메소드 )
	@RequestMapping("login.me")
	public String loginMember(Member m,HttpSession session,Model model) {
		
		Member loginUser=null;
		
		try {			
			loginUser = ms.loginCheck(m);
			session.setAttribute("loginUser",loginUser);			
			return "redirect:loginOk.me";									
		} catch (loginException e) {			
			model.addAttribute("msg",e.getMessage());
			return "common/errorAlert";
		} 
	}
	@RequestMapping("loginOk.me")
	public String loginOk(Member loginUser) {
		
		return "main/main";
	}
	//비밀번호 (암호화 처리 메소드)
	

	//과목조회, 수강신청 이동
	@RequestMapping(value="goSugang.st")
	public String goSugang(Member m, Model model, HttpSession session) {
		
		return "student/class/Notice";
	}
	//수강공지사항
	@RequestMapping(value="goNotice.st")
	public String goNotice(Model model, HttpSession session) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println(loginUser);
		return "student/class/Notice";
	}
	//교과목조회
	@RequestMapping(value="goCourseInquiry.st")
	public String goCourseInquiry(Member m, Model model, HttpSession session) {
		
		return "student/class/courseInquiry";
	}
	//예비수강신청목록
	@RequestMapping(value="goPreliminaryCourse.st")
	public String goPreliminaryCourse(Member m, Model model, HttpSession session) {
		
		return "student/class/preliminaryCourseApplyList";
	}
	//수강신청
	@RequestMapping(value="goCourseApply.st")
	public String goCourseApply(Member m, Model model, HttpSession session) {
		
		return "student/class/courseApply";
	}

	
	//로그 아웃  
	@RequestMapping("logOut.me" )
	public String logOut(HttpSession session) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		if(loginUser!=null) {
			ms.logOutLoginCheck(loginUser);
		}		
		session.invalidate();		
		return "main/Login";
	}
	
	//교직원 계정 발급 Page 이동 
	@RequestMapping("insert.me")
	public String insertMember() {
		
	  return "Faculty/systemAccountManagement/createSystemAccount";

	}
}
