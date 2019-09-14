package com.kh.finalProject.professor.sendSMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalProject.professor.sendSMS.model.service.professorService;

@Controller
public class ProfessorController {
	@Autowired
	professorService ps;
	
	
	@RequestMapping("sendSMS.pro")
	public String sendSMSviewChange () {
		
		return "professor/sendSMS/sendSMS";
	}
	@RequestMapping("addressStudent.pro")
	public String addressList(){
		
		return "professor/sendSMS/addressList";
	}
}
