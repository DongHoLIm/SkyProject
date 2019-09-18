package com.kh.finalProject.professor.sendSMS.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.service.professorService;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;



@Controller
public class ProfessorController {
	@Autowired
	private professorService ps;
	
	@RequestMapping("sendSMS.pro")
	public String sendSMSviewChange () {
		
		return "professor/sendSMS/sendSMS";
	}
	@RequestMapping("addressStudent.pro")	
	public String addressList(@ModelAttribute("loginUser") Member loginUser,HttpServletRequest request,HttpServletResponse response){
			System.out.println("들어오나요??");
		ArrayList<StudentList> list = null;
		int currentPage = 1 ;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ; 
		try {
			listCount =  ps.studentList();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			list = ps.studentPageList(pi);			
			
			request.setAttribute("list", list);
			request.setAttribute("pi",pi);

			return "professor/sendSMS/addressList";
		}catch(Exception e) {
			request.setAttribute("msg","MemberList실패");
			return "common/errorAlert";
		}	
	}
	@RequestMapping("ajaxPaging.pro")
	@ResponseBody
	public ModelAndView ajaxPaging(ModelAndView mv,HttpServletRequest request,HttpServletResponse response){
		
		ArrayList<StudentList> list = null;
		int currentPage = 1 ;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount ; 
		try {
			listCount =  ps.studentList();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			list = ps.studentPageList(pi);
			
			response.setCharacterEncoding("UTF-8");
			mv.addObject("list", list);
			mv.addObject("pi",pi);
		}catch(Exception e){
			System.out.println("실패");
		}
		
		
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	@RequestMapping("sendSMSResult.pro")
	@ResponseBody
	public ModelAndView sendSMS(ModelAndView mv,String send,HttpSession session) {
		ObjectMapper mapper = new ObjectMapper();
	    List<Object> list = new ArrayList<Object> ();
	    Member proInfo =(Member) session.getAttribute("loginUser");		
	     try {
	    	 list = mapper.readValue(send,new TypeReference <List<Object>>() {});
	    	 HashMap<String,Object> hmap = null;
	    	 StudentList sl = new StudentList();
	    	String phonelist = "";
	    	String message = null;
	    	 for(int i = 0;i<list.size();i++) {
	    		 hmap = (HashMap<String,Object>)list.get(i);
	    		 if(i==list.size()-1) {
	    			 phonelist+=(String)hmap.get("phone");	    			 
	    		 }else {
	    			 phonelist+=(String)hmap.get("phone")+",";
	    		 }
	    		 message = (String)hmap.get("message");
	    		 sl.setGrade(message);
	    		 sl.setMemberId((String)hmap.get("memberId"));
	    		 sl.setMemberKName(proInfo.getMemberId());	    		 
	    		 System.out.println("message 왜 널임?"+sl);
	    		 int result = ps.insertSMS(sl); 
	    	 }
	    	 mv.addObject("msg", message);
	    	 mv.addObject("phoneNumber",phonelist);	     
	     } catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     
	     mv.setViewName("jsonView");
		return mv;
	}
	@RequestMapping("SMSList.pro")
	public String SMSList(HttpServletRequest request, HttpSession session) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		String memberId = loginUser.getMemberId();
		SendSMSList list = new SendSMSList();
		list.setMemberId(memberId);
		ArrayList<SendSMSList> sendSMSList = ps.sendSMSList(list); 	
		
		request.setAttribute("list", sendSMSList);
		
		
		return "professor/sendSMS/sendSMSList";
	}
	@RequestMapping("SendSMSDetail.pro")
	public String SendSMSDetail(HttpServletRequest request) {
		String date = request.getParameter("date");
		SendSMSList sl = new SendSMSList();
		sl.setSendDate(date);
		ArrayList <StudentList> resultList = ps.SendSMSDetail(sl);
		
		request.setAttribute("list", resultList);
		return "professor/sendSMS/sendSMSDetailList";
	}
	
}
