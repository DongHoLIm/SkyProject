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
         <form action="login.me" method="post">
          	<table id="findIdInfo" align="center">          		
          		<tr>
          			<td rowspan="3">* 사용자 구분(User Group)</td>         			
          			<td colspan="2"><input type="radio" name="UserGroup" value="1" id="demo-priority-low"/><label for="demo-priority-low">졸업생/ 휴학생/재학생 (Students)</label></td>          			      			
          		</tr>
          		<tr>          			
          			<td colspan="2"><input type="radio" name="UserGroup" value="2" id="demo-priority-normal"/><label for="demo-priority-normal">교수(Professor)</label></td>          			
          		</tr>
          		<tr>
          			<td colspan="2"><input type="radio" name="UserGroup" value="3" id="demo-priority-high"/><label for="demo-priority-high">교직원(Faculty and Staff)</label></td>
          			
          		</tr>          		
          		<tr>
          			<td>* 학교(교번)(ID No)</td>
          			<td colspan="2"><input type="text" placeholder="학번(교번)를 입력하세요" name="memberId"/></td>
          		</tr>          		
          		<tr>
          			<td rowspan="2">* 인증 방식 (Authentication method)</td>          		
          			<td colspan="2"><a class="button primary fit" onclick="phoneCheck();">핸드폰인증</a></td>
          		</tr>
          		<tr>
          			<td><input type="text" placeholder="인증번호를 입력하세요"/></td>
          			<td><a href="#" class="button primary small">인증확인</a></td>
          		</tr>
          		<tr>
          			<td colspan="3" align="center"><input type="submit" class="primary" value="비밀번호(학번/교번/직원번호) 찾기"/></td>
          		</tr>
          	</table>
           
         </form>
      </div>
      <address>
         <span>COPYRIGHT</span>&copy; 2019 KH UNIV. ALL RIGHTS RESERVED.
      </address>
   </div>	
</body>
</html>