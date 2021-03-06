package com.kh.finalProject.professor.openSubject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.employee.classManagement.model.service.LessonPlanService;
import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.openSubject.model.service.OpenSubjectService;
import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

@Controller
public class OpenSubjectController {
	@Autowired
	LessonPlanService lps;
	@Autowired
	OpenSubjectService openSubjectService;
	
	
	
	
	@RequestMapping("opensubject.pro")
	public ModelAndView OpenSubject (ModelAndView mav) {
		List<OpenSubject> openSubjectList = openSubjectService.selectOpenSubjectList();
		System.out.println("openSubjectList : " + openSubjectList);
		mav.addObject("openSubjectList", openSubjectList);
		mav.setViewName("professor/class/syllabus");
		return mav;
	
	}
	/*public String OpenSubject(@ModelAttribute("loginUser") Member professorInfo,HttpServletRequest request) {
		String memberId= professorInfo.getMemberId();
		
		List<OpenSubject> openSubjectList = openSubjectService.selectOpenSubjectList();
		
		request.setAttribute("openSubjectList",openSubjectList);
		
		return "professor/class/syllabus";
	}*/
	
	
	@RequestMapping(value="opensubjectWrite.pro")
	public ModelAndView OpenSubjectWrite(@RequestParam(name="subCode", required=false)String subCode, ModelAndView mv,HttpSession session ) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		OpenSubject os = new OpenSubject();

		System.out.println("시작합니다");
		System.out.println("subCode :::::" + subCode);
		os = openSubjectService.selectOneSubject(subCode);
		//System.out.println(os);
		//System.out.println("@@@ : " + loginUser);
		
		mv.addObject("loginUser", loginUser);
		mv.addObject("os", os);
		mv.setViewName("professor/class/syllabusWrite");
		
		return mv;

			
		}
	
	@RequestMapping("lessonPlan.pro")
	public ModelAndView LessonPlan (LessonPlan lp, ModelAndView mav) {
		lps.insertLessonPlan(lp);
		List<OpenSubject> openSubjectList = openSubjectService.selectOpenSubjectList();
		System.out.println("openSubjectList : " + openSubjectList);
		mav.addObject("openSubjectList", openSubjectList);
		mav.setViewName("professor/class/syllabus");
		return mav;
	
	}
	

}

