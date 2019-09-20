<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사 관리 시스템</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
	#basic {
	   padding: 10px 0px 0px 100px;
	}
	
	table.basicinfo td {
	   background: #FFF;
	   text-align: center;
	}
	
	td.td {
	   text-align: center;
	   background: #c7c5b7 !important;
	   color: black;
	   width: 110px !important;
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
			<h4 id="basic" class="applyH4">자퇴 신청</h4>
			<table class="basicinfo" id="applyTable">
				<tr>
					<td class="td">학번</td>
					<td>${doInfo.studentNo}</td>
					<td class="td">이름</td>
					<td>${doInfo.studentName}</td>
					<td class="td">학년</td>
					<td>${doInfo.grade}</td>
				</tr>
				<tr>
					<td class="td">단과대학</td>
					<td>${doInfo.collegeName}</td>
					<td class="td">학과</td>
					<td>${doInfo.sdeptName}</td>
					<td class="td">연락처</td>
					<td>${doInfo.studentPhone}</td>
				</tr>
				<tr>
					<td class="td">은행명</td>
					<td>${doInfo.bank}</td>
					<td class="td">예금주</td>
					<td>${doInfo.accountHolder}</td>
					<td class="td">계좌번호</td>
					<td>${doInfo.accountNo}</td>
				</tr>
				<tr>
					<td class="td">학과장</td>
					<td>${doInfo.professorName}</td>
					<td class="td">학과장 연락처</td>
					<td colspan="3">${doInfo.professorPhone}</td>
				</tr>
				<c:if test="${empty list}">
					<tr id="inputTr">
						<td class="td">자퇴 사유</td>
						<td colspan="5"><input type="text" id="dropReason" name="dropReason"></td>
					</tr>
				</c:if>
			</table>
			<div style="margin: 0 auto; width: 85%;">
				<div align="left" style="color:red; float: left">
					<span>※ 반환 받을 금액이 있는 경우 반드시 본인의 계좌정보를 확인하세요.</span>
					<br>
					<span>※ 신청 후 학과장 면담을 진행해야 신청이 완료 됩니다.</span>
				</div>
				<c:if test="${empty list}">
					<div align="right" style="float: right" id="applyArea">
						<input type="hidden" id="studentNo" name="studentNo" value="${doInfo.studentNo}">
						<input type="hidden" id="professorNo" name="professorNo" value="${doInfo.professorNo}">
						<button id="applyBtn">신청하기</button>
					</div>
				</c:if>
			</div>
			<br><br><br>
			<h4 id="basic">자퇴 신청 내역</h4>
			<table class="basicinfo" id="Change">
				<thead>
					<tr>
						<th style="text-align: center" id="t1">신청번호</th>
						<th style="text-align: center" id="t1">학번</th>
						<th style="text-align: center" id="t1">학과장</th>
						<th style="text-align: center" id="t1">사유</th>
						<th style="text-align: center" id="t1">신청일자</th>
						<th style="text-align: center" id="t1">면담여부</th>
						<th style="text-align: center" id="t1">처리상태</th>
						<th style="text-align: center" id="t1">처리일자</th>
					</tr>
				<thead>
				<tbody id="tbody">
					<c:if test="${empty list}">
						<tr>
							<td colspan="8">신청내역이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${!empty list}">
						<c:forEach var="b" items="${list}">
							<tr>
								<td>${b.dropNo}</td>
								<td>${b.studentNo}</td>
								<td>${b.professorName}</td>
								<td>${b.dropReason}</td>
								<td>${b.dropDate}</td>
								<td>${b.dropInterview}</td>
								<td>${b.dropStatus}</td>
								<td>${b.successDate}</td>
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
		$("#applyBtn").click(function(){
			var dropReason = $("#dropReason").val();
			var studentNo = $("#studentNo").val();
			var professorNo = $("#professorNo").val();
			
			if(confirm("자퇴를 신청하시겠습니까?") == true){
				$.ajax({
					url:"st_insertDropOut.si",
					type:"POST",
					data:{
						"dropReason":dropReason,
						"studentNo":studentNo,
						"professorNo":professorNo
					},
					success:function(data){
						$tbody = $("#tbody");
						
						$tbody.children().remove();
						
						for(var i = 0; i < data.list.length; i++){						
							
							var $tr = $("<tr>");
							var $td1 = $("<td>");
							var $td2 = $("<td>");
							var $td3 = $("<td>");
							var $td4 = $("<td>");
							var $td5 = $("<td>");
							var $td6 = $("<td>");
							var $td7 = $("<td>");
							var $td8 = $("<td>");
							
							$td1.text(data.list[i].dropNo);
							$td2.text(data.list[i].studentNo);
							$td3.text(data.list[i].professorName);							
							$td4.text(data.list[i].dropReason);
							$td5.text(data.list[i].dropDate);
							$td6.text(data.list[i].dropInterview);
							$td7.text(data.list[i].dropStatus);
							$td8.text(data.list[i].successDate);							
							
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.append($td7);
							$tr.append($td8);							
							
							$tbody.append($tr);	
							
							$("#inputTr").hide();
							$("#applyBtn").hide();
						}			
					} // success function 끝
				}); // ajax 끝
			}// if문 끝
		}); // 신청버튼 클릭 이벤트 끝
	</script>
</body>
</html>