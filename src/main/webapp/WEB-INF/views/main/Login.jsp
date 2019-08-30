<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>ㅇㅇ</title>
<meta charset="utf-8" />
<style>
.box {
   display: table-cell;
   vertical-align: middle;
   width: 1000px;
   height: 500px;
   margin: 0 auto;
   border: #000 solid 1px;
}

.left-box {
   float: left;
   width: 50%;
   margin: 0 auto;
}

.right-box {
   float: right;
   width: 50%;
   left: 50%;
}

#loginBtn {
   width: 357%;
   background-color: #f8585b;
   border: none;
   color: #fff;
   padding: 15px 0;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 15px;
   cursor: pointer;
}
</style>
</head>
<body>
   <div class="box">
      <div class="left-box">
         <img src="resources/images/logo.png">
      </div>
      <div class="right-box">
         <form action="login.me" method="post">
            <table id="loginTable" style="text-align: center;">
               <tr>
                  <td><label>아이디</label></td>
                  <td><input type="text" name="memberId"></td>

               </tr>
               <tr>
                  <td>패스워드</td>
                  <td><input type="password" name="memberPwd"></td>
               </tr>
               <tr>
                  <td>
                     <button id="loginBtn">로그인</button>
                  </td>
               </tr>
               <tr>
                  <td colspan="3"><a href="#">아이디찾기</a> <a href="#">비밀번호 찾기</a>
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </div>
</body>
</html>