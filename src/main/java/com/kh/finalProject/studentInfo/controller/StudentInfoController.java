package com.kh.finalProject.studentInfo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.service.StudentInfoService;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;


@Controller
@SessionAttributes("loginUser")
public class StudentInfoController {
	
	@Autowired
	private StudentInfoService ss;
	
	//학생_학적관리_학적정보조회
	@RequestMapping(value="st_studentInfo.si")
	public String infoMain(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo stuInfo = ss.stuInfo(userId);
		
		System.out.println(basicInfo);
		System.out.println(stuInfo);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);
		
		return "student/info/studentInfo";
	}
	
	//학생_학적관리_신상관리
	@RequestMapping(value="st_personalInfo.si")
	public String personalInfo(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo personalInfo = ss.personInfoManage(userId);
		
		System.out.println(basicInfo);
		System.out.println(personalInfo);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("personalInfo",personalInfo);
		
		return "student/info/studentPersonalInfo";
	}
	
	
	//학생_학적관리_신상정보 수정
	@RequestMapping(value="st_changePersonalInfo.si")
	public String changePersonalInfo(Model model, StudentInfo si, HttpServletRequest request,
													@ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		System.out.println(si);
		
		String postcode1 = request.getParameter("postcode1");
		String address1 = request.getParameter("address1");
		String detailAddress1 = request.getParameter("detailAddress1");
		
		System.out.println(postcode1);
		System.out.println(address1);
		System.out.println(detailAddress1);
		
		String studentAddress = postcode1 + "/" + address1 + "/" + detailAddress1;
		System.out.println("학생주소::"+studentAddress);

		
		String postcode2 = request.getParameter("postcode2");
		String address2 = request.getParameter("address2");
		String detailAddress2 = request.getParameter("detailAddress2");
		
		System.out.println(postcode2);
		System.out.println(address2);
		System.out.println(detailAddress2);
		
		String parentsAddress = postcode2 + "/" + address2 + "/" + detailAddress2;
		System.out.println("보호자주소::"+parentsAddress);
		
		si.setStudentNo(userId);
		si.setAddress(studentAddress);
		si.setParentsAddress(parentsAddress);
		
		System.out.println(si);
		
		int result = ss.changePersonalInfo(si);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo personalInfo = ss.personInfoManage(userId);
		
		System.out.println(basicInfo);
		System.out.println(personalInfo);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("personalInfo",personalInfo);
		
		
		if(result>0) {
			return "student/info/studentPersonalInfo";			
		}else {
			model.addAttribute("msg","신상정보 수정 실패");
			return "common/errorPage";	
		}
	}
	
	
	//교직원_학생전체조회
	@RequestMapping(value="em_studentInfoList.si")
	public String studentInfoList(HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount;
		
		try {
			listCount = ss.getListCount();
			
			System.out.println("listCount::" + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage,listCount);
			
			ArrayList<StudentInfo> list = ss.selectStudentList(pi);
			
			System.out.println("list ::" + list);
			System.out.println("pi ::" + pi);
			
			request.setAttribute("list",list);
			request.setAttribute("pi",pi);
			
			return "employee/studentInfo/studentList";
			
		} catch (StudentInfoSelectListException e) {
			request.setAttribute("msg",e.getMessage());
			
			return "common/errorPage";
		}
		
	}
	
	//교직원_학생 전체조회 (ajax페이징)
	@RequestMapping(value="em_studentListNext.si",produces="application/json;charset=utf8")
	public ModelAndView studentListNext(ModelAndView mv, HttpServletRequest request) {
		
		System.out.println("requestCurrentPage::" + request.getParameter("currentPage"));
		
		int currentPage=1;
		int listCount=0;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		try {
			listCount = ss.getListCount();
			
			System.out.println("listCount::" + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage,listCount);
			
			ArrayList<StudentInfo> list = ss.selectStudentList(pi);
			
			System.out.println("list ::" + list);
			System.out.println("pi ::" + pi);
			
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			
			mv.setViewName("jsonView");
			
			System.out.println(mv.getViewName());
			System.out.println(mv.getModel());
			
			return mv;
			
		} catch (StudentInfoSelectListException e) {
			mv.addObject("msg",e.getMessage());
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
		
	}
	
	//교직원_학생전체 조회 필터링후 페이징
	@RequestMapping("em_studentListFilter.si")
	public ModelAndView studentListFilter(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String college = request.getParameter("collegeCondition");
		String sdept = request.getParameter("sdeptCondition");
		String grade = request.getParameter("gradeCondition");
		String status = request.getParameter("statusCondition");
		
		System.out.println("college::" + college);
		System.out.println("sdept::" + sdept);
		System.out.println("grade::" + grade);
		System.out.println("status::" + status);
		
		FilterCondition fc = new FilterCondition();
		
		fc.setCollege(college);
		fc.setSdeptName(sdept);
		fc.setGrade(grade);
		fc.setStudentStatus(status);
		
		
		int listCount;
		
		try {
			listCount = ss.getFilterListCount(fc);
			
			System.out.println("필터링후 listCount::" + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage,listCount);
			
			ArrayList<StudentInfo> list = ss.selectFilterStudent(fc,pi);
			
			System.out.println("list ::" + list);
			System.out.println("pi ::" + pi);
			
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			
			mv.setViewName("jsonView");
			
			System.out.println(mv.getViewName());
			System.out.println(mv.getModel());
			
			return mv;
			
			
		} catch (StudentInfoSelectListException e) {
			mv.addObject("msg",e.getMessage());
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
		
	}
	
	//교직원_학생조회 필터링 단과대선택
	@RequestMapping("em_selectCollege.si")
	public ModelAndView selectCollege(ModelAndView mv, HttpServletRequest request) {
		
		String college = request.getParameter("college");
		
		System.out.println(college);
				
		try {
			ArrayList list = ss.selectCollegeFilter(college);
			
			System.out.println(list);
			
			mv.addObject("list",list);
			mv.setViewName("jsonView");
			
			System.out.println("mv.getModel::" + mv.getModel());
			
			return mv;
			
		} catch (StudentInfoSelectListException e) {
			mv.addObject("msg",e.getMessage());
			
			mv.setViewName("common/errorPage");
			
			return mv;
		}
		
	}
	
	
	//교직원_학생조회 필터링 초기값
	@RequestMapping("em_studentSelectBox.si")
	public ModelAndView studentSelectBox(ModelAndView mv, HttpServletRequest request) {
				
				try {
					ArrayList collegeList = ss.selectcollege();
					System.out.println(collegeList);
					
					ArrayList sdeptList = ss.selectSdeptList();
					System.out.println(sdeptList);
					
					mv.addObject("collegeList", collegeList);
					mv.addObject("sdeptList", sdeptList);
					mv.setViewName("jsonView");
					
					System.out.println("mv.getModel::" + mv.getModel());
					
					return mv;
					
				} catch (StudentInfoSelectListException e) {
					mv.addObject("msg",e.getMessage());
					
					mv.setViewName("common/errorPage");
					
					return mv;
				}
				
			}	
	
	
	//교직원_학생조회_학생선택
	@RequestMapping(value="em_selectStudent.si")
	public String selectStudent(HttpServletRequest request) {
		
		return "student/info/studentDetail";
	}
	
	//학생_졸업관리
	@RequestMapping(value="st_graduation.si")
	public String graduationManagement(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		request.setAttribute("basicInfo",basicInfo);
		
		try {
			ArrayList<Graduation> list = ss.selectGraduationCondition(userId);
			
			System.out.println("list::" + list);
			
			String division="";
			String check="";
			for(int i=0 ; i<list.size() ; i++) {
				
				division = list.get(i).getsDeptCode();
				if(division.equals("SD100")) {
					list.get(i).setDivision("교내 인증");
				}else {
					list.get(i).setDivision("학과 인증");
				}
				
				check = list.get(i).getCheck();
				if(check.equals("Y")) {
					list.get(i).setCheck("통과");
				}else {
					list.get(i).setCheck("미통과");
				}
			}
			
			System.out.println("list::" + list);
			request.setAttribute("list",list);
			
			return "student/info/graduationManagement";
			
		} catch (StudentInfoSelectListException e) {
			request.setAttribute("msg",e.getMessage());
			
			return "common/errorPage";
		}
		
		
	}
	

  
	// 학생_다전공신청_뷰 출력
	@RequestMapping("st_showSecondMajor.si")
	public String st_showSecondMajor(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {
		
		String userId = loginUser.getMemberId();
		System.out.println(userId);
		
		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo stuInfo = ss.stuInfo(userId);		
		ArrayList<SecondMajor> list = ss.selectSecondMajor(userId);
		
		System.out.println(basicInfo);
		System.out.println(stuInfo);
		System.out.println(list);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);
		request.setAttribute("list", list);	
  
		return "student/info/secondMajor";
	}
	
	// 학생_다전공신청_insert
	@RequestMapping("st_insertSecondMajor.si")
	public ModelAndView st_insertSecondMajor(ModelAndView mv, HttpServletRequest request, SecondMajor sm) {	
		
		System.out.println("insert 전 sm :::: " + sm);
		
		int result = ss.insertSecondMajor(sm);
		
		ArrayList<SecondMajor> list = null;
		
		if(result > 0) {
			list = ss.selectSecondMajor(sm);
		}
		
		System.out.println("select 후 list :::: " + list);
		
		mv.addObject("list", list);
		mv.setViewName("jsonView");
		
		return mv;
	}


}









