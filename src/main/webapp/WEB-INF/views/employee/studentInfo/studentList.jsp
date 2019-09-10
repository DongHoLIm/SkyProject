<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->
			<br>
			
			<h2>학생전체조회</h2>
			<div id="searchArea">
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
						<option value="정치외교학과">정치외교학과</option>
						<option value="실용음악과">실용음악과</option>
						<option value="체육학과">체육학과</option>
						<option value="컴퓨터공학과">컴퓨터공학과</option>
						<option value="전자공학과">전자공학과</option>
						<option value="건축학과">건축학과</option>
					</select>
				</td>
				<td>
					<select id="gradeCondition" name="gradeCondition">
						<option value="학년">학년</option>
						<option value="1">1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
						<option value="4">4학년</option>
						<option value="5">5학년 이상</option>
					</select>
				</td>
				<td>
					<select id="collegeCondition" name="collegeCondition">
						<option value="학정상태">학정상태</option>
						<option value="">재학</option>
						<option value="">휴학</option>
						<option value="">졸업</option>
					</select>
				</td>
				<td>
					<button onclick="searchStudent();">검색</button>
				</td>
				
			</tr>
			
			</table>
			
			
			</div>
			
			<table id="tableArea" align="center">
			<thead>
				<tr>
					<th>단과대학</th>
					<th>학과</th>
					<th>학년</th>
					<th>학번</th>
					<th>이름</th>
					<th>학적상태</th>
				</tr>
			</thead>	
			
			<tbody>
				<c:forEach var="list" items="${list }">
					<tr>
						<td><c:out value="${list.college }"/></td>
						<td><c:out value="${list.sdeptName }"/></td>
						<td><c:out value="${list.grade }"/></td>
						<td><c:out value="${list.studentNo }"/></td>
						<td><c:out value="${list.kName }"/></td>
						<td><c:out value="${list.studentStatus }"/></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<div class="pageingArea" align="center">
			<ul class="pagination" style="justify-content: center; cursor: pointer;">
				<c:if test="${pi.currentPage <= 1}">
			   		<li class="page-item disabled"><a class="page-link">이전</a></li>				
				</c:if>
				<c:if test="${pi.currentPage > 1}">
					<c:url var="loadPage" value="em_studentListNext.si">
						<c:param name="currentPage" value="${pi.currentPage - 1}"/>
					</c:url>
					<li class="page-item"><a class="page-link" href="${loadPage}">이전</a></li>	
				</c:if>
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:if test="${p eq pi.currentPage}">
					    <li class="page-item"><a class="page-link">${p}</a></li>					
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<c:url var="loadPage" value="em_studentListNext.si">
							<c:param name="currentPage" value="${p}"/>
						</c:url>
						 <li class="page-item"><a class="page-link" href="${loadPage}">${p}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<c:url var="loadPage" value="em_studentListNext.si">
						<c:param name="currentPage" value="${pi.currentPage + 1}"/>
					</c:url>
			    	<li class="page-item"><a class="page-link" href="${loadPage}">다음</a></li>				
				</c:if>
				<c:if test="${pi.currentPage >= pi.maxPage}">
					<li class="page-item"><a class="page-link">다음</a></li>	
				</c:if>
			 </ul>
			</div>
			
			<script>
			$(function(){
				$.ajax({
					url:"em_studentListNext.si",
					type:"get",
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						console.log( data.list[0].college);
						
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
							var $td6 = $("<td style='text-align:center;'>");
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].grade);
							$td4.text(data.list[i].studentNo);
							$td5.text(data.list[i].kName);
							$td6.text(data.list[i].studentStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
							
						}
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
			});
			
			
			function loadPage(curr){
				var currentPage = curr;
				
				$.ajax({
					url:"em_studentListNext.si",
					type:"get",
					data:{currentPage:currentPage},
					success:function(data){
						console.log("접속성공");
						console.log("data.list.length::" + data.list.length);
						console.log( data.list[0].college);
						
var $tbody = 			$("#tbody");
						
						$tbody.children().remove();
						
						console.log("data.list.length::" + data.list.length);
						
						for(var i=0 ; i<data.list.length ; i++){
							var $tr = $("<tr>");
							var $td1 = $("<td style='text-align:center;'>");
							var $td2 = $("<td style='text-align:center;'>");
							var $td3 = $("<td style='text-align:center;'>");
							var $td4 = $("<td style='text-align:center;'>");
							var $td5 = $("<td style='text-align:center;'>");
							var $td6 = $("<td style='text-align:center;'>");
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].grade);
							$td4.text(data.list[i].studentNo);
							$td5.text(data.list[i].kName);
							$td6.text(data.list[i].studentStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							
							$tbody.append($tr);
						}
						
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
			};
			
			
			</script>

	</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
	
	<script>
			function searchStudent(){
				var searchCondition = $("#searchCondition").val();
				var searchVale = $("searchValue").val();
				
				console.log(searchCondition);
				console.log(searchVale);
				
				$.ajax({
					url:"em_studentListFilter.si",
					data:{searchCondition:searchCondition,
						  searchVale:searchVale},
					type:"post",
					success:function(data){
						console.log("접속성공");
					},
					error:function(data){
						console.log("접속실패");
					}
				})
				
			}
			
			</script>
			
</body>
</html>