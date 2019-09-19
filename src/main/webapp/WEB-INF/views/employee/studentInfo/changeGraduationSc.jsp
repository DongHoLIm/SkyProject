<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
 <link rel="stylesheet" href="resources/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
   rel="stylesheet">

<style>
#basic {
   padding: 10px 0px 0px 100px;
}

table.basicinfo td {
   background: #FFF;
}

th {	
	background: #E5E6E7;
	}
	
td {
	background: white;
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
  
        
<h4 id="basic">졸업인증 변경</h4>
       
            <table class="basicinfo">
               <tr>
               	<th width="15%">구분</th>
               	<td>교내인증</td>
               	<th width="15%">졸업인증 코드</th>
               	<td>SD10002</td>
               </tr>
               
               <tr>
               	<th width="15%">졸업인증 명칭</th>
               	<td colspan='3'>토익</td>
               </tr>
               
               <tr>
               	<th width="15%">졸업인증 내용</th>
               	<td colspan='3'>
               	<input type="text" value="토익점수 600">
               	</td>
               </tr>
               
            </table>

            <br><br>
            <div style="text-align:center">
            <button onclick="#">수정</button>
            <button onclick="self.close();">취소</button>
            </div>
         <br><br><br><br><br>
      </div>
      
   </div>
</body>
</html>
