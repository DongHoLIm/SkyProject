<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
 <link rel="stylesheet" href="resources/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Karla&display=swap"
   rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

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
  
        <br>
		<h4 id="basic">학과 졸업인증 변경</h4>
       
            <table class="basicinfo">
               <tr>
               	<th width="15%">구분</th>
               	<td>${graduation.division }</td>
               	<th width="15%">졸업인증 코드</th>
               	<td id="code">${graduation.graduationCode }</td>
               </tr>
               
               <tr>
               	<th width="15%">졸업인증 명칭</th>
               	<td>${graduation.graduationName }</td>
               	<th width="15%">학과</th>
               	<td>${graduation.sdeptName }</td>
               </tr>
               
               <tr>
               	<th width="15%">졸업인증 내용</th>
               	<td colspan='3'>
               	<textarea id="content" rows="10" cols="5">${graduation.graduationContent }</textarea>
               	</td>
               </tr>
               
            </table>

            <br><br>
            <div style="text-align:center">
            <button onclick="changeInfo();">수정</button>
            <button onclick="self.close();">닫기</button>
            </div>
         <br><br><br><br><br>
      </div>
      
      <script>
      	function changeInfo(){
      		
      		var code = $("#code").text();
      		var content = $("#content").val();
      		
      		console.log(code);
      		console.log(content);
      		
      		$.ajax({
      			url:"em_changeGraduationMa.si",
      			type:"post",
      			data:{code:code,
      				  content:content},
      			success:function(data){
      				console.log("접속성공");
      				
      				document.location.reload();
      				alert("수정 완료");
      				opener.parent.location.reload();
      				//window.self.close();
      			}
      			
      		})
      		
      	}
      
      </script>
      
   </div>
</body>
</html>