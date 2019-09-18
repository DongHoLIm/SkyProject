<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap" rel="stylesheet">
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

table.basicinfo td {
   background: #FFF;
}

td.td {
   text-align: center;
   background: #c7c5b7 !important;
   color: black;
   width: 100px !important;
}

.basicinfo{
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

			<jsp:include page="../info/common.jsp" />
		
			<h4 id="basic">다전공 신청</h4>
			<table class="basicinfo">
				<tr>
					<td class="td">다전공 분류</td>
					<td colspan="5">
						<select name="majorCheck" id="majorCheck">
							<option value="복수전공">복수전공</option>
							<option value="부전공">부전공</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td">단과대학</td>
					<td colspan="2">
						<select name="collegeName" id="collegeName">
							<option value="CollegeChoice">-- 선택 --</option>
							<option value="인문대학">인문대학</option>
							<option value="예술대학">예술대학</option>
							<option value="공과대학">공과대학</option>
						</select>
					</td>
					<td class="td">학과</td>
					<td colspan="2">
						<select name="sdeptName" id="sdeptName">
						
						</select>
					</td>
				</tr>
			</table>
			<div align="right" style="margin: 0 auto; width:85%;">
				<input type="hidden" id="grade" name="grade" value="${basicInfo.grade}">
				<input type="hidden" id="firstMajor" name="firstMajor" value="${basicInfo.sdeptName}">
				<input type="hidden" id="studentNo" name="studentNo" value="${basicInfo.studentNo}">
				<input type="hidden" id="secondMajor" name="secondMajor" value="${basicInfo.secondMajor}">
				<button id="applyBtn">신청</button>
			</div>
				
			<h4 id="basic">신청 내역</h4>
			<table class="basicinfo" id="Change">
				<thead>
					<tr>
						<th style="text-align: center" id="t1">다전공 분류</th>
						<th style="text-align: center" id="t1">단과 대학</th>
						<th style="text-align: center" id="t1">학과</th>
						<th style="text-align: center" id="t1">신청일자</th>
						<th style="text-align: center" id="t1">처리 결과</th>
					</tr>
				<thead>
				<tbody id="tbody">
					<c:if test="${empty list}">
						<tr>
							<td colspan="6">신청내역이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${!empty list}">
						<c:forEach var="b" items="${list}">
							<tr>
								<td>${b.majorCheck}</td>
								<td>${b.collegeName}</td>
								<td>${b.sdeptName}</td>
								<td>${b.applyDate}</td>
								<td>${b.majorStatus}</td>
							</tr>					
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
	
	<script>	
	
		$("#collegeName").change(function() {
			var collegeName = $(this).val();			

			var $option1 = $("<option value='경영학과'>경영학과</option>")
			var $option2 = $("<option value='경제학과'>경제학과</option>")
			var $option3 = $("<option value='정치외교과'>정치외교과</option>")
			var $option4 = $("<option value='실용음악과'>실용음악과</option>")
			var $option5 = $("<option value='사회체육과'>사회체육과</option>")
			var $option6 = $("<option value='컴퓨터공학과'>컴퓨터공학과</option>")
			var $option7 = $("<option value='전자공학과'>전자공학과</option>")
			var $option8 = $("<option value='건축과'>건축과</option>")

			if (collegeName == "인문대학") {
				$("#sdeptName").children().remove();
				$("#sdeptName").append($option1);
				$("#sdeptName").append($option2);
				$("#sdeptName").append($option3);
			} else if (collegeName == "예술대학") {
				$("#sdeptName").children().remove();
				$("#sdeptName").append($option4);
				$("#sdeptName").append($option5);
			} else if (collegeName == "공과대학") {
				$("#sdeptName").children().remove();
				$("#sdeptName").append($option6);
				$("#sdeptName").append($option7);
				$("#sdeptName").append($option8);
			}
		});
		
		$("#applyBtn").click(function(){
			var grade = $("#grade").val();
			var majorCheck = $("#majorCheck option:selected").val();
			var collegeName = $("#collegeName option:selected").val();
			var sdeptName = $("#sdeptName option:selected").val();
			var firstMajor = $("#firstMajor").val();
			var studentNo = $("#studentNo").val();			
			
			if(sdeptName == firstMajor){
				
				alert("현재 소속된 과는 선택할 수 없습니다.");
				
			}else if(Number(grade) < 2){
				
				alert("2학년 이상 신청 가능합니다.");
				
			}else if((Number(grade) >= 2) && (sdeptName != firstMajor)){
				
				$.ajax({
					url:"st_insertSecondMajor.si",
					type:"POST",
					data:{
						"majorCheck":majorCheck,
						"collegeName":collegeName,
						"sdeptName":sdeptName,
						"studentNo":studentNo
					},
					success: function(data){
						console.log("data.list.length :::: " + data.list.length);	
						console.log(data)
						
						$tbody = $("#tbody");
						
						for(var i = 0; i < data.list.length; i++){						
							
							var $tr = $("<tr>");
							var $td1 = $("<td>");
							var $td2 = $("<td>");
							var $td3 = $("<td>");
							var $td4 = $("<td>");
							var $td5 = $("<td>");
							
							$td1.text(data.list[i].majorCheck);
							$td2.text(data.list[i].collegeName);
							$td3.text(data.list[i].sdeptName);							
							$td4.text(data.list[i].applyDate);
							$td5.text(data.list[i].majorStatus);
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							
							$tbody.append($tr);							
						}
						
						
					}
				});
			}
		});
	</script>
</body>
</html>