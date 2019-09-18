<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	.basic {
		padding: 10px 0px 0px 100px;
	}
	
	.explusionInfo {
	   width: 85%;
	   text-align: center; 
	   margin: 0 auto;
	   border: 1px solid #dde1e3;
	}
	
	.enrollSpan:hover {
		cursor: pointer;
		color: red;
	}
	
	.rejectSpan:hover {
		cursor: pointer;
		color: red;
	}
	
	.pagingArea, .pagingArea2 {
		margin-top: 2%;
	}	
	
	.search {
		width: 85%;
		text-align: center;
		margin: 0 auto;
	}
	
	.searchArea {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.searchArea2 {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.inputArea {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.inputArea2 {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.btnArea {
		float: right;
		padding-left: 1%;
	}
	
	.btnArea2 {
		float: right;
		padding-left: 1%;
	}
	
	.h4Area {
		float: left;
		padding-left: 1%;
	}
	
</style>
<script>
	$(function(){
		$.ajax({
			url:"em_ExplusionList.si",
			type:"POST",
			success:function(){
				console.log("연결성공!");
			} // success 끝
		}) // 첫 번째 ajax 끝
	}); // onload funcion 끝
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<br><br>
			<div class="search">
				<div class="h4Area">
					<h4>제적 대상자</h4>
				</div>
				<div class="btnArea">
					<button id="firstBtn">검색</button>
				</div>
				<div class="inputArea">
					<input type="text" id="searchValue" name="searchValue">	
				</div>
				<div class="searchArea">
					<select id="searchCondition" name="searchCondition">
						<option value="all">전체보기</option>
						<option value="studentNo">학번</option>
						<option value="sdeptName">학과</option>
						<option value="studentNo">이름</option>
					</select>		
				</div>				
			</div>
			<table class="explusionInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">단과대학</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">제적 사유</th>
						<th style="text-align: center">관리</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>	
			
			<br><br>
					
			<div class="search">
				<div class="h4Area">
					<h4>제적 처리 내역</h4>
				</div>
				<div class="btnArea2">
					<button id="secondBtn">검색</button>
				</div>
				<div class="inputArea2">
					<input type="text" id="searchValue2" name="searchValue2">	
				</div>
				<div class="searchArea2">
					<select id="searchCondition2" name="searchCondition2">
						<option value="all">전체보기</option>
						<option value="studentNo">학번</option>
						<option value="sdeptName">학과</option>
						<option value="studentNo">이름</option>
					</select>		
				</div>
			</div>
			<table class="explusionInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">단과대학</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">제적 사유</th>
						<th style="text-align: center">제적일</th>
					</tr>
				</thead>
				<tbody id="tbody2">
					
				</tbody>
			</table>
			<div class="pagingArea2">
			
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</body>
</html>