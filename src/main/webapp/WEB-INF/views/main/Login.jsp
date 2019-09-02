<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
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

img, button, fieldset {
   border: 0;
}

fieldset {
   min-width: 0;
}

legend {
   overflow: hidden;
   visibility: hidden;
   position: absolute;
   left: -9999px;
   width: 0;
   height: 0;
   color: transparent;
   font-size: 0;
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

address {
   font-style: normal;
}

input[type=text], input[type=password] {
   height: 18px;
   line-height: 18px;
   margin-bottom: 10px;
   padding: 10px;
   font-size: 14px;
   border: 1px solid #ccc;
}

button::-moz-focus-inner {
   padding: 0;
   border: 0;
}

::-webkit-input-placeholder {
   color: #737373;
}

:-ms-input-placeholder {
   color: #737373;
}

:-moz-placeholder {
   color: #737373;
   opacity: 1;
}

::-moz-placeholder {
   color: #737373;
   opacity: 1;
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
   height: 314px;
   padding: 72px 69px 0 78px;
   border: 1px solid #e6e6e6;
   border-top: 0;
   background: #fff;
}

h1 {
   float: left;
   width: 238px;
   margin-right: 77px;
}

.inputWrap input {
   width: 303px;
   color: #4d4d4d;
}

button {
   width: 100%;
   height: 50px;
   text-align: center;
   font-size: 18px;
   color: #fff;
   background: #0067b3;
   cursor: pointer;
}

p {
   font-size: 14px;
   line-height: 20px;
}

.error p {
   display: none;
   margin-bottom: 14px;
   color: #ff4c4c;
}

.linkWrap {
   text-align: center;
   margin: 13px 0 16px ;
}

.linkWrap a span:first-child {
   display: inline-block;
   width: 1px;
   height: 11px;
   margin: -1px 9px 0 7px;
   vertical-align: middle;
   background: #b3b3b3;
}

.linkWrap a span.q {
   display: inline-block;
   width: 15px;
   height: 15px;
   margin: -1px 0 0 1px;
   vertical-align: middle;
   background: url(../img/icon_question.png);
   background-size: 100%;
}

p span:first-child {
   display: inline-block;
   width: 4px;
   height: 2px;
   margin: -3px 5px 0 0;
   vertical-align: middle;
   background: #808080;
}

address {
   margin-top: 10px;
   text-align: center;
}

@media screen and (min-width: 810px) and (max-height: 600px) {
   #wrap {
      margin: 30px auto;
   }
}

@media screen and (max-width: 810px) {
   body {
      background: #fff;
   }
   #wrap {
      width: auto;
      margin: 30px;
      background: none;
   }
   #container {
      height: auto;
      padding: 0;
      border: 0;
   }
   h1 {
      float: none;
      width: 130px;
      margin: 0 auto 30px;
   }
   .inputWrap {
      padding: 0 11px;
   }
   .inputWrap input {
      width: 100%;
      margin-left: -11px;
   }
   .linkWrap, p {
      text-align: center;
   }
   .error p {
      text-align: left;
   }
   p span:first-child, .linkWrap a.ty3 span:first-child {
      display: none;
   }
   .linkWrap {
      margin: 18px 10px 32px;
   }
   .linkWrap a.ty3 {
      display: block;
      margin-top: 10px;
      text-align: center;
   }
   address {
      margin-top: 37px;
   }
}

@media screen and (max-width: 480px) {
   #wrap {
      margin: 30px 15px;
   }
   address {
      font-size: 12px;
   }
   address span {
      display: none;
   }
}
</style>

</head>
<body>
   <div id="wrap">
   <img src="resources/images/bg_borderTop.png">
      <div id="container">
         <form action="login.me" method="post">
            <h1>
               <img class="img" src="resources/images/logo.png" alt="KH정보교육원">
            </h1>
            <fieldset>
               <legend>로그인</legend>
               <div class="inputWrap">
                  <input type="text" id="loginId" name="memberId" title="아이디 혹은 학번"
                     placeholder="학번(교번) (ID No.)" maxlength="16"> <input
                     type="password" id="loginPasswd" name="memberPwd" title="비밀번호"
                     placeholder="비밀번호 (Password)" maxlength="16">
               </div>
               <button type="submit" class="submit" style="cursor: pointer;">로그인(Login)</button>
               <div class="linkWrap">
                  <a href="#">아이디 찾기</a> <a
                     href="#"><span></span>임시비밀번호발급</a>
               </div>
               <p>
                  <span></span>이용 후 반드시 로그아웃 해주세요!<br>&nbsp;&nbsp;Please be
                  sure to log out after use.
               </p>
               <br>

            </fieldset>
         </form>
      </div>
      <address>
         <span>COPYRIGHT</span>&copy; 2019 KH UNIV. ALL RIGHTS RESERVED.
      </address>
   </div>

</body>
</html>