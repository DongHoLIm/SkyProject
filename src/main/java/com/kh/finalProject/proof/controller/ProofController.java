package com.kh.finalProject.proof.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.proof.model.service.ProofService;
import com.kh.finalProject.proof.model.vo.Proof;


@Controller
@SessionAttributes("loginUser")
public class ProofController {
	@Autowired
	private ProofService ps;
	
	@RequestMapping(value="showIdCheck.pf")
	public String showIdCheck(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {		
		
		ArrayList<Proof> list = ps.selectProofList();
		
		request.setAttribute("list", list);
		
		return "proof/accountCheck";
	}
	
	@RequestMapping(value="checkMemberPwd.pf")
	public ModelAndView checkMemberPwd(String checkPwd, @ModelAttribute("loginUser") Member loginUser, ModelAndView mv) {		
		int result = 0;
		
		if(checkPwd.equals(loginUser.getMemberPwd())) {
			result = 1;
		}else {
			result = 0;
		}
		
		mv.addObject("result", result);
		mv.setViewName("jsonView");		
		
		return mv;
	}
	
	@RequestMapping(value="Payment.pf")
	public String Payment(Proof pf, @ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {				
		
		request.setAttribute("loginUser", loginUser);
		request.setAttribute("pf", pf);
		
		return "proof/Payment";
	}
	
	
//	@RequestMapping(value="insertProofPrint.pf")
//	public String insertProofPrint(Proof pf, HttpServletRequest request) {
//		System.out.println("결제 후 증명서 내역관리 insert 전 pf :::: " + pf);
//		
//		ps.insertProofPrint(pf);
//		
//		System.out.println("결제 후 증명서 내역관리 insert 후 pf :::: " + pf);
//		
//		request.setAttribute("pf", pf);
//		
//		return "proof/;
//	}
}
