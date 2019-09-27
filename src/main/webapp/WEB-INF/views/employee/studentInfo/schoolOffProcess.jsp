<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<!-- 입력 라인  -->
			
			<div class="container">
			<br>
			<h4>휴학 신청 명단</h4>
			<br>
			<div id="filterArea" style="width:85%; text-align: center; margin: 0 auto;">
				<table>
					<tr>
						<td>
							<select id="offType" name="offType">
								<option value="휴학구분">휴학구분</option>
								<option value="일반휴학">일반휴학</option>
								<option value="군휴학">군휴학</option>
							</select>
						</td>
						
						<td>
							<select id="offStatus" name="offStatus">
								<option value="처리상태">처리상태</option>
								<option value="신청완료">신청완료</option>
								<option value="서류확인">서류확인</option>
							</select>
						</td>
						
						<td>
							<button onclick="searchStudent();">검색</button>
						</td>
						
					</tr>
				</table>
					
			</div>
			
  				<br>
    				
      					<table id="applyList" class="table table-bordered" >
    						<thead>
      							<tr>
        							<th style='text-align:center;'>단과대학</th>
        							<th style='text-align:center;'>학과</th>
        							<th style='text-align:center;'>학번</th>
        							<th style='text-align:center;'>이름</th>
        							<th style='text-align:center;'>휴학신청학기</th>
        							<th style='text-align:center;'>복학예정학기</th>
        							<th style='text-align:center;'>신청일자</th>
        							<th style='text-align:center;'>휴학구분</th>
        							<th style='text-align:center;'>처리상태</th>
      							</tr>
    						</thead>
    						<tbody id="tbody">
      							
      							
    						</tbody>
  						</table>
  						
  						<div class="applyPage" align="center">
  						
  						</div>
  						
  						<br><br><br><br>
  						
			</div>
			
			
			<script>
			$(function(){
				$.ajax({
					url:"em_offApplyList.si",
					type:"get",
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
							var $td6 = $("<td style='text-align:center;'>");
							var $td7 = $("<td style='text-align:center;'>");
							var $td8 = $("<td style='text-align:center;'>");
							var $td9 = $("<td style='text-align:center;'>");
							
							var applyDate=data.list[i].applyDate;
							console.log(applyDate);
							
							/* var $fmt1 = $('<fmt:parseDate value="${applyDate}" var="applyDate" pattern="yyyy-MM-dd HH:mm:ss">');
							var $fmt2 = $('<fmt:formatDate value="${applyDate}" var="applyDate" pattern="yyyy/MM/dd">');
							 */
							/* <fmt:parseDate value="${applyDate}" var="applyDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${applyDate}" pattern="yyyy/MM/dd"/> */
							
								
								/* console.log("${applyDate}"); */
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].studentNo);
							$td4.text(data.list[i].kName);
							$td5.text(data.list[i].offStart);
							$td6.text(data.list[i].returnDate);
							$td7.addend(fmt1);
							$td7.addend(fmt2);
							$td8.text(data.list[i].offType);
							$td9.text(data.list[i].offStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							$tr.append($td9);
							
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
						
						$(".applyPage").children().remove();
						$(".applyPage").append($ul);
						
					}
				});
			});
			
			function loadPage(curr){
				var currentPage = curr;
				console.log(currentPage);
				
				$.ajax({
					url:"em_offApplyList.si",
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
							var $td6 = $("<td style='text-align:center;'>");
							var $td7 = $("<td style='text-align:center;'>");
							var $td8 = $("<td style='text-align:center;'>");
							var $td9 = $("<td style='text-align:center;'>");
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].studentNo);
							$td4.text(data.list[i].kName);
							$td5.text(data.list[i].offStart);
							$td6.text(data.list[i].returnDate);
							$td7.text(data.list[i].applyDate);
							$td8.text(data.list[i].offType);
							$td9.text(data.list[i].offStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							$tr.append($td9);
							
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
						
						$(".applyPage").children().remove();
						$(".applyPage").append($ul);
						
					}
				});
				
			}
			
			function searchStudent(){
				var offType = $("#offType").val();
				var offStatus = $("#offStatus").val();
				
				console.log(offType);
				console.log(offStatus);
				
				$.ajax({
					url:"em_offApplyFilter.si",
					type:"get",
					data:{offType:offType,
						offStatus:offStatus},
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
							var $td6 = $("<td style='text-align:center;'>");
							var $td7 = $("<td style='text-align:center;'>");
							var $td8 = $("<td style='text-align:center;'>");
							var $td9 = $("<td style='text-align:center;'>");
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].studentNo);
							$td4.text(data.list[i].kName);
							$td5.text(data.list[i].offStart);
							$td6.text(data.list[i].returnDate);
							$td7.text(data.list[i].applyDate);
							$td8.text(data.list[i].offType);
							$td9.text(data.list[i].offStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							$tr.append($td9);
							
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
						
						$(".applyPage").children().remove();
						$(".applyPage").append($ul);
					}
				});
				
			}
			
			function loadPage2(curr){
				var currentPage = curr;
				console.log(currentPage);
				
				$.ajax({
					url:"em_offApplyList.si",
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
							var $td6 = $("<td style='text-align:center;'>");
							var $td7 = $("<td style='text-align:center;'>");
							var $td8 = $("<td style='text-align:center;'>");
							var $td9 = $("<td style='text-align:center;'>");
							
							$td1.text(data.list[i].college);
							$td2.text(data.list[i].sdeptName);
							$td3.text(data.list[i].studentNo);
							$td4.text(data.list[i].kName);
							$td5.text(data.list[i].offStart);
							$td6.text(data.list[i].returnDate);
							$td7.text(data.list[i].applyDate);
							$td8.text(data.list[i].offType);
							$td9.text(data.list[i].offStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);
							$tr.append($td9);
							
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
						
						$(".applyPage").children().remove();
						$(".applyPage").append($ul);
						
					}
				});
				
			}
			
			</script>
			
			
			
		<div>
		<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
</div>

</body>
</html>