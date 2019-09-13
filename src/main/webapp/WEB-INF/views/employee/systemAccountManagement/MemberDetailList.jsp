<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){	
	$("input[name='address']").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	           $("input[name='address']").val(data.address);	         
	        }
	    }).open();
	});
});
    
</script>
<style>
	.subTitle{
		display:inline-block;
	}
	#detailMember{
		text-align: center;
	}
</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<form action="upDateMemberInfo.me" method="post">
				<h3 class="subTitle">회원 상세 정보</h3>				
				<div style="float: right;">				
					<button type="submit" class="subTitle">수정</button>
					&nbsp;&nbsp;
					<button type="reset" class="subTitle">취소</button>	
				</div>
				<hr />				
				<table id="detailMember">
					<tr>
						<td>아이디</td>
						<td><input type="text" value="${memberDetail.memberId}" name="memberId"readonly/></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" value="${memberDetail.memberPwd}" readonly/></td>
					</tr>
					<tr>
						<td>이름(한글)</td>
						<td><input type="text" value="${memberDetail.memberKName }" name="memberKName"/></td>
					</tr>
					<tr>
						<td>이름(영문)</td>
						<td><input type="text" value="${memberDetail.memberEName }" name="memberEName"/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" value="${memberDetail.email }" name="email"/></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" value="${memberDetail.address }"name="address"/></td>
					</tr>
					<tr>
						<td>핸드폰번호</td>
						<td><input type="text" value="${memberDetail.phone }" name="phone"/></td>
					</tr>
					<tr>
						<td>구분</td>
						<c:if test="${memberDetail.memberStatus != null}">
						<td><input type="text" value="${memberDetail.memberStatus}" name="memberStatus" readonly/></td>	
						</c:if>
						<c:if test="${memberDetail.loginCheck=='2'}">
						<td><input type="text" value="교수" name="memberStatus" readonly/></td>
						</c:if>
						<c:if test = "${memberDetail.loginCheck=='3' }">
						<td><input type="text" value="교직원" name="memberStatus" readonly/></td>
						</c:if>					
					</tr>
					<tr>
						<td>부서/과</td>
						<td><input type="text" value="${memberDetail.sdeptCode}" readonly/></td>
					</tr>
					<c:if test="${memberDetail.loginCheck=='3' }">
					<tr>
						<td>직급</td>
						<td>
						<input type="hidden" value="${memberDetail.rankCode }" id="rankName"/>						
						<select name="rankCode" id="jobCodeName">
							<option value="사원">사원</option>
							<option value="대리">대리</option>
							<option value="과장">과장</option>
							<option value="팀장">팀장</option>
						</select>
						</td>
					</tr>
					</c:if>
					<c:if test="${memberDetail.loginCheck!='1' }">					
					<tr>
						<td>퇴사여부</td>
						<td>
						<select name="loginCheck" id="">						
							<option value="N">재직중</option>
							<option value="Y">퇴사</option>
						</select>
						</td>
					</tr>
					</c:if>
				</table>
				</form>
				
			</div>
		</div>
		<div>		
			<jsp:include page="../../common/menubar-employee.jsp" />			
		</div>
	</div>	
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	<script>
		$(function(){
			var jobName = $("#rankName").val();
			$("#jobCodeName option[value="+jobName+"]").attr('selected','selected');
			 
		});
	</script>
</body>
</html>