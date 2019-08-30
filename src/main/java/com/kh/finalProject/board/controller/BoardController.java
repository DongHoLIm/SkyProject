package com.kh.finalProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@RequestMapping(value="normalListView.no")
	public String showNormalListView() {
		return "student/board/notice/normalNotice/normalNoticeList";
	}
	
	@RequestMapping(value="normalDetail.no")
	public String selectNormalDetail() {
		
		return "student/board/notice/normalNotice/normalNoticeDetail";
	}
	
	@RequestMapping(value="freeListView.bo")
	public String showFreeListView() {
		return "student/board/schoolLife/freeBoard/freeBoardList";
	}
}
