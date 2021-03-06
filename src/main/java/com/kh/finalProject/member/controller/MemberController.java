package com.kh.finalProject.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.common.CommonUtils;
import com.kh.finalProject.common.Pagination;
import com.kh.finalProject.common.mailController;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberAccount;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

//	//비밀번호 (암호화 비처리 메소드 )
//	@RequestMapping("login.me")
//	public String loginMember(Member m,Model model,HttpSession session) {
//
//		Member loginUser=null;
//		MemberAccount ma = null;
//		try {			
//			loginUser = ms.loginCheck(m);
//			if(loginUser.getMemberStatus().equals("3")) {
//				ma = ms.Account(loginUser.getMemberId());
//				System.out.println("AccountList :"+ma);
//				session.setAttribute("Account",ma);
//			}
//			model.addAttribute("loginUser",loginUser);			
//			return "redirect:loginOk.me";									
//		} catch (loginException e) {			
//			model.addAttribute("msg",e.getMessage());
//			return "common/errorAlert";
//		} 
//	}
	@RequestMapping("loginOk.me")
	public String loginOk(Member loginUser) {

		return "main/main";
	}
	//비밀번호 (암호화 처리 메소드)
	@RequestMapping("login.me")
	public String loginMember(Member m,Model model,HttpSession session) {
		Member loginUser=null;
		MemberAccount ma = null;	
		try {			
			loginUser = ms.loginCheck(m);
			if(loginUser.getMemberStatus().equals("3")) {
				ma = ms.Account(loginUser.getMemberId());				
				session.setAttribute("Account",ma);
			}
			model.addAttribute("loginUser",loginUser);			
			return "redirect:loginOk.me";									
		} catch (loginException e) {	
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			return "common/errorAlert";
		}
	}

	//로그 아웃  
	@RequestMapping("logOut.me" )
	public String logOut(SessionStatus status,@ModelAttribute("loginUser") Member loginUser,HttpSession session,HttpServletRequest request) {		
		ms.logOutLoginCheck(loginUser);
		status.isComplete();
		session.invalidate();
		String msg = request.getParameter("result");
		if(msg != null) {			
			request.setAttribute("msg", "수정이 완료 되었습니다. 재 로그인 하세요");
		}
		return "main/Login";
	}

	//교직원 권한발급 Page 이동 
	@RequestMapping("insert.me")
	public String changePage() {
		
	  return "employee/systemAccountManagement/createSystemAccount";
	}
	
	//excel 
	@RequestMapping(value="excel.me")
	public String showMemberExcel(Model model,HttpServletRequest request,@RequestParam(name="ExcelFile" ,required=false) MultipartFile file) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filepath = root+"\\uploadFiles\\excelFiles";
		String originFileName = file.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeName = CommonUtils.getRandomString();
		
		try {
			
			file.transferTo(new File(filepath+"\\"+changeName+ext));
			
			  FileInputStream fileName = new FileInputStream(filepath+"\\"+changeName+ext);
	            XSSFWorkbook workbook = new XSSFWorkbook(fileName);
	 
	            int rowindex=0;
	            int columnindex=0;
	            //시트 수 (첫번째에만 존재하므로 0을 준다)
	            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
	            XSSFSheet sheet=workbook.getSheetAt(0);
	            //행의 수	          
	            int rows=sheet.getPhysicalNumberOfRows();
	            ArrayList <Member> list = new ArrayList<Member>();
	            for(rowindex=1;rowindex<rows;rowindex++){
	                //행을읽는다
	                XSSFRow row=sheet.getRow(rowindex);
	                Member insertMember = new Member();
	                if(row !=null){
	                    //셀의 수
	                    int cells=row.getPhysicalNumberOfCells();
	                   
	                    for(columnindex=0; columnindex<=cells; columnindex++){
	                        //셀값을 읽는다
	                        XSSFCell cell=row.getCell(columnindex);
	                        String value="";
	                        //셀이 빈값일경우를 위한 널체크
	                        if(cell==null){
	                            continue;
	                        }else{
	                            //타입별로 내용 읽기
	                            switch (cell.getCellType()){
	                            case XSSFCell.CELL_TYPE_FORMULA:
	                                value=cell.getCellFormula();
	                                break;
	                            case XSSFCell.CELL_TYPE_NUMERIC:
	                                value=String.valueOf((int)cell.getNumericCellValue());
	                                break;
	                            case XSSFCell.CELL_TYPE_STRING:
	                                value=cell.getStringCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_BLANK:
	                                value=cell.getBooleanCellValue()+"";
	                                break;
	                            case XSSFCell.CELL_TYPE_ERROR:
	                                value=cell.getErrorCellValue()+"";
	                                break;
	                            }                          
	                         
	                        }
	                        
	                        if(rowindex!=0) {	                        	
	                        	if(columnindex==0) {	                        		
	                        		insertMember.setMemberId(value);
	                        	}else if(columnindex==1) {
	                        		insertMember.setMemberPwd(value);
	                        	}else if(columnindex==2) {
	                        		insertMember.setMemberKName(value);
	                        	}else if(columnindex==3) {
	                        		insertMember.setMemberEName(value);
	                        	}else if(columnindex==4) {
	                        		insertMember.setMemberNo(value);	                        		
	                        	}else if(columnindex==5) {
	                        		insertMember.setPhone(value);
	                        	}else if(columnindex==6) {
	                        		insertMember.setEmail(value);
	                        	}else if(columnindex==7) {
	                        		insertMember.setAddress(value);
	                        	}else if(columnindex==8) {
	                        		insertMember.setLoginCheck(value);
	                        	}else if(columnindex==9) {	                        		
	                        		insertMember.setMemberStatus(value);
	                        	}else if(columnindex==10) {
	                        		insertMember.setSdeptCode(value);
	                        	}else if(columnindex==11) {
	                        		insertMember.setRankCode(value);
	                        	}else if(columnindex==12) {
	                        		insertMember.setBankNumber(value);
	                        	}
	                        }	
	                    }
	                }
	                list.add(insertMember);
	            }
	            model.addAttribute("insertMember_parent", list);
	            new File(filepath+"\\"+changeName+ext).delete();
	            return "employee/systemAccountManagement/createSystemAccount";
		} catch (IllegalStateException e) {
			new File(filepath+"\\"+changeName+ext).delete();
			return "common/errorAlert";
		} catch (IOException e) {
			new File(filepath+"\\"+changeName+ext).delete();
			return "common/errorAlert";
			
		}
	}
	@RequestMapping(value="insertMember.me")
	public ModelAndView insertMember(ModelAndView mv,String resultStr,Model model) {
		
		
		 ObjectMapper mapper = new ObjectMapper();
	     Map<Object, Object> memberMap = new HashMap<Object, Object>();
	     
	     try {
			memberMap = mapper.readValue(resultStr, new TypeReference<Map<Object, Object>>(){});
						
			ArrayList<Object> list = (ArrayList<Object>) memberMap.get("list");
			
			 int checkresult = 0;
			for(int i =0;i<list.size();i++) {				
				Map<Object,Object> list2 =new HashMap<Object,Object>();
				list2 = (Map<Object, Object>) list.get(i);
				Member insertMember = new Member();
				String memberId = (String) list2.get("memberId");
				String memberPwd = (String)list2.get("memberPwd");
				String memberKName= (String)list2.get("memberKName");
				String memberEName = (String)list2.get("memberEName");
				String memberNo = (String)list2.get("memberNo");
				String phone =(String)list2.get("phone");
				String email = (String)list2.get("email");
				String address = (String)list2.get("address");
				String memberStatus = (String)list2.get("memberStatus");
				String sdeptCode =(String)list2.get("sdeptCode");
				String rankCode = (String)list2.get("rankCode");
				String bankNumber = (String)list2.get("bankNumber");
				if(memberStatus.equals("학생")) {
					memberStatus = "1";					
				}else if(memberStatus.equals("교수")) {
					memberStatus ="2";					
				}else if(memberStatus.equals("교직원")) {
					memberStatus ="3";					
				}				
				if(sdeptCode.equals("교양학과")) {
					sdeptCode="SD100";
				}else if(sdeptCode.equals("경영학과")) {
					sdeptCode="SD110";
				}else if(sdeptCode.equals("경제학과")) {
					sdeptCode="SD120";
				}else if(sdeptCode.equals("정치외교과")) {
					sdeptCode="SD130";
				}else if(sdeptCode.equals("실용음악과")) {
					sdeptCode="SD140";
				}else if(sdeptCode.equals("사회체육과")) {
					sdeptCode="SD150";
				}else if(sdeptCode.equals("컴퓨터공학과")) {
					sdeptCode="SD160";
				}else if(sdeptCode.equals("전자공학과")) {
					sdeptCode="SD170";
				}else if(sdeptCode.equals("건축과")) {
					sdeptCode="SD180";
				}else if(sdeptCode.equals("학사지원팀")) {
					sdeptCode="ED1000";
				}else if(sdeptCode.equals("장학지원팀")) {
					sdeptCode="ED1100";
				}else if(sdeptCode.equals("학생지원팀")) {
					sdeptCode="ED1200";
				}else {
					sdeptCode=null;
				}				
				if(rankCode.equals("사원")) {
					rankCode="RANK1000";
				}else if(rankCode.equals("대리")) {
					rankCode="RANK1001";
				}else if(rankCode.equals("과장")) {
					rankCode="RANK1002";
				}else if(rankCode.equals("팀장")) {
					rankCode="RANK1003";
				}else {
					insertMember.setBank(rankCode);
				}

				
				insertMember.setMemberId(memberId);
				insertMember.setMemberPwd(passwordEncoder.encode(memberPwd));
				insertMember.setMemberKName(memberKName);
				insertMember.setMemberEName(memberEName);
				insertMember.setMemberNo(memberNo);
				insertMember.setPhone(phone);
				insertMember.setEmail(email);
				insertMember.setAddress(address);
				insertMember.setLoginCheck("0");
				insertMember.setMemberStatus(memberStatus);
				insertMember.setSdeptCode(sdeptCode);
				insertMember.setBankNumber(bankNumber);
				if(insertMember.getBank()==null) {
					insertMember.setRankCode(rankCode);
				}
				
				int result = ms.insertMember(insertMember);
				if(result<0) {
					checkresult=-1;
				}else {
					if(memberStatus.equals("1")) {
						result=ms.insertStudentInfo(insertMember);
					}else if(memberStatus.equals("2")) {
						result=ms.insertProfessorInfo(insertMember);
					}else {
						result=ms.insertEmployeeInfo(insertMember);
					}
				}
			}
			if(checkresult<0) {
				model.addAttribute("정보 추가에 실패 했습니다.");
				mv.setViewName("common/errorAlert");
			}else {
				
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
		}
	     mv.setViewName("JsonView");
	     return mv;	
	}
	@RequestMapping("findId.me")
	public String findId() {
		
		return "main/findId";
	}
	@RequestMapping("newPassword.me")
	public String newPassword() {
		return "main/newPassword";
	}
	@RequestMapping("findIdResult.me")
	public String findIdResult(Member findId,HttpServletRequest request) {
		Member findMemberId = null;
		int status = 0;
		try {
			findMemberId = ms.findIdResult(findId);				
			mailController mc = new mailController();
			int result = mc.sendEmail(findMemberId, request,status);
			
			if(result == 1) {
				request.setAttribute("msg","이메일전송되었습니다.");				
			}else {
				request.setAttribute("msg","메일 발송에 실패했습니다.");				
			}			
		}catch(Exception e) {
			request.setAttribute("msg","해당아이디가 없습니다.");					
		}
		return "common/errorAlert";
		
	}
	@RequestMapping("findPwd.me")
	public String findPwdResult (Member findPwd,HttpServletRequest request) {
		Member findMemberPwd = null;
		int status = 1;
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
		    int rIndex = rnd.nextInt(3);
		    switch (rIndex) {
		    case 0:
		        // a-z
		        temp.append((char) ((int) (rnd.nextInt(26)) + 97));
		        break;
		    case 1:
		        // A-Z
		        temp.append((char) ((int) (rnd.nextInt(26)) + 65));
		        break;
		    case 2:
		        // 0-9
		        temp.append((rnd.nextInt(10)));
		        break;
		    }
		}
		String password = temp.toString() ;
		Member originalPwd = new Member();
		originalPwd.setMemberPwd(password);
		try {
			findMemberPwd = ms.findPwd(findPwd);
			findMemberPwd.setMemberPwd(password);
			originalPwd.setEmail(findMemberPwd.getEmail());
			int result1 = ms.changeNewpassword(findMemberPwd);
			if(result1>0) {
				mailController mc= new mailController();
				int result = mc.sendEmail(originalPwd,request,status);
				if(result == 1) {
					request.setAttribute("msg", "새로운 비밀번호가 이메일로 전송되었습니다.");
				}else {
					request.setAttribute("msg", "이메일 전송에 실패 했습니다.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","해당 아이디가 없습니다.");
		}
		return "common/errorAlert";
	}
	@RequestMapping("account.me")
	public String accountMember (HttpServletRequest request) {
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}		
		int listCount;
		try {
		listCount = ms.accountMember();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Member> list = ms.employeeList(pi);
		request.setAttribute("list",list);
		request.setAttribute("pi",pi);
		return "employee/systemAccountManagement/systemAccount";
		}catch(Exception e) {
			request.setAttribute("msg", "리스트 출력 실패");
			return "common/errorAlert";
		}
		
	}
	
	@RequestMapping("MemberListview.me")
	public String MemberListView(@ModelAttribute("loginUser") Member loginUser, HttpServletRequest request) {
		ArrayList <Member> list = null;
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}		
		int listCount;
		try {
		listCount = ms.getMemberListCount(loginUser.getMemberId());
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		list = ms.memberAllList(loginUser.getMemberId(),pi);
		
		request.setAttribute("MemberList", list);
		request.setAttribute("pi", pi);
		return "employee/systemAccountManagement/MemberList";		
		}catch(Exception e){			
			request.setAttribute("msg","MemberList실패");
			return "common/errorAlert";			 
		}	
	}
	@RequestMapping("MemberDetailList.me")
	public String MemberDetailList(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		Member findMemberDetail = new Member();
		findMemberDetail.setMemberId(userId);
		
		Member memberDetail = ms.memberDetail(findMemberDetail);
		
		request.setAttribute("memberDetail",memberDetail);
		return "employee/systemAccountManagement/MemberDetailList";
	}
	@RequestMapping("upDateMemberInfo.me")
	public String upDateMemberInfo(Member updateMember,HttpServletRequest request) {
		int result = 0;
		if(updateMember.getMemberStatus().equals("교직원")) {	
			if(updateMember.getRankCode().equals("사원")) {
				updateMember.setRankCode("RANK1000");
			}else if(updateMember.getRankCode().equals("대리")) {
				updateMember.setRankCode("RANK1001");
			}else if(updateMember.getRankCode().equals("과장")) {
				updateMember.setRankCode("RANK1002");
			}else {
				updateMember.setRankCode("RANK1003");
			}			
			result = ms.proUpdate(updateMember);
		}
			result = ms.stuUpdate(updateMember);
		
			request.setAttribute("msg","수정이 완료 되었습니다.");
			return "common/errorAlert";	
	}
	@RequestMapping("accountDetail.me")
	public String updateAccount(MemberAccount ma,HttpServletRequest request) {
		String userId = request.getParameter("userId");
		Member employee = new Member();
		employee.setMemberId(userId);
		
		ma.setEmployeeNo(userId);
		
		Member employeeList = ms.employeeDetailList(employee);
		MemberAccount employeema = ms.employeeMachart(ma);
		
		request.setAttribute("detailemployee", employeeList);
		request.setAttribute("employeema",employeema);		
		return "employee/systemAccountManagement/employeeDetailAccount";
	}
	@RequestMapping("updateAccount.me")
	public ModelAndView updatingAccount(ModelAndView mv,MemberAccount ma,HttpServletRequest request) {		
		String classValue = request.getParameter("classValue");
		String scholarlyValue = request.getParameter("scholarlyValue");
		String enrollValue =request.getParameter("enrollValue");
		String scholValue =request.getParameter("scholValue");
		String dormitoryValue =request.getParameter("dormitoryValue");
		String boardValue =request.getParameter("boardValue");
		String memberId = request.getParameter("memberId");
		
		ma.setClassManager(classValue);
		ma.setBoardManager(boardValue);
		ma.setDormitoryManager(dormitoryValue);
		ma.setEmployeeNo(memberId);
		ma.setEnrollManager(enrollValue);
		ma.setScholarlyManager(scholarlyValue);
		ma.setScholManager(scholValue);
		
		
		ms.updatingAccount(ma);
		
		
		 mv.setViewName("jsonView");
		 return mv;
	}
	@RequestMapping("viewChangToMain.me")
	public String viewChangToMain() {
		
		return "main/main";
	}
	@RequestMapping("ajaxPagingMemberList.me")
	public ModelAndView ajaxPML(ModelAndView mv,HttpServletRequest request) {
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}		
		int listCount;
		try {
		listCount = ms.accountMember();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Member> list = ms.employeeList(pi);
		mv.addObject("list", list);
		mv.addObject("pi", pi);
		mv.setViewName("jsonView");
		}catch(Exception e) {
			mv.addObject("msg", "리스트 출력 실패");
			mv.setViewName("common/errorAlert");
		}
		return mv;
	}
	@RequestMapping("searchMember.me")
	@ResponseBody
	public ModelAndView searchMember(ModelAndView mv,HttpServletRequest request) {
		String searchValue = request.getParameter("searchValue");
		
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}		
		int listCount;
		try {			
			listCount =ms.searchMemberCount(searchValue);		
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<Member>list = ms.searchMember(searchValue,pi);
			mv.addObject("list", list);
			mv.addObject("pi", pi);		
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "검색 실패");
			/* mv.setViewName("common/errorAlert"); */
		}
		mv.setViewName("jsonView");
		return mv;
	}
	@RequestMapping("checkPwd.me")
	public String checkPwd(HttpServletRequest request,HttpSession session) {
		String chekPwd = request.getParameter("password");		
		Member loginUser =(Member) session.getAttribute("loginUser"); 	
		if(chekPwd == null) {
			String msg = request.getParameter("msg");
			if(msg!=null) {
				request.setAttribute("msg","모든 정보를 입력을해야 가능합니다.");
			}			
			return "main/checkPwd";			
		}else {			
			
			if(passwordEncoder.matches(chekPwd,loginUser.getMemberPwd())) {
				Member user =ms.memberInfo(loginUser);
				String[] address = user.getAddress().split("/");				
				request.setAttribute("user",user);
				request.setAttribute("address",address);
				return "main/updateMemberInfo";
			}else {
				request.setAttribute("msg", "비밀번호가 틀렸습니다.");
				return "common/errorAlert";
			}
		}	
	}
	@RequestMapping("updateMemberInfo1.me")
	public String updateMemberInfo(HttpServletRequest request,Member m,SessionStatus status,HttpSession session) {
		String address = request.getParameter("address1");
		String address1 = request.getParameter("address2");
		String address2 = request.getParameter("address3");
		String addressFullName = address+"/"+address1+"/"+address2;
		m.setAddress(addressFullName);
		
		try {
			if(m.getMemberPwd().equals("")||request.getParameter("pwd2").equals("")) {				
				return "redirect:checkPwd.me?msg="+1;
			}else {
				int result = ms.updateMemberInfo(m);
				return "redirect:logOut.me?result="+result;
			}		
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","수정실패 했습니다.");
			return "common/errorAlert";
		}	
		
	}
}
