package com.kh.finalProject.professor.openSubject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.openSubject.model.service.OpenSubjectService;
import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

@Controller
public class OpenSubjectController {
	
	@Autowired
	OpenSubjectService openSubjectService;
	
	@RequestMapping("opensubject.pro")
	public ModelAndView OpenSubject (ModelAndView mav) {
		List<OpenSubject> openSubjectList = openSubjectService.selectOpenSubjectList();
		System.out.println("openSubjectList : " + openSubjectList);
		mav.addObject("openSubjectList", openSubjectList);
		mav.setViewName("professor/class/syllabus");
		return mav;
	
	/*public String OpenSubject(@ModelAttribute("loginUser") Member professorInfo,HttpServletRequest request) {
		String memberId= professorInfo.getMemberId();
		
		List<OpenSubject> openSubjectList = openSubjectService.selectOpenSubjectList();
		
		request.setAttribute("openSubjectList",openSubjectList);
		
		return "professor/class/syllabus";
	}*/
	}
	
	//22
	/*
	 * @RequestMapping("opensubjectWrite.pro") public ModelAndView OpenSubjectWrite
	 * (ModelAndView mav) {
	 * 
	 * List<OpenSubject> openSubjectList =
	 * openSubjectService.selectOpenSubjectList();
	 * System.out.println("openSubjectList!! : " + openSubjectList);
	 * mav.addObject("openSubjectList", openSubjectList);
	 * mav.setViewName("professor/class/syllabusWrite");
	 * 
	 * 
	 * return mav; }
	 */
	
	@RequestMapping(value="opensubjectWrite.pro")
	public String OpenSubjectWrite(HttpServletRequest request,@RequestParam(name="subCode", required=false) String subCode, @ModelAttribute("loginUser") Member loginUser, ModelAndView mv) {

		OpenSubject os = new OpenSubject();

		System.out.println("시작합니다");
		System.out.println("subCode :::::" + subCode);
		//os = openSubjectService.selectOneSubject(subCode);
		


		/*
		 * ArrayList<DepartmentProfessor> proList; try { proList =
		 * cms.selectProfessorList(lo.getSdeptName()); ArrayList<ClassRoomInformation>
		 * room = cms.selectClassRoomList();
		 * 
		 * 
		 * request.setAttribute("lo", lo); request.setAttribute("proList", proList);
		 * request.setAttribute("room", room);
		 * 
		 * return "employee/class/lectureRegistration"; } catch
		 * (ClassManagementSelectListException e) { request.setAttribute("msg",
		 * e.getMessage());
		 */
			return "professor/class/syllabusWrite";
		}
	
		

}

