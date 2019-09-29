package com.kh.finalProject.enrollment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.service.EnrollmentService;
import com.kh.finalProject.enrollment.model.vo.Enrollment;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;

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
			ArrayList<Enrollment> memberEnrollment = es.userEnrollment(studentNo);
			System.out.println("memberEnrollment :  "+ memberEnrollment);
			//model.addAttribute("memberEnrollment", memberEnrollment);
			
			request.setAttribute("memberEnrollment", memberEnrollment);
			
			return "student/register/registerInfo";
		} catch (EnrollmentException e1) {
			model.addAttribute("msg", e1.getMessage());
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="stStartEnrollment.en")
	public String stStartEnrollmentCheck(Enrollment e, Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("들어옴 :::");
			
			ArrayList<Enrollment> memberEnrollment = es.stEnrollment();
			System.out.println("memberEnrollment :  "+ memberEnrollment);
			//model.addAttribute("memberEnrollment", memberEnrollment);
			
			request.setAttribute("memberEnrollment", memberEnrollment);
			
			return "employee/register/registerInfo";
		} catch (EnrollmentException e1) {
			model.addAttribute("msg", e1.getMessage());
			return "common/errorAlert";
		}
	}
	
	
	@RequestMapping(value="stEnrollment.en")
	public String stEnrollmentCheck(@RequestParam("studentNo") String studentNo, @RequestParam("enrollYear") String enrollYear,  Scholarship s, Model model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("등록 조회 컨트롤러 들어옴");
		
		if(studentNo == "" || enrollYear == "") {
			
			System.out.println("studentNo :::" + studentNo);
			System.out.println("enrollYear :::" + enrollYear);
			
			List<Enrollment> beforeEnrollment;
			
			try {
				beforeEnrollment = es.beforeEnrollData();
				System.out.println("beforeEnrollment ::: " + beforeEnrollment);
				
				request.setAttribute("beforeEnrollment", beforeEnrollment);
				
				return "employee/register/registerInfo";
				
			} catch (EnrollmentException e) {
				model.addAttribute("msg", e.getMessage());
				return "common/errorAlert";
			}
		}
		
		
		System.out.println("studentNo :::" + studentNo);
		System.out.println("enrollYear :::" + enrollYear);
		
		List<Enrollment> beforeEnrollment;
		
		Enrollment enrollment = new Enrollment();
		enrollment.setStudentNo(studentNo);
		enrollment.setEnrollYear(enrollYear);
		
		try {
			beforeEnrollment = es.beforeEnrollmentData(enrollment);
			System.out.println("beforeEnrollment ::: " + beforeEnrollment);
			
			request.setAttribute("beforeEnrollment", beforeEnrollment);
			
			return "employee/register/searchRegisterInfo";
			
		} catch (EnrollmentException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="updateEnrollment.en")
	public String update() {
		System.out.println("결제했으니까 수정하자");
		
		es.updateEnrollment();
		
		return "student/register/registerInfo";
	}
	
	@RequestMapping(value="print.en")
	public String printView(Enrollment e, Model model, HttpServletRequest request, HttpServletResponse response) {
String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		System.out.println("studentNo :::" + studentNo);
		
		
		try {
			ArrayList<Enrollment> memberEnrollment = es.userEnrollment(studentNo);
			System.out.println("memberEnrollment :  "+ memberEnrollment);
			//model.addAttribute("memberEnrollment", memberEnrollment);
			
			request.setAttribute("memberEnrollment", memberEnrollment);
			
			return "student/register/print";
		} catch (EnrollmentException e1) {
			model.addAttribute("msg", e1.getMessage());
			return "common/errorAlert";
		}
	}
}

















