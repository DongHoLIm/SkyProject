package com.kh.finalProject.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.reply.model.exception.ReplyInsertException;
import com.kh.finalProject.reply.model.service.ReplyService;
import com.kh.finalProject.reply.model.vo.Reply;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService rs;
	
	@RequestMapping(value="st_insertfreeBoardRP.rp")
	public ModelAndView stinsertFreeBoardRP(ModelAndView mv, Reply rp) {
		System.out.println("자유게시판 댓글 insert rp :::: " + rp);
		
		try {
			rs.insertFreeBoardRP(rp);
			
			mv.addObject(rp);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplyInsertException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	
	
}
