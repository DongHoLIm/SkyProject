<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#memberDetail {
		text-align: center;
	}
	#main{
		width:70%;
		margin: 0 auto;
	}
	.title{
		display: inline-block;
	}
	#BtnDiv{
		float: right;	
	}
</style>
</head>
<body>
<div id="main">
	<br />
	<br />
	<h3 class="title">권한부여 여부</h3>	
	<div id="BtnDiv">
	<button id="submitBtn" class="title">수정</button>
	<button type="reset" id="cancel"class="title">취소</button>
	</div>
	<hr />
	<br />
	<c:set var="employee" value="${detailemployee}"/>
	<c:set var="Account" value="${ employeema}"/>
	<input type="hidden" value="" name="employeeNo"/>
	<table id="memberDetail">
		<tr>
			<td><h4>이름</h4></td>	
			<td><input type="text" value="${employee.memberKName}" id="memberId" readonly/></td>		
		</tr>
		<tr>
			<td><h4>부서</h4></td>
			<td><input type="text" value="${employee.sdeptCode}"  readonly/></td>
		</tr>
		<tr>
			<td><h4>직급</h4></td>
			<td><input type="text" value="${employee.rankCode}" readonly/></td>
		</tr>
		<tr>
			<td colspan="2"><h4>권한여부</h4></td>
		</tr>
		<tr>
			<td><h4>수업관리</h4></td>
			<td>
				<select name="classManager" id="class">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h4>학적관리</h4></td>
			<td>
				<select name="scholarlyManager" id="scholarly">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h4>등록관리</h4></td>
			<td>
				<select name="enrollManager" id="enroll">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h4>장학관리</h4></td>
			<td>
				<select name="scholManager" id="schol">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h4>기숙사관리</h4></td>
			<td>
				<select name="dormitoryManager" id="dormitory">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h4>정보생활</h4></td>
			<td>
				<select name="boardManager" id="board">
					<option value="0">Y</option>
					<option value="1">N</option>
				</select>
			</td>
		</tr>
	</table>
	<input type="hidden" id="cm" value="${Account.classManager}"/>
	<input type="hidden" id="sm" value="${Account.scholarlyManager}" />
	<input type="hidden" id="em" value="${Account.enrollManager }" />
	<input type="hidden" id="scm" value="${Account.scholManager }"/>
	<input type="hidden" id="dm" value="${Account.dormitoryManager }" />
	<input type="hidden" id="bm" value="${Account.boardManager }" />
	<input type="hidden" id="en" value="${Account.employeeNo }" name="employeeNo"/>
	</div>	
	<script>
		$(function (){
			var cmv = $("#cm").val();
			var sm = $("#sm").val();
			var em = $("#em").val();
			var scm = $("#scm").val();
			var dm = $("#dm").val();
			var bm = $("#bm").val();
			$("#class option[value="+cmv+"]").attr('selected','selected');
			$("#scholarly option[value="+sm+"]").attr('selected','selected');
			$("#enroll option[value="+em+"]").attr('selected','selected');
			$("#schol option[value="+scm+"]").attr('selected','selected');
			$("#dormitory option[value="+dm+"]").attr('selected','selected');
			$("#board option[value="+bm+"]").attr('selected','selected');
			
			$("#submitBtn").click(function(){
				var classValue=$("#class").val();
				var scholarlyValue=$("#scholarly").val();
				var enrollValue=$("#enroll").val();
				var scholValue=$("#schol").val();
				var dormitoryValue=$("#dormitory").val();
				var boardValue=$("#board").val();
				var memberId = $("#en").val();
				console.log(classValue);
				$.ajax({
					url:"updateAccount.me",
					type: "post",
					data:{"classValue":classValue,"scholarlyValue":scholarlyValue,"enrollValue":enrollValue,"scholValue":scholValue,"dormitoryValue":dormitoryValue,"boardValue":boardValue,"memberId":memberId},
					success: function(data){
						self.close();
					}
				});			
			});
			$("#cancel").click(function(){
				self.close();
			})
		});
	</script>
</body>
</html>