package com.kh.finalProject.student.classmanagement.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.student.classmanagement.model.service.ClassService;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;
@Controller
@SessionAttributes("loginUser")
public class ClassController {
	@Autowired
	private ClassService cs;

	//과목조회, 수강신청 이동
	@RequestMapping(value="goSugang.st")
	public String goSugang(Member m, Model model, HttpSession session) {

		return "student/class/Notice";
	}
	//수강공지사항
	@RequestMapping(value="goNotice.st")
	public String goNotice(@ModelAttribute("loginUser") Member loginUser) {
		System.out.println(loginUser);
		return "student/class/Notice";
	}
	//교과목조회
	@RequestMapping(value="goCourseInquiry.st")
	public String goCourseInquiry(@ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {
		ArrayList<Sdepartment> sdList = cs.selectSdept();
		ArrayList<OpenSubject> osList = cs.selectOpenSubject();
		request.setAttribute("sdList", sdList);
		request.setAttribute("osList", osList);

		return "student/class/courseInquiry";
	}
	//예비수강신청목록
	@RequestMapping(value="goPreliminaryCourse.st")
	public String goPreliminaryCourse(@ModelAttribute("loginUser") Member loginUser) {

		return "student/class/preliminaryCourseApplyList";
	}
	//수강신청
	@RequestMapping(value="goCourseApply.st")
	public String goCourseApply(@ModelAttribute("loginUser") Member loginUser) {

		return "student/class/courseApply";
	}

	@RequestMapping(value="goSubject.st")
	public ModelAndView selectSubject(String sdeptCode, String completeType, ModelAndView mv) {

		System.out.println(sdeptCode);
		System.out.println(completeType);
		OpenSubject os = new OpenSubject();

		os.setSdeptName(sdeptCode);
		os.setCompleteType(completeType);

		ArrayList<OpenSubject> osList2 = cs.selectSubject(os);

		mv.addObject("osList2", osList2);
		mv.setViewName("jsonView");

		System.out.println("osList2 :::" + osList2);
		System.out.println("mv::::" + mv);
		return mv;
	}
	@RequestMapping(value="selectOpensubject.st")
	public ModelAndView selectOpenSubject(String subCode, ModelAndView mv) {
		OpenSubject os = new OpenSubject();

		os.setOpenSubCode(subCode);

		ArrayList<OpenSubject> list = cs.selectOpenSubject(os);

		mv.addObject("list", list);
		mv.setViewName("jsonView");


		return mv;
	}
	@RequestMapping(value="selectgwamok.st")
	public ModelAndView selectSearchgwamok(String gwamok, ModelAndView mv) {


		ArrayList<OpenSubject> list = cs.selectSearchgwamok(gwamok);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}
	@RequestMapping(value="selectProfessor.st")
	public ModelAndView selectProfessor(String professor, ModelAndView mv) {
		OpenSubject os = new OpenSubject();

		ArrayList<OpenSubject> list2 = cs.selectProfessor(professor);

		os.setProfessorNo(list2.get(0).getProfessorNo());

		ArrayList<OpenSubject> list = cs.selectProGwamok(os);



		mv.addObject("list2", list2);
		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}
	@RequestMapping(value="selectGwamok.st")
	public ModelAndView selectGwamok(String professorNo, ModelAndView mv) {
		OpenSubject os = new OpenSubject();


		os.setProfessorNo(professorNo);

		ArrayList<OpenSubject> list = cs.selectProGwamok(os);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}
	@RequestMapping(value="insertPreliminaryCourseRegistration.st")
	public ModelAndView insertCourseApply(@RequestParam(value="subCode[]") String[] subCode, @ModelAttribute("loginUser") Member loginUser, ModelAndView mv) {			

		SubjectApply sa = new SubjectApply();
		sa.setStudentNo(loginUser.getMemberId());
		ArrayList<SubjectApply> list = cs.selectMySugang(sa);

		if(list.size() == 0) {
			System.out.println("IN!!!");
			cs.insertCourseApply(subCode, sa);			
		}else {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getOpenSubCode().equals(subCode[i])) {
					String[] subCodeArr;
					/* subCodeArr = subCode[i]; */
				}else {
					cs.insertCourseApply(subCode, sa);
				}
			}
		}
		mv.setViewName("jsonView");

		return mv;
	}
}
