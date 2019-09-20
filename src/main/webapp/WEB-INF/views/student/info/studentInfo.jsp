<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
 <link rel="stylesheet" href="resources/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
   rel="stylesheet">
  
<style>
#basic {
   padding: 10px 0px 0px 100px;
}

table.basicinfo td {
   background: #FFF;
}

td.td {
   text-align: center;
   background: #c7c5b7 !important;
   color: black;
  
}

table.basicinfo {
   width: 85%;
   border: 1px solid #dde1e3;
   margin-left: auto;
   margin-right: auto;
} 

#Change {
   text-align: center;
   border: 1px solid #dde1e3;
}

#t1 {
   background: #c7c5b7;
   border: 1px solid #dde1e3;
}
</style>
</head>
<body>
   <div id="wrapper">
      <div id="main">
         <div class="inner">
            <jsp:include page="../../common/header.jsp" />
         </div>
         
         <jsp:include page="../info/common.jsp" />         


            <h4 id="basic">입학 사항</h4>

            <table class="basicinfo">
               <tr>
                  <td class="td" width="20%">입학 구분</td>
                  <td width="30%">${stuInfo.enrolType }</td>
                  <td class="td" width="20%">입학 일자</td>
                  <td width="30%">${stuInfo.enrolDate }</td>
               </tr>
               <tr>
                  <td class="td">입학 학년</td>
                  <td>${stuInfo.enroleGrade }</td>
                  <td class="td">수험 번호</td>
                  <td>${stuInfo.enrolNo }</td>
               </tr>
            </table>

            <h4 id="basic">복수 / 부전공</h4>

            <table class="basicinfo">
               <tr>
               	  <c:if test="${empty smInfo}">
	                  <td class="td" width="20%">복수전공</td>
	                  <td width="30%"></td>
	                  <td class="td" width="20%">부전공</td>
	                  <td width="30%"></td>
                  </c:if>
                  <c:if test="${!empty smInfo}">
                  	  <c:if test="${smInfo.majorCheck eq '복수전공'}">
	                  	  <td class="td" width="20%">복수전공</td>
		                  <td width="30%">${smInfo.sdeptName}</td>
		                  <td class="td" width="20%">부전공</td>
		                  <td width="30%"></td>
	                  </c:if>
	                  <c:if test="${smInfo.majorCheck eq '부전공'}">
	                  	  <td class="td" width="20%">복수전공</td>
		                  <td width="30%"></td>
		                  <td class="td" width="20%">부전공</td>
		                  <td width="30%">${smInfo.sdeptName}</td>
	                  </c:if>
                  </c:if>
               </tr>
            </table>
            
            <h4 id="basic">전과 정보</h4>

            <table class="basicinfo">
               <tr>
               	  <c:if test="${empty cmInfo}">
	                  <td class="td" width="20%">현재학과</td>
	                  <td width="30%"></td>
	                  <td class="td" width="20%">변경학과</td>
	                  <td width="30%"></td>
                  </c:if>
                  <c:if test="${!empty cmInfo}">
                  	  <c:if test="${cmInfo.status eq '승인'}">
	                  	  <td class="td" width="40%">전과 전 학과</td>
		                  <td width="30%">${cmInfo.beforeMajorName}</td>
		                  <td class="td" width="20%">전과 후 학과</td>
		                  <td width="30%">${cmInfo.changeSdeptName}</td>
	                  </c:if>
	                  <c:if test="${cmInfo.status ne '승인'}">
	                  	  <td class="td" width="20%">현재 학과</td>
		                  <td width="30%">${cmInfo.beforeMajorName}</td>
		                  <td class="td" width="20%">신청 학과</td>
		                  <td width="30%">${cmInfo.changeSdeptName}</td>
	                  </c:if>
                  </c:if>
               </tr>
            </table>
			<c:if test="${empty expInfo or empty dpoInfo}">
	            <h4 id="basic">졸업 사항</h4>
	
	            <table class="basicinfo">
	               <tr>
	                  <td class="td" width="20%">졸업 일자</td>
	                  <td width="30%">${stuInfo.graduatedDate }</td>
	                  <td class="td" width="20%">졸업 증서 번호</td>
	                  <td width="30%">${stuInfo.graduatedNo }</td>
	               </tr>
	               <tr>
	                  <td class="td">학위명</td>
	                  <td>${stuInfo.degreeName }</td>
	                  <td class="td">학위 등록 번호</td>
	                  <td>${stuInfo.graduatedNo }</td>
	               </tr>
	            </table>
	        </c:if>
	        <c:if test="${!empty expInfo}">
	            <h4 id="basic">제적 정보</h4>
	
	            <table class="basicinfo">
	               <tr>
	                  <td class="td" width="20%">제적번호</td>
	                  <td width="30%">${expInfo.explusionNo }</td>
	                  <td class="td" width="20%">학번</td>
	                  <td>${expInfo.studentNo }</td>
	               </tr>
	               <tr>
	                  <td class="td" width="20%">제적사유</td>
	                  <td width="30%">${expInfo.explusionReason }</td>
	                  <td class="td" width="20%">제적일</td>
	                  <td width="30%">${expInfo.explusionDate }</td>
	               </tr>
	            </table>
	        </c:if>
	         <c:if test="${!empty dpoInfo}">
	            <h4 id="basic">자퇴 정보</h4>
	
	            <table class="basicinfo">
	               <tr>
	                  <td class="td" width="20%">자퇴번호</td>
	                  <td width="30%">${dpoInfo.dropNo }</td>
	                  <td class="td" width="20%">학번</td>
	                  <td>${dpoInfo.studentNo }</td>
	               </tr>
	               <tr>
	                  <td class="td" width="20%">자퇴사유</td>
	                  <td width="30%">${dpoInfo.dropReason }</td>
	                  <td class="td" width="20%">자퇴일</td>
	                  <td width="30%">${dpoInfo.successDate }</td>
	               </tr>
	            </table>
	        </c:if>         
      </div>
      <div>
         <jsp:include page="../../common/menubar-student.jsp" />
      </div>
   </div>

</body>
</html>