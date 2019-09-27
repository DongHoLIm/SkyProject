package com.kh.finalProject.studentInfo.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.common.CommonUtils;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.service.StudentInfoService;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.DocFile;
import com.kh.finalProject.studentInfo.model.vo.DropOut;
import com.kh.finalProject.studentInfo.model.vo.Explusion;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.OffApplyFilter;
import com.kh.finalProject.studentInfo.model.vo.SchoolOff;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
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

		// 학적 정보 조회에 복수/부전공 조회용 객체
		SecondMajor smInfo = ss.smInfo(userId);

		// 학적 정보 조회에 전과정보 조회용 객체
		ChangeMajor cmInfo = ss.cmInfo(userId);

		// 학적 정보 조회에 제적정보 조회용 객체
		Explusion expInfo = ss.expInfo(userId);
		
		// 학적 정보 조회에 자퇴 정보 조회용 객체
		DropOut dpoInfo = ss.dpoInfo(userId);

		System.out.println("basicInfo :::: " + basicInfo);
		System.out.println("stuInfo :::: " + stuInfo);
		System.out.println("smInfo :::: " + smInfo);
		System.out.println("cmInfo :::: " + cmInfo);
		System.out.println("expInfo :::: " + expInfo);
		System.out.println("dpoInfo :::: " + dpoInfo);
		
		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);
		request.setAttribute("smInfo", smInfo);
		request.setAttribute("cmInfo", cmInfo);
		request.setAttribute("expInfo", expInfo);
		request.setAttribute("dpoInfo", dpoInfo);

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
			return "common/errorAlert";	
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
			
			return "common/errorAlert";

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
			
			mv.setViewName("common/errorAlert");			

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
			
			mv.setViewName("common/errorAlert");			

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
			
			mv.setViewName("common/errorAlert");			

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
					
					mv.setViewName("common/errorAlert");
					
					return mv;
				}
				
			}		

	//교직원_학생조회_학생선택
	@RequestMapping(value="em_selectStudent.si")
	public String selectStudent(HttpServletRequest request) {

		String id = request.getParameter("id");
		System.out.println(id);

		StudentInfo basicInfo = ss.basicInfo(id);
		StudentInfo stuInfo = ss.stuInfo(id);

		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);

		return "employee/studentInfo/studentDetail";
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
			
			return "common/errorAlert";

		}

	}

	//교직원_졸업인증관리_교내인증
	@RequestMapping(value="em_graduationSchool.si")
	public String graduationSchool(HttpServletRequest request) {

		ArrayList<Graduation> list = ss.selectGraduationSchool(); 

		System.out.println("list::"+list);

		String division="";
		for(int i=0 ; i<list.size() ; i++) {
			division = list.get(i).getsDeptCode();
			if(division.equals("SD100")) {
				list.get(i).setDivision("교내 인증");
			}else {
				list.get(i).setDivision("학과 인증");
			}
		}
		System.out.println("list::" + list);
		request.setAttribute("list",list);

		return "employee/studentInfo/graduationSchool";
	}

	//교직원_졸업관리_교내인증 상세보기
	@RequestMapping(value="em_selectGraduationSc.si")
	public String graSchoolChange(HttpServletRequest request) {

		String code = request.getParameter("code");
		System.out.println(code);

		Graduation graduation = ss.selectGraduationScDetail(code);

		String division = graduation.getsDeptCode();
		if(division.equals("SD100")) {
			graduation.setDivision("교내 인증");
		}else {
			graduation.setDivision("학과 인증");
		}

		System.out.println("graduation::" + graduation);
		request.setAttribute("graduation",graduation);

		return "employee/studentInfo/changeGraduationSc";
	}

	//교직원_졸업관리_교내인증 수정하기
	@RequestMapping(value="em_changeGraduationSc.si")
	public ModelAndView changeGraduationSc(ModelAndView mv, HttpServletRequest request) {

		String code = request.getParameter("code");
		String content = request.getParameter("content");

		System.out.println("code::" + code);
		System.out.println("content::" + content);

		Graduation gd = new Graduation();

		gd.setGraduationCode(code);
		gd.setGraduationContent(content);

		System.out.println("수정내용::"+gd);

		int result = ss.updateGraduationSc(gd);

		if(result>0) {
			mv.addObject("gd", gd);
			mv.setViewName("jsonView");
		}else {
			mv.setViewName("jsonView");
		}

		return mv;
	}


	//교직원_졸업인증관리_학과인증
	@RequestMapping(value="em_graduationMajor.si")
	public String graduationMajor(HttpServletRequest request){

		ArrayList<Graduation> list = ss.selectGraduationMajor(); 

		System.out.println("list::"+list);

		String division="";
		for(int i=0 ; i<list.size() ; i++) {
			division = list.get(i).getsDeptCode();
			if(division.equals("SD100")) {
				list.get(i).setDivision("교내 인증");
			}else {
				list.get(i).setDivision("학과 인증");
			}
		}
		System.out.println("list::" + list);
		request.setAttribute("list",list);

		return "employee/studentInfo/graduationMajor";

	}

	//교직원_졸업관리_학과인증 상세보기
	@RequestMapping(value="em_selectGraduationMa.si")
	public String graMajorChange(HttpServletRequest request) {

		String code = request.getParameter("code");
		System.out.println(code);

		Graduation graduation = ss.selectGraduationMaDetail(code);

		String division = graduation.getsDeptCode();
		if(division.equals("SD100")) {
			graduation.setDivision("교내 인증");
		}else {
			graduation.setDivision("학과 인증");
		}

		System.out.println("graduation::" + graduation);
		request.setAttribute("graduation",graduation);

		return "employee/studentInfo/changeGraduationMa";
	}

	//교직원_졸업관리_학과인증 수정하기
	@RequestMapping(value="em_changeGraduationMa.si")
	public ModelAndView changeGraduationMa(ModelAndView mv, HttpServletRequest request) {

		String code = request.getParameter("code");
		String content = request.getParameter("content");

		System.out.println("code::" + code);
		System.out.println("content::" + content);

		Graduation gd = new Graduation();

		gd.setGraduationCode(code);
		gd.setGraduationContent(content);

		System.out.println("수정내용::"+gd);

		int result = ss.updateGraduationMa(gd);

		if(result>0) {
			mv.addObject("gd", gd);
			mv.setViewName("jsonView");
		}else {
			mv.setViewName("jsonView");
		}

		return mv;
	}

	//학생_휴학신청 
	@RequestMapping("st_schoolOff.si")
	public String schoolOnOffApply(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {

		String userId = loginUser.getMemberId();
		System.out.println(userId);
    
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("MM");
		
		Date time = new Date();
		
		String year = format1.format(time);
		String month = format2.format(time);
		System.out.println("year::" + year);
		System.out.println("month::" + month);
		
		String start="";
		if(month.equals("02") || month.equals("08") || month.equals("09")) {
			if(month=="2") {
				start = year + ".1학기" ;	
			}else {
				start = year + ".2학기" ;				
			}
			System.out.println("휴학시작학기::"+start);
			
			StudentInfo basicInfo = ss.basicInfo(userId);
			request.setAttribute("basicInfo",basicInfo);
			request.setAttribute("start",start);
			
			ArrayList<SchoolOff> list = ss.selectSchoolOff(userId);
			System.out.println("휴학신청 list :: " + list);
			request.setAttribute("list", list);
			
			return "student/info/schoolOff";
		
		}
		else {
			request.setAttribute("msg","휴학 신청 기간이 아닙니다.");
			return "common/errorAlert";
			
		}	

	}
	
	//휴학신청 insert
//	@RequestMapping("st_insertSchoolOff.si")
//	public String insertSchoolOff(HttpServletRequest request, @ModelAttribute SchoolOff so,DocFile df, 
//											@ModelAttribute("loginUser") Member loginUser) {
//		
//		System.out.println("휴학신청::"+so);
//		
//		
//		
//		return "";
//	}
	
	//휴학신청 insert (ajax)
	@RequestMapping(value="st_insertSchoolOff.si")
	public ModelAndView insertSchoolOff( ModelAndView mv, HttpServletRequest request, @ModelAttribute SchoolOff so, @ModelAttribute("loginUser") Member loginUser,
			DocFile df, MultipartHttpServletRequest req) {
		
		System.out.println("휴학신청 객체::"+so);
		String userId = loginUser.getMemberId();
		so.setStudentNo(userId);
		
		MultipartFile mf = req.getFile("docFile");
		
		if(mf == null) {
			ss.schoolOffApply(so);
			
			mv.setViewName("jsonView");
			return mv;
			
		}else {
			String originFileName = mf.getOriginalFilename();
			System.out.println("originalfileName : " + originFileName);
			
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String changeName = CommonUtils.getRandomString() + ext;
			System.out.println("changeName::"+changeName);
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("root::"+root);
			
			String filePath = root + "\\docFiles";
			
			df.setOldName(originFileName);
			df.setChangeName(changeName);
			df.setPath(filePath + "\\" + changeName);
			System.out.println(df);
			
			try {
				mf.transferTo(new File(filePath+"\\"+changeName));
				
				ss.schoolOffApplyWithFile(so,df);
				
				
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		}
		
		
		mv.setViewName("jsonView");
		return mv;
			
	}
		

	
	
	//학생_휴학신청_휴학구분선택
	@RequestMapping("st_changeOffType.si")
	public ModelAndView changeOffType(ModelAndView mv, HttpServletRequest request) {
		
		String offType = request.getParameter("offType");
		System.out.println(offType);
		
		int[] arr = new int[2];
		if(offType.equals("군휴학")) {
			arr[0] = 3;
			arr[1] = 4;
		}else {
			arr[0] = 1;
			arr[1] = 2;
		}
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		mv.addObject("arr", arr);
		mv.setViewName("jsonView");
		return mv;
	}
		

	
	//학생_휴학신청_희망휴학기간 선택
	@RequestMapping("st_selectOffTerm.si")
	public ModelAndView selectOffTerm(ModelAndView mv, HttpServletRequest request) {
		
		int offTerm = Integer.parseInt(request.getParameter("offTerm"));
		String start = request.getParameter("start");

		System.out.println(offTerm);
		System.out.println(start);
		
		int year = Integer.parseInt(start.substring(0, 4));
		//String year = start.substring(0, 3);
		int semester=Integer.parseInt(start.substring(5, 6));
		
		System.out.println("년도:"+year);
		System.out.println("학기:"+semester);
		
		String end = "";
		String returnDay = "";
		if(offTerm==1) { //신청휴학학기가 1학기인경우
			if(semester==1) {//휴학시작학기가 __년.1학기인경우
				end = start;
				returnDay = year + "." + (semester+1) + "학기";
				
			}else { //휴학신청학기가  __년.2학기인 경우
				end = start;
				returnDay = (year+1) + "." + (semester-1) + "학기";
				
			}
		}else if(offTerm==2) { //신청휴학학기가 2학기인 경우(1년휴학)
			if(semester==1) { //휴학시작학기가 __년.1학기인경우
				end = year + "." + (semester+1) + "학기";
				returnDay = (year+1) + "." + semester + "학기";
				
			}else { //휴학신청학기가  __년.2학기인 경우
				end = (year+1) + "." + (semester-1) + "학기";
				returnDay = (year+1) + "." + semester + "학기";
				
			}
		}else if(offTerm==3) { //신청휴학학기가 3학기인 경우(군휴학 1년 반 휴학)
			if(semester==1) {//휴학시작학기가 __년.1학기인경우
				end = (year+1) + "." + (semester) + "학기";
				returnDay = (year+1) + "." + (semester+1) + "학기";
				
			}else { //휴학신청학기가  __년.2학기인 경우
				end = (year+1) + "." + (semester) + "학기";
				returnDay = (year+2) + "." + (semester-1) + "학기";
				
			}
		}else {	//신청휴학학기가 4학기인경우(군휴학 2년 휴학)
			if(semester==1) { //휴학시작학기가 __년.1학기인경우
				end = (year+1) + "." + (semester+1) + "학기";
				returnDay = (year+2) + "." + semester + "학기";
				
			}else { //휴학신청학기가  __년.2학기인 경우
				end = (year+2) + "." + (semester-1) + "학기";
				returnDay = (year+2) + "." + (semester) + "학기";
			}
			
		}
		
		String offTermm = start + " - " + end;
		
		System.out.println("휴학기간::" + offTermm);
		System.out.println("복학예정::" + returnDay);
		
		mv.addObject("offTermm", offTermm);
		mv.addObject("returnDay", returnDay);
		mv.setViewName("jsonView");

		return mv;
		
	}
	
	//교직원_휴학처리 뷰출력
	@RequestMapping("em_schoolOff.si")
	public String schooloff(HttpServletRequest request) {
		
		return "employee/studentInfo/schoolOffProcess";
	}
	
	//교직원_금학기휴학신청자 명단 출력
	@RequestMapping("em_offApplyList.si")
	public ModelAndView offApplyList(ModelAndView mv, HttpServletRequest request) {
		
		System.out.println("requestCurrentPage::" + request.getParameter("currentPage"));

		int currentPage=1;
		int listCount=0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("currentPage::"+currentPage);
		
		listCount = ss.getOffApplyListCount();
		System.out.println("offApplyCount::"+listCount);
		
		PageInfo pi = Pagination.getPageInfo(currentPage,listCount);

		ArrayList<SchoolOff> list;
		try {
			list = ss.selectOffApplyList(pi);
			
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
			
			mv.setViewName("common/errorAlert");			

			return mv;
		}

	}
	//교직원_휴학신청자명단 필터링후 페이징
	@RequestMapping("em_offApplyFilter.si")
	public ModelAndView em_offApplyFilter(OffApplyFilter of, ModelAndView mv, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("OffApplyFilter::" + of);
		
		int listCount;
		
		listCount = ss.getOffFilterListCount(of);
		System.out.println("필터링후 listCount::" + listCount);
		
		PageInfo pi = Pagination.getPageInfo(currentPage,listCount);
		
		ArrayList<SchoolOff> list = ss.selectOffFilterStudent(of,pi);
		
		System.out.println("list ::" + list);
		System.out.println("pi ::" + pi);

		mv.addObject("list",list);
		mv.addObject("pi",pi);

		mv.setViewName("jsonView");
		
		return mv;
	}
	
	
	
	//학생_복학신청
	@RequestMapping("st_schoolOn.si")
	public String schoolOnOnApply() {
		
		return "student/info/schoolOn";
	}
	
	//교직원_복학처리
	@RequestMapping("em_schoolOn.si")
	public String schoolOn() {
		
		return "employee/studentInfo/schoolOnProcess";
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


	// 교직원_다전공 신청 관리_뷰 출력
	@RequestMapping("em_showSecondMajor.si")
	public String em_showSecondMajor(){

		return "employee/studentInfo/em_secondMajor";
	}

	// 교직원_다전공 신청 관리_ajax 리스트 출력
	@RequestMapping("em_SecondMajorList.si")
	public ModelAndView em_SecondMajorList(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.selectSecondMajorListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<SecondMajor> list = ss.selectSecondMajorList(pi);		

		System.out.println("SecondMajorList list :::: " + list);
		System.out.println("SecondMajorList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_다전공 신청 관리_ajax 리스트 출력2
	@RequestMapping("em_SecondMajorList2.si")
	public ModelAndView em_SecondMajorList2(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.selectSecondMajorSuccessListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<SecondMajor> list = ss.selectSecondMajorSuccessList(pi);	

		System.out.println("selectSecondMajorSuccessList list :::: " + list);
		System.out.println("selectSecondMajorSuccessList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_다전공 신청 관리_ajax 완료처리
	@RequestMapping("em_SecondMajorUpdate.si")
	public ModelAndView em_SecondMajorUpdate(ModelAndView mv, SecondMajor sm, HttpServletRequest request) {	

		ss.SuccessSecondMajor(sm);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_다전공 신청 검색_ajax 검색
	@RequestMapping("searchSecondMajorApply.si")
	public ModelAndView searchSecondMajorApply(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);
		System.out.println("currentPage :::: " + currentPage);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("majorCheck")) {
			sc.setMajorCheck(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		listCount = ss.searchSecondMajorApplyCount(sc);

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<SecondMajor> list = ss.searchSecondMajorApplyList(sc, pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_다전공 처리 완료_ajax 검색
	@RequestMapping("searchSecondMajorApply2.si")
	public ModelAndView searchSecondMajorApply2(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);
		System.out.println("currentPage :::: " + currentPage);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("majorCheck")) {
			sc.setMajorCheck(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		listCount = ss.searchSecondMajorApplyCount2(sc);

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<SecondMajor> list = ss.searchSecondMajorApplyList2(sc, pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 학생_전과신청_뷰 출력
	@RequestMapping("st_showChangeMajor.si")
	public String st_showChangeMajor(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser) {

		String userId = loginUser.getMemberId();
		System.out.println(userId);

		StudentInfo basicInfo = ss.basicInfo(userId);
		StudentInfo stuInfo = ss.stuInfo(userId);		
		ChangeMajor cmInfo = ss.cmInfo(userId);

		System.out.println(basicInfo);
		System.out.println(stuInfo);
		System.out.println(cmInfo);

		request.setAttribute("basicInfo",basicInfo);
		request.setAttribute("stuInfo",stuInfo);
		request.setAttribute("cmInfo", cmInfo);	

		return "student/info/changeMajor";
	}

	// 학생_전과신청_insert
	@RequestMapping("st_insertChangeMajor.si")
	public ModelAndView st_insertChangeMajor(ModelAndView mv, HttpServletRequest request, ChangeMajor cm) {	

		System.out.println("insert 전 cm :::: " + cm);

		int result = ss.insertChangeMajor(cm);

		ChangeMajor changeMajor = null;

		if(result > 0) {
			changeMajor = ss.selectChangeMajor(cm);
		}

		mv.addObject("changeMajor", changeMajor);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_전과 신청 관리_뷰 출력
	@RequestMapping("em_showChangeMajor.si")
	public String em_showChangeMajor(){

		return "employee/studentInfo/em_changeMajor";
	}

	// 교직원_전과 신청 관리_ajax 리스트 출력
	@RequestMapping("em_ChangeMajorList.si")
	public ModelAndView em_ChangeMajorList(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.ChangeMajorListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<ChangeMajor> list = ss.ChangeMajorList(pi);		

		System.out.println("ChangeMajorList list :::: " + list);
		System.out.println("ChangeMajorList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_전과 신청 관리_ajax 리스트2 출력
	@RequestMapping("em_ChangeMajorList2.si")
	public ModelAndView em_ChangeMajorList2(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.ChangeMajorListCount2();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<ChangeMajor> list = ss.ChangeMajorList2(pi);		

		System.out.println("ChangeMajorList2 list :::: " + list);
		System.out.println("ChangeMajorList2 pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_전과 신청 관리_ajax 전과 처리
	@RequestMapping("em_ChangeMajorEnroll.si")
	public ModelAndView em_ChangeMajorEnroll(ModelAndView mv, ChangeMajor cm, HttpServletRequest request) {	

		ss.ChangeMajorEnroll(cm);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_전과 신청 관리_ajax 반려 처리
	@RequestMapping("em_ChangeMajorReject.si")
	public ModelAndView em_ChangeMajorReject(ModelAndView mv, ChangeMajor cm, HttpServletRequest request) {	

		ss.ChangeMajorReject(cm);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_전과 신청 검색_ajax 검색
	@RequestMapping("searchChangeMajor.si")
	public ModelAndView searchChangeMajor(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		ArrayList<ChangeMajor> list = ss.searchChangeMajor(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_전과 처리 완료_ajax 검색
	@RequestMapping("searchChangeMajor2.si")
	public ModelAndView searchChangeMajor2(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("status")) {
			sc.setStatus(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		ArrayList<ChangeMajor> list = ss.searchChangeMajor2(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_제적 처리_뷰 출력
	@RequestMapping("em_showExplusion.si")
	public String em_showExplusion(){

		return "employee/studentInfo/em_explusion";
	}

	// 교직원_전과 신청 관리_ajax 리스트 출력
	@RequestMapping("em_ExplusionList.si")
	public ModelAndView em_ExplusionList(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.ExplusionListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<Explusion> list = ss.ExplusionList(pi);		

		System.out.println("ExplusionList list :::: " + list);
		System.out.println("ExplusionList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	@RequestMapping("em_ExplusionList2.si")
	public ModelAndView em_ExplusionList2(ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.ExplusionListCount2();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<Explusion> list = ss.ExplusionList2(pi);		

		System.out.println("ExplusionList list :::: " + list);
		System.out.println("ExplusionList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}	

	// 교직원_전과 신청 관리_ajax 전과 처리
	@RequestMapping("em_ExplusionEnroll.si")
	public ModelAndView em_ExplusionEnroll(ModelAndView mv, Explusion exp, HttpServletRequest request) {	

		System.out.println("ExplusionEnroll exp :::: " + exp);

		ss.ExplusionEnroll(exp);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_전과 신청 검색_ajax 검색
	@RequestMapping("searchExplusion.si")
	public ModelAndView searchExplusion(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("memberKName")) {
			sc.setMemberKName(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		ArrayList<Explusion> list = ss.searchExplusion(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_전과 처리 완료_ajax 검색
	@RequestMapping("searchExplusion2.si")
	public ModelAndView searchExplusion2(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("memberKName")) {
			sc.setMemberKName(searchValue);
		}
		if(searchCondition.equals("sdeptName")) {
			sc.setSdeptName(searchValue);
		}

		ArrayList<Explusion> list = ss.searchExplusion2(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 학생_자퇴 신청_뷰 출력
	@RequestMapping("st_showDropOut.si")
	public String st_showDropOut(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser){

		String studentNo = loginUser.getMemberId();
		System.out.println(studentNo);

		DropOut doInfo = ss.doInfo(studentNo);
		ArrayList<DropOut> list = ss.selectDropOut(studentNo);
		System.out.println("doInfo :::: " + doInfo);

		request.setAttribute("doInfo", doInfo);
		request.setAttribute("list", list);

		return "student/info/dropOut";
	}

	// 학생_자퇴 신청_insert
	@RequestMapping("st_insertDropOut.si")
	public ModelAndView st_insertDropOut(ModelAndView mv, HttpServletRequest request, DropOut dpo) {	

		System.out.println("insert 전 dpo :::: " + dpo);

		int result = ss.insertDropOut(dpo);

		ArrayList<DropOut> list = null;

		if(result > 0) {
			list = ss.selectDropOut(dpo);
		}

		System.out.println("select 후 list :::: " + list);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교수_자퇴 신청 관리_뷰 출력
	@RequestMapping("pro_showDropOut.si")
	public String pro_showDropOut(HttpServletRequest request, @ModelAttribute("loginUser") Member loginUser){

		String professorNo = loginUser.getMemberId();

		DropOut proInfo = ss.selectProInfo(professorNo);

		request.setAttribute("proInfo", proInfo);

		return "professor/class/pro_dropOut";
	}

	// 교수_자퇴 신청 관리_ajax 리스트 출력
	@RequestMapping("pro_DropOutList.si")
	public ModelAndView pro_DropOutList(ModelAndView mv, HttpServletRequest request, String pdeptCode){		

		System.out.println("pdeptCode :::: " + pdeptCode);

		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.pro_dropOutListCount(pdeptCode);

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<DropOut> list = ss.pro_dropOutList(pi, pdeptCode);		

		System.out.println("pro_DropOutList list :::: " + list);
		System.out.println("pro_DropOutList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교수_자퇴 신청 관리_ajax 리스트 출력
	@RequestMapping("pro_DropOutList2.si")
	public ModelAndView pro_DropOutList2(ModelAndView mv, HttpServletRequest request, String pdeptCode){		

		System.out.println("pdeptCode :::: " + pdeptCode);

		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.pro_dropOutListCount2(pdeptCode);

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<DropOut> list = ss.pro_dropOutList2(pi, pdeptCode);		

		System.out.println("pro_DropOutList list :::: " + list);
		System.out.println("pro_DropOutList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교수_자퇴 신청 관리_ajax 면담완료 처리
	@RequestMapping("pro_DropOutEnroll.si")
	public ModelAndView pro_DropOutEnroll(ModelAndView mv, DropOut dpo, HttpServletRequest request) {	

		System.out.println("DropOutEnroll exp :::: " + dpo);

		ss.pro_DropOutEnroll(dpo);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교수_자퇴 신청 검색_ajax 검색
	@RequestMapping("searchDropOut.si")
	public ModelAndView searchDropOut(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("dropNo")) {
			sc.setDropNo(searchValue);
		}
		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("studentName")) {
			sc.setStudentName(searchValue);
		}

		ArrayList<DropOut> list = ss.searchDropOut(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교수_자퇴 신청 면담 완료_ajax 검색
	@RequestMapping("searchDropOut2.si")
	public ModelAndView searchDropOut2(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("dropNo")) {
			sc.setDropNo(searchValue);
		}
		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("studentName")) {
			sc.setStudentName(searchValue);
		}

		ArrayList<DropOut> list = ss.searchDropOut2(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_자퇴 신청 관리_뷰 출력
	@RequestMapping("em_showDropOut.si")
	public String em_showDropOut(HttpServletRequest request){

		return "employee/studentInfo/em_dropOut";
	}

	// 교직원_자퇴 신청 관리_ajax 리스트 출력
	@RequestMapping("em_DropOutList.si")
	public ModelAndView em_DropOutList(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.em_dropOutListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<DropOut> list = ss.em_dropOutList(pi);		

		System.out.println("em_DropOutList list :::: " + list);
		System.out.println("em_DropOutList pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_자퇴 신청 관리_ajax 리스트 출력
	@RequestMapping("em_DropOutList2.si")
	public ModelAndView em_DropOutList2(ModelAndView mv, HttpServletRequest request){
		int currentPage = 1;
		int listCount = 0;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		listCount = ss.em_dropOutListCount2();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

		ArrayList<DropOut> list = ss.em_dropOutList2(pi);		

		System.out.println("em_DropOutList2 list :::: " + list);
		System.out.println("em_DropOutList2 pi :::: " + pi);

		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교직원_자퇴 신청 관리_ajax 완료 처리
	@RequestMapping("em_DropOutEnroll.si")
	public ModelAndView em_DropOutEnroll(ModelAndView mv, DropOut dpo, HttpServletRequest request) {	

		System.out.println("DropOutEnroll dpo :::: " + dpo);

		ss.em_DropOutEnroll(dpo);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_자퇴 신청 관리_ajax 반려 처리
	@RequestMapping("em_DropOutReject.si")
	public ModelAndView em_DropOutReject(ModelAndView mv, DropOut dpo, HttpServletRequest request) {	

		System.out.println("DropOutReject dpo :::: " + dpo);

		ss.em_DropOutReject(dpo);		

		mv.setViewName("jsonView");	

		return mv;
	}

	// 교직원_자퇴 신청 검색_ajax 검색
	@RequestMapping("searchDropOut3.si")
	public ModelAndView searchDropOut3(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("dropNo")) {
			sc.setDropNo(searchValue);
		}
		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("studentName")) {
			sc.setStudentName(searchValue);
		}

		ArrayList<DropOut> list = ss.searchDropOut3(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}

	// 교수_자퇴 신청 면담 완료_ajax 검색
	@RequestMapping("searchDropOut4.si")
	public ModelAndView searchDropOut4(ModelAndView mv, String searchCondition, String searchValue, HttpServletRequest request) {

		System.out.println("searchCondition :::: " + searchCondition);
		System.out.println("searchValue :::: " + searchValue);

		SearchCondition sc = new SearchCondition();

		if(searchCondition.equals("dropNo")) {
			sc.setDropNo(searchValue);
		}
		if(searchCondition.equals("studentNo")) {
			sc.setStudentNo(searchValue);
		}
		if(searchCondition.equals("studentName")) {
			sc.setStudentName(searchValue);
		}

		ArrayList<DropOut> list = ss.searchDropOut4(sc);

		mv.addObject("list", list);
		mv.setViewName("jsonView");

		return mv;
	}
}









