package com.kh.finalProject.print.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.print.model.vo.Print;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.print.model.exception.PrintException;
import com.kh.finalProject.print.model.service.PrintService;

@Controller
@SessionAttributes("enrollmentPrint")
public class PrintController {
	@Autowired
	private PrintService ps;
	
	@RequestMapping(value="print.pr")
	public String printCheckInfo(Print p, Model model, HttpServletRequest request) {
		
		System.out.println("프린트 컨트롤러 들어옴");
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		ArrayList<Print> printCheck;
		
		try {
			printCheck = ps.printCheck(studentNo);
			System.out.println("printCheck ::: " + printCheck);
			request.setAttribute("printCheck", printCheck);
			
			return "student/register/print";
		} catch (PrintException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
	} 
}
