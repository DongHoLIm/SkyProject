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
			url:"st_showLectureEvaluationOpenList.le",
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
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $span = $("<span>");
					
					$td1.text(data.list[i].subCode);
					$td2.text(data.list[i].subName);
					$td3.text(data.list[i].openYear);
					$td4.text(data.list[i].openSemester);
					$td5.text(data.list[i].memberKName);
					
					$span.addClass("insertSpan");
					$span.text("입력");
					
					$td6.html($span);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					
					$tbody.append($tr);
				}
				
				$(".insertSpan").click(function(){
					var subCode = $(this).parent().parent().children().eq(0).text();
					var openYear = $(this).parent().parent().children().eq(2).text();
					var openSemester = $(this).parent().parent().children().eq(3).text();
					
					var location ="st_showLectureEvaluationInsert.le?subCode=" + subCode + "&openYear=" + openYear + "&openSemester=" + openSemester;
					
					window.open(location, "_blank", "width=700, height=300");
					
				});
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
			<h4 id="basic">강의평가</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>		
			<table style="width: 88.5%; text-align: center; margin: 0 auto;">
				<tr>
					<td>검색</td>
					<td colspan='2'>
						<select id="searchCondition" name="searchCondition">
							<option value="account">교수명</option>
							<option value="proof">강의명</option>
						</select>
					</td>
					<td>
						<input style="display: inline-block;" type="submit" value="검색">
					</td>
				</tr>
			</table>
			<br><br>
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="boardArea">
				<thead>
					<tr>
						<th style="text-align: center;">수업번호</th>
						<th style="text-align: center;">강의명</th>
						<th style="text-align: center;">개강년도</th>
						<th style="text-align: center;">개강학기</th>
						<th style="text-align: center;">교수명</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>			
		</div>
		<div>
			<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>