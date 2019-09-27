package com.kh.finalProject.lectureEvaluation.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.service.LectureEvaluationService;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;
import com.kh.finalProject.member.model.vo.Member;



@Controller
@SessionAttributes("loginUser")
public class LectureEvaluationController {
	
	@Autowired
	private LectureEvaluationService ls;
	
	@RequestMapping(value="em_showLectureEvaluationOpen.le")
	public String em_showLectureEvaluationOpen(HttpServletRequest request) {		
		
		return "employee/class/em_LectureEvaluation";
	}
	
	@RequestMapping(value="em_LectureEvaluationOpenList.le")
	public ModelAndView em_LectureEvaluationOpenList(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}	
		
		int listCount = ls.em_LectureEvalOpenListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<LectureEvaluation> list = ls.em_LectureEvalOpenList(pi);
		
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("pi :::: " + pi);
		System.out.println("list :::: " + list);
		
		mv.addObject("list", list);
		mv.addObject("pi", pi);
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	
	@RequestMapping(value="em_LectureEvaluationOpen.le")
	public ModelAndView em_LectureEvaluationOpen(ModelAndView mv, LectureEvaluation lev) {		
		
		System.out.println("lev :::: " + lev);
		
		ls.em_LectureEvaluationOpen(lev);
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping(value="em_LectureEvaluationOpenList2.le")
	public ModelAndView em_LectureEvaluationOpenList2(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}	
		
		int listCount = ls.em_LectureEvalOpenListCount2();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<LectureEvaluation> list = ls.em_LectureEvalOpenList2(pi);
		
		System.out.println("currentPage2 :::: " + currentPage);
		System.out.println("pi2 :::: " + pi);
		System.out.println("list2 :::: " + list);
		
		mv.addObject("list", list);
		mv.addObject("pi", pi);
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping(value="em_LectureEvaluationClose.le")
	public ModelAndView em_LectureEvaluationClose(ModelAndView mv, LectureEvaluation lev) {			
		
		ls.em_LectureEvaluationClose(lev);
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	
	// 학생 강의평가 입력
	@RequestMapping(value="st_showLectureEvaluation.le")
	public String st_showLectureEvaluation(HttpServletRequest request) {		
		
		return "student/class/st_LectureEvaluation";
	}
	
	@RequestMapping(value="st_LectureEvaluationList.le")
	public ModelAndView st_LectureEvaluationList(ModelAndView mv, HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String studentNo = loginUser.getMemberId();
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}	
		
		int listCount = ls.st_LectureEvaluationListCount(studentNo);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<LectureEvaluation> list = ls.st_LectureEvaluationList(pi, studentNo);
		
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("pi :::: " + pi);
		System.out.println("list :::: " + list);
		
		mv.addObject("list", list);
		mv.addObject("pi", pi);
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping(value="st_showLectureEvaluationInsert.le")
	public String st_showLectureEvaluationInsert(LectureEvaluation lev, HttpServletRequest request) {
		
		request.setAttribute("lev", lev);
		
		return "student/class/st_LectureEvaluationInsert";
	}
	
	@RequestMapping(value="st_LectureEvaluationInsert.le")
	public String st_LectureEvaluationInsert(LectureEvaluation lev, String[] answer, HttpServletRequest request) {
		
		lev.setAnswer1(answer[0]);
		lev.setAnswer2(answer[1]);
		lev.setAnswer3(answer[2]);
		lev.setAnswer4(answer[3]);
		lev.setAnswer5(answer[4]);
		
		System.out.println("lev :::: " + lev);
		
		return "";
	}
	
}
