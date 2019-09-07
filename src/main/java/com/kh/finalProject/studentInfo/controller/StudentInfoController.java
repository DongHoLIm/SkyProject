package com.kh.finalProject.studentInfo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.service.StudentInfoService;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;


@Controller
@SessionAttributes("loginUser")
public class StudentInfoController {
	
	@Autowired
	private StudentInfoService ss;
	
	//학적조회 메인
	@RequestMapping(value="studentInfo.st")
	public String infoMain(@ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo stuInfo = ss.stuInfo(userId);
		
		
		return "student/info/schoolRegister";
	}
	
	
	

}
