package com.kh.finalProject.studentInfo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.service.StudentInfoService;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;


@Controller
@SessionAttributes("loginUser")
public class StudentInfoController {
	
	@Autowired
	private StudentInfoService ss;
	
	//학생_학적조회 메인
	@RequestMapping(value="st_studentInfo.si")
	public String infoMain(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo stuInfo = ss.stuInfo(userId);
		
		System.out.println(basicInfo);
		System.out.println(stuInfo);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);
		
		
		return "student/info/schoolRegister";
	}
	
	//교직원_학생전체조회
	@RequestMapping(value="em_studentInfoList.si")
	public String studentInfoList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount;
		
		try {
			listCount = ss.getListCount();
			
			System.out.println("listCount::" + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage,listCount);
			
			ArrayList<StudentInfo> list = ss.selectStudentList(pi);
			
			System.out.println("list ::" + list);
			System.out.println("pi ::" + pi);
			
			request.setAttribute("list",list);
			request.setAttribute("pi",pi);
			
			return "employee/studentInfo/studentList";
			
		} catch (StudentInfoSelectListException e) {
			request.setAttribute("msg",e.getMessage());
			
			return "common/errorAlert";
		}
		
	}

}
