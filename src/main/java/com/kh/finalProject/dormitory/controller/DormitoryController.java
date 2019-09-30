package com.kh.finalProject.dormitory.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
		
		dormitory.setStudentNo(loginUser.getMemberId());
		dormitory.setPostNum(postNum);
		dormitory.setAddress(address);
		dormitory.setAddressDetail(addressDetail);
		
		System.out.println("dormitory :::" + dormitory);
		ds.insertDormitory(dormitory);
		
		return "common/successAlert";
	}
	
	@RequestMapping(value="stDormApply.dor")
	public String stDormApplyInfo(Dormitory m, Model model, HttpServletRequest request, HttpServletResponse response) {
ArrayList<Dormitory> memberDormitory;
		
		try {
			memberDormitory = ds.empApplyDormitory();
			System.out.println("memberDormitory ::: " + memberDormitory);
			
			request.setAttribute("memberDormitory", memberDormitory);
			
			return "employee/dormitory/dormitoryApproval";
			
		} catch (DormitoryException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
		
	}
	
	@RequestMapping(value="stDorm.dor")
	public String stDormInfo() {
		return "employee/dormitory/dormitoryInfo";
	}
	
	@RequestMapping(value="stDormSearch.dor")
	public String stDormSearchApply(@RequestParam("applyCode") String applyCode, @RequestParam("studentNo") String studentNo, Dormitory dormitory, Model model, HttpServletRequest request, HttpServletResponse response) {
		if(applyCode == "" || studentNo == "") {
			System.out.println("applyCode :::" + applyCode);
			System.out.println("studentNo :::" + studentNo);
			
			List<Dormitory> beforeDormitory;
			
			try {
				beforeDormitory = ds.beforeDormitoryData();
				System.out.println("beforeDormitory ::: " + beforeDormitory);
				
				request.setAttribute("beforeDormitory", beforeDormitory);
				
				return "employee/dormitory/searchDormitory";
				
			} catch (DormitoryException e) {
				model.addAttribute("msg", e.getMessage());
				return "common/errorAlert";
			}
			
		}
		
		System.out.println("applyCode :::" + applyCode);
		System.out.println("studentNo :::" + studentNo);
		
		List<Dormitory> beforeDormitory;
		
		Dormitory dor = new Dormitory();
		dor.setApplyCode(applyCode);
		dor.setStudentNo(studentNo);
		
		try {
			beforeDormitory = ds.beforeDormData(dor);
			System.out.println("beforeDormitory :::" + beforeDormitory);
			
			request.setAttribute("beforeDormitory", beforeDormitory);
			
			return "employee/dormitory/searchDormitory";
		} catch (DormitoryException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
		
	}
	
	@RequestMapping(value="beforeDetail.dor")
	public String empDormitoryCheck(Dormitory m, Model model, HttpServletRequest request, HttpServletResponse response){
System.out.println("들어옴");
		
		ArrayList<Dormitory> memberDormitory;
		
		try {
			memberDormitory = ds.empDormitory();
			System.out.println("memberDormitory ::: " + memberDormitory);
			
			request.setAttribute("memberDormitory", memberDormitory);
			
			return "employee/dormitory/beforeDetailDormitory";
			
		} catch (DormitoryException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="dormitoryAggrement.dor")
	public String update() {
		System.out.println("들어옴");
		
		ds.updateDormitory();
		
		return "common/successAlert";
	}
	
}


















