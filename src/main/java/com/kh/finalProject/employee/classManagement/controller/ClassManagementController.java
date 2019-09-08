package com.kh.finalProject.employee.classManagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.service.ClassManagementService;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

@Controller
public class ClassManagementController {
	@Autowired
	private ClassManagementService cms;

	//강의개설등록
	@RequestMapping("lectureOpen.ac")
	public String selectSubject(HttpServletRequest request) {
			
		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;


		try {
			listCount = cms.getListCount();

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<LectureOpen> subjectList = cms.selectnSubjectList(pi);

			request.setAttribute("subjectList", subjectList);
			request.setAttribute("pi", pi);
			return "employee/class/lectureOpen";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}
	}
	@RequestMapping(value="lectureRegistration.ac")
	public ModelAndView insertLecture(String subCode, ModelAndView mv) {
		
		LectureOpen lo = new LectureOpen();
		
		lo.setSubCode(subCode);
		lo = cms.selectOneSubject(subCode);
		mv.addObject("LectureOpen", lo);
		mv.setViewName("jsonView");
		return mv;
	}
}
