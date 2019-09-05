package com.kh.finalProject.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalProject.common.CommonUtils;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.vo.Member;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	@Autowired
	private MemberService ms;
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	//비밀번호 (암호화 비처리 메소드 )
	@RequestMapping("login.me")
	public String loginMember(Member m,Model model) {

		Member loginUser=null;

		try {			
			loginUser = ms.loginCheck(m);
			model.addAttribute("loginUser",loginUser);			
			return "redirect:loginOk.me";									
		} catch (loginException e) {			
			model.addAttribute("msg",e.getMessage());
			return "common/errorAlert";
		} 
	}
	@RequestMapping("loginOk.me")
	public String loginOk(Member loginUser) {

		return "main/main";
	}
	//비밀번호 (암호화 처리 메소드)


	//로그 아웃  
	@RequestMapping("logOut.me" )
	public String logOut(SessionStatus status,@ModelAttribute("loginUser") Member loginUser) {		
		ms.logOutLoginCheck(loginUser);
		status.isComplete();	
		return "main/Login";
	}

	//교직원 계정 발급 Page 이동 
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
	            for(rowindex=0;rowindex<rows;rowindex++){
	                //행을읽는다
	                XSSFRow row=sheet.getRow(rowindex);
	                if(row !=null){
	                    //셀의 수
	                    int cells=row.getPhysicalNumberOfCells();
	                    Member insertMember = new Member();
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
	                        	}
	                        }	
	                    }
	                    list.add(insertMember);
	                }
	            }
	            model.addAttribute("insertMember_parent", list);
	            return "employee/systemAccountManagement/createSystemAccount";
		} catch (IllegalStateException e) {
			new File(filepath+"\\"+changeName+ext).delete();
			return "common/errorAlert";
		} catch (IOException e) {
			new File(filepath+"\\"+changeName+ext).delete();
			return "common/errorAlert";
			
		}
	}
//	@RequestMapping(value="insertMember.me")
//	public String insertMember(@RequestParam(value="listmember", required=true) List<String> values) {
//		
//		
//		for(int i =0;i<values.size();i++) {
//			System.out.println("[start]" + values.get(i) + "[end]");
//		}
//		ms.insertMember(values);
//		
//		
//		return "employee/systemAccountManagement/createSystemAccount";
//	}
	@RequestMapping(value="insertMember.me")
	public ModelAndView insertMember(ModelAndView mv,String resultStr) {
		System.out.println(resultStr);
		
		 ObjectMapper mapper = new ObjectMapper();
	     Map<Object, Object> memberMap = new HashMap<Object, Object>();
	     
	     try {
			memberMap = mapper.readValue(resultStr, new TypeReference<Map<Object, Object>>(){});
			System.out.println("memberMap::" + memberMap);
			
			ArrayList<Object> list = (ArrayList<Object>) memberMap.get("list");
			System.out.println(list.get(1));
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

}
