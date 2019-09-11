package com.kh.finalProject.scholarship.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.service.ScholarshipService;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

@Controller
@SessionAttributes("memberScholarship")
public class ScholarshipController {
	@Autowired
	private ScholarshipService ss;
	
	@RequestMapping(value="scholarship.sc")
	public String ScholarshipCheck(Scholarship s, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		System.out.println("studentNo :::" + studentNo);
		
		ArrayList<Scholarship> memberScholarship;
		try {
			memberScholarship = ss.userScholarship(studentNo);
			System.out.println("memberScholarship ::: " + memberScholarship);
			
			request.setAttribute("memberScholarship", memberScholarship);
			
			return "student/scholarship/scholarshipInfo";
		} catch (ScholarshipException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="scholarshipApply.sc")
	public String showScholarshipApplyView(Scholarship s, Model model, HttpServletRequest request, HttpServletResponse response) {
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		System.out.println("studentNo ::: " + studentNo);
		
		ArrayList<Scholarship> memberScholarshipApply;
		
		try {
			memberScholarshipApply = ss.userScholarshipApply(studentNo);
			System.out.println("memberScholarshipApply ::: " + memberScholarshipApply);
			
			request.setAttribute("memberScholarshipApply", memberScholarshipApply);
			
			return "student/scholarship/scholarshipApply";
		} catch (ScholarshipException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
		
	}
	
}
