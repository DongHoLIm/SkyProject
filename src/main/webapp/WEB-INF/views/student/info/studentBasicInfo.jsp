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
<link rel="stylesheet" href="assets/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
   rel="stylesheet">
<style>
#basic {
	padding: 10px 0px 0px 100px;
    
}

table.basicinfo td{
	background: #FFF;

}
td.td	{
	text-align: center;
	background: #c7c5b7 !important;
	color:black;
	width:100px !important;
	
}


table.basicinfo {
	width:85%;
	border: 1px solid #dde1e3;
	margin-left: auto;
	margin-right: auto;
}

#modified {
	margin-left: 80%;
}


</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			   <h4 id="basic">기본 정보</h4>
            <form class="ba">
            <table class="basicinfo">
            	<tr>
	            	<td class="td">학번</td>
	            	<td colspan='5'><input type="text" value="123456789" readonly></td>
            	</tr>
            	
            	<tr>
	            	<td class="td">한글 성명</td>
	            	<td><input type="text" value="홍길동" readonly></td>
	            	<td class="td">영문 성명</td>
	            	<td><input type="text" value="In Woo Kang" readonly></td>
	            	<td class="td">한문 성명</td>
	            	<td><input type="text" value="姜因遇" readonly></td>
            	</tr>
            	
            	<tr>
	            	<td class="td">주민 번호</td>
	            	<td><input type="text" value="940205-*******" readonly></td>
	            	<td class="td">생년월일</td>
	            	<td><input type="text" value="2000.07.26" readonly></td>
	            	<td class="td">성별</td>
	            	<td><input type="text" value="남" readonly></td>
            	</tr>
            	
            	<tr>
	            	<td class="td">학부(과)</td>
	            	<td><input type="text" value="소프트웨어 응용" readonly></td>
	            	<td class="td">전공</td>
	            	<td><input type="text" value="컴퓨터 공학" readonly></td>
	            	<td class="td">학년</td>
	            	<td><input type="text" value="1" readonly></td>
            	</tr>
            	
            	<tr>
	            	<td class="td">학적 상태</td>
	            	<td><input type="text" value="재학" readonly></td>
	            	<td class="td">주야</td>
	            	<td><input type="text" value="주간" readonly></td>
	            	<td class="td">병역 구분</td>
	            	<td><input type="text" value="" readonly></td>
            	</tr>
            	
            </table>
            
            <!-- 신상 정보 조회 -->
            	<h4 id="basic">신상 정보 조회</h4>
            	<table class="basicinfo">
            	<tr>
	            	<td class="td">한글 성명</td>
	            	<td><input type="text" value="강인우" readonly></td>
	            	<td class="td">영문 성명</td>
	            	<td><input type="text" value="In Woo Kang" readonly></td>
	            	<td class="td">한문 성명</td>
	            	<td><input type="text" value="姜因遇" readonly></td>
            	</tr>
            	
            	<tr>
	            	<td class="td">주소</td>
	            	<td colspan='5'><input style="width: 50%; display: inline-block;" type="text" value="서울시 역삼동" readonly>
	            				    <input style=" display: inline-block; width:30%;" type="text" value="체르노빌 201호">
	            					<input style=" display: inline-block;" type="button" value="검색">				
	            	</td>
            	</tr>
            	<td class="td">주민등록 주소지</td>
	            	<td colspan='5'><input type="checkbox" id="checkadd">
	            					<input style="width: 50%; display: inline-block;" type="text" value="서울시 역삼동" readonly>
	            				    <input style=" display: inline-block; width:30%;" type="text" value="체르노빌 201호">
	            					<input style=" display: inline-block;" type="button" value="검색">				
	            	</td>
            	
            		<tr>
	            		<td class="td">전자 우편</td>
		            	<td><input type="text" value="7479383@hanmail.net" readonly></td>
		            	<td class="td">전화 번호</td>
		            	<td><input type="text" value="031-383-7479" readonly></td>
		            	<td class="td">휴대폰 번호</td>
		            	<td><input type="text" value="010-9478-2687" readonly></td>
	            	</tr>
	            
		            	
	            	<tr>
						<td class="td">은행명</td>
		            	<td><select name='bank'>
							  <option value=''>-- 선택 --</option>
							  <option value='KAKAO' selected>카카오 뱅크</option>
							  <option value='NHD' disabled>농협</option>
							  <option value='SH' label=''>신한은행</option>
						</select></td>
		            	<td class="td">계좌 번호</td>
		            	<td><input type="text" value="3560306" readonly></td>
		            	<td class="td">예금주</td>
		            	<td><input type="text" value="강인우" readonly></td>
	            	</tr>
	          	
            </table>
          	
          	<table class="basicinfo">
          		<tr>
					<td class="td">보호자성명</td>
		            <td><input type="text" value="홍길동" readonly></td>
		            <td class="td">보호자관계</td>
		            <td>
		            	<select name='pa'>
							  <option value=''>-- 선택 --</option>
							  <option value='father' selected>부</option>
							  <option value='mather' selected>모</option>
						</select>
						
					</td>
					<td class="td">보호자<br>연락처</td>
		            <td><input type="text" value="010-9478-2687" readonly></td>
		       		
		       </tr>
		       <tr>
					<td class="td">보호자<br>주소</td>
		            <td><input type="text" value="홍길동" readonly></td>
		            <td colspan='5'><input style="width: 50%; display: inline-block;" type="text" value="서울시 역삼동" readonly>
	            				    <input style=" display: inline-block; width:30%;" type="text" value="체르노빌 201호">
	            					<input style=" display: inline-block;" type="button" value="검색">		
		       		
		       </tr>
		       
		       <table id="modified">
		       
		       		<input type="button" value="신상정보 수정" id="modified">
		     
		       </table>
          	</table>  
      	</form>		
		</div>
		<div>
		<jsp:include page="../../common/menubar-student.jsp" />
	</div>
</div>
</body>
</html>