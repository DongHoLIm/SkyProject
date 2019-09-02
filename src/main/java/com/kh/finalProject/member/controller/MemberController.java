package com.kh.finalProject.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String loginMember(Member m,Model model) {
		
		Member loginUser=null;
		try {
			loginUser = ms.loginCheck(m);
			model.addAttribute("loginUser",loginUser);
			System.out.println(loginUser);
			return "main/main";
			
		} catch (loginException e) {
			
			model.addAttribute("msg",e.getMessage());
			return "common/errorAlert";
		}
		
		
			
		
			
		
		
	}
	
	//비밀번호 (암호화 처리 메소드)
	
	//과목조회, 수강신청 이동
	@RequestMapping(value="goSugang.st")
	public String goSugang(Member m, Model model, HttpSession session) {
		
		return "student/class/Notice";
	}
	//수강공지사항
	@RequestMapping(value="goNotice.st")
	public String goNotice(Member m, Model model, HttpSession session) {
		
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
}
