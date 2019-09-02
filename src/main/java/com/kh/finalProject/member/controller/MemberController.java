package com.kh.finalProject.member.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String loginMember(Member m,Model model) {
		
		Member loginUser=null;
		try {			
			loginUser = ms.loginCheck(m);
			model.addAttribute("loginUser",loginUser);
			return "main/main";									
		} catch (loginException e) {			
			model.addAttribute("msg",e.getMessage());
			return "common/errorAlert";
		} 
	}
	
	//비밀번호 (암호화 처리 메소드)
	
	
	//로그 아웃  
	@RequestMapping("logOut.me")
	public String logOut(Model model,SessionStatus status) {
		
		status.setComplete();
		return "main/Login";
	}
	
	//교직원 계정 발급 Page 이동 
	@RequestMapping("insert.me")
	public String insertMember() {
		
		return "Faculty/systemAccountManagement/createSystemAccount";
	}
}
