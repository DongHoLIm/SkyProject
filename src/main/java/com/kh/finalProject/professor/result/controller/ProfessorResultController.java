package com.kh.finalProject.professor.result.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.service.ProfessorResultService;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;
import com.kh.finalProject.professor.result.model.vo.SubjectScheduler;

@Controller
public class ProfessorResultController {
	@Autowired
	private ProfessorResultService ps;
	
	
	@RequestMapping("resultInsert.pror")
	public String resultInsert(HttpSession session,HttpServletRequest request) {
		Member loginInfo = (Member)session.getAttribute("loginUser");
		ArrayList<ProfessorResult> list = ps.subList(loginInfo);
		request.setAttribute("list", list);
		return "professor/result/resultInsert";
	}
	@RequestMapping("insertResult.pror")
	public String insertResult(HttpServletRequest request) {
		String jsonStr = request.getParameter("resultStr");
		ObjectMapper mapper = new ObjectMapper();
		 List<Object> list = new ArrayList<Object> ();
		 ProfessorResult subjectInfo = new ProfessorResult();
		 try {
			 list = mapper.readValue(jsonStr,new TypeReference <List<Object>>() {});
			
			 HashMap<String,Object> hmap = null;
			 String opensubCode =null;
			 String yearSemester = null;
			 String subName = null;
			 String completeType = null;
			 String subGrade = null;
			 String roomBuildingName = null;
			 String dayInfo = null;		 
			 
			 for(int i =0;i<list.size();i++) {
				 hmap =  (HashMap<String,Object>)list.get(i);
				 opensubCode=(String)hmap.get("opensubCode");
				 yearSemester =(String)hmap.get("yearSemester");
				 subName =(String)hmap.get("subName");
				 completeType= (String)hmap.get("completeType");
				 subGrade = (String)hmap.get("subGrade");
				 roomBuildingName=(String)hmap.get("buildingRoom");
				 dayInfo = (String)hmap.get("dayInfoTimeInfo");
			 }		 
			 int year = Integer.parseInt(yearSemester.substring(0,4));
			 int semester =Integer.parseInt(yearSemester.substring(7,8));
			 
			 subjectInfo.setOpensubCode(opensubCode);
			 subjectInfo.setSubName(subName);
			 subjectInfo.setBuildingName(roomBuildingName);
			 subjectInfo.setDayInfo(dayInfo);
			 subjectInfo.setOpenYear(year);
			 subjectInfo.setOpenSemester(semester);
			 ArrayList<StudentResult> stuList = ps.studentList(opensubCode);
			 SubjectScheduler subSch = ps.subSch(opensubCode);
//			 if(subSch==null) {
//				 request.setAttribute("msg", "강의계획서를 입력해주세요");
//				 return "common/errorAlert";
//			 }		 
			 request.setAttribute("subSch",subSch);
			 request.setAttribute("stuList",stuList);
			 request.setAttribute("subjectInfo",subjectInfo);
		 }catch(Exception e) {
			e.printStackTrace(); 
		 }
		
		return "professor/result/resultInsertStu";
	}
	@RequestMapping("searchResult.pror")
	public String searchResult(HttpServletRequest request,HttpSession session) {
		Member loginInfo = (Member)session.getAttribute("loginUser");
		ArrayList<ProfessorResult> list = ps.subList(loginInfo);
		request.setAttribute("list", list);
		return "professor/result/searchResult";
	}
	@RequestMapping("checkResultDetail.pror")
	public String checkResultDetail(HttpServletRequest request) {
		String subCode = request.getParameter("opensubCode");
		 ArrayList<StudentResult> stuList = ps.studentList(subCode);
		 SubjectScheduler subSch = ps.subSch(subCode);	
		 request.setAttribute("stuList",stuList);
		 request.setAttribute("subSch",subSch);		
		return  "professor/result/checkResultDetail";
	}
	
	@RequestMapping("resultInsertStu.pror")
	@ResponseBody
	public ModelAndView resultInsertStu(ModelAndView mv,String str ) {
		StudentResult sr = new StudentResult();
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object> ();
		HashMap<String,Object> resultInsertSut =null;
		 try {
			list = mapper.readValue(str,new TypeReference <List<Object>>() {});
			String gradeCode=null;
			String grade=null;
			int middleScore =0;
			int finalScore=0;
			int attendanceScore= 0;
			int workScore=0;
			int score=0;
			
			 for(int i =0;i<list.size();i++) {
				 resultInsertSut =  (HashMap<String,Object>)list.get(i);
				 gradeCode=(String)resultInsertSut.get("gradeCode");
				 middleScore =Integer.parseInt((String)resultInsertSut.get("middleScore"));
				 finalScore =Integer.parseInt((String)resultInsertSut.get("finalScore"));
				 attendanceScore= Integer.parseInt((String)resultInsertSut.get("attendanceScore"));
				 workScore = Integer.parseInt((String)resultInsertSut.get("workScore"));
				 score = Integer.parseInt((String)resultInsertSut.get("score"));
				 grade = (String)resultInsertSut.get("grade");
				 sr.setGradeCode(gradeCode);
				 sr.setMiddleScore(middleScore);
				 sr.setFinalScore(finalScore);
				 sr.setAttendanceScore(attendanceScore);
				 sr.setWorkScore(workScore);
				 sr.setScore(score);
				 sr.setGrade(grade);
				 int result = ps.resultInsertStu(sr);
				 if(result<=0) {
					 mv.addObject("msg","입력 실패~!");					
				 }else {
					 mv.addObject("msg","입력 완료");					
				 }
			 }
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		 mv.setViewName("jsonView");
		return mv;
	}
}
