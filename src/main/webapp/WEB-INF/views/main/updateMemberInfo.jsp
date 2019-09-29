<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	#memberInfo{
		text-align: center;
	}
	#memberInfoDiv{
		width: 70%;
		margin: 0 auto;
	}
	#search{
		cursor: pointer;
	}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function searchAddress(){
    new daum.Postcode({
        oncomplete: function(data) {
            console.log(data);
            var postCode = data.postcode;
            var jibun = data.roadAddress;
            console.log(jibun);
            $("input[name='address1']").val(postCode);
            $("input[name='address2']").val(jibun);
        }
    }).open();
	
}
$(function (){
	$("input[id='memberPwd2']").on("propertychange change keyup paste input", function() {
		var password2=$(this).val();		
		var password1 = $("input[name='memberPwd']").val();		
		if(password1!=password2){
			$("p[id='fail']").css('display', '');
			$("p[id='success']").css('display', 'none');
			
		}else{
			$("p[id='success']").css('display', '');
			$("p[id='fail']").css('display','none');
		}
	});
});
</script>
</head>
<body>
<c:set var="member" value="${loginUser.memberStatus}" />
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../common/header.jsp" />
				<br />
				<h4>회원 정보 변경</h4>				
				<hr />	
				<form action="updateMemberInfo1.me" method="post">
				<div id="memberInfoDiv" >			
				<table id="memberInfo">
					<tr>
						<td>한글이름 :</td>
						<td colspan="2"><input type="text" value="${user.memberKName}" name="memberKName" style="color:black;"/></td>
					</tr>
					<tr>
						<td>영어이름 :</td>
						<td colspan="2"><input type="text" value="${user.memberEName}" name="memberEName" style="color:black;"/></td>
					</tr>
					<tr>
						<td>아이디 : </td>
						<td colspan="2"><input type="text" value="${user.memberId}" name="memberId" style="background: rgb(227, 226, 222);color:black;" readonly/></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td colspan="2"><input type="password" name="memberPwd" style="color:black;" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인 : </td>
						<td colspan="2"><input type="password" style="color:black;" id="memberPwd2" name="pwd2"/><p style="display:none; color:blue;" id="success">비밀번호가 일치합니다.</p>
						<p style="display:none; color:red" id="fail">비밀번호가 불일치합니다.</p></td>
					</tr>
					<tr>
						<td rowspan="3">주소 :</td>
						<td><input type="text" value="${address[0]}" name="address1"/></td>
						<td><a id="search" onclick="searchAddress();">검색</a></td>							
					</tr>
					<tr>						
						<td colspan="2"><input type="text" style="color:black;" value="${address[1]}" name="address2"/></td>
						
					</tr>
					<tr>
						<td colspan="2"><input type="text" style="color:black;" value="${address[2]}"name="address3" placeholder="상세주소입력"/></td>
					</tr>
					<tr>
						<td>이메일 :</td>
						<td colspan="2">
						<input type="text" value="${user.email }" name="email"/>						
						</td>
						
					</tr>
					<tr>
						<td>연락처 : </td>
						<td colspan="2"><input type="tel" value="${user.phone }" name="phone" style="color:black;" placeholder="-를 사용하여 기입해주세요"/></td>
					</tr>
					<tr>
						<td>비상 연락망 :</td>
						<td colspan="2"><input type="tel" value="${user.phone2}"name="phone2"style="color:black;"/></td>
					</tr>
				</table>				
				<div align="center">
				<button type="submit">수정</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset">취소</button>
				</div>
				</div>
				</form>
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
</body>
</html>