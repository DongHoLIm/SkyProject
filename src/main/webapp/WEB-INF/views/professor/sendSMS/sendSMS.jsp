<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#addressList{
		width: 100%;
		height: 450px;		
		overflow: auto;
		background: white;
	}
	#addressStuList{
		width: 100%;
		margin: 0 auto;
		background: white;
		
	}		
	.SMSbtn{
		display: inline-block;
	}
	#addressStuList tr{
		text-align: center;
	}
	#addressStuList tr td{
		text-align: center;
	}
	#addressStuList tr th{
		text-align:  center;
	}
</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>			
						<h3 id="title" class="SMSbtn">SMS 보내기</h3>					
					<div class="titleInDiv" style="float: right;">
						<button class="SMSbtn" onclick="addressList();">주소록</button>						
						<button class="SMSbtn">보내기</button>				
					</div>
				
				<br />			
				<hr />				
				<textarea name="" id="" cols="30" rows="10" id="message" style="resize: none;border-radius: 30px;border:3px solid lightgray;"></textarea>
				<br />
				<br />			
				<div id="addressList">
					<table id="addressStuList">
						<thead>
							<tr>
								<th><input type="checkbox" value="selectAll" id="Allcheck">
									<label for="Allcheck"></label></th>
								<th>학번</th>
								<th>학생이름</th>
								<th>핸드폰 번호</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" value="" id="selectOne" /><label
									for="selectOne"></label></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>						
					</table>
				</div>
				<br />				
					
			</div>
		</div>
		<div>			
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	
	<script>
		function addressList(){
			window.open("addressStudent.pro","주소록","width='150px'");
		}
	</script>
</body>
</html>