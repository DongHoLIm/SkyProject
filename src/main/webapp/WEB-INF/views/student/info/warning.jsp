<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리시스템</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
   rel="stylesheet">
<style>
#basic {
   padding: 10px 0px 0px 100px;
}

table.basicinfo td {
   background: #FFF;
}

td.td {
   text-align: center;
   background: #c7c5b7 !important;
   color: black;
   width: 100px !important;
}

table.basicinfo {
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
         <h4 id="basic">기본 정보</h4>
         <form class="ba">
            <table class="basicinfo">
               <tr>
                  <td class="td">학번</td>
                  <td colspan='5'><input type="text" value="123456789" readonly></td>
               </tr>

               <tr>
                  <td class="td">한글 성명</td>
                  <td><input type="text" value="홍길동" readonly></td>
                  <td class="td">영문 성명</td>
                  <td><input type="text" value="In Woo Kang" readonly></td>
                  <td class="td">한문 성명</td>
                  <td><input type="text" value="姜因遇" readonly></td>
               </tr>

               <tr>
                  <td class="td">주민 번호</td>
                  <td><input type="text" value="940205-*******" readonly></td>
                  <td class="td">생년월일</td>
                  <td><input type="text" value="2000.07.26" readonly></td>
                  <td class="td">성별</td>
                  <td><input type="text" value="남" readonly></td>
               </tr>

               <tr>
                  <td class="td">학부(과)</td>
                  <td><input type="text" value="소프트웨어 응용" readonly></td>
                  <td class="td">전공</td>
                  <td><input type="text" value="컴퓨터 공학" readonly></td>
                  <td class="td">학년</td>
                  <td><input type="text" value="1" readonly></td>
               </tr>

               <tr>
                  <td class="td">학적 상태</td>
                  <td><input type="text" value="재학" readonly></td>
                  <td class="td">주야</td>
                  <td><input type="text" value="주간" readonly></td>
                  <td class="td">병역 구분</td>
                  <td><input type="text" value="" readonly></td>
               </tr>


               <table class="basicinfo" id="Change">

                  <h4 id="basic">학사 경고</h4>

                  <thead>
                     <tr>
                        <th style="text-align: center">번호</th>
                        <th style="text-align: center">년도</th>
                        <th style="text-align: center">학기</th>
                        <th style="text-align: center">사유</th>
                     </tr>
                  <thead>
                     <tobody>
                     <tr>
                        <td>안녕</td>
                        <td>하세요</td>
                        <td>안녕</td>
                        <td>하세요</td>
                     </tr>
                     </tobody>
               </table>


            </table>
         </form>
      </div>
      <div>
         <jsp:include page="../../common/menubar-student.jsp" />
      </div>
   </div>

</body>
</html>