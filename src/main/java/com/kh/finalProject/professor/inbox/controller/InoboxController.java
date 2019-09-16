package com.kh.finalProject.professor.inbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoboxController {

	
	@RequestMapping("inbox.pro")
	public ModelAndView Inbox (ModelAndView mav) {
		
		mav.setViewName("professor/class/inbox");
		
		return mav;
		
	}
}
