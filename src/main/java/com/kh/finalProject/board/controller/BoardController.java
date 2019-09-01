package com.kh.finalProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@RequestMapping(value="em_nNoticeList.bo")
	public String emNoticeList() {
		
		return "employee/board/notice/normalNotice/em_normalNoticeList";
	}
	
	@RequestMapping(value="em_nNoticeDetail.bo")
	public String emNoticeDetail() {
		
		return "employee/board/notice/normalNotice/em_normalNoticeDetail";
	}
}
