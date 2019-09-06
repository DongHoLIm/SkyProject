<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#basic {
		padding: 10px 0px 0px 100px;
	}
	
	#searchValue { 
		width: 100%
	}
	
	#writeArea {
	margin: 0 auto;
	width: 88.5%;
	}
	
	#writeBtn {
		align: right;
	}
	
	.pagingArea {
		margin-top: 2%;
	}
	
	.sNoticeTitle:hover{
		color: black;
		font-weight: bold;
		cursor: pointer;
	}

</style>
<script>	
	$(function(){
		$.ajax({
			url:"em_sNoticeList.bo",
			type:"get",
			success:function(data){
				console.log("접속 성공!");
				console.log("data.list.boardNo :::: " + data.list[0].boardNo);
				console.log("data.pi.currentPage :::: " + data.pi.currentPage);
				
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				console.log("data.list.length :::: " + data.list.length);
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr class='sNoticeTr'>");
					var $td1 = $("<td style='text-align: center;' class='sNoticeNo'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;' class='sNoticeTitle'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].boardNo);
					
					var eDateAll = data.list[i].enrollDate.split("-");
					var eDateDay = eDateAll[2].split(" ");
					var enrollDate = eDateAll[0] + "/" + eDateAll[1] + "/" + eDateDay[0];					
					$td2.text(enrollDate);
					
					$td3.text(data.list[i].title);
					$td4.text(data.list[i].writer);
					$td5.text(data.list[i].writeDept);
					$td6.text(data.list[i].count);
					
					var dDateAll = data.list[i].deadLine.split("-");
					var dDateDay = dDateAll[2].split(" ");
					var deadLine = dDateAll[0] + "/" + dDateAll[1] + "/" + dDateDay[0];
					$td7.text(deadLine);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
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
						"onclick":"loadAjax("+(currentPage-1)+")",
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
						"onclick":"loadAjax("+p+")",
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
						"onclick":"loadAjax("+(currentPage+1)+")",
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
				
				$(".sNoticeTitle").click(function(){
					var boardNo = $(this).parent().children().eq(0).text();
					
					location.href="em_sNoticeDetail.bo?boardNo=" + boardNo;
				});
			}
		});
	});
	
	function loadAjax(curr){
		var currentPage = curr;
		
		$.ajax({
			url:"em_sNoticeList.bo",
			type:"get",
			data:{currentPage:currentPage},
			success:function(data){
				console.log("접속 성공!");
				console.log("data.list.boardNo :::: " + data.list[0].boardNo);
				console.log("data.pi.currentPage :::: " + data.pi.currentPage);
				
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				console.log("data.list.length :::: " + data.list.length);
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;' class='sNoticeNo'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;' class='sNoticeTitle'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].boardNo);
					
					var eDateAll = data.list[i].enrollDate.split("-");
					var eDateDay = eDateAll[2].split(" ");
					var enrollDate = eDateAll[0] + "/" + eDateAll[1] + "/" + eDateDay[0];					
					$td2.text(enrollDate);
					
					$td3.text(data.list[i].title);
					$td4.text(data.list[i].writer);
					$td5.text(data.list[i].writeDept);
					$td6.text(data.list[i].count);
					
					var dDateAll = data.list[i].deadLine.split("-");
					var dDateDay = dDateAll[2].split(" ");
					var deadLine = dDateAll[0] + "/" + dDateAll[1] + "/" + dDateDay[0];
					$td7.text(deadLine);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					
					$tbody.append($tr);
				}
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
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
						"onclick":"loadAjax("+(currentPage-1)+")",
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
						"onclick":"loadAjax("+p+")",
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
						"onclick":"loadAjax("+(currentPage+1)+")",
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
				
				$(".sNoticeTitle").click(function(){
					var boardNo = $(this).parent().children().eq(0).text();
					
					location.href="em_sNoticeDetail.bo?boardNo=" + boardNo;
				});
			}
		});
	};
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">장학 공지</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
			
			<input type="hidden" name="searchflag" id="searchflag" value="true">
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tr>
					<td>상세검색</td>
					<td colspan='5'>
						<select id="searchCondition" name="searchCondition">
							<option value="writer">작성자</option>
							<option value="writeDept">작성부서</option>
							<option value="title">제목</option>
						</select>
					</td>
					<td>
						<input style="display: inline-block; width: 80%;" type="text" name="searchValue" id="searchValue" placeholder="내용을 입력해주세요">
					</td>
					<td>
						<input style="display: inline-block;" type="submit" value="검색">
					</td>
				</tr>
			</table>
			<br>
			<br>
			<c:if test="${sessionScope.loginUser.memberStatus == 3}">
				<div id="writeArea">
					<div align="right" style="margin-bottom: 10px;">
						<button id="writeBtn" onclick="">글쓰기</button>
					</div>
				</div>
			</c:if>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<thead>
					<tr>
						<th width="5%" style="text-align: center">번호</th>
						<th width="9%" style="text-align: center;">등록일자</th>
						<th width="50%" style="text-align: center;">제목</th>
						<th width="9%" style="text-align: center;">작성자</th>
						<th width="9%" style="text-align: center;">작성부서</th>
						<th width="9%" style="text-align: center;">조회수</th>
						<th width="9%" style="text-align: center;">게시기한</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-employee.jsp" />
		</div>
	</div>	
			
</body>
</html>