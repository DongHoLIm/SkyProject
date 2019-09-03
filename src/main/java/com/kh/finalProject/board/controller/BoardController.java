package com.kh.finalProject.board.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.service.BoardService;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;
import com.kh.finalProject.common.CommonUtils;
import com.kh.finalProject.common.Pagination;


@Controller
@SessionAttributes("loginUser")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value="em_nNoticeList.bo")
	public String emNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = bs.getListCount();
		
		System.out.println("boardCtrl listCount :::: " + listCount);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		try {
			ArrayList<Board> list = bs.selectnNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/notice/normalNotice/em_normalNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}
		
	}
	
	@RequestMapping(value="em_nNoticeDetail.bo")
	public String emNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("emNoticeDetail boardNo :::: " + boardNo);
		
		Board b = bs.selectOneBoard(boardNo);
		
		System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
		
		request.setAttribute("b", b);
		
		return "employee/board/notice/normalNotice/em_normalNoticeDetail";
	}
	
	@RequestMapping(value="em_showInsertnNotice.bo")
	public String emShowNoticeInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emNoticeInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectWriterInfo(memberId);
		
		System.out.println("selectWriterInfo writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/notice/normalNotice/em_normalNoticeInsert";
	} 
	
	@RequestMapping(value="em_nNoticeInsert.bo")
	public String emnNoticeInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_nNoticeInsert.bo photo :::: " + photo);
		System.out.println("em_nNoticeInsert.bo b :::: " + b);
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		System.out.println("em_nNoticeInsert.bo root :::: " + root);
		
		String filePath = root + "\\uploadFiles";
		String originFileName = photo.getOriginalFilename();
		
		System.out.println("em_nNoticeInsert.bo originFileName :::: " + originFileName);
		
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		String changeName = CommonUtils.getRandomString();
		
		uf.setOldName(originFileName);
		uf.setChangeName(changeName);
		uf.setPath(filePath + "\\" + changeName + ext);
		
//		try{			
//			photo.transferTo(new File(filePath + "\\" + changeName + ext));
//		 	
//			bs.insertnNotice(b, uf);
//			
//		}catch(Exception e) {
//		 
//		}
		 
		
		return "";
	}
}
