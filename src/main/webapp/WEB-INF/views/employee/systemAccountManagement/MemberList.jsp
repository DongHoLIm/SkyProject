<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정조회및 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.updateAccount{
		display: inline-block;
	}
	#MemberList tr th{
		text-align: center;
	}
	#MemberList tr td{
		text-align: center;
	}
	#search{
		width: 200px;
	}
	.searchArea{
		display: inline-block;
	}
	#MemberList tbody tr:hover{		
		color : black;
	}
	.pagination li a{
		background:white;
		border:0.5px solid #f56a6a;			
		cursor: pointer;
	}
</style>
</head>
<body>
	<c:set var="member" value="${loginUser.memberStatus}" />
	<c:set var="memberList" value="${requestScope.MemberList }"/>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>				
				<h3 class="updateAccount">계정조회및 수정</h3>
				<div style="float: right;">				
				<button class="updateAccount" >수정</button>
				<button type="reset"class="updateAccount" >취소</button>
				</div>
				<hr />				
				<div class="searchArea" style="float: right;">
					<input type="text" name="searchBar" class="searchArea"/>
					<button class="searchArea">Search</button>
				</div>
				<table id="MemberList">					
					<thead>
						<tr>							
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>이메일</th>						
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${memberList }">
						<tr>							
							<td>${a.memberId}</td>
							<td>${a.memberPwd }</td>
							<td>${a.memberKName }</td>
							<td>${a.email }</td>
							<c:if test="${a.memberStatus==3 }">
							<td>교직원</td>
							</c:if>
							<c:if test="${a.memberStatus==2 }">
							<td>교수</td>
							</c:if>
							<c:if test="${a.memberStatus==1 }">
							<td>학생</td>
							</c:if>							
						</tr>						
						</c:forEach>
					</tbody>					
				</table>
				<c:set var = "pageInfo" value="${pi }"/>
				<ul class="pagination" align="center">
					<c:if test = "${pi.currentPage<=1 }">
						<li><span class="button disabled">Prev</span></li>
					</c:if>
					<c:if test = "${pi.currentPage>1 }">
						<li><span class="button">Prev</span></li>
					</c:if>
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}"> 
						<c:if test="${p eq pi.currentPage }">
							<li><p class="page active">${p}</p></li>
						</c:if>
						<c:if test ="${p ne pi.currentPage }">
							<li><a class="page" onclick="pagingAjax(${p});">${p}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pi.currentPage < pi.maxPage }">					
					<li><span class="button">next</span></li>
					</c:if>
					<c:if test = "${pi.currentPage ==pi.maxPage }">
					<li><span class="button disabled">Next</span></li>
					</c:if>
				</ul>		
		</div>
			</div>
		<div>		
			<jsp:include page="../../common/menubar-employee.jsp" />	
		</div>
	</div>	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script type="application/json">
	function pagingAjax(index){		
		var currentPage =index;
			$.ajax({
				uri : "MemberList.me",
				data: {"currentPage":currentPage},					
				type:"post",
				success: function(data){
					console.log("성공"+data);
				}				
						
			});
			
		}
	</script>
</body>
</html>