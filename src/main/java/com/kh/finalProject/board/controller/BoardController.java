package com.kh.finalProject.board.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
			bs.deleteNotice(boardNo);
			
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
	
	@RequestMapping(value="em_showInsertsNotice.bo")
	public String emShowsNoticeInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emNoticeInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectWriterInfo(memberId);
		
		System.out.println("selectWriterInfo writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/notice/scholarshipNotice/em_scholNoticeInsert";
	} 
	
	@RequestMapping(value="em_sNoticeInsert.bo")
	public String emsNoticeInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_sNoticeInsert.bo photo :::: " + photo);
		System.out.println("em_sNoticeInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_sNoticeInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_sNoticeInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertsNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_showsNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertsNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_showsNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deletesNotice.bo")
	public String emNoticeDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectnNotice boardNo ::::" + boardNo);
		
		try {
			bs.deleteNotice(boardNo);
			
			return "forward:em_showsNoticeList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
	@RequestMapping("em_showUpdatesNotice.bo")
	public String emShowUpdatesNotice(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectsNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("장학공지 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/scholarshipNotice/em_scholNoticeUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("장학공지 상세보기 Ctrl b :::: " + b);
				System.out.println("장학공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/notice/scholarshipNotice/em_scholNoticeUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_sNoticeUpdate.bo")
	public String emsNoticeUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		
		System.out.println("장학공지 글 수정 b :::: " + b);
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();			
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			System.out.println("장학공지 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatesNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_showsNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			System.out.println("if문 바깥으로 들어옴");
			bs.updatesNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_showsNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_searchsNotice.bo")
	public ModelAndView emsearchsNotice(ModelAndView mv, String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchsNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);			
			
			ArrayList<Board> list = bs.SearchsNoticeResultList(sc, pi);
			
			System.out.println("list :::: " + list);
			System.out.println("pi :::: " + pi);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (BoardSearchException e) {
			mv.addObject("msg", e.getMessage());
			
			mv.setViewName("common/errorPage");
			
			return mv;	
		}
	}
	
///////////////////////////////교수 장학공지///////////////////////////////
///////////////////////////////교수 장학공지///////////////////////////////
///////////////////////////////교수 장학공지///////////////////////////////
///////////////////////////////교수 장학공지///////////////////////////////
	
	@RequestMapping(value="pro_showsNoticeList.bo")
	public String proshowsNoticeList(HttpServletRequest request) {
		
		return "professor/board/notice/scholarshipNotice/pro_scholNoticeList";
	}
	
	@RequestMapping(value="pro_sNoticeList.bo", produces="application/json;charset=utf8")
	public ModelAndView prosNoticeList(ModelAndView mv, HttpServletRequest request) {
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
	
	@RequestMapping(value="pro_sNoticeDetail.bo")
	public String prosNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("교수 sNotice 상세보기 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectsNoticeOne(boardNo);
			
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				
				return "professor/board/notice/scholarshipNotice/pro_scholNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "professor/board/notice/scholarshipNotice/pro_scholNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping("pro_searchsNotice.bo")
	public ModelAndView prosearchsNotice(ModelAndView mv, String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchsNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);			
			
			ArrayList<Board> list = bs.SearchsNoticeResultList(sc, pi);
			
			System.out.println("list :::: " + list);
			System.out.println("pi :::: " + pi);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			
			mv.setViewName("jsonView");
			
			return mv;
			
		} catch (BoardSearchException e) {
			mv.addObject("msg", e.getMessage());
			
			mv.setViewName("common/errorPage");
			
			return mv;	
		}
	}
	
///////////////////////////////학생 장학공지///////////////////////////////
///////////////////////////////학생 장학공지///////////////////////////////
///////////////////////////////학생 장학공지///////////////////////////////
///////////////////////////////학생 장학공지///////////////////////////////

	@RequestMapping(value="st_showsNoticeList.bo")
	public String stshowsNoticeList(HttpServletRequest request) {

		return "student/board/notice/scholarshipNotice/st_scholNoticeList";
	}

	@RequestMapping(value="st_sNoticeList.bo", produces="application/json;charset=utf8")
	public ModelAndView stsNoticeList(ModelAndView mv, HttpServletRequest request) {
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

	@RequestMapping(value="st_sNoticeDetail.bo")
	public String stsNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("교수 sNotice 상세보기 boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectsNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);

			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);

				return "student/board/notice/scholarshipNotice/st_scholNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("일반공지 상세보기 Ctrl b :::: " + b);
				System.out.println("일반공지 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/notice/scholarshipNotice/st_scholNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}	
	}

	@RequestMapping("st_searchsNotice.bo")
	public ModelAndView stsearchsNotice(ModelAndView mv, String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {

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
			listCount = bs.SearchsNoticeResultCount(sc);

			System.out.println("검색후 listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			pi.setSearchflag(searchflag);			

			ArrayList<Board> list = bs.SearchsNoticeResultList(sc, pi);

			System.out.println("list :::: " + list);
			System.out.println("pi :::: " + pi);

			mv.addObject("list", list);
			mv.addObject("pi", pi);

			mv.setViewName("jsonView");

			return mv;

		} catch (BoardSearchException e) {
			mv.addObject("msg", e.getMessage());

			mv.setViewName("common/errorPage");

			return mv;	
		}
	}
	
///////////////////////////////////////////////////////교직원 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 학사일정///////////////////////////////////////////////////////
	@RequestMapping(value="em_acNoticeList.bo")
	public String emacNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectacNoticeCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectacNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/notice/academicCalendar/em_acNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("em_searchacNotice.bo")
	public String emacNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchacNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchacNoticeResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "employee/board/notice/academicCalendar/em_acNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_acNoticeSearchMonth.bo")
	public String emacNoticeSearchMonth(HttpServletRequest request, String month, boolean monthflag) {	
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectacNoticeMonthCount(month);
			
			System.out.println("emacNoticeSearchMonth listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setMonthflag(monthflag);
			
			ArrayList<Board> list = bs.selectacNoticeMonthList(pi, month);
			
			System.out.println("emacNoticeSearchMonth list :::: " + list);
			System.out.println("emacNoticeSearchMonth :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("month", month);
			
			return "employee/board/notice/academicCalendar/em_acNoticeList";
			
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping(value="em_acNoticeDetail.bo")
	public String emacNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		System.out.println("em_acNoticeDetail boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		
		try {
			b = bs.selectacNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);

			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/academicCalendar/em_acNoticeDetail";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				System.out.println("학사일정 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
				
				return "employee/board/notice/academicCalendar/em_acNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
		
	}
	
	@RequestMapping("em_showUpdateacNotice.bo")
	public String emShowUpdateacNotice(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectacNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/academicCalendar/em_acNoticeUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				System.out.println("학사일정 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/notice/academicCalendar/em_acNoticeUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_acNoticeUpdate.bo")
	public String emacNoticeUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("학사일정 글 수정 b :::: " + b);
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();			
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			System.out.println("학사일정 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateacNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_acNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateacNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_acNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_showInsertacNotice.bo")
	public String emShowacNoticeInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emNoticeInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectWriterInfo(memberId);
		
		System.out.println("selectWriterInfo writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/notice/academicCalendar/em_acNoticeInsert";
	} 
	
	@RequestMapping(value="em_acNoticeInsert.bo")
	public String emacNoticeInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_nNoticeInsert.bo photo :::: " + photo);
		System.out.println("em_nNoticeInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_acNoticeInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_acNoticeInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertacNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_acNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertacNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_acNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deleteacNotice.bo")
	public String emacNoticeDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectnNotice boardNo ::::" + boardNo);
		
		try {
			bs.deleteNotice(boardNo);
			
			return "forward:em_acNoticeList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////교수 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 학사일정///////////////////////////////////////////////////////
	@RequestMapping(value="pro_acNoticeList.bo")
	public String proacNoticeList(HttpServletRequest request) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = bs.selectacNoticeCount();

			System.out.println("boardCtrl listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<Board> list = bs.selectacNoticeList(pi);

			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);

			return "professor/board/notice/academicCalendar/pro_acNoticeList";

		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}		
	}

	@RequestMapping("pro_searchacNotice.bo")
	public String proacNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {

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
			listCount = bs.SearchacNoticeResultCount(sc);

			System.out.println("검색후 listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			pi.setSearchflag(searchflag);

			System.out.println("검색후 pi :::: " + pi);

			ArrayList<Board> list = bs.SearchacNoticeResultList(sc, pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);

			return "professor/board/notice/academicCalendar/pro_acNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";	
		}
	}

	@RequestMapping(value="pro_acNoticeSearchMonth.bo")
	public String proacNoticeSearchMonth(HttpServletRequest request, String month, boolean monthflag) {	

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = bs.selectacNoticeMonthCount(month);

			System.out.println("emacNoticeSearchMonth listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			pi.setMonthflag(monthflag);

			ArrayList<Board> list = bs.selectacNoticeMonthList(pi, month);

			System.out.println("emacNoticeSearchMonth list :::: " + list);
			System.out.println("emacNoticeSearchMonth :::: " + pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("month", month);

			return "professor/board/notice/academicCalendar/pro_acNoticeList";

		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}		
	}

	@RequestMapping(value="pro_acNoticeDetail.bo")
	public String proacNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("em_acNoticeDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectacNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);

				return "professor/board/notice/academicCalendar/pro_acNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				System.out.println("학사일정 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/notice/academicCalendar/pro_acNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}	

	}
	
///////////////////////////////////////////////////////학생 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 학사일정///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 학사일정///////////////////////////////////////////////////////
	@RequestMapping(value="st_acNoticeList.bo")
	public String stacNoticeList(HttpServletRequest request) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = bs.selectacNoticeCount();

			System.out.println("boardCtrl listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<Board> list = bs.selectacNoticeList(pi);

			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);

			return "student/board/notice/academicCalendar/st_acNoticeList";

		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}		
	}

	@RequestMapping("st_searchacNotice.bo")
	public String stacNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {

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
			listCount = bs.SearchacNoticeResultCount(sc);

			System.out.println("검색후 listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			pi.setSearchflag(searchflag);

			System.out.println("검색후 pi :::: " + pi);

			ArrayList<Board> list = bs.SearchacNoticeResultList(sc, pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);

			return "student/board/notice/academicCalendar/st_acNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";	
		}
	}

	@RequestMapping(value="st_acNoticeSearchMonth.bo")
	public String stacNoticeSearchMonth(HttpServletRequest request, String month, boolean monthflag) {	

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = bs.selectacNoticeMonthCount(month);

			System.out.println("emacNoticeSearchMonth listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			pi.setMonthflag(monthflag);

			ArrayList<Board> list = bs.selectacNoticeMonthList(pi, month);

			System.out.println("emacNoticeSearchMonth list :::: " + list);
			System.out.println("emacNoticeSearchMonth :::: " + pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("month", month);

			return "student/board/notice/academicCalendar/st_acNoticeList";

		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}		
	}

	@RequestMapping(value="st_acNoticeDetail.bo")
	public String stacNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("em_acNoticeDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectacNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);

				return "student/board/notice/academicCalendar/st_acNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("학사일정 상세보기 Ctrl b :::: " + b);
				System.out.println("학사일정 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/notice/academicCalendar/st_acNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}	

	}
	
///////////////////////////////////////////////////////교직원 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 교내외행사///////////////////////////////////////////////////////
	
	@RequestMapping(value="em_eNoticeList.bo")
	public String emeNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selecteNoticeCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selecteNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/notice/eventNotice/em_eNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("em_searcheNotice.bo")
	public String emeNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearcheNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearcheNoticeResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "employee/board/notice/eventNotice/em_eNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_eNoticeDetail.bo")
	public String emeNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("em_eNoticeDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selecteNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);

				return "employee/board/notice/eventNotice/em_eNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);
				System.out.println("교내외행사 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/notice/eventNotice/em_eNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_showInserteNotice.bo")
	public String emShoweNoticeInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emNoticeInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectWriterInfo(memberId);
		
		System.out.println("selectWriterInfo writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/notice/eventNotice/em_eNoticeInsert";
	} 
	
	@RequestMapping(value="em_eNoticeInsert.bo")
	public String emeNoticeInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_eNoticeInsert.bo photo :::: " + photo);
		System.out.println("em_eNoticeInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_eNoticeInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_eNoticeInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.inserteNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_eNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.inserteNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_eNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showUpdateeNotice.bo")
	public String emShowUpdateeNotice(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selecteNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/notice/eventNotice/em_eNoticeUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);
				System.out.println("교내외행사 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/notice/eventNotice/em_eNoticeUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_eNoticeUpdate.bo")
	public String emeNoticeUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("교내외행사 글 수정 b :::: " + b);
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();			
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			System.out.println("교내외행사 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateeNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_eNoticeList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateeNotice(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_eNoticeList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deleteeNotice.bo")
	public String emeNoticeDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delecteNotice boardNo ::::" + boardNo);
		
		try {
			bs.deleteNotice(boardNo);
			
			return "forward:em_eNoticeList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////교수 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 교내외행사///////////////////////////////////////////////////////
	@RequestMapping(value="pro_eNoticeList.bo")
	public String proeNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selecteNoticeCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selecteNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/notice/eventNotice/pro_eNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("pro_searcheNotice.bo")
	public String proeNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearcheNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearcheNoticeResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "professor/board/notice/eventNotice/pro_eNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_eNoticeDetail.bo")
	public String proeNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("pro_eNoticeDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selecteNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);

				return "professor/board/notice/eventNotice/pro_eNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);
				System.out.println("교내외행사 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/notice/eventNotice/pro_eNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}

///////////////////////////////////////////////////////학생 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 교내외행사///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 교내외행사///////////////////////////////////////////////////////
	
	@RequestMapping(value="st_eNoticeList.bo")
	public String steNoticeList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selecteNoticeCount();
			
			System.out.println("boardCtrl listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selecteNoticeList(pi);
			
			System.out.println("boardCtrl list :::: " + list);
			System.out.println("boardCtrl :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/notice/eventNotice/st_eNoticeList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("st_searcheNotice.bo")
	public String steNoticeSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearcheNoticeResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearcheNoticeResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "student/board/notice/eventNotice/st_eNoticeList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_eNoticeDetail.bo")
	public String steNoticeDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("pro_eNoticeDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selecteNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);

				return "student/board/notice/eventNotice/st_eNoticeDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("교내외행사 상세보기 Ctrl b :::: " + b);
				System.out.println("교내외행사 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/notice/eventNotice/st_eNoticeDetail";			
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
}











