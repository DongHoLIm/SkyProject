package com.kh.finalProject.employee.classManagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.service.ClassManagementService;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

@Controller
public class ClassManagementController {
	@Autowired
	private ClassManagementService cms;

	//강의개설등록
	@RequestMapping("lectureOpen.em")
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
	@RequestMapping(value="lectureRegistration.em")
	public String goLectureRegistration(HttpServletRequest request,@RequestParam(name="subCode", required=false) String subCode) {

		LectureOpen lo = new LectureOpen();

		System.out.println("시작합니다");
		System.out.println("subCode :::::" + subCode);
		lo = cms.selectOneSubject(subCode);
		System.out.println("다시돌아옴 !!" + lo);

		System.out.println(lo.getSdeptName());
		ArrayList<DepartmentProfessor> pf = cms.selectProfessorList(lo.getSdeptName());

		System.out.println("pf다시옴!!" + pf);

		request.setAttribute("lo", lo);

		return "employee/class/lectureRegistration";
	}

}
