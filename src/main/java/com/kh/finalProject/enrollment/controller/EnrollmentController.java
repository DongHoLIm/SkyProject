package com.kh.finalProject.enrollment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.service.EnrollmentService;
import com.kh.finalProject.enrollment.model.vo.Enrollment;
import com.kh.finalProject.member.model.vo.Member;

@Controller
@SessionAttributes("memberEnrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentService es;
	
	@RequestMapping(value="enrollment.en")
	public String EnrollmentCheck(Enrollment e, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		System.out.println("studentNo :::" + studentNo);
		
		
		try {
			Enrollment memberEnrollment = es.userEnrollment(studentNo);
			System.out.println("memberEnrollment :  "+memberEnrollment);
			model.addAttribute("memberEnrollment", memberEnrollment);
			
			return "redirect:index.jsp";
		} catch (EnrollmentException e1) {
			model.addAttribute("msg", e1.getMessage());
			return "common/errorAlert";
		}
	}
}
