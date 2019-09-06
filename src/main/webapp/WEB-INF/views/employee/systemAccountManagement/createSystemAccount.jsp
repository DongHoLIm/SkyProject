<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.sel {
	width: 24%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			<br>
			<h2>계정 발급/삭제</h2>
				<a>사용자</a>&nbsp;/<a>고급</a>
			<hr>
			<form action="excel.me" method = "post" enctype="multipart/form-data" id="excelfile-form">
				<div id="ssbox" style="width:100%">
				<input type="file" name="ExcelFile" id="file" style="display: none" />
				 	<a class="button icon solid fa-download" id="fileuploader">Excel Upload</a>
				 	<button type="submit">파일 올리기</button>	
				 				
					<div style="display:inline-block;width:50%;float:right;">
						<select class="sel" style="display: inline-block; ">
							<option>선택</option>
							<option>이름</option>
							<option>구분</option>
							<option>상태</option>
						</select>
						 <input type="text" id="search" value="" placeholder="내용을 입력해주세요" style="width: 75%; display: inline;">
					</div>	
				</div>
				</form>				
				<br>
				<div style="float:right">
					<button id="resetBtn">삭제</button>
					<button id="insertMemberAll">발급</button>
				</div>
				<br>
				<br>
				<br>
				<table id="memberlist"class="" style="margin: 0 auto;">
					<thead>
						<tr>
							<th width="30"><input type="checkbox" value="selectAll" id="Allcheck"> <label for="Allcheck"></label></th>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>한글이름</th>
							<th>영문이름</th>
							<th>주민번호</th>
							<th>연락처</th>
							<th>이메일</th>
							<th>주소</th>
							<th>구분</th>
							<th>학과/부서</th>												
							<th>직급/은행명</th>
							<th>계좌번호</th>			
						</tr>
					</thead>
					<c:if test="${!empty insertMember_parent }">
						<tbody>
						<c:forEach var="insertMember" items="${insertMember_parent}">
								<tr class="trClass">		
									<td><input type="checkbox" value="selectOne" id="Allcheck"><label for="Allcheck"></label></td>
									<td>${insertMember.memberId}</td>
									<td>${insertMember.memberPwd}</td>
									<td>${insertMember.memberKName}</td>
									<td>${insertMember.memberEName}</td>
									<td>${insertMember.memberNo}</td>
									<td>${insertMember.phone}</td>
									<td>${insertMember.email}</td>
									<td>${insertMember.address}</td>								
									<c:if test="${insertMember.memberStatus== 1}">
										<td>학생</td>
									</c:if>
									<c:if test="${insertMember.memberStatus == 2}">
										<td>교수</td>
									</c:if>
									<c:if test="${insertMember.memberStatus == 3}">
										<td>교직원</td>
									</c:if>
									<td>${insertMember.sdeptCode }</td>
									<c:if test="${! empty insertMember.rankCode }">
										<td>${insertMember.rankCode}</td>
									</c:if>	
									<td>${insertMember.bankNumber}</td>					
								</tr>
						</c:forEach>
						</tbody>
						<script>
						 $("#insertMemberAll").click(function(){
							 $(function(){
								 var resultMember = new Object();
								 var member = new Object();
								var list = new Array();
								
								 
								 $(".trClass").each(function(){
									
									var memberId = $(this).children().eq(1).text();
									var memberPwd = $(this).children().eq(2).text();
									var memberKName = $(this).children().eq(3).text();
									var memberEName = $(this).children().eq(4).text();
									var memberNo = $(this).children().eq(5).text();
									var phone = $(this).children().eq(6).text();
									var email = $(this).children().eq(7).text();
									var address = $(this).children().eq(8).text();
									var memberStatus = $(this).children().eq(9).text();
									var sdeptCode =$(this).children().eq(10).text();
									var rankCode=$(this).children().eq(11).text();
									var bankNumber=$(this).children().eq(12).text();
									member = {
											memberId : memberId,
											memberPwd : memberPwd,
											memberKName : memberKName,
											memberEName : memberEName,
											memberNo : memberNo,
											phone : phone,
											email : email,
											address : address,
											memberStatus : memberStatus,
											sdeptCode : sdeptCode,
											rankCode : rankCode,
											bankNumber : bankNumber
									}
									list.push(member);
								 });
								 resultMember.list = list;
								 
								 var resultStr = JSON.stringify(resultMember);
							 	 $.ajax({
										url:"insertMember.me",
										type:"post",
										data: {resultStr : resultStr},
										success:function(data){
											console.log("hellow")
										},
										error:function(data){
											alert("정보삽입이 완료 되었습니다.");
										}
										
									}); 
							 });
						 });						 
							
						
						</script>
					</c:if>
				</table>	
		</div>		
		</div>		
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
	<script>	
		$("#fileuploader").click(function(){
			$("#file").click();
		}) 
	</script>
</body>
</html>