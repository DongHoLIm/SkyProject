package com.kh.finalProject.scholarship.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.service.ScholarshipService;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
@SessionAttributes("memberScholarship")
public class ScholarshipController {
	@Autowired
	private ScholarshipService ss;
	
	@RequestMapping(value="applyView.sc")
	public String scholarshipInfoView() {
		return "student/scholarship/scholarshipApply";
	}
	
	@RequestMapping(value="beforeScholarshipApply.sc")
	public String beforeScholarshipApplyInfo(@RequestParam("schoYear") String schoYear, @RequestParam("schoSemester") String schoSemester,  Scholarship s, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("장학금 조회 컨트롤러 들어옴");
		
		if(schoYear == "" || schoSemester == "") {
			String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
			System.out.println("studentNo :::" + studentNo);
			
			System.out.println("schoYear :::" + schoYear);
			System.out.println("schoSemester :::" + schoSemester);
			
			List<Scholarship> beforeScholarship;
			
			try {
				beforeScholarship = ss.beforeScholarData(studentNo);
				System.out.println("beforeScholarship ::: " + beforeScholarship);
				
				request.setAttribute("beforeScholarship", beforeScholarship);
				
				return "student/scholarship/scholarshipApply";
				
			} catch (ScholarshipException e) {
				model.addAttribute("msg", e.getMessage());
				return "common/errorAlert";
			}
		}
		
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		System.out.println("studentNo :::" + studentNo);
		
		System.out.println("schoYear :::" + schoYear);
		System.out.println("schoSemester :::" + schoSemester);
		
		List<Scholarship> beforeScholarship;
		
		Scholarship scholarship = new Scholarship();
		scholarship.setStudentNo(studentNo);
		scholarship.setSchoYear(schoYear);
		scholarship.setSchoSemester(schoSemester);
		
		try {
			beforeScholarship = ss.beforeScholarshipData(scholarship);
			System.out.println("beforeScholarship ::: " + beforeScholarship);
			
			request.setAttribute("beforeScholarship", beforeScholarship);
			
			return "student/scholarship/scholarshipApply";
			
		} catch (ScholarshipException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
		
	}
	
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
	
	@RequestMapping(value="scholarshipNew.sc")
	public String showScholarshipNewApply() {
		
		return "student/scholarship/scholarshipNewApply";
	}
	
	@RequestMapping(value="scholarshipNewApply.sc")
	public String insert(@RequestParam("postNum") String postNum, @RequestParam("address") String address, @RequestParam("addressDetail") String addressDetail, Scholarship scholarship, ModelAndView mav, HttpSession session) {
		
		System.out.println("들어옴");
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("loginUser ::: " + loginUser);
		
		scholarship.setPostNum(postNum);
		scholarship.setAddress(address);
		scholarship.setAddressDetail(addressDetail);
		scholarship.setStudentNo(loginUser.getMemberId());
		
		ss.insertScholarship(scholarship);
		
		return "common/successAlert";
	}
	
	
	
}
