<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4 id="basic">기본 정보</h4>
       
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
                  <td class="td">학적 상태</td>
                  <td>${basicInfo.studentStatus }</td>
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
            </table>


</body>
</html>