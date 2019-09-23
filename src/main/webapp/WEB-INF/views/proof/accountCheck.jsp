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
	th {
		background: #E5E6E7;
		text-align: center;
	}
	
	td {
		background: white;
		text-align: center;
	}
	
	.applyArea {
		width: 88.5%;
		text-align: center;
		margin: 0 auto;
	}
</style>
<script>
	
	$(function(){
		$(".applyArea").hide();
		
		alert("제증명 발급용 본인 확인을 위해 비밀번호를 입력하세요.");
		
		$("#checkPwdBtn").click(function(){
			var checkPwd = $("#checkPwd").val();
			
			console.log("checkPwd :::: " + checkPwd);
			
			if(checkPwd == ''){
				alert("비밀번호를 입력하세요.");
			}else if(checkPwd != ''){
				$.ajax({
					url:"checkMemberPwd.pf",
					type:"POST",
					data:{
						"checkPwd":checkPwd
					},
					success:function(data){
						var result = data.result;
						
						if(result == 1){
							alert("발급할 증명서를 선택하세요.");
							$("#idCheckArea").hide();
							$(".applyArea").show();
						}else if(result != 1){
							alert("비밀번호가 맞지 않습니다. 다시 입력하세요.");
							$("#checkPwd").val("");
						}
					}
				});				
			}			
		}); // checkPwdBtn click function end			
	});
	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<input type="hidden" name="memberId" id="memberId" value="${loginUser.memberId}">
			<h4 style="padding: 10px 0px 0px 100px;">제증명 신청</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>			
			<table style="width: 88.5%; text-align: center; margin: 0 auto;" id="idCheckArea">
				<tr>
					<th>아이디 : </th>
					<td>${loginUser.memberId}</td>
					<th>비밀번호 : </th>
					<td><input type="password" name="checkPwd" id="checkPwd"></td>
					<td><button id="checkPwdBtn">비밀번호 확인</button></td>
				</tr>			
			</table>
			<br><br>
			<div class="applyArea">
				<table style="width: 88.5%; text-align: center; margin: 0 auto;">
					<tr>
						<th style="text-align: center">증명서 번호</th>
						<th style="text-align: center">증명서 </th>
						<th style="text-align: center">부수</th>
						<th style="text-align: center">가격</th>
						<th style="text-align: center"></th>
					</tr>
					<c:forEach var="pf" items="${list}">
						<tr>
							<td>${pf.certiCode}</td>
							<td>${pf.certiName}</td>
							<td><input type="number" class="printCount" name="printCount" max="10" min="0" value="0" style="width: 40px;"></td>
							<td>&#8361;500</td>
							<td><button class="proofBtn">발급</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
			</div>
		</div>
	</div>	
	<script>
		$(".proofBtn").click(function(){
			var certiCode = $(this).parent().parent().children().eq(0).text();
			var certiName = $(this).parent().parent().children().eq(1).text();
			var printCount = $(this).parent().parent().children().find(".printCount").val();
			var memberId = $("#memberId").val();			
			
			var location ="Payment.pf?memberId="+memberId+"&certiName="+certiName+"&certiCode="+certiCode+"&printCount="+printCount;
			
			window.open(location, "_blank", "width=1000, height=800");
			
			$.ajax({
				url:location,
				type:"GET",
				success:function(data){
					console.log("연결성공!");
				}
			});
		});
	</script>
</body>
</html>