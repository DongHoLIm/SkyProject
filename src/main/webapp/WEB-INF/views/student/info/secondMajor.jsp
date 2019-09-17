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
                  <td class="td">학과</td>
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
             <h4 id="basic">다전공 신청</h4>
               <table class="basicinfo">
                  <tr>
                     <td class="td">다전공 분류 </td>
                     <td colspan="5">
                     	<select name="secondMajor" id="secondMajor">
                           <option value="multi">복수전공</option>
                           <option value="second">부전공</option>
                     	</select>
                     </td>
                  </tr>
                  <tr>
                     <td class="td">단과대학</td>
                     <td colspan="2">
                     	<select name="college" id="college">
                           <option value="CollegeChoice">-- 선택 --</option>
                           <option value="Humanities">인문대학</option>
                           <option value="Art">예술대학</option>
                           <option value="Engineering">공과대학</option>
                   		</select>
                     </td>
                     <td class="td">학과</td>
                     <td colspan="2">
                     	<select name="sDept" id="sDept">
                           
                    	</select>
                    </td>
                  </tr>
               </table>               
               <input type="button" value="신청 하기" id="modified" style="float: right; margin-right: 50px;">
           </form>
               <br><br><br>
               
               <h4 id="basic">신청 내역</h4>
               <table class="basicinfo" id="Change">
                  <thead>
                     <tr>
                        <th style="text-align: center" id="t1">다전공 분류</th>
                        <th style="text-align: center" id="t1">단과 대학</th>
                        <th style="text-align: center" id="t1">학과</th>
                        <th style="text-align: center" id="t1">신청 날짜</th>
                        <th style="text-align: center" id="t1">처리 결과</th>
                     </tr>
                  <thead>
                  <tbody>
                     <tr>
                        <td>경영</td>
                        <td>글로벌</td>
                        <td>인문</td>
                        <td>2019-09-12</td>
                        <td>승인</td>
                     </tr>
                  </tbody>
               </table>
         
      </div>
      <div>
         <jsp:include page="../../common/menubar-student.jsp" />
      </div>
   </div>
	<script>
		$("#college").change(function(){
			var college = $(this).val();
			
			var $option1 = $("<option value='business'>경영학과</option>")
			var $option2 = $("<option value='economics'>경제학과</option>")
			var $option3 = $("<option value='diplomacy'>정치외교과</option>")
			var $option4 = $("<option value='music'>실용음악과</option>")
			var $option5 = $("<option value='atheletic'>사회체육과</option>")
			var $option6 = $("<option value='computer'>컴퓨터공학과</option>")
			var $option7 = $("<option value='electronic'>전자공학과</option>")
			var $option8 = $("<option value='building'>건축과</option>")
			
			if(college == "Humanities"){
				$("#sDept").children().remove();
				$("#sDept").append($option1);
				$("#sDept").append($option2);
				$("#sDept").append($option3);
			}else if(college == "Art"){
				$("#sDept").children().remove();
				$("#sDept").append($option4);
				$("#sDept").append($option5);
			}else if(college == "Engineering"){
				$("#sDept").children().remove();
				$("#sDept").append($option6);
				$("#sDept").append($option7);
				$("#sDept").append($option8);
			}
		});
		
	</script>
</body>
</html>