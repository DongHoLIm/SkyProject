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

            </table>




            <h4 id="basic">입력 사항</h4>

            <table class="basicinfo">
               <tr>
                  <td class="td">입학 구분</td>
                  <td><input type="text" value="신입" readonly></td>
                  <td class="td">입학 일자</td>
                  <td><input type="text" value="2019.03.03" readonly></td>
               </tr>
               <tr>
                  <td class="td">입학 학년</td>
                  <td><input type="text" value="4" readonly></td>
                  <td class="td">수험 번호</td>
                  <td><input type="text" value="201346027" readonly></td>
               </tr>
            </table>




            <h4 id="basic">복수 / 부전공</h4>

            <table class="basicinfo">
               <tr>
                  <td class="td">복수 전공 1</td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td">복수 전공 2</td>
                  <td><input type="text" value="" readonly></td>
               </tr>
               <tr>
                  <td class="td">부 전공 1</td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td">부 전공 2</td>
                  <td><input type="text" value="" readonly></td>
               </tr>
            </table>

            <h4 id="basic">졸업 사항</h4>

            <table class="basicinfo">
               <tr>
                  <td class="td">졸업 일자</td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td">학위 등록 번호</td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td">졸업 증서 번호</td>
                  <td><input type="text" value="" readonly></td>
               </tr>
               <tr>
                  <td class="td">학위명</td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td"></td>
                  <td><input type="text" value="" readonly></td>
                  <td class="td">조기 졸업 구분</td>
                  <td><input type="text" value="" readonly></td>
               </tr>

            </table>
         </form>
      </div>
      <div>
         <jsp:include page="../../common/menubar-student.jsp" />
      </div>
   </div>

</body>
</html>