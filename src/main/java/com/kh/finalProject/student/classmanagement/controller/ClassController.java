package com.kh.finalProject.student.classmanagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.student.classmanagement.model.service.ClassService;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;
@Controller
@SessionAttributes("loginUser")
public class ClassController {
	@Autowired
	private ClassService cs;
	
	//과목조회, 수강신청 이동
		@RequestMapping(value="goSugang.st")
		public String goSugang(Member m, Model model, HttpSession session) {
			
			return "student/class/Notice";
		}
		//수강공지사항
		@RequestMapping(value="goNotice.st")
		public String goNotice(@ModelAttribute("loginUser") Member loginUser) {
			System.out.println(loginUser);
			return "student/class/Notice";
		}
		//교과목조회
		@RequestMapping(value="goCourseInquiry.st")
		public String goCourseInquiry(@ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {
			ArrayList<Sdepartment> sdList = cs.selectSdept();
			
			request.setAttribute("sdList", sdList);
			
			return "student/class/courseInquiry";
		}
		//예비수강신청목록
		@RequestMapping(value="goPreliminaryCourse.st")
		public String goPreliminaryCourse(@ModelAttribute("loginUser") Member loginUser) {
			
			return "student/class/preliminaryCourseApplyList";
		}
		//수강신청
		@RequestMapping(value="goCourseApply.st")
		public String goCourseApply(@ModelAttribute("loginUser") Member loginUser) {
			
			return "student/class/courseApply";
		}
	
	
	
	
}
