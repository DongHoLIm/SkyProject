<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
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
   width: 100px !important;
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
         
         <%-- <h4 id="basic">기본 정보</h4>
       
            <table class="basicinfo">
               <tr>
                  <td class="td">학번</td>
                  <td colspan='5'>${basicInfo.studentNo }</td>
               </tr>

               <tr>
                  <td class="td" width="15%">한글 성명</td>
                  <td width="21%">${basicInfo.kName }</td>
                  <td class="td" width="15%">영문 성명</td>
                  <td width="21%">${basicInfo.eName }</td>
                  <td class="td" width="15%">한문 성명</td>
                  <td width="13%"> </td>
               </tr>
               
               <c:set var="memberNo" value="${basicInfo.memberNo }"/>
			   <c:set var="birthYear" value="${ fn:substring(memberNo, 0, 2 ) }"/>
			   <c:set var="birthMonth" value="${ fn:substring(memberNo, 2, 4 ) }"/>
			   <c:set var="birthDay" value="${ fn:substring(memberNo, 4, 6 ) }"/>
              
              <c:set var="genderArr" value="${ fn:split(memberNo, '-') }"/>
              <c:set var="genderNo" value="${ genderArr[1] }"/>
              <c:choose>
				<c:when test="${ genderNo==1 || genderNo==3}">
					<c:set var="gender" value="남"/>
				</c:when>
				<c:otherwise>
					<c:set var="gender" value="여"/>
				</c:otherwise>
			  </c:choose>
              
              
               <tr>
                  <td class="td">주민 번호</td>
                  <td>${basicInfo.memberNo }</td>
                  <td class="td">생년월일</td>
                  <td>${birthYear }.${birthMonth }.${birthDay }</td>
                  <td class="td">성별</td>
                  <td>${gender }</td>
               </tr>
               
              <c:set var="sdeptName" value="${basicInfo.sdeptName }"/>
              <c:set var="sdeptLength" value="${ fn:length(sdeptName) }"/>
			  <c:set var="major" value="${ fn:substring(sdeptName, 0, sdeptLength-1 ) }"/>
			  

               <tr>
                  <td class="td">학과</td>
                  <td>${basicInfo.sdeptName }</td>
                  <td class="td">전공</td>
                  <td>${ major} 전공</td>
                  <td class="td">학년</td>
                  <td>${basicInfo.grade }</td>
               </tr>

               <tr>
                  <td class="td">학적 상태</td>
                  <td>${basicInfo.studentStatus }</td>
                  <td class="td">주야</td>
                  <td>주간</td>
                  <td class="td">병역 구분</td>
                  <td></td>
               </tr>

            </table>

 --%>


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
                  <td class="td" width="20%">복수 전공 1</td>
                  <td width="30%"></td>
                  <td class="td" width="20%">복수 전공 2</td>
                  <td width="30%"></td>
               </tr>
               <tr>
                  <td class="td">부 전공 1</td>
                  <td></td>
                  <td class="td">부 전공 2</td>
                  <td></td>
               </tr>
            </table>

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
         
      </div>
      <div>
         <jsp:include page="../../common/menubar-student.jsp" />
      </div>
   </div>

</body>
</html>