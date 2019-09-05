package com.kh.finalProject.student.classmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.student.classmanagement.model.service.ClassService;
import com.kh.finalProject.student.classmanagement.model.vo.Inquiry;
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
		public String goCourseInquiry(@ModelAttribute("loginUser") Member loginUser) {
			
			System.out.println(loginUser);
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
	
	//학생 개강과목조회
		@RequestMapping(value="inquiry.st")
		public String courseInquiry(SessionStatus status,@ModelAttribute("loginUser") Member loginUser, 
				@RequestParam(name="department", required=false) String department,
				@RequestParam(name="allIsu", required=false) String isu,
				@RequestParam(name="subject", required=false) String subject) {
			
			System.out.println("department:::" + department);
			System.out.println("Isu :::" + isu);
			System.out.println("subject:::" + subject);
			
			
			Inquiry i = new Inquiry();
			
			i.setDepartment(department);
			i.setIsu(isu);
			i.setSubject(subject);
			
			cs.courseInquiry(i);
			
			
			
			return "student/class/courseInquiry";
		}
	
	
	
}
