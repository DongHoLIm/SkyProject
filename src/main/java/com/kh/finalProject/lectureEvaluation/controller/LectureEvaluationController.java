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
	
	@RequestMapping(value="st_showLectureEvaluationOpen.le")
	public String st_showLectureEvaluationOpen() {
		
		return "student/class/st_LectureEvaluation";
	}	
	
	@RequestMapping(value="st_showLectureEvaluationOpenList.le")
	public ModelAndView st_showLectureEvaluationOpen(ModelAndView mv, HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String studentNo = loginUser.getMemberId();
		
		System.out.println("studentNo :::: " + studentNo);
		
		
		try {			
			
			ArrayList<LectureEvaluation> list = ls.stSelectLectureEvalOpenList(studentNo);			
			
			mv.addObject("list", list);
			mv.setViewName("jsonView");	
			
			return mv;
			
		} catch (LectureEvaluationSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return mv;
		}		
	}
	
	@RequestMapping(value="st_showLectureEvaluationInsert.le")
	public String st_showLectureEvaluationInsert(LectureEvaluation le, @ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {
		
		ArrayList<LectureEvaluation> list = ls.questionList();
		
		request.setAttribute("list", list);
		
		return "student/class/st_LectureEvaluationInsert";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="em_showLectureEvaluationOpen.le")
	public String em_showLectureEvaluationOpen() {
		
		return "employee/class/em_LectureEvaluation";
	}
	
	@RequestMapping(value="em_selectLectureEvalOpenList.le")
	public ModelAndView em_selectLectureEvalOpenList(ModelAndView mv, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = ls.getListCount();
			
			System.out.println("교직원 강의평가 오픈 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<LectureEvaluation> list = ls.selectLectureEvalOpenList(pi);
			
			System.out.println("교직원 강의평가 오픈 pi :::: " + pi);
			System.out.println("교직원 강의평가 오픈 list :::: " + list);
			
			mv.addObject("pi", pi);
			mv.addObject("list", list);
			mv.setViewName("jsonView");	
			
			return mv;
			
		} catch (LectureEvaluationSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return mv;
		}		
	}
}
