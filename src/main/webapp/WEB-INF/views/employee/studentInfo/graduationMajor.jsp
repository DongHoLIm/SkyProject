<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
#tableArea tbody tr td:last-child:hover {
	font-weight: bold;
	cursor: pointer;
}

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
			<!-- 입력 라인  -->
			<br>
			<h2 style="width:85%; margin: 0 auto;">학과 졸업 인증 기준</h2>
			<br>
			
			<div id="searchArea" style="width:85%; text-align: center; margin: 0 auto;">
			<table>
			<tr>
				<td>
					<select id="collegeCondition" name="collegeCondition">
						<option value="단과대학">단과대학</option>
						<option value="인문대학">인문대학</option>
						<option value="예술대학">예술대학</option>
						<option value="공과대학">공과대학</option>
					</select>
				</td>
				<td>
					<select id="sdeptCondition" name="sdeptCondition">
						<option value="학과">학과</option>
						<option value="경영학과">경영학과</option>
						<option value="경제학과">경제학과</option>
						<option value="정치외교과">정치외교과</option>
						<option value="실용음악과">실용음악과</option>
						<option value="사회체육과">사회체육과</option>
						<option value="컴퓨터공학과">컴퓨터공학과</option>
						<option value="전자공학과">전자공학과</option>
						<option value="건축학과">건축학과</option>
					</select>
				</td>
				
				<td>
					<button onclick="searchStandard();">검색</button>
				</td>
				
			</tr>
			
			</table>
			
			
			</div>
			
			<table id="tableArea" style="width:85%; text-align: center; margin: 0 auto;">
			<thead>
				<tr>
					<th width="10%" style="text-align:center">구분</th>
					<th width="15%" style="text-align:center">졸업인증 코드</th>
					<th width="15%" style="text-align:center">단과대학</th>
					<th width="10%" style="text-align:center">학과</th>
					<th width="15%" style="text-align:center">졸업인증 명칭</th>
					<th width="25%" style="text-align:center">내용 수정</th>
				</tr>
			</thead>	
			
			<tbody id="tbody">
				<c:forEach var="list" items="${list }">
					<tr>
						<td><c:out value="${list.division }"/></td>
						<td><c:out value="${list.graduationCode }"/></td>
						<td><c:out value="${list.college }"/></td>
						<td><c:out value="${list.sdeptName }"/></td>
						<td><c:out value="${list.graduationName }"/></td>
						<td class="btn">상세보기 / 수정하기</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<div class="pagingArea" align="center">
			
			</div>
			
			<script>
			
			$(function(){
				$.ajax({
					url:"em_graduationMaPage.si",
					type:"get",
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						
						var $tbody = $("#tbody");
						
						$tbody.children().remove();
						
						console.log("data.list.length::" + data.list.length);
						
						for(var i=0 ; i<data.list.length ; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align:center;'>");
							var $td2 = $("<td style='text-align:center;'>");
							var $td3 = $("<td style='text-align:center;'>");
							var $td4 = $("<td style='text-align:center;'>");
							var $td5 = $("<td style='text-align:center;'>");
							var $td6 = $("<td class='btn' style='text-align:center;'>");
							
							$td1.text(data.list[i].division);
							$td2.text(data.list[i].graduationCode);
							$td3.text(data.list[i].college);
							$td4.text(data.list[i].sdeptName);
							$td5.text(data.list[i].graduationName);
							$td6.text("상세보기  / 수정하기");
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
						}
						
						$(".btn").click(function(){
							
							var code = $(this).parents().children("td").eq(1).text();
							
							console.log(code);
							
							window.open("em_selectGraduationMa.si?code="+code,'changMa' ,"height=550, width=900");

						});
						
						
						
						var currentPage = data.pi.currentPage;
						var listCount = data.pi.listCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;
						
						console.log(currentPage);
						
						var $ul = $("<ul>");
						$ul.addClass("pagination");
						$ul.attr({
							"style":"justify-content: center; cursor: pointer;"
						});
						
						
						var $li1 = $("<li>");
						var $a1 = $("<a>");
						
						if(currentPage <= 1){
							$li1.addClass("page-item disabled");
							$a1.addClass("page-link");					
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);					
						}else if(currentPage > 1){
							$li1.addClass("page-item");
							$a1.addClass("page-link");
							$a1.attr({
								"onclick":"loadPage("+(currentPage-1)+")",
							});
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);
						}					
						
						for(var p = startPage; p <= endPage; p++){
							var $li2 = $("<li>");
							var $a2 = $("<a>");		
							$li2.addClass("page-item");
							$a2.addClass("page-link");
							$a2.attr({
								"onclick":"loadPage("+p+")",
							});
							$a2.html(p);
							$li2.append($a2);
							$ul.append($li2);				
						}
						
						var $li3 = $("<li>");
						var $a3 = $("<a>");	
						
						if(currentPage < maxPage){
							$li3.addClass("page-item");
							$a3.addClass("page-link");
							$a3.attr({
								"onclick":"loadPage("+(currentPage+1)+")",
							});
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);	
						}else{
							$li3.addClass("page-item disabled");
							$a3.addClass("page-link");
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);
						}
						
						$(".pagingArea").children().remove();
						$(".pagingArea").append($ul);
			
						
					}
				});
			})
			
			function loadPage(curr){
				var currentPage = curr;
				console.log(currentPage);
				
				$.ajax({
					url:"em_graduationMaPage.si",
					type:"get",
					data:{currentPage:currentPage},
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						
						var $tbody = $("#tbody");
						
						$tbody.children().remove();
						
						for(var i=0 ; i<data.list.length ; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align:center;'>");
							var $td2 = $("<td style='text-align:center;'>");
							var $td3 = $("<td style='text-align:center;'>");
							var $td4 = $("<td style='text-align:center;'>");
							var $td5 = $("<td style='text-align:center;'>");
							var $td6 = $("<td class='btn' style='text-align:center;'>");
							
							$td1.text(data.list[i].division);
							$td2.text(data.list[i].graduationCode);
							$td3.text(data.list[i].college);
							$td4.text(data.list[i].sdeptName);
							$td5.text(data.list[i].graduationName);
							$td6.text("상세보기  / 수정하기");
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
						}
						
						$(".btn").click(function(){
							
							var code = $(this).parents().children("td").eq(1).text();
							
							console.log(code);
							
							window.open("em_selectGraduationMa.si?code="+code,'changMa' ,"height=550, width=900");

						});
						
						var currentPage = data.pi.currentPage;
						var listCount = data.pi.listCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;
						
						console.log(currentPage);
						
						var $ul = $("<ul>");
						$ul.addClass("pagination");
						$ul.attr({
							"style":"justify-content: center; cursor: pointer;"
						});
						
						
						var $li1 = $("<li>");
						var $a1 = $("<a>");
						
						if(currentPage <= 1){
							$li1.addClass("page-item disabled");
							$a1.addClass("page-link");					
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);					
						}else if(currentPage > 1){
							$li1.addClass("page-item");
							$a1.addClass("page-link");
							$a1.attr({
								"onclick":"loadPage("+(currentPage-1)+")",
							});
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);
						}					
						
						for(var p = startPage; p <= endPage; p++){
							var $li2 = $("<li>");
							var $a2 = $("<a>");		
							$li2.addClass("page-item");
							$a2.addClass("page-link");
							$a2.attr({
								"onclick":"loadPage("+p+")",
							});
							$a2.html(p);
							$li2.append($a2);
							$ul.append($li2);				
						}
						
						var $li3 = $("<li>");
						var $a3 = $("<a>");	
						
						if(currentPage < maxPage){
							$li3.addClass("page-item");
							$a3.addClass("page-link");
							$a3.attr({
								"onclick":"loadPage("+(currentPage+1)+")",
							});
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);	
						}else{
							$li3.addClass("page-item disabled");
							$a3.addClass("page-link");
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);
						}
						
						$(".pagingArea").children().remove();
						$(".pagingArea").append($ul);
			
					}
					
				});
				
			}
			
			
			$(function(){
				$(".btn").click(function(){
					
					var code = $(this).parents().children("td").eq(1).text();
					
					console.log(code);
					
					window.open("em_selectGraduationMa.si?code="+code,'changMa' ,"height=550, width=900");

				});
			});
			
			
			$(function(){
				$.ajax({
					url:"em_studentSelectBox.si",
					type:"get",
					success:function(data){
						console.log("접속성공");
						
						var $select1 = $("#collegeCondition");
						
						$select1.children().remove();
						console.log("단과대학 갯수::" + data.collegeList.length);
						
						var $option1 = $("<option>");
						
						$option1.text("단과대학");
						$option1.val("단과대학");
						
						$select1.append($option1);
						
						for(var i=0 ; i<data.collegeList.length ; i++){
							
							var $option1 = $("<option>");
							
							$option1.text(data.collegeList[i].college);
							$option1.val(data.collegeList[i].college);
							
							$select1.append($option1);
						}
						
						
						var $select2 = $("#sdeptCondition");
						
						$select2.children().remove();
						console.log("학과 갯수:: " + data.sdeptList.length);
						
						var $option2 = $("<option>");
						
						$option2.text("학과");
						$option2.val("학과");
						
						$select2.append($option2);	
						
						for(var i = 0; i < data.sdeptList.length; i++){
							
							var $option2 = $("<option>");
							
							$option2.text(data.sdeptList[i].sdeptName);
							$option2.val(data.sdeptList[i].sdeptName);
							
							$select2.append($option2);	
						}
						
					}
				})
			})
			
			
			$(function(){
				$("#collegeCondition").change(function(){
					
					var change = $(this).val();
					console.log("change::" + change);
					
					var college = $("#collegeCondition").val();
					console.log("college::" + college);
					
					$.ajax({
						url:"em_selectCollege.si",
						type:"get",
						data:{college:college},
						success:function(data){
							console.log("접속성공");
							console.log("college::" + college);
							
							var $select = $("#sdeptCondition");
							
							$select.children().remove();
							
							console.log("data.list.length :::: " + data.list.length);
							
							var $option = $("<option>");
							
							$option.text("학과");
							$option.val("학과");
							
							$select.append($option);
							
							for(var i = 0; i < data.list.length; i++){
								
								var $option = $("<option>");
								
								console.log(data.list[i].sdeptName);
								
								$option.text(data.list[i].sdeptName);
								$option.val(data.list[i].sdeptName);
								
								$select.append($option);	
							}
							
						}
					});
					
				});
			})
			
			
			
			
			
			function searchStandard(){
				var collegeCondition = $("#collegeCondition").val();
				var sdeptCondition = $("#sdeptCondition").val();
				
				console.log(collegeCondition);
				console.log(sdeptCondition);
				
				$.ajax({
					url:"em_graduationMajorFilter.si",
					type:"get",
					data:{collegeCondition:collegeCondition,
						  sdeptCondition:sdeptCondition},
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						
						var $tbody = $("#tbody");
						
						$tbody.children().remove();
						
						for(var i=0 ; i<data.list.length ; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align:center;'>");
							var $td2 = $("<td style='text-align:center;'>");
							var $td3 = $("<td style='text-align:center;'>");
							var $td4 = $("<td style='text-align:center;'>");
							var $td5 = $("<td style='text-align:center;'>");
							var $td6 = $("<td class='btn' style='text-align:center;'>");
							
							$td1.text(data.list[i].division);
							$td2.text(data.list[i].graduationCode);
							$td3.text(data.list[i].college);
							$td4.text(data.list[i].sdeptName);
							$td5.text(data.list[i].graduationName);
							$td6.text("상세보기  / 수정하기");
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
						}
						
						$(".btn").click(function(){
							
							var code = $(this).parents().children("td").eq(1).text();
							
							console.log(code);
							
							window.open("em_selectGraduationMa.si?code="+code,'changMa' ,"height=550, width=900");

						});
						
						var currentPage = data.pi.currentPage;
						var listCount = data.pi.listCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;
						
						console.log(currentPage);
						
						var $ul = $("<ul>");
						$ul.addClass("pagination");
						$ul.attr({
							"style":"justify-content: center; cursor: pointer;"
						});
						
						
						var $li1 = $("<li>");
						var $a1 = $("<a>");
						
						if(currentPage <= 1){
							$li1.addClass("page-item disabled");
							$a1.addClass("page-link");					
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);					
						}else if(currentPage > 1){
							$li1.addClass("page-item");
							$a1.addClass("page-link");
							$a1.attr({
								"onclick":"loadPage2("+(currentPage-1)+")",
							});
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);
						}					
						
						for(var p = startPage; p <= endPage; p++){
							var $li2 = $("<li>");
							var $a2 = $("<a>");		
							$li2.addClass("page-item");
							$a2.addClass("page-link");
							$a2.attr({
								"onclick":"loadPage2("+p+")",
							});
							$a2.html(p);
							$li2.append($a2);
							$ul.append($li2);				
						}
						
						var $li3 = $("<li>");
						var $a3 = $("<a>");	
						
						if(currentPage < maxPage){
							$li3.addClass("page-item");
							$a3.addClass("page-link");
							$a3.attr({
								"onclick":"loadPage2("+(currentPage+1)+")",
							});
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);	
						}else{
							$li3.addClass("page-item disabled");
							$a3.addClass("page-link");
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);
						}
						
						$(".pagingArea").children().remove();
						$(".pagingArea").append($ul);
			
					}
				});
				
			}
			
			function loadPage2(curr){
				var collegeCondition = $("#collegeCondition").val();
				var sdeptCondition = $("#sdeptCondition").val();
				
				console.log(collegeCondition);
				console.log(sdeptCondition);
				
				$.ajax({
					url:"em_graduationMajorFilter.si",
					type:"get",
					data:{collegeCondition:collegeCondition,
						  sdeptCondition:sdeptCondition},
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						
						var $tbody = $("#tbody");
						
						$tbody.children().remove();
						
						for(var i=0 ; i<data.list.length ; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align:center;'>");
							var $td2 = $("<td style='text-align:center;'>");
							var $td3 = $("<td style='text-align:center;'>");
							var $td4 = $("<td style='text-align:center;'>");
							var $td5 = $("<td style='text-align:center;'>");
							var $td6 = $("<td class='btn' style='text-align:center;'>");
							
							$td1.text(data.list[i].division);
							$td2.text(data.list[i].graduationCode);
							$td3.text(data.list[i].college);
							$td4.text(data.list[i].sdeptName);
							$td5.text(data.list[i].graduationName);
							$td6.text("상세보기  / 수정하기");
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
						}
						
						$(".btn").click(function(){
							
							var code = $(this).parents().children("td").eq(1).text();
							
							console.log(code);
							
							window.open("em_selectGraduationMa.si?code="+code,'changMa' ,"height=550, width=900");

						});
						
						var currentPage = data.pi.currentPage;
						var listCount = data.pi.listCount;
						var limit = data.pi.limit;
						var maxPage = data.pi.maxPage;
						var startPage = data.pi.startPage;
						var endPage = data.pi.endPage;
						
						console.log(currentPage);
						
						var $ul = $("<ul>");
						$ul.addClass("pagination");
						$ul.attr({
							"style":"justify-content: center; cursor: pointer;"
						});
						
						
						var $li1 = $("<li>");
						var $a1 = $("<a>");
						
						if(currentPage <= 1){
							$li1.addClass("page-item disabled");
							$a1.addClass("page-link");					
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);					
						}else if(currentPage > 1){
							$li1.addClass("page-item");
							$a1.addClass("page-link");
							$a1.attr({
								"onclick":"loadPage2("+(currentPage-1)+")",
							});
							$a1.html("이전");
							$li1.append($a1);
							$ul.append($li1);
						}					
						
						for(var p = startPage; p <= endPage; p++){
							var $li2 = $("<li>");
							var $a2 = $("<a>");		
							$li2.addClass("page-item");
							$a2.addClass("page-link");
							$a2.attr({
								"onclick":"loadPage2("+p+")",
							});
							$a2.html(p);
							$li2.append($a2);
							$ul.append($li2);				
						}
						
						var $li3 = $("<li>");
						var $a3 = $("<a>");	
						
						if(currentPage < maxPage){
							$li3.addClass("page-item");
							$a3.addClass("page-link");
							$a3.attr({
								"onclick":"loadPage2("+(currentPage+1)+")",
							});
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);	
						}else{
							$li3.addClass("page-item disabled");
							$a3.addClass("page-link");
							$a3.html("다음");
							$li3.append($a3);
							$ul.append($li3);
						}
						
						$(".pagingArea").children().remove();
						$(".pagingArea").append($ul);
			
					}
				});
				
			}
			
			
			</script>
			
		</div>
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>


</body>
</html>