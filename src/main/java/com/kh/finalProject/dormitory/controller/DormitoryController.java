package com.kh.finalProject.dormitory.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println("들어옴");
		
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
	
	@RequestMapping(value="apply.dor")
	public String DormitoryApplyAgreement() {
		return "student/dormitory/dormitoryApplyAgreement";
	}
	
	@RequestMapping(value="applyView.dor")
	public String DormitoryApplyView() {
		return "student/dormitory/dormitoryApply";
	}
	
	@RequestMapping(value="applyCancle.dor")
	public String DormitoryApplyCancle() {
		return "main/main";
	}
	
	@RequestMapping(value="dormitoryApply.dor", method=RequestMethod.POST)
	public String insert(@RequestParam("postNum") String postNum, @RequestParam("address") String address, @RequestParam("addressDetail") String addressDetail, Dormitory dormitory, ModelAndView mav, HttpSession session) {
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("loginUser ::: " + loginUser);
		
		dormitory.setMemberId(loginUser.getMemberId());
		dormitory.setPostNum(postNum);
		dormitory.setAddress(address);
		dormitory.setAddressDetail(addressDetail);
		
		System.out.println("dormitory :::" + dormitory);
		ds.insertDormitory(dormitory);
		
		return "common/successAlert";
	}
}
