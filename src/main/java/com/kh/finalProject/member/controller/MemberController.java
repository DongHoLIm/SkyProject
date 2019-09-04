package com.kh.finalProject.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import com.kh.finalProject.common.CommonUtils;

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


	//로그 아웃  
	@RequestMapping("logOut.me" )
	public String logOut(SessionStatus status,@ModelAttribute("loginUser") Member loginUser) {		
		ms.logOutLoginCheck(loginUser);
		status.isComplete();	
		return "main/Login";
	}

	//교직원 계정 발급 Page 이동 
	@RequestMapping("insert.me")

	public String insertMember() {		
	  return "employee/systemAccountManagement/createSystemAccount";
	}
	
	//excel 
	@RequestMapping(value="excel.me")
	public ModelAndView showMemberExcel(ModelAndView mv,String fileName) {
		
		
		
		
		
		
		mv.setViewName("jsonView");
		return mv;
		

	}

}
