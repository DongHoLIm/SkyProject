<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
@charset "UTF-8";

@font-face {
   font-family: 'NanumBarunGothic';
   src: url(../font/NanumBarunGothicWeb.eot);
   src: url(../font/NanumBarunGothicWeb.eot?#iefix)
      format('embedded-opentype'), url(../font/NanumBarunGothicWeb.woff)
      format('woff'), url(../font/NanumBarunGothicWeb.ttf)
      format('truetype');
}

body {
   font-family: NanumBarunGothic, "맑은 고딕", Arial, Sans-Serif;
   font-weight: 400;
   font-size: 15px;
   color: #737373;
}

html, body, h1, p, button, img, input, fieldset, address {
   margin: 0;
   padding: 0;
}
img.img {
   
   padding-top: 40%;
}

button, input {
   font-family: inherit;
   font-size: inherit;
   color: inherit;
}

a {
   font-size: inherit;
   color: #4d4d4d;
   text-decoration: none;
}
body {
   background: #f2f2f2;
}
#wrap {
   width: 790px;
   margin: 160px auto 50px;
   padding-top: 3px;
   background: url(../img/bg_borderTop.png) no-repeat;
}

#container {
   overflow: hidden;
   height: 100%;
   padding: 72px 69px 0 78px;
   border: 1px solid #e6e6e6;
   border-top: 0;
   background: #fff;
}
address {
   font-style: normal;
   text-align: center;
}

</style>
</head>
<body>
 <div id="wrap">
   <img src="resources/images/bg_borderTop.png">
      <div id="container">
      <h2>ID 찾기</h2>     
      <hr />
         <form action="findIdResult.me" method="post">
          	<table id="findIdInfo" align="center">          		
          		<tr>
          			<td rowspan="3">* 사용자 구분(User Group)</td>         			
          			<td colspan="3"><input type="radio" name="memberStatus" value="1" id="demo-priority-low" checked/><label for="demo-priority-low">졸업생/ 휴학생/재학생 (Students)</label></td>          			      			
          		</tr>
          		<tr>          			
          			<td colspan="3"><input type="radio" name="memberStatus" value="2" id="demo-priority-normal"/><label for="demo-priority-normal">교수(Professor)</label></td>          			
          		</tr>
          		<tr>
          			<td colspan="3"><input type="radio" name="memberStatus" value="3" id="demo-priority-high"/><label for="demo-priority-high">교직원(Faculty and Staff)</label></td>
          			
          		</tr>          		
          		<tr>
          			<td>*이름(Name)</td>
          			<td colspan="3"><input type="text" placeholder="이름를 입력하세요" name="memberKName" id="memberKNameA"/></td>
          		</tr>
          		<tr>
          			<td>*생년월일(BirthDay)</td>
          			<td colspan="3"><input type="text" placeholder="생년월일를 입력하세요" maxlength="6" name="memberNo" id="memberNoA"/></td>
          		</tr>
          		<tr>
          			<td>*핸드폰번호(PhoneNumber)</td>
          			<td>
          			<input type="text"  id="phone1" maxlength="3"/>
          			</td>
          			
          			<td>
          			<input type="text" id="phone2" maxlength="4"/>
          			</td>
          			
          			<td>
          			<input type="text" id="phone3" maxlength="4"/>
          			</td>
          		</tr>
          		<tr>
          			<td rowspan="2">* 인증 방식 (Authentication method)</td>          		
          			<td colspan="3"><a class="button primary fit" onclick="phoneCheck();">핸드폰인증</a></td>
          		</tr>
          		<tr>
          			<td colspan="2"><input type="text" placeholder="인증번호를 입력하세요" id="checkNumber"/></td>
          			<td><a class="button primary small" onclick="checkUser();">인증확인</a></td>
          		</tr>
          		<tr>          		
          			<td colspan="2" align="center"><input type="button" class="primary" value="로그인페이지로이동" onclick="returnLogin();" id="findIdBtn"/></td>	
          			<td colspan="2" align="center"><input type="button" class="primary" value="아이디(학번/교번/직원번호) 찾기" onclick="submitBtn();" id="findIdBtn"/></td>
          		</tr>
          	</table>           
         </form>
      </div>
      <address>
         <span>COPYRIGHT</span>&copy; 2019 KH UNIV. ALL RIGHTS RESERVED.
      </address>
   </div>
   <script>
 
				var random = "";
				function phoneCheck() {
					$(function() {
						var checkPoint = "0";
						var phone1 = $("#phone1").val();
						var phone2 = $("#phone2").val();
						var phone3 = $("#phone3").val();						
						var phoneNumber =phone1+"-"+phone2+"-"+phone3;
						var result = Math.floor(Math.random() * 999999) + 100000;
						random = result;
						var msg = "인증번호는 " + result + "입니다.";
						$.ajax({
							url : "sendMessage.ac",
							data : {
								phoneNumber : phoneNumber,
								msg : msg,
								checkPoint : checkPoint
							},
							type : "post",
							success : function(data) {
								
							}
						});
						alert("인증번호를 확인후 기입하세요");
					});
				};
				function checkUser() {									
					var checkNumber = $("#checkNumber").val();					
					if (random == "") {
						alert("핸드폰 인증을 먼저 해주세요");
					}else{
						if(random==checkNumber){
							alert("핸드폰 인증완료");
							$("#checkNumber").css({"background-color": "lightgray"});
							$("#checkNumber").attr({"readonly":""});
							
						}else{
							alert("핸드폰 인증실패");
						}
					} 
				}
				function submitBtn(){
					var checkPostion =$("input[name='UserGroup']:checked").val();
					var memberKNameA =$("#memberKNameA").val();
					var memberNoA = $("#memberNoA").val();
					var phone1 = $("#phone1").val();
					var phone2 = $("#phone2").val();
					var phone3 = $("#phone3").val();
					
					if(memberKNameA==""||memberNoA==""||phone1==""||phone2==""||phone3==""){
						alert("모든 내용을 작성해주세요");						
					}else{
						$("#findIdBtn").attr({"type":"submit"}).click();
												
					}					
				}
				function returnLogin(){
					location.href="index.jsp";
				}
			</script>	
</body>
</html>