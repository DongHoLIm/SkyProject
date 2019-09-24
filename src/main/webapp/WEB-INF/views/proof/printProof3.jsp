<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
	#h1 {
		align: center;
		margin-top: 15%;
	}
	
</style>
</head>
<body>
	<div align="center" style="border:1px solid black; width:600px; height:1000px; padding:1em 1em 1em 1em;">
		<h1 id="h1">졸업 증명서</h1>
		<table align="center" style="text-align:center; border-spacing: 0 50px;">
			<tr>
				<td style="text-align:left">이름 : </td>
				<td style="text-align:left">${proofInfo.memberKName}</td> 
			</tr>
			<tr>
				<td style="text-align:left">학번 : </td>
				<td style="text-align:left">${proofInfo.memberId}</td> 
			</tr>
			<tr>
				<td style="text-align:left">주민등록번호 : </td>
				<td style="text-align:left">${proofInfo.memberNo}******</td> 
			</tr>
			<tr>
				<td style="text-align:left">학위번호 : </td>
				<td style="text-align:left">${proofInfo.degreeNo}</td> 
			</tr>
			<tr>
				<td style="text-align:left">학위명 : </td>
				<td style="text-align:left">${proofInfo.degreeName}</td> 
			</tr>
			<tr>
				<td style="text-align:left">졸업년월일 : </td>
				<td style="text-align:left">
					<fmt:parseDate value="${proofInfo.graduatedDate}" var="graduatedDate" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${graduatedDate}" pattern="yyyy/MM/dd"/>
				</td> 
			</tr>
			<tr>
				<td style="text-align:left">졸업증서번호 : </td>
				<td style="text-align:left">${proofInfo.graduatedNo}</td> 
			</tr>
			<tr>
				<td colspan="2">위의 사실을 증명합니다.</td>
			</tr>
			<tr>
				<td colspan="2">
					<fmt:parseDate value="${proofInfo.printDate}" var="printDate" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${printDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
		</table>		
		<br>		
		<h1>K H 대 학 교 총 무 처 장</h1>
	</div>
	<script>
		window.print();
	</script>
</body>
</html>