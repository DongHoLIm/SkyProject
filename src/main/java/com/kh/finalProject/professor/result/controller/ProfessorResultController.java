package com.kh.finalProject.professor.result.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorResultController {
	
	
	@RequestMapping("resultInsert.pror")
	public String resultInsert() {
		System.out.println("hellow");
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
