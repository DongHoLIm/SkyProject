package com.kh.finalProject.professor.result.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.service.ProfessorResultService;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;

@Controller
public class ProfessorResultController {
	@Autowired
	private ProfessorResultService ps;
	
	
	@RequestMapping("resultInsert.pror")
	public String resultInsert(HttpSession session,HttpServletRequest request) {
		Member loginInfo = (Member)session.getAttribute("loginUser");
		ArrayList<ProfessorResult> list = ps.subList(loginInfo);
		request.setAttribute("list", list);
		return "professor/result/resultInsert";
	}
	@RequestMapping("insertResult.pror")
	public String insertResult() {
		return "professor/result/resultInsertStu";
	}
	@RequestMapping("searchResult.pror")
	public String searchResult() {
		
		return "professor/result/searchResult";
	}
	@RequestMapping("checkResultDetail.pror")
	public String checkResultDetail() {
		
		return  "professor/result/checkResultDetail";
	}
}
