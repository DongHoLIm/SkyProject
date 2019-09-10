package com.kh.finalProject.reply.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.reply.model.exception.ReplyDeleteException;
import com.kh.finalProject.reply.model.exception.ReplyInsertException;
import com.kh.finalProject.reply.model.exception.ReplySelectException;
import com.kh.finalProject.reply.model.exception.ReplyUpdateException;
import com.kh.finalProject.reply.model.service.ReplyService;
import com.kh.finalProject.reply.model.vo.Reply;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService rs;	
	
	@RequestMapping(value="insertfreeBoardRP.rp")
	public ModelAndView insertFreeBoardRP(ModelAndView mv, Reply rp) {
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
	
	@RequestMapping(value="selectfreeBoardRP.rp")
	public ModelAndView selectfreeBoardRP(ModelAndView mv, HttpServletRequest request) {
		
		int currentPage = 1;
		int listCount = 0;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		try {
			listCount = rs.freeBoardRPListCount(boardNo);
			
			System.out.println("자유게시판 댓글 리스트 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Reply> list = rs.selectfreeBoardRPList(pi, boardNo);
			
			System.out.println("자유게시판 댓글 리스트 pi :::: " + pi);
			System.out.println("자유게시판 댓글 리스트 list :::: " + list);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplySelectException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
		
	}
	
	@RequestMapping(value="deletefreeBoardRP.rp")
	public ModelAndView deleteFreeBoardRP(ModelAndView mv, Reply rp) {
		
		System.out.println("자유게시판 댓글 delete rp :::: " + rp);
		
		try {
			rs.deleteFreeBoardRP(rp);
			
			mv.addObject(rp);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplyDeleteException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	
	@RequestMapping(value="updatefreeBoardRP.rp")
	public ModelAndView updateFreeBoardRP(ModelAndView mv, Reply rp) {
		
		System.out.println("자유게시판 댓글 update rp :::: " + rp);
		
		try {
			rs.updateFreeBoardRP(rp);
			
			mv.addObject(rp);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplyUpdateException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	
	
////////////////////////////////// 아래부터 칭찬합시다 //////////////////////////////////
////////////////////////////////// 아래부터 칭찬합시다 //////////////////////////////////
////////////////////////////////// 아래부터 칭찬합시다 //////////////////////////////////
////////////////////////////////// 아래부터 칭찬합시다 //////////////////////////////////
////////////////////////////////// 아래부터 칭찬합시다 //////////////////////////////////
	
	@RequestMapping(value="insertpraiseBoardRP.rp")
	public ModelAndView insertpraiseBoardRP(ModelAndView mv, Reply rp) {
		System.out.println("칭찬합시다 댓글 insert rp :::: " + rp);
		
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
	
	@RequestMapping(value="selectpraiseBoardRP.rp")
	public ModelAndView selectpraiseBoardRP(ModelAndView mv, HttpServletRequest request) {
		
		int currentPage = 1;
		int listCount = 0;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		try {
			listCount = rs.freeBoardRPListCount(boardNo);
			
			System.out.println("칭찬합시다 댓글 리스트 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Reply> list = rs.selectfreeBoardRPList(pi, boardNo);
			
			System.out.println("칭찬합시다 댓글 리스트 pi :::: " + pi);
			System.out.println("칭찬합시다 댓글 리스트 list :::: " + list);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplySelectException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
		
	}
	
	@RequestMapping(value="deletepraiseBoardRP.rp")
	public ModelAndView deletepraiseBoardRP(ModelAndView mv, Reply rp) {
		
		System.out.println("칭찬합시다 댓글 delete rp :::: " + rp);
		
		try {
			rs.deleteFreeBoardRP(rp);
			
			mv.addObject(rp);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplyDeleteException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	
	@RequestMapping(value="updatepraiseBoardRP.rp")
	public ModelAndView updatepraiseBoardRP(ModelAndView mv, Reply rp) {
		
		System.out.println("칭찬합시다 댓글 update rp :::: " + rp);
		
		try {
			rs.updateFreeBoardRP(rp);
			
			mv.addObject(rp);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (ReplyUpdateException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	
	
}
