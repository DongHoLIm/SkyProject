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
	
	.insertSpan:hover {
		color:red;
		cursor: pointer;
	}
	
</style>
</head>
<script>
	$(function(){
		$.ajax({
			url:"st_LectureEvaluationList.le",
			type:"POST",
			success:function(data){
				var $tbody = $("#tbody");
					
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $span = $("<span>");
					
					$td1.text(data.list[i].lectureNo);
					$td2.text(data.list[i].subName);
					$td3.text(data.list[i].professorName);
					
					$span.addClass("insertSpan");
					$span.text("입력");
					
					$td4.html($span);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					
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
				
				$(".insertSpan").click(function(){
					var lectureNo = $(this).parent().parent().children().eq(0).text();
					
					var location ="st_showLectureEvaluationInsert.le?lectureNo=" + lectureNo;
					
					window.open(location, "_blank", "width=700, height=300");
					
				});// insertspan 끝
			} // success function 끝
		}); // 1번 ajax 끝
	}); // onload function 끝
</script>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">강의평가 입력</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br><br>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<thead>
					<tr>
						<th style="text-align: center;">강의번호</th>
						<th style="text-align: center;">과목명</th>
						<th style="text-align: center;">교수명</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>	
			<br><br>
			<h4 id="basic">강의평가 입력 내역</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<thead>
					<tr>
						<th style="text-align: center;">강의번호</th>
						<th style="text-align: center;">과목명</th>
						<th style="text-align: center;">교수명</th>
						<th></th>
					</tr>
				</thead>
				<tbody id=tbody2>
					
				</tbody>
			</table>
			<div class="pagingArea2">
			
			</div>		
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>