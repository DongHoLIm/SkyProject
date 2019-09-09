package com.kh.finalProject.professor.sendSMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	@RequestMapping("sendSMS.pro")
	public String sendSMSviewChange () {
		return "professor/sendSMS/sendSMS";
	}
	@RequestMapping("addressStudent.pro")
	public String addressList(){
		
		return "professor/sendSMS/addressList";
	}
}
