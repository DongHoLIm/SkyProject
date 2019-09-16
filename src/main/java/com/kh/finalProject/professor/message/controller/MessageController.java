package com.kh.finalProject.professor.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	
	@RequestMapping("message.pro")
	public ModelAndView Message (ModelAndView mav) {
		
		mav.setViewName("professor/class/message");
		
		return mav;
		
	}
	
}
