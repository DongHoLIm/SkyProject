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
import com.kh.finalProject.board.model.vo.SystemQuestion;
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
	
///////////////////////////////////////////////////////학생 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 자유게시판///////////////////////////////////////////////////////
	
	@RequestMapping(value="st_freeBoardList.bo")
	public String stfreeBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectfreeBoardCount();
			
			System.out.println("st_freeBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectfreeBoardList(pi);
			
			System.out.println("학생 자유게시판 list :::: " + list);
			System.out.println("학생 자유게시판 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/schoolLife/freeBoard/st_freeBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("st_freeBoardsearch.bo")
	public String stfreeBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchefreeBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchfreeBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "student/board/schoolLife/freeBoard/st_freeBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_freeBoardDetail.bo")
	public String stfreeBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("st_freeBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);

				return "student/board/schoolLife/freeBoard/st_freeBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/schoolLife/freeBoard/st_freeBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="st_showInsertfreeBoard.bo")
	public String stShowfreeBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("stShowfreeBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectFreeBoardstWriter(memberId);
		
		System.out.println("selectFreeBoardstWriter writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "student/board/schoolLife/freeBoard/st_freeBoardInsert";	
	} 
	
	@RequestMapping(value="st_freeBoardInsert.bo")
	public String stfreeBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("st_freeBoardInsert.bo photo :::: " + photo);
		System.out.println("st_freeBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("st_freeBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("st_freeBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertfreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:st_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertfreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:st_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_showUpdatefreeBoard.bo")
	public String stShowUpdatefreeBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				
				return "student/board/schoolLife/freeBoard/st_freeBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "student/board/schoolLife/freeBoard/st_freeBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_freeBoardUpdate.bo")
	public String stfreeBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("자유게시판 글 수정 b :::: " + b);
		
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
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:st_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:st_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_deletefreeBoard.bo")
	public String stfreeBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delecteNotice boardNo ::::" + boardNo);
		
		try {
			bs.deletefreeBoard(boardNo);
			
			return "forward:st_freeBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////교수 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 자유게시판///////////////////////////////////////////////////////
	
	@RequestMapping(value="pro_freeBoardList.bo")
	public String profreeBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectfreeBoardCount();
			
			System.out.println("pro_freeBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectfreeBoardList(pi);
			
			System.out.println("교수 자유게시판 list :::: " + list);
			System.out.println("교수 자유게시판 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/schoolLife/freeBoard/pro_freeBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("pro_freeBoardsearch.bo")
	public String profreeBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchefreeBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchfreeBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "professor/board/schoolLife/freeBoard/pro_freeBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_freeBoardDetail.bo")
	public String profreeBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("pro_freeBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);

				return "professor/board/schoolLife/freeBoard/pro_freeBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/schoolLife/freeBoard/pro_freeBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="pro_showInsertfreeBoard.bo")
	public String proShowfreeBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("proShowfreeBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectFreeBoardproWriter(memberId);
		
		System.out.println("selectFreeBoardproWriter writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "professor/board/schoolLife/freeBoard/pro_freeBoardInsert";	
	} 
	
	@RequestMapping(value="pro_freeBoardInsert.bo")
	public String profreeBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("pro_freeBoardInsert.bo photo :::: " + photo);
		System.out.println("pro_freeBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("pro_freeBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("pro_freeBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertfreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:pro_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertfreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:pro_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_showUpdatefreeBoard.bo")
	public String proShowUpdatefreeBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				
				return "professor/board/schoolLife/freeBoard/pro_freeBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "professor/board/schoolLife/freeBoard/pro_freeBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_freeBoardUpdate.bo")
	public String profreeBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("자유게시판 글 수정 b :::: " + b);
		
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
			
			System.out.println("자유게시판 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:pro_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:pro_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_deletefreeBoard.bo")
	public String profreeBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("profreeBoardDelete boardNo ::::" + boardNo);
		
		try {
			bs.deletefreeBoard(boardNo);
			
			return "forward:pro_freeBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////교직원 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 자유게시판///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 자유게시판///////////////////////////////////////////////////////
	
	@RequestMapping(value="em_freeBoardList.bo")
	public String emfreeBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectfreeBoardCount();
			
			System.out.println("em_freeBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectfreeBoardList(pi);
			
			System.out.println("교직원 자유게시판 list :::: " + list);
			System.out.println("교직원 자유게시판 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/schoolLife/freeBoard/em_freeBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("em_freeBoardsearch.bo")
	public String emfreeBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchefreeBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchfreeBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "employee/board/schoolLife/freeBoard/em_freeBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_freeBoardDetail.bo")
	public String emfreeBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("em_freeBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/freeBoard/em_freeBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/freeBoard/em_freeBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_showInsertfreeBoard.bo")
	public String emShowfreeBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emShowfreeBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectFreeBoardemWriter(memberId);
		
		System.out.println("selectFreeBoardemWriter writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/schoolLife/freeBoard/em_freeBoardInsert";	
	} 
	
	@RequestMapping(value="em_freeBoardInsert.bo")
	public String emfreeBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_freeBoardInsert.bo photo :::: " + photo);
		System.out.println("em_freeBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_freeBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_freeBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertfreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertfreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showUpdatefreeBoard.bo")
	public String emShowUpdatefreeBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/freeBoard/em_freeBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				System.out.println("자유게시판 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/freeBoard/em_freeBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_freeBoardUpdate.bo")
	public String emfreeBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("자유게시판 글 수정 b :::: " + b);
		
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
			
			System.out.println("자유게시판 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_freeBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_freeBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deletefreeBoard.bo")
	public String emfreeBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("emfreeBoardDelete boardNo ::::" + boardNo);
		
		try {
			bs.deletefreeBoard(boardNo);
			
			return "forward:em_freeBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
	
	@RequestMapping(value="st_praiseBoardList.bo")
	public String stpraiseBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectpraiseBoardCount();
			
			System.out.println("st_praiseBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectpraiseBoardList(pi);
			
			System.out.println("학생 칭찬합시다 list :::: " + list);
			System.out.println("학생 칭찬합시다 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/schoolLife/praiseBoard/st_praiseBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("st_praiseBoardsearch.bo")
	public String stpraiseBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchepraiseBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchpraiseBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "student/board/schoolLife/praiseBoard/st_praiseBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_praiseBoardDetail.bo")
	public String stpraiseBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("st_praiseBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectpraiseBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);

				return "student/board/schoolLife/praiseBoard/st_praiseBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/schoolLife/praiseBoard/st_praiseBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="st_showInsertpraiseBoard.bo")
	public String stShowpraiseBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("stShowpraiseBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectpraiseBoardstWriter(memberId);
		
		System.out.println("selectpraiseBoardstWriter writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "student/board/schoolLife/praiseBoard/st_praiseBoardInsert";	
	} 
	
	@RequestMapping(value="st_praiseBoardInsert.bo")
	public String stpraiseBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("st_praiseBoardInsert.bo photo :::: " + photo);
		System.out.println("st_praiseBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("st_praiseBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("st_praiseBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertpraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:st_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertpraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:st_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_showUpdatepraiseBoard.bo")
	public String stShowUpdatepraiseBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("자유게시판 상세보기 Ctrl b :::: " + b);
				
				return "student/board/schoolLife/praiseBoard/st_praiseBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "student/board/schoolLife/praiseBoard/st_praiseBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_praiseBoardUpdate.bo")
	public String stpraiseBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("칭찬합시다 글 수정 b :::: " + b);
		
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
			
			System.out.println("칭찬합시다 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:st_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:st_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_deletepraiseBoard.bo")
	public String stpraiseBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectpraise boardNo ::::" + boardNo);
		
		try {
			bs.deletepraiseBoard(boardNo);
			
			return "forward:st_praiseBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
	@RequestMapping(value="pro_praiseBoardList.bo")
	public String propraiseBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectpraiseBoardCount();
			
			System.out.println("pro_praiseBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectpraiseBoardList(pi);
			
			System.out.println("교수 칭찬합시다 list :::: " + list);
			System.out.println("교수 칭찬합시다 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/schoolLife/praiseBoard/pro_praiseBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("pro_praiseBoardsearch.bo")
	public String propraiseBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchepraiseBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchpraiseBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "professor/board/schoolLife/praiseBoard/pro_praiseBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_praiseBoardDetail.bo")
	public String propraiseBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("pro_praiseBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectpraiseBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "professor/board/schoolLife/praiseBoard/pro_praiseBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/schoolLife/praiseBoard/pro_praiseBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="pro_showInsertpraiseBoard.bo")
	public String proShowpraiseBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("proShowpraiseBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectpraiseBoardstWriter(memberId);
		
		System.out.println("proShowpraiseBoardInsert writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "professor/board/schoolLife/praiseBoard/pro_praiseBoardInsert";	
	} 
	
	@RequestMapping(value="pro_praiseBoardInsert.bo")
	public String propraiseBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("pro_praiseBoardInsert.bo photo :::: " + photo);
		System.out.println("pro_praiseBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("pro_praiseBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("pro_praiseBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertpraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:pro_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertpraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:pro_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_showUpdatepraiseBoard.bo")
	public String proShowUpdatepraiseBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				
				return "professor/board/schoolLife/praiseBoard/pro_praiseBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "professor/board/schoolLife/praiseBoard/pro_praiseBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_praiseBoardUpdate.bo")
	public String propraiseBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("칭찬합시다 글 수정 b :::: " + b);
		
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
			
			System.out.println("칭찬합시다 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:pro_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:pro_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_deletepraiseBoard.bo")
	public String propraiseBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectpraise boardNo ::::" + boardNo);
		
		try {
			bs.deletepraiseBoard(boardNo);
			
			return "forward:pro_praiseBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 칭찬합시다///////////////////////////////////////////////////////
	@RequestMapping(value="em_praiseBoardList.bo")
	public String empraiseBoardList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.selectpraiseBoardCount();
			
			System.out.println("em_praiseBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectpraiseBoardList(pi);
			
			System.out.println("교직원 칭찬합시다 list :::: " + list);
			System.out.println("교직원 칭찬합시다 pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/schoolLife/praiseBoard/em_praiseBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("em_praiseBoardsearch.bo")
	public String empraiseBoardSearch(String searchCondition, String searchValue, boolean searchflag, HttpServletRequest request) {
		
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
			listCount = bs.SearchepraiseBoardResultCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.SearchpraiseBoardResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
			return "employee/board/schoolLife/praiseBoard/em_praiseBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_praiseBoardDetail.bo")
	public String empraiseBoardDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("em_praiseBoardDetail boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectpraiseBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/praiseBoard/em_praiseBoardDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/praiseBoard/em_praiseBoardDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_showInsertpraiseBoard.bo")
	public String emShowpraiseBoardInsert(Writer writerInfo, HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		
		System.out.println("emShowpraiseBoardInsert memberId :::: " + memberId);
		
		writerInfo = bs.selectpraiseBoardstWriter(memberId);
		
		System.out.println("emShowpraiseBoardInsert writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "employee/board/schoolLife/praiseBoard/em_praiseBoardInsert";	
	} 
	
	@RequestMapping(value="em_praiseBoardInsert.bo")
	public String empraiseBoardInsert(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("em_praiseBoardInsert.bo photo :::: " + photo);
		System.out.println("em_praiseBoardInsert.bo b :::: " + b);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("em_praiseBoardInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("em_praiseBoardInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertpraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertpraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showUpdatepraiseBoard.bo")
	public String emShowUpdatepraiseBoard(int boardNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/praiseBoard/em_praiseBoardUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("칭찬합시다 상세보기 Ctrl b :::: " + b);
				System.out.println("칭찬합시다 상세보기 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/praiseBoard/em_praiseBoardUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_praiseBoardUpdate.bo")
	public String empraiseBoardUpdate(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("칭찬합시다 글 수정 b :::: " + b);
		
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
			
			System.out.println("칭찬합시다 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				
				return "redirect:em_praiseBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			
			return "redirect:em_praiseBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_deletepraiseBoard.bo")
	public String empraiseBoardDelete(String boardNo, HttpServletRequest request) {
		System.out.println("delectpraise boardNo ::::" + boardNo);
		
		try {
			bs.deletepraiseBoard(boardNo);
			
			return "forward:em_praiseBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////학생 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 내 게시글 조회///////////////////////////////////////////////////////
	@RequestMapping("st_searchMyBoardList.bo")
	public String stsearchMyBoardList(HttpServletRequest request, String memberId) {
		
		System.out.println("stsearchMyBoardList memberId :::: " + memberId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardListCount(memberId);
			
			System.out.println("st_searchMyBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.searchMyBoardList(pi, memberId);
			
			System.out.println("st_searchMyBoardList list :::: " + list);
			System.out.println("st_searchMyBoardList pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/schoolLife/searchMyBoard/st_searchMyBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("st_searchMyBoardSearchList.bo")
	public String stsearchMyBoardSearchList(String searchCondition, String memberId, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		sc.setMemberId(memberId);		
		
		if(searchCondition.equals("all")) {
			sc.setAll(searchCondition);
		}
		if(searchCondition.equals("praise")) {
			sc.setPraise(searchCondition);
		}
		if(searchCondition.equals("free")) {
			sc.setFree(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.searchMyBoardSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "student/board/schoolLife/searchMyBoard/st_searchMyBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_searchMyBoardDelete.bo")
	public String stsearchMyBoardDelete(String boardNo, String memberId, HttpServletRequest request) {
		System.out.println("stsearchMyBoardDelete boardNo ::::" + boardNo);
		
		try {
			bs.searchMyBoardDelete(boardNo);
			
			request.setAttribute("memberId", memberId);
			
			return "forward:st_searchMyBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
	@RequestMapping("st_showsearchMyBoardUpdateFree.bo")
	public String stshowsearchMyBoardUpdateFree(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학생 내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardUpdateFree";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학생 내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("학생 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardUpdateFree";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping("st_showsearchMyBoardUpdatePraise.bo")
	public String stshowsearchMyBoardUpdatePraise(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학생 내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardUpdatePraise";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학생 내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("학생 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardUpdatePraise";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_searchMyBoardUpdateFree.bo")
	public String stsearchMyBoardUpdateFree(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("학생 내 게시즐 조회 자유게시판 글 수정 b :::: " + b);
		String memberId = b.getMemberId();
		
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
			
			System.out.println("학생 내 게시즐 조회 자유게시판  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:st_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:st_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_searchMyBoardUpdatePraise.bo")
	public String stsearchMyBoardUpdatePraise(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("학생 내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("학생 내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:st_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:st_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_searchMyBoardDetailFree.bo")
	public String stsearchMyBoardDetailFree(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("stsearchMyBoardDetailFree boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 Ctrl b :::: " + b);

				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardDetailFree";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardDetailFree";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="st_searchMyBoardDetailPraise.bo")
	public String stsearchMyBoardDetailPraise(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("stsearchMyBoardDetailFree boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardDetailPraise";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "student/board/schoolLife/searchMyBoard/st_searchMyBoardDetailPraise";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
///////////////////////////////////////////////////////교수 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 내 게시글 조회///////////////////////////////////////////////////////
	
	@RequestMapping("pro_searchMyBoardList.bo")
	public String prosearchMyBoardList(HttpServletRequest request, String memberId) {
		
		System.out.println("prosearchMyBoardList memberId :::: " + memberId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardListCount(memberId);
			
			System.out.println("st_searchMyBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.searchMyBoardList(pi, memberId);
			
			System.out.println("prosearchMyBoardList list :::: " + list);
			System.out.println("prosearchMyBoardList pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("pro_searchMyBoardSearchList.bo")
	public String prosearchMyBoardSearchList(String searchCondition, String memberId, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		sc.setMemberId(memberId);		
		
		if(searchCondition.equals("all")) {
			sc.setAll(searchCondition);
		}
		if(searchCondition.equals("praise")) {
			sc.setPraise(searchCondition);
		}
		if(searchCondition.equals("free")) {
			sc.setFree(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.searchMyBoardSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_searchMyBoardDelete.bo")
	public String prosearchMyBoardDelete(String boardNo, String memberId, HttpServletRequest request) {
		System.out.println("prosearchMyBoardDelete boardNo ::::" + boardNo);
		
		try {
			bs.searchMyBoardDelete(boardNo);
			
			request.setAttribute("memberId", memberId);
			
			return "forward:pro_searchMyBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
	@RequestMapping("pro_showsearchMyBoardUpdateFree.bo")
	public String proshowsearchMyBoardUpdateFree(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교수 내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardUpdateFree";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("교수 내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("교수 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardUpdateFree";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping("pro_showsearchMyBoardUpdatePraise.bo")
	public String proshowsearchMyBoardUpdatePraise(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("학생 내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardUpdatePraise";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("교수 내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("교수 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardUpdatePraise";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_searchMyBoardUpdateFree.bo")
	public String prosearchMyBoardUpdateFree(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("교수 내 게시즐 조회 자유게시판 글 수정 b :::: " + b);
		String memberId = b.getMemberId();
		
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
			
			System.out.println("교수 내 게시즐 조회 자유게시판  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:pro_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:pro_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_searchMyBoardUpdatePraise.bo")
	public String prosearchMyBoardUpdatePraise(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("학생 내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("교수 내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:pro_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:pro_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_searchMyBoardDetailFree.bo")
	public String prosearchMyBoardDetailFree(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("prosearchMyBoardDetailFree boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 Ctrl b :::: " + b);

				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardDetailFree";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardDetailFree";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="pro_searchMyBoardDetailPraise.bo")
	public String prosearchMyBoardDetailPraise(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("prosearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardDetailPraise";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "professor/board/schoolLife/searchMyBoard/pro_searchMyBoardDetailPraise";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
///////////////////////////////////////////////////////교직원 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 내 게시글 조회///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교직원 내 게시글 조회///////////////////////////////////////////////////////
	@RequestMapping("em_searchMyBoardList.bo")
	public String emsearchMyBoardList(HttpServletRequest request, String memberId) {
		
		System.out.println("emsearchMyBoardList memberId :::: " + memberId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardListCount(memberId);
			
			System.out.println("emsearchMyBoardList listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.searchMyBoardList(pi, memberId);
			
			System.out.println("emsearchMyBoardList list :::: " + list);
			System.out.println("emsearchMyBoardList pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}		
	}
	
	@RequestMapping("em_searchMyBoardSearchList.bo")
	public String emsearchMyBoardSearchList(String searchCondition, String memberId, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		sc.setMemberId(memberId);		
		
		if(searchCondition.equals("all")) {
			sc.setAll(searchCondition);
		}
		if(searchCondition.equals("praise")) {
			sc.setPraise(searchCondition);
		}
		if(searchCondition.equals("free")) {
			sc.setFree(searchCondition);
		}
		if(searchCondition.equals("normal")) {
			sc.setNormal(searchCondition);
		}
		if(searchCondition.equals("schol")) {
			sc.setSchol(searchCondition);
		}
		if(searchCondition.equals("event")) {
			sc.setEvent(searchCondition);
		}
		if(searchCondition.equals("schedule")) {
			sc.setSchedule(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.searchMyBoardSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.searchMyBoardSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_searchMyBoardDelete.bo")
	public String emsearchMyBoardDelete(String boardNo, String memberId, HttpServletRequest request) {
		System.out.println("emsearchMyBoardDelete boardNo ::::" + boardNo);
		
		try {
			bs.searchMyBoardDelete(boardNo);
			
			request.setAttribute("memberId", memberId);
			
			return "forward:em_searchMyBoardList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}		
	}
	
	@RequestMapping("em_showsearchMyBoardUpdateFree.bo")
	public String emshowsearchMyBoardUpdateFree(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectfreeBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("교직원 내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateFree";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("교수 내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("교수 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateFree";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdateFree.bo")
	public String emsearchMyBoardUpdateFree(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("교수 내 게시즐 조회 자유게시판 글 수정 b :::: " + b);
		String memberId = b.getMemberId();
		
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
			
			System.out.println("교수 내 게시즐 조회 자유게시판  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatefreeBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatefreeBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showsearchMyBoardUpdatePraise.bo")
	public String emshowsearchMyBoardUpdatePraise(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectpraiseBoardOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdatePraise";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdatePraise";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdatePraise.bo")
	public String emsearchMyBoardUpdatePraise(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("학생 내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatepraiseBoardwithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatepraiseBoard(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showsearchMyBoardUpdateNormal.bo")
	public String emshowsearchMyBoardUpdateNormal(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectOneBoard(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateNormal";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateNormal";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdateNormal.bo")
	public String emsearchMyBoardUpdateNormal(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatenNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatenNotice(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showsearchMyBoardUpdateSchol.bo")
	public String emshowsearchMyBoardUpdateSchol(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectsNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateSchol";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateSchol";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdateSchol.bo")
	public String emsearchMyBoardUpdateSchol(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updatesNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updatesNotice(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showsearchMyBoardUpdateSchedule.bo")
	public String emshowsearchMyBoardUpdateSchedule(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selectacNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateSchedule";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateSchedule";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdateSchedule.bo")
	public String emsearchMyBoardUpdateSchedule(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateacNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateacNotice(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("em_showsearchMyBoardUpdateEvent.bo")
	public String emshowsearchMyBoardUpdateEvent(int boardNo, String memberId, String boardType, HttpServletRequest request) {
		
		System.out.println("update전 select용 boardNo :::: " + boardNo);
		System.out.println("update전 select용 memberId :::: " + memberId);
		System.out.println("update전 select용 boardType :::: " + boardType);
		
		Board b;
		UploadFile uf;
		try {
			b = bs.selecteNoticeOne(boardNo);
			uf = bs.selectUploadFile(boardNo);
			
			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateEvent";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("내 게시물 업데이트 Ctrl b :::: " + b);
				System.out.println("내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("b", b);
				request.setAttribute("uf", uf);
			
				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardUpdateEvent";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_searchMyBoardUpdateEvent.bo")
	public String emsearchMyBoardUpdateEvent(Model model, Board b, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("내 게시즐 조회 칭찬합시다 글 수정 b :::: " + b);
		
		String memberId = b.getMemberId();
		
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
			
			System.out.println("내 게시즐 조회 칭찬합시다  글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateeNoticewithFile(b, uf);
				
				model.addAttribute("b", b);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:em_searchMyBoardList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateeNotice(b);
			
			model.addAttribute("b", b);
			model.addAttribute("memberId", memberId);
			
			return "redirect:em_searchMyBoardList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailFree.bo")
	public String emsearchMyBoardDetailFree(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailFree boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailFree";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 자유게시판 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailFree";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailPraise.bo")
	public String emsearchMyBoardDetailPraise(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectfreeBoardOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailPraise";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailPraise";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailNormal.bo")
	public String emsearchMyBoardDetailNormal(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectOneBoard(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailNormal";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailNormal";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailSchol.bo")
	public String emsearchMyBoardDetailSchol(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectsNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailSchol";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailSchol";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailSchedule.bo")
	public String emsearchMyBoardDetailSchedule(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selectacNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailSchedule";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailSchedule";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_searchMyBoardDetailEvent.bo")
	public String emsearchMyBoardDetailEvent(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		System.out.println("emsearchMyBoardDetailPraise boardNo :::: " + boardNo);

		Board b;
		UploadFile uf;

		try {
			b = bs.selecteNoticeOne(boardNo);

			uf = bs.selectUploadFile(boardNo);


			if(uf == null) {
				request.setAttribute("b", b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 Ctrl b :::: " + b);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailEvent";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + b);
				System.out.println("내 게시글 조회 칭찬합시다 상세보기 :::: " + uf);

				request.setAttribute("b", b);
				request.setAttribute("uf", uf);

				return "employee/board/schoolLife/searchMyBoard/em_searchMyBoardDetailEvent";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
	
	@RequestMapping(value="st_systemQuestionList.bo")
	public String stsystemQuestionList(HttpServletRequest request, String memberId) {
		
		System.out.println("시스템문의 List memberId :::: " + memberId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.systemQuestionListCount(memberId);
			
			System.out.println("시스템문의 List listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.systemQuestionList(pi, memberId);
			
			System.out.println("시스템문의 list list :::: " + list);
			System.out.println("시스템문의 List pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "student/board/systemQuestion/st_systemQuestionList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_systemQuestionSearchList.bo")
	public String stsystemQuestionSearchList(String searchCondition, String memberId, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		sc.setMemberId(memberId);		
		
		if(searchCondition.equals("account")) {
			sc.setAccount(searchCondition);
		}
		if(searchCondition.equals("proof")) {
			sc.setProof(searchCondition);
		}
		if(searchCondition.equals("school")) {
			sc.setSchool(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.systemQuestionSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.systemQuestionSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "student/board/systemQuestion/st_systemQuestionList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_showInsertSystemQuestion.bo")
	public String stShowInsertSystemQuestion(HttpServletRequest request, Writer writerInfo) {
	
		String memberId = request.getParameter("memberId");
		
		System.out.println("stShowInsertSystemQuestion memberId :::: " + memberId);
		
		writerInfo = bs.selectSystemQuestionWriter(memberId);
		
		System.out.println("stShowInsertSystemQuestion writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "student/board/systemQuestion/st_systemQuestionInsert";	
	}
	
	@RequestMapping(value="st_SystemQuestionInsert.bo")
	public String stSystemQuestionInsert(Model model, SystemQuestion sq, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("stSystemQuestionInsert.bo photo :::: " + photo);
		System.out.println("stSystemQuestionInsert.bo sq :::: " + sq);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("stSystemQuestionInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("stSystemQuestionInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertSystemQuestionwithFile(sq, uf);
				
				model.addAttribute("sq", sq);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", sq.getMemberId());
				
				return "redirect:st_systemQuestionList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertSystemQuestion(sq);
			
			model.addAttribute("sq", sq);
			model.addAttribute("memberId", sq.getMemberId());
			
			return "redirect:st_systemQuestionList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="st_SystemQuestionDetail.bo")
	public String stSystemQuestionDetail(HttpServletRequest request) {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		System.out.println("stSystemQuestionDetail questionNo :::: " + questionNo);

		SystemQuestion sq;
		UploadFile uf;

		try {
			sq = bs.selectSystemQuestionOne(questionNo);

			uf = bs.selectSystemQuestionFile(questionNo);


			if(uf == null) {
				request.setAttribute("sq", sq);
				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);

				return "student/board/systemQuestion/st_systemQuestionDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);
				System.out.println("시스템문의 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("sq", sq);
				request.setAttribute("uf", uf);

				return "student/board/systemQuestion/st_systemQuestionDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping("st_showSystemQuestionUpdate.bo")
	public String stshowSystemQuestionUpdate(int questionNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 questionNo :::: " + questionNo);
		
		SystemQuestion sq;
		UploadFile uf;
		try {
			sq = bs.selectSystemQuestionOne(questionNo);
			uf = bs.selectSystemQuestionFile(questionNo);
			
			if(uf == null) {
				request.setAttribute("sq", sq);
				System.out.println("시스템문의 업데이트 Ctrl sq :::: " + sq);
				
				return "student/board/systemQuestion/st_systemQuestionUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학생 내 게시물 업데이트 Ctrl sq :::: " + sq);
				System.out.println("학생 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("sq", sq);
				request.setAttribute("uf", uf);
			
				return "student/board/systemQuestion/st_systemQuestionUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="st_SystemQuestionUpdate.bo")
	public String stSystemQuestionUpdate(Model model, SystemQuestion sq, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("시스템문의 글 수정 sq :::: " + sq);
		
		String memberId = sq.getMemberId();
		
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
			
			System.out.println("시스템문의 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateSystemQuestionwithFile(sq, uf);
				
				model.addAttribute("sq", sq);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:st_systemQuestionList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateSystemQuestion(sq);
			
			model.addAttribute("sq", sq);
			model.addAttribute("memberId", memberId);
			
			return "redirect:st_systemQuestionList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("st_SystemQuestionDelete.bo")
	public String stSystemQuestionDelete(int questionNo, String memberId, HttpServletRequest request) {
		System.out.println("stsearchMyBoardDelete boardNo ::::" + questionNo);
		
		try {
			bs.SystemQuestionDelete(questionNo);
			
			request.setAttribute("memberId", memberId);
			
			return "forward:st_systemQuestionList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////교수 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////교수 시스템 문의///////////////////////////////////////////////////////
	
	@RequestMapping(value="pro_systemQuestionList.bo")
	public String prosystemQuestionList(HttpServletRequest request, String memberId) {
		
		System.out.println("시스템문의 List memberId :::: " + memberId);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = bs.systemQuestionListCount(memberId);
			
			System.out.println("시스템문의 List listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.systemQuestionList(pi, memberId);
			
			System.out.println("시스템문의 list list :::: " + list);
			System.out.println("시스템문의 List pi :::: " + pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			return "professor/board/systemQuestion/pro_systemQuestionList";
			
		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_systemQuestionSearchList.bo")
	public String prosystemQuestionSearchList(String searchCondition, String memberId, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();
		
		sc.setMemberId(memberId);		
		
		if(searchCondition.equals("account")) {
			sc.setAccount(searchCondition);
		}
		if(searchCondition.equals("proof")) {
			sc.setProof(searchCondition);
		}
		if(searchCondition.equals("school")) {
			sc.setSchool(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.systemQuestionSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<Board> list = bs.systemQuestionSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "professor/board/systemQuestion/pro_systemQuestionList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_showInsertSystemQuestion.bo")
	public String proShowInsertSystemQuestion(HttpServletRequest request, Writer writerInfo) {
	
		String memberId = request.getParameter("memberId");
		
		System.out.println("stShowInsertSystemQuestion memberId :::: " + memberId);
		
		writerInfo = bs.selectSystemQuestionWriter(memberId);
		
		System.out.println("stShowInsertSystemQuestion writerInfo :::: " + writerInfo);
		
		request.setAttribute("writerInfo", writerInfo);
		
		return "professor/board/systemQuestion/pro_systemQuestionInsert";	
	}
	
	@RequestMapping(value="pro_SystemQuestionInsert.bo")
	public String proSystemQuestionInsert(Model model, SystemQuestion sq, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("stSystemQuestionInsert.bo photo :::: " + photo);
		System.out.println("stSystemQuestionInsert.bo sq :::: " + sq);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("stSystemQuestionInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("stSystemQuestionInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertSystemQuestionwithFile(sq, uf);
				
				model.addAttribute("sq", sq);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", sq.getMemberId());
				
				return "redirect:pro_systemQuestionList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertSystemQuestion(sq);
			
			model.addAttribute("sq", sq);
			model.addAttribute("memberId", sq.getMemberId());
			
			return "redirect:pro_systemQuestionList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="pro_SystemQuestionDetail.bo")
	public String proSystemQuestionDetail(HttpServletRequest request) {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		System.out.println("stSystemQuestionDetail questionNo :::: " + questionNo);

		SystemQuestion sq;
		UploadFile uf;

		try {
			sq = bs.selectSystemQuestionOne(questionNo);

			uf = bs.selectSystemQuestionFile(questionNo);


			if(uf == null) {
				request.setAttribute("sq", sq);
				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);

				return "professor/board/systemQuestion/pro_systemQuestionDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);
				System.out.println("시스템문의 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("sq", sq);
				request.setAttribute("uf", uf);

				return "professor/board/systemQuestion/pro_systemQuestionDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping("pro_showSystemQuestionUpdate.bo")
	public String proshowSystemQuestionUpdate(int questionNo, HttpServletRequest request) {
		
		System.out.println("update전 select용 questionNo :::: " + questionNo);
		
		SystemQuestion sq;
		UploadFile uf;
		try {
			sq = bs.selectSystemQuestionOne(questionNo);
			uf = bs.selectSystemQuestionFile(questionNo);
			
			if(uf == null) {
				request.setAttribute("sq", sq);
				System.out.println("시스템문의 업데이트 Ctrl sq :::: " + sq);
				
				return "professor/board/systemQuestion/pro_systemQuestionUpdate";
				
			} else {
				
				String realPath = uf.getPath().split("webapp")[1];
				
				System.out.println(realPath);
				
				uf.setPath("/finalProject/" + realPath);
				
				System.out.println("학생 내 게시물 업데이트 Ctrl sq :::: " + sq);
				System.out.println("학생 내 게시물 업데이트 Ctrl uf :::: " + uf);
				
				request.setAttribute("sq", sq);
				request.setAttribute("uf", uf);
			
				return "professor/board/systemQuestion/pro_systemQuestionUpdate";
			}
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="pro_SystemQuestionUpdate.bo")
	public String proSystemQuestionUpdate(Model model, SystemQuestion sq, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {	
		
		System.out.println("시스템문의 글 수정 sq :::: " + sq);
		
		String memberId = sq.getMemberId();
		
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
			
			System.out.println("시스템문의 글 수정 uf :::: " + uf);
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.updateSystemQuestionwithFile(sq, uf);
				
				model.addAttribute("sq", sq);
				model.addAttribute("uf", uf);
				model.addAttribute("memberId", memberId);
				
				return "redirect:pro_systemQuestionList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글 수정 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			bs.updateSystemQuestion(sq);
			
			model.addAttribute("sq", sq);
			model.addAttribute("memberId", memberId);
			
			return "redirect:pro_systemQuestionList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글 수정 실패!");
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping("pro_SystemQuestionDelete.bo")
	public String proSystemQuestionDelete(int questionNo, String memberId, HttpServletRequest request) {
		System.out.println("stsearchMyBoardDelete boardNo ::::" + questionNo);
		
		try {
			bs.SystemQuestionDelete(questionNo);
			
			request.setAttribute("memberId", memberId);
			
			return "forward:pro_systemQuestionList.bo";
		} catch (BoardDeleteException e) {			
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
		
	}
	
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////
///////////////////////////////////////////////////////학생 시스템 문의///////////////////////////////////////////////////////

	@RequestMapping(value="em_systemQuestionList.bo")
	public String emsystemQuestionList(HttpServletRequest request) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = bs.emsystemQuestionListCount();

			System.out.println("시스템문의 List listCount :::: " + listCount);

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<SystemQuestion> list = bs.emsystemQuestionList(pi);

			System.out.println("시스템문의 list list :::: " + list);
			System.out.println("시스템문의 List pi :::: " + pi);

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);

			return "employee/board/systemQuestion/em_systemQuestionList";

		} catch (BoardSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}	
	}
	
	@RequestMapping(value="em_systemQuestionSearchList.bo")
	public String emsystemQuestionSearchList(String searchCondition, boolean searchflag, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("currentPage :::: " + currentPage);
		System.out.println("searchflag :::: " + searchflag);
		
		SearchCondition sc = new SearchCondition();		
		
		if(searchCondition.equals("account")) {
			sc.setAccount(searchCondition);
		}
		if(searchCondition.equals("proof")) {
			sc.setProof(searchCondition);
		}
		if(searchCondition.equals("school")) {
			sc.setSchool(searchCondition);
		}
		
		System.out.println("sc :::: " + sc);
		
		int listCount;
		
		try {
			listCount = bs.emsystemQuestionSearchListCount(sc);
			
			System.out.println("검색후 listCount :::: " + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			pi.setSearchflag(searchflag);
			
			System.out.println("검색후 pi :::: " + pi);
			
			ArrayList<SystemQuestion> list = bs.emsystemQuestionSearchList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("searchCondition", searchCondition);
			
			return "employee/board/systemQuestion/em_systemQuestionList";
		} catch (BoardSearchException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";	
		}
	}
	
	@RequestMapping(value="em_SystemQuestionDetail.bo")
	public String emSystemQuestionDetail(HttpServletRequest request) {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		System.out.println("stSystemQuestionDetail questionNo :::: " + questionNo);

		SystemQuestion sq;
		UploadFile uf;

		try {
			sq = bs.selectSystemQuestionOne(questionNo);

			uf = bs.selectSystemQuestionFile(questionNo);


			if(uf == null) {
				request.setAttribute("sq", sq);
				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);

				return "employee/board/systemQuestion/em_systemQuestionDetail";

			} else {

				String realPath = uf.getPath().split("webapp")[1];

				System.out.println(realPath);

				uf.setPath("/finalProject/" + realPath);

				System.out.println("시스템문의 상세보기 Ctrl sq :::: " + sq);
				System.out.println("시스템문의 상세보기 Ctrl uf :::: " + uf);

				request.setAttribute("sq", sq);
				request.setAttribute("uf", uf);

				return "employee/board/systemQuestion/em_systemQuestionDetail";		
			}
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="em_showSystemQuestionAnswer.bo")
	public String emshowSystemQuestionAnswer(int questionNo, HttpServletRequest request) {
	
		System.out.println("update전 select용 questionNo :::: " + questionNo);
		
		SystemQuestion sq;
		UploadFile uf;
		try {
			sq = bs.selectSystemQuestionOne(questionNo);
			
			request.setAttribute("sq", sq);
			
			System.out.println("시스템문의 답글 달기 Ctrl sq :::: " + sq);
			
			return "employee/board/systemQuestion/em_systemQuestionAnswer";				
			
		} catch (BoardSelectOneException e) {
			request.setAttribute("msg", e.getMessage());
			
			return "common/errorAlert";
		}	
	}	
	
	@RequestMapping(value="em_SystemQuestionAnswer.bo")
	public String emSystemQuestionAnswer(Model model, SystemQuestion sq, UploadFile uf, HttpServletRequest request, @RequestParam(name="photo", required=false) MultipartFile photo) {
		System.out.println("stSystemQuestionInsert.bo photo :::: " + photo);
		System.out.println("stSystemQuestionInsert.bo sq :::: " + sq);	
		
		String root;
		String filePath;
		String originFileName;
		String ext;
		String changeName;
		
		
		if(photo.getOriginalFilename().length() > 0) {
			root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("stSystemQuestionInsert.bo root :::: " + root);
			
			filePath = root + "\\uploadFiles";
			originFileName = photo.getOriginalFilename();
			
			System.out.println("stSystemQuestionInsert.bo originFileName :::: " + originFileName);
			
			ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			changeName = CommonUtils.getRandomString();
			
			uf.setOldName(originFileName);
			uf.setChangeName(changeName + ext);
			uf.setPath(filePath + "\\" + changeName + ext);	
			
			try{	
				
				photo.transferTo(new File(filePath + "\\" + changeName + ext));
				
				bs.insertSystemQuestionAnswerwithFile(sq, uf);
				
				model.addAttribute("sq", sq);
				model.addAttribute("uf", uf);
				
				return "redirect:em_systemQuestionList.bo";
				
			}catch(Exception e) {
				new File(filePath + "\\" + changeName + ext).delete();
				
				model.addAttribute("msg", "글쓰기 실패!");
				
				return "common/errorAlert";
			}
		}
		
		try{			
			
			bs.insertSystemQuestionAnswer(sq);
			
			model.addAttribute("sq", sq);
			
			return "redirect:em_systemQuestionList.bo";
			
		}catch(Exception e) {
			
			model.addAttribute("msg", "글쓰기 실패!");
			
			return "common/errorAlert";	
		}
	}
	
}











