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
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.exception.BoardDeleteException;
import com.kh.finalProject.board.model.exception.BoardSearchException;
import com.kh.finalProject.board.model.exception.BoardSelectListException;
import com.kh.finalProject.board.model.exception.BoardSelectOneException;
import com.kh.finalProject.board.model.service.BoardService;
import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.board.model.vo.UploadFile;
import com.kh.finalProject.board.model.vo.Writer;
import com.kh.finalProject.common.CommonUtils;
import com.kh.finalProject.common.Pagination;


@Controller
@SessionAttributes("loginUser")
public class BoardController {
	@Autowired
	private BoardService bs;
	
///////////////////////////////////////////// 교직원 일반공지 ///////////////////////////////////////////////
///////////////////////////////////////////// 교직원 일반공지 ///////////////////////////////////////////////
///////////////////////////////////////////// 교직원 일반공지 ///////////////////////////////////////////////
///////////////////////////////////////////// 교직원 일반공지 ///////////////////////////////////////////////
///////////////////////////////////////////// 교직원 일반공지 ///////////////////////////////////////////////
	@RequestMapping(value="em_nNoticeList.bo")
	public String emNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.getListCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
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
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectOneBoard(boardNo);
			
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/normalNotice/em_normalNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "employee/board/notice/normalNotice/em_normalNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
		
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
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_nNoticeInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_nNoticeInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertnNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_nNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertnNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_nNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deletenNotice.bo")
	public String emnNoticeDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectnNotice boardNo ::::" + boardNo);
		
		try {
			bs.deletenNotice(boardNo);
			
			return "forward:em_nNoticeList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
	@RequestMapping("em_searchnNotice.bo")
	public String emnNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		if(searchCondition.equals("writer")) {
			sc.setWriter(searchValue);
		}
		if(searchCondition.equals("writeDept")) {
			sc.setWriteDept(searchValue);
		}
		if(searchCondition.equals("title")) {
			sc.setTitle(searchValue);
		}
		
		int listCount;
		
		try {
			listCount = bs.getSearchResultListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo spi = Pagination.getPageInfo(currentPage, listCount);
			
			spi.setSearchflag(searchflag);
			
			System.out.println("spi :::: " + spi);
			
			ArrayList<Board> slist = bs.selectSearchResultList(sc, spi);
			
			request.setAttribute("slist", slist);
			request.setAttribute("spi", spi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "employee/board/notice/normalNotice/em_normalNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showUpdatenNotice.bo")
	public String emShowUpdateNotice(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectOneBoard(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/normalNotice/em_normalNoticeUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/notice/normalNotice/em_normalNoticeUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_nNoticeUpdate.bo")
	public String emnNoticeUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		
		System.out.println("일반공지 글 수정 b :::: " + b);
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;		
		
		if(photo.getOriginalFilename().length() > 0) {
			System.out.println("if문 안으로 들어옴");
			root = request.getSession().getServletContext().getRealPath("resources");
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();			
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			System.out.println("일반공지 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatenNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_nNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			System.out.println("if문 바깥으로 들어옴");
			bs.updatenNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_nNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
///////////////////////// 교수 일반공지 ////////////////////////////////////
///////////////////////// 교수 일반공지 ////////////////////////////////////
///////////////////////// 교수 일반공지 ////////////////////////////////////
///////////////////////// 교수 일반공지 ////////////////////////////////////
///////////////////////// 교수 일반공지 ////////////////////////////////////
	
	@RequestMapping(value="pro_nNoticeList.bo")
	public String pronNoticeList(HttpServletRequest request) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.getListCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectnNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/notice/normalNotice/pro_normalNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="pro_nNoticeDetail.bo")
	public String pronNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("emNoticeDetail boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectOneBoard(boardNo);
			
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "professor/board/notice/normalNotice/pro_normalNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "professor/board/notice/normalNotice/pro_normalNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_searchnNotice.bo")
	public String pronNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		if(searchCondition.equals("writer")) {
			sc.setWriter(searchValue);
		}
		if(searchCondition.equals("writeDept")) {
			sc.setWriteDept(searchValue);
		}
		if(searchCondition.equals("title")) {
			sc.setTitle(searchValue);
		}
		
		int listCount;
		
		try {
			listCount = bs.getSearchResultListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo spi = Pagination.getPageInfo(currentPage, listCount);
			
			spi.setSearchflag(searchflag);
			
			System.out.println("spi :::: " + spi);
			
			ArrayList<Board> slist = bs.selectSearchResultList(sc, spi);
			
			request.setAttribute("slist", slist);
			request.setAttribute("spi", spi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "professor/board/notice/normalNotice/pro_normalNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
///////////////////////// 학생 일반공지 ////////////////////////////////////
///////////////////////// 학생 일반공지 ////////////////////////////////////
///////////////////////// 학생 일반공지 ////////////////////////////////////
///////////////////////// 학생 일반공지 ////////////////////////////////////
///////////////////////// 학생 일반공지 ////////////////////////////////////
	@RequestMapping(value="st_nNoticeList.bo")
	public String stnNoticeList(HttpServletRequest request) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.getListCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectnNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/notice/normalNotice/st_normalNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="st_nNoticeDetail.bo")
	public String stnNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("emNoticeDetail boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectOneBoard(boardNo);
			
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "student/board/notice/normalNotice/st_normalNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "student/board/notice/normalNotice/st_normalNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_searchnNotice.bo")
	public String stnNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		if(searchCondition.equals("writer")) {
			sc.setWriter(searchValue);
		}
		if(searchCondition.equals("writeDept")) {
			sc.setWriteDept(searchValue);
		}
		if(searchCondition.equals("title")) {
			sc.setTitle(searchValue);
		}
		
		int listCount;
		
		try {
			listCount = bs.getSearchResultListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo spi = Pagination.getPageInfo(currentPage, listCount);
			
			spi.setSearchflag(searchflag);
			
			System.out.println("spi :::: " + spi);
			
			ArrayList<Board> slist = bs.selectSearchResultList(sc, spi);
			
			request.setAttribute("slist", slist);
			request.setAttribute("spi", spi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "student/board/notice/normalNotice/st_normalNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
///////////////////////////////교직원 장학공지///////////////////////////////
///////////////////////////////교직원 장학공지///////////////////////////////
///////////////////////////////교직원 장학공지///////////////////////////////
///////////////////////////////교직원 장학공지///////////////////////////////
	
	@RequestMapping(value="em_showsNoticeList.bo")
	public String emshowsNoticeList(HttpServletRequest request) {
		
		return "employee/board/notice/scholarshipNotice/em_scholNoticeList";
	}
	
	@RequestMapping(value="em_sNoticeList.bo", produces="application/json;charset=utf8")
	public ModelAndView emsNoticeList(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		int listCount = 0;
		
		System.out.println("curr" + request.getParameter("currentPage"));
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		try {
			listCount = bs.sNoticeListCount();
			
			System.out.println("sNotice listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectsNoticeList(pi);
			
			System.out.println("sNotice list :::: " + list);
			System.out.println("sNotice pi :::: " + pi);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (BoardSelectListException e) {
			mv.addObject("msg", "게시글 조회 실패!");
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
	}
	@RequestMapping(value="em_sNoticeDetail.bo")
	public String emsNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("교직원 sNotice 상세보기 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectsNoticeOne(boardNo);
			
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/scholarshipNotice/em_scholNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "employee/board/notice/scholarshipNotice/em_scholNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
}










