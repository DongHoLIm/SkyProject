<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/styleSd.css" />
<script src="resources/js/scaduler.js"></script>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<script>
	$(function(){
		$.ajax({
			url:"mainBoardList.bo",
			type:"post",
			success:function(data){
				
				for(var i = 0;i<data.boardList.length;i++){
					
					var $tr =$("<tr>");
					var $td1 =$("<td>").text(i+1);
					var $td2 =$("<td>").text(data.boardList[i].enrollDate);
					var $td3 =$("<td>").text(data.boardList[i].title);
					var $td4 =$("<td>").text(data.boardList[i].writer);
					var $td5 =$("<td>").text(data.boardList[i].writeDept);
					var $td6 =$("<td>").text(data.boardList[i].count);
					var $input = $("<input type='hidden' value='"+data.boardList[i].boardNo+"'>");
					
					$td1.append($input);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					
					$("#mainBoardList tbody").append($tr);					
				}
				
			},
			error:function(error){
				console.log("실패");
			}
		});
	});
	
</script>
<style>
	#mainBoardList {
		text-align: center;
	}
	#mainBoardList tbody tr :hover{
		color: black;
	}
	.second-floor{
		display: inline-block;
		padding: 30px;
		
	}
	#dateDetail {
		text-align: center;		
		font-family: 'Lato', sans-serif;
		
	}
	#dateDetail tr th {
		background: rgb(44, 62, 80);
		width:130px;
		text-align:center;
		color:white;
		border-radius: 20px;
		border: 0px solid white;
		
	}
	#dateDetail tr{
		border: 0px solid white;
	}
	#dateDetail tr td{
		border-radius: 20px;
	}
</style>
</head>
<body>	
	<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
				<br> <br>
				<h2 align="center">공지 사항</h2>
				<hr />
				<br>
				<table id="mainBoardList">
					<thead>
						<tr>
							<th width="5%" style="text-align: center">번호</th>
							<th width="14%" style="text-align: center;">게시일자</th>
							<th width="45%" style="text-align: center;">제목</th>
							<th width="9%" style="text-align: center;">작성자</th>
							<th width="12%" style="text-align: center;">작성부서</th>
							<th width="7%" style="text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<br /> <br />
				<h2 align="center">학사 일정</h2>
				<hr>
				<div id="calendar" style="margin-left: 20%">
					<div id="calendar_header" class="second-floor">
						<i class="icon-chevron-left"></i>
						<h1></h1>
						<i class="icon-chevron-right"></i>
					</div>
					<div id="calendar_weekdays"></div>
					<div id="calendar_content"></div>
				</div>
				<div class="second-floor">
					<table id="dateDetail" style="border-radius: 40px;">
						<thead>
							<tr>
								<th>날짜</th>
								<th>해당일정</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div>
			<c:if test="${member eq '1'}">
				<jsp:include page="../common/menubar-student.jsp" />
			</c:if>
			<c:if test="${member eq '2'}">
				<jsp:include page="../common/menubar-professor.jsp" />
			</c:if>
			<c:if test="${member eq '3'}">
				<jsp:include page="../common/menubar-employee.jsp" />
			</c:if>
		</div>
	</div>
	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>	
	<script>
		$(function(){			
				dateResult();
			$(".icon-chevron-right").click(function(){
				dateResult();
			});
			$(".icon-chevron-left").click(function(){		
				dateResult();
			});
			$("#mainBoardList tbody").on("click","tr",function(){
				var boardNo = $(this).children().eq(0).children().eq(0).val();
				location.href = "em_nNoticeDetail.bo?boardNo=" + boardNo;
			});
		});
			function dateResult(){
				$.ajax({
					url:"mainSchool.bo",
					type:"post",
					success:function(data){
						$("#dateDetail tbody").empty();
						var yearAndMonth =$("#calendar_header h1").text();						
						var date = $("#calendar_content").children();						
						for(var i =0;i<data.dateList.length;i++){
							var $tr = $("<tr>");
							var $td = $("<td>");
							var $td1 = $("<td>");
							var sYear = data.dateList[i].sYear;
							var sMonth = data.dateList[i].sMonth;
							var sYearAndsMonth =sMonth+" "+sYear;	
							var title = data.dateList[i].title;
							var $br =$("<br>");
							if(sYearAndsMonth == yearAndMonth){
							$td.text(data.dateList[i].sDate+"일");
							$td1.text(data.dateList[i].title);
							$tr.append($td);
							$tr.append($td1);
							$("#dateDetail tbody").append($tr);
								for(var j= 0; j<date.length;j++){								
									 if(Number (data.dateList[i].sDate) == Number(date.eq(j).text())){
										date.eq(j).css({color:"cyon"}); 
										date.eq(j).append($br);
										date.eq(j).append(title);
									} 
								}
							}
							
						}
							
					}
				});
			}
	</script>
</body>
</html>