package com.kh.finalProject.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.finalProject.register.model.service.RegisterService;
import com.kh.finalProject.register.model.vo.Register;


@Controller
@SessionAttributes("registerInfomation")
public class RegisterController {
	@Autowired
	private RegisterService rs;
	
	@RequestMapping(value="registerInfo.me")
	public String registerCheck(Register r, Model model) {
		Register registerInfomation = rs.registerStudent(r);
		
		model.addAttribute("registerInfomation", registerInfomation);
		
		return "";
		
	}
}
