package com.kh.finalProject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
}
