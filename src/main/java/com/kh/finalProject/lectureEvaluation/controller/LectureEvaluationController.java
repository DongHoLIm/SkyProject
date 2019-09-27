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
	
}
