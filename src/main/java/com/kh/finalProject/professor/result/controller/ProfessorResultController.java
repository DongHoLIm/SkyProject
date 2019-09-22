package com.kh.finalProject.professor.result.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.service.ProfessorResultService;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;

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
			 request.setAttribute("stuList",stuList);
			 request.setAttribute("subjectInfo",subjectInfo);
		 }catch(Exception e) {
			e.printStackTrace(); 
		 }
		
		return "professor/result/resultInsertStu";
	}
	@RequestMapping("searchResult.pror")
	public String searchResult() {
		
		return "professor/result/searchResult";
	}
	@RequestMapping("checkResultDetail.pror")
	public String checkResultDetail() {
		
		return  "professor/result/checkResultDetail";
	}
}
