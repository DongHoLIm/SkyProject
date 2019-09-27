package com.kh.finalProject.professor.stuInfo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.stuInfo.model.service.stuInfoService;
import com.kh.finalProject.professor.stuInfo.model.vo.stuInfoVo;

@Controller
public class stuInfoController {
	@Autowired 
	private stuInfoService si;
	
	@RequestMapping("stuInfo.pro")
	public String stuInfoList(HttpSession session ,HttpServletRequest request ) {
		Member professorInfo = (Member) session.getAttribute("loginUser");
		String professorId = professorInfo.getMemberId();
		int currentPage=1;
		int listCount ;
		
		try {
			listCount = si.stuInfoListCount(professorId);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList <stuInfoVo> list  = si.stuInfoList(professorId,pi);
			
			request.setAttribute("list",list);
			request.setAttribute("pi", pi);
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return "professor/stuInfo/studentList";
	}
	
	@RequestMapping("ajaxStuPaging.pro")
	public ModelAndView ajaxStuPaging(ModelAndView mv,HttpSession session,HttpServletRequest request) {
		Member professorInfo = (Member) session.getAttribute("loginUser");
		String professorId = professorInfo.getMemberId();
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ;
		
		try {
			listCount = si.stuInfoListCount(professorId);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList <stuInfoVo> list  = si.stuInfoList(professorId,pi);
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("jsonView");
		return mv;
	}
	@RequestMapping("searchStuList.pro")
	public ModelAndView ajaxSearchStuList(ModelAndView mv,HttpServletRequest request,HttpSession session) {
		String value = request.getParameter("value");
		String standard  = request.getParameter("standard");
		Member professorInfo = (Member) session.getAttribute("loginUser");
		String professorId = professorInfo.getMemberId();
		stuInfoVo sv = new stuInfoVo();
		sv.setMemberId(value);
		sv.setMemberKName(standard);
		sv.setMemberNo(professorId);
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ;
		try {
			listCount=si.ajaxSearchStuList(sv);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList <stuInfoVo> list =si.searchStu(pi,sv);
			
			mv.addObject("list" ,list);
			mv.addObject("pi",pi);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("jsonView");
		return mv;
	}	
}
