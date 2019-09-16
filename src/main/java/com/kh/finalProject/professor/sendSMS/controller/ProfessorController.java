package com.kh.finalProject.professor.sendSMS.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.service.professorService;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;


import net.sf.json.JSONObject;

@Controller
public class ProfessorController {
	@Autowired
	professorService ps;
	
	
	@RequestMapping("sendSMS.pro")
	public String sendSMSviewChange () {
		
		return "professor/sendSMS/sendSMS";
	}
	@RequestMapping("addressStudent.pro")	
	public String addressList(@ModelAttribute("loginUser") Member loginUser,HttpServletRequest request,HttpServletResponse response){
			
		ArrayList<StudentList> list = null;
		int currentPage = 1 ;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ; 
		try {
			listCount =  ps.studentList();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			list = ps.studentPageList(pi);			
			
			request.setAttribute("list", list);
			request.setAttribute("pi",pi);

			return "professor/sendSMS/addressList";
		}catch(Exception e) {
			request.setAttribute("msg","MemberList실패");
			return "common/errorAlert";
		}	
	}
	@RequestMapping("ajaxPaging.pro")
	@ResponseBody
	public ModelAndView ajaxPaging(ModelAndView mv,HttpServletRequest request,HttpServletResponse response){
		
		ArrayList<StudentList> list = null;
		int currentPage = 1 ;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ; 
		try {
			listCount =  ps.studentList();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			list = ps.studentPageList(pi);
			
			response.setCharacterEncoding("UTF-8");
			mv.addObject("list", list);
			mv.addObject("pi",pi);
		}catch(Exception e){
			System.out.println("실패");
		}
		
		
		
		mv.setViewName("jsonView");
		
		return mv;
	}
}
