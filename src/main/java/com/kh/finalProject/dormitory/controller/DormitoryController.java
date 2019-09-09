package com.kh.finalProject.dormitory.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.service.DormitoryService;
import com.kh.finalProject.dormitory.model.vo.Dormitory;
import com.kh.finalProject.member.model.vo.Member;

@Controller
@SessionAttributes("memberDormitory")
public class DormitoryController {
	@Autowired
	private DormitoryService ds;
	
	@RequestMapping(value="dormitory.dor")
	public String DormitoryCheck(Dormitory m, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String studentNo = ((Member) request.getSession().getAttribute("loginUser")).getMemberId();
		
		System.out.println("studentNo :::" + studentNo);
		
		ArrayList<Dormitory> memberDormitory;
		
		try {
			memberDormitory = ds.userDormitory(studentNo);
			System.out.println("memberDormitory ::: " + memberDormitory);
			
			request.setAttribute("memberDormitory", memberDormitory);
			
			return "student/dormitory/dormitoryApplyInfo";
			
		} catch (DormitoryException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
		
	}
}
