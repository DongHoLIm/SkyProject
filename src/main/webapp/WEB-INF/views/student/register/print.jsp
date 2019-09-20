<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
<div align="center" style="border:1px solid black; width:800px; height:950px; padding:1em 1em 1em 1em;">
		<h2 align="left">제 1 호</h2>
		<h1 align="center">등록금 확인증</h1>
		<table align="center" style="text-align:center">
		<c:forEach var="print" items="${ printCheck }">
			<tr>
			<td>소속 : </td>
			<td style="text-align:left"><c:out value="${print.college}" />&nbsp;&nbsp;<c:out value="${print.sdeptName}" /></td> 
			</tr>
			<tr>
			<td>학년/학기 : </td>
			<td><c:out value="${print.grade}" />/<c:out value="${print.enrollSemester}" /></td> 
			</tr>
			<tr>
			<td>학번 : </td>
			<td><c:out value="${print.studentNo}" /></td> 
			</tr>
			<tr>
			<td>주민등록번호 : </td>
			<td><c:out value="${print.memberNo}" /></td> 
			</tr>
			<tr>
			<td>성명 : </td>
			<td><c:out value="${print.memberKname}" /></td> 
			</tr>
			<tr>
			<td>등록일자 : </td>
			<td><c:out value="${print.enrollYear}" /></td> 
			</tr>
			<tr>
			<td>등록상태 : </td>
			<td><c:out value="${print.payStatus}" /></td> 
			</tr>
		</c:forEach>
		</table>
		
		<h3 align="center">-학년도 제 학기 등록 내역-</h3>
		
		<table align="center" text-align="center"  style="border: 1px solid black">
		<thead  style="border: 1px solid black">
			<tr rowspan="2">구분</tr>
			<tr rowspan="2">금액</tr>
		</thead>
		<tbody style="border: 1px solid black">
			<tr rowspan="5"  style="border: 1px solid black">
			<td style="border: 1px solid black">입학금</td>
			<td rowspan="2"  style="border: 1px solid black"></td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">등록금</td>
			<td rowspan="2"  style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">감면금액</td>
			<td rowspan="2"  style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">장학내역</td>
			<tdrowspan="2"  style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">계</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr rowspan="8" style="border: 1px solid black">
			<td style="border: 1px solid black">학생회비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">원우회비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">동문회비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">자치회비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">신체 검사비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">교과서비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">생활관비</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr style="border: 1px solid black">
			<td style="border: 1px solid black">계</td>
			<td rowspan="2" style="border: 1px solid black">0</td>
			</tr>
			<tr rowspan="2" style="border: 1px solid black"></tr>
		</tbody>
		</table>
		<h3>년월일</h3>
		
		<br>
		
		<h1 align="center">K H 대 학 교 총 무 처 장</h1>
	</div>
</body>
</html>