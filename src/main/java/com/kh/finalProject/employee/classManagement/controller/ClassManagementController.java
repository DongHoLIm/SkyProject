package com.kh.finalProject.employee.classManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.service.ClassManagementService;
import com.kh.finalProject.employee.classManagement.model.service.LessonPlanService;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.employee.classManagement.model.vo.SubjectDelete;
import com.kh.finalProject.professor.openSubject.model.service.OpenSubjectService;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;


@Controller
public class ClassManagementController {
	@Autowired
	ClassManagementService cms;
	@Autowired
	LessonPlanService lps;
	@Autowired
	OpenSubjectService openSubjectService;
	
	//강의개설등록
	@RequestMapping("lectureOpen.em")
	public String selectSubject(HttpServletRequest request) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = cms.getListCount();

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<LectureOpen> subjectList = cms.selectnSubjectList(pi);

			request.setAttribute("subjectList", subjectList);
			request.setAttribute("pi", pi);
			return "employee/class/lectureOpen";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	//개강과목등록 정보받아오기
	@RequestMapping(value="lectureRegistration.em")
	public String goLectureRegistration(HttpServletRequest request,@RequestParam(name="subCode", required=false) String subCode) {

		LectureOpen lo = new LectureOpen();

		System.out.println("시작합니다");
		System.out.println("subCode :::::" + subCode);
		lo = cms.selectOneSubject(subCode);
		System.out.println("다시돌아옴 !!" + lo);

		System.out.println(lo.getSdeptName());
		ArrayList<DepartmentProfessor> proList;
		try {
			proList = cms.selectProfessorList(lo.getSdeptName());
			ArrayList<ClassRoomInformation> room = cms.selectClassRoomList();
			
			
			request.setAttribute("lo", lo);
			request.setAttribute("proList", proList);
			request.setAttribute("room", room);
			
			return "employee/class/lectureRegistration";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
		
		

		
	}
	//개강과목등록
	@RequestMapping(value="insertCoursesOffered.em")
	public String insertCourseOffered(LectureOpen lo, HttpServletRequest request, 
			@RequestParam(name="proList", required=false) String proList,
			@RequestParam(name="dayWeek", required=false)String dayWeek,
			@RequestParam(name="year", required=false)int year,
			@RequestParam(name="semester", required=false)int semester,
			@RequestParam(name="period1", required=false)String period1,
			@RequestParam(name="period2", required=false)String period2,
			@RequestParam(name="room", required=false)String room,
			@RequestParam(name="personnel", required=false)int personnel)	{
		
		LectureRegistration lr = new LectureRegistration();
		String period = "";
		if(period1.equals(period2)) {
			lr.setTimeInfo(period1);
		}else {
			period = period1+","+period2;
			lr.setTimeInfo(period);
		}
		System.out.println("period:::" + period);
		String pCode[] = proList.split("/");
		String rCode[] = room.split("/");
		
		
		lr.setOpenSubCode(lo.getSubCode());
		lr.setStudentMax(personnel);
		lr.setOpenYear(year);
		lr.setOpenSemester(semester);
		lr.setProfessorNo(pCode[1]);
		lr.setBuildingName(rCode[0]);
		lr.setRoomName(rCode[1]);
		lr.setDayInfo(dayWeek);
		
		System.out.println("lr::::" + lr);
		
		cms.insertCourseOffered(lr);
		
		cms.updateSubject(lr.getOpenSubCode());
		
		
		return "redirect:/lectureOpen.em";
	}
	@RequestMapping(value="openPreliminaryCourseRegistration.em")
	public String selectCoursesOffered(HttpServletRequest request) {
		
		ArrayList<OpenSubject> list = cms.selectOpenSubjectList();
		System.out.println(list);
		request.setAttribute("list", list);
		return "employee/class/openPreliminaryCourseRegistration";
	}
	@RequestMapping(value="openFinishCourseRegistration.em")
	public String selectPreliminaryCoursesOffered(HttpServletRequest request) {
		
		ArrayList<OpenSubject> list = cms.selectPreliminaryOpenSubjectList();
		request.setAttribute("list", list);
		return "employee/class/openFinishCourseRegistration";
	}
	@RequestMapping(value="updateOpenSubject.em")
	public String updateOpenSubject(HttpServletRequest request,
		@RequestParam(name="openSubCode", required=false)String openSubCode){
			
		System.out.println(openSubCode);
		String subCode[] = openSubCode.split(",");
		
		cms.updateOpenSubject(subCode);
		
		return "employee/class/openPreliminaryCourseRegistration";
	}
	
	
	
	

	
	@RequestMapping("lessionPlan.em")
	public ModelAndView LessonPlan (ModelAndView mav) {
		List<LessonPlan> lessonPlanList = lps.selectLessonPlanServiceList();
		System.out.println("lessonPlanList : " + lessonPlanList);
		mav.addObject("lessonPlanList", lessonPlanList);
		mav.setViewName("employee/class/lessonPlan");
		return mav;
			
	
	}
	
	

	
	
	@RequestMapping(value="updateFinishOpenSubject.em")
	public String updateFinishOpenSubject(HttpServletRequest request,
		@RequestParam(name="openSubCode", required=false)String openSubCode){
			
		System.out.println(openSubCode);
		String subCode[] = openSubCode.split(",");
		
		cms.updateFinishOpenSubject(subCode);
		
		return "employee/class/openFinishCourseRegistration";
	}
	@RequestMapping(value="closeFinishCourseRegistration.em")
	public String selectFinishCoursesOffered(HttpServletRequest request) {
		
		ArrayList<OpenSubject> list = cms.selectFinishOpenSubjectList();
		request.setAttribute("list", list);
		return "employee/class/closeFinishCourseRegistration";
	}
	@RequestMapping(value="closeFinishOpenSubject.em")
	public String closeFinishOpenSubject(HttpServletRequest request,
			@RequestParam(name="openSubCode", required=false)String openSubCode){
				
			System.out.println(openSubCode);
			String subCode[] = openSubCode.split(",");
			
			cms.closeFinishOpenSubject(subCode);
			ArrayList<SubjectApply> list = cms.selectUpdateList();
			System.out.println("list :::" + list);
			cms.updateSubjectApply();
			int result = list.size();
			String[] code = new String[result];
			System.out.println("code.length::: " + code.length);
			for(int i=0;i<list.size();i++) {
				System.out.println("???");
				code[i] = list.get(i).getSubApplyCode();
				System.out.println("code:::" + code[i]);
			}
			cms.insertSubApplyDone(code);
			cms.deleteCloseSubjectApply();
			
			
			return "employee/class/closeFinishCourseRegistration";
		}
	@RequestMapping("subjectAbolition.em")
	public String selectsubjectAbolitionList(HttpServletRequest request) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = cms.getListCount2();

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<LectureOpen> subjectList = cms.selectsubjectAbolitionList(pi);

			request.setAttribute("subjectList", subjectList);
			request.setAttribute("pi", pi);
			return "employee/class/subjectAbolition";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	@RequestMapping(value="goLectureAbolitionRegistration.em")
	public String goLectureAbolitionRegistration(HttpServletRequest request,@RequestParam(name="subCode", required=false) String subCode) {

		OpenSubject os = new OpenSubject();
		LectureOpen lo = new LectureOpen();

		System.out.println("시작합니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		System.out.println("subCode :::::" + subCode);
		os = cms.selectOneOpenSubject(subCode);
		
		if(os != null) {
			System.out.println("os :::" + os);
			request.setAttribute("os", os);
		}else {
			lo = cms.selectOneSubject(subCode);
			OpenSubject os2 = new OpenSubject();
			 
			os2.setOpenSubCode(lo.getSubCode());
			os2.setSubName(lo.getSubName());
			os2.setSdeptName(lo.getSdeptName());
			
			request.setAttribute("os", os2);
		}
			return "employee/class/lectureAbolitionRegistration";
		}
	
	@RequestMapping(value="insertSubjectDelete.em")
	public String insertSubjectDelete(SubjectDelete sd) {
		OpenSubject os = new OpenSubject();
		String subCode = sd.getSubCode();
		os = cms.selectOneOpenSubject(subCode);
		cms.insertSubjectDelete(sd, os);

			return "employee/class/lectureAbolitionRegistration";
		}
	@RequestMapping(value="lectureAbolitionSelect.em")
	public String selectLectureAbolition(HttpServletRequest request) {
		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = cms.getListCount3();

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<OpenSubject> list = cms.selectOpenSubjectList2(pi);
			

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			return "employee/class/openAbolitionInquiry";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
	}
	
	@RequestMapping(value="abolitionSelect.em")
	public String selectAbolition(HttpServletRequest request) {
		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = cms.getListCount4();

			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<LectureOpen> list = cms.selectAbolitiontList(pi);
			

			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			return "employee/class/abolitionInquiry";
		} catch (ClassManagementSelectListException e) {
			request.setAttribute("msg", e.getMessage());

			return "common/errorAlert";
		}
		
	}
}
 