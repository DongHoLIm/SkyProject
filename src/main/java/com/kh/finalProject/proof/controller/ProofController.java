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
	
	@RequestMapping(value="showProof.pf")
	public String showIdCheck(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {		
		
		ArrayList<Proof> list = ps.selectProofList();
		
		request.setAttribute("list", list);
		
		return "proof/proofApply";
	}
	
	
	@RequestMapping(value="Payment.pf")
	public String Payment(Proof pf, @ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {				
		
		request.setAttribute("loginUser", loginUser);
		request.setAttribute("pf", pf);
		
		return "proof/Payment";
	}
	
	
	@RequestMapping(value="insertProofPrint.pf")
	public String insertProofPrint(Proof pf, HttpServletRequest request) {
		
		ps.insertProofPrint(pf);			
		
		request.setAttribute("pf", pf);
		
		return "redirect:showProofPrint.pf";
	}
	
	@RequestMapping(value="showProofPrint.pf")
	public String showProofPrint(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {		
		
		return "proof/proofManagement";
	}
	
	@RequestMapping(value="selectProofList.pf")
	public ModelAndView selectProofList(ModelAndView mv, @ModelAttribute("loginUser") Member loginUser) {
		
		ArrayList<Proof> list = ps.selectProofPrintList(loginUser);
		
		System.out.println("list :::: " + list);
		
		mv.addObject("list", list);
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping(value="showPrintCerti.pf")
	public String showPrintCerti(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser, Proof pf) {
		
		System.out.println("pf :::: " + pf);
		System.out.println("loginUser :::: " + loginUser);
		
		return "proof/printCerti1";
	}
}
