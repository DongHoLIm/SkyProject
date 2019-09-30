<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   width: 90%;
   border: 1px solid #dde1e3;
   margin-left: auto;
   margin-right: auto;
} 

</style>
</head>
<body>
<div id="wrapper">
      <div id="main">
  
        <br>
		<h4 id="basic">휴학신청 상세 내용</h4>
       
            <table class="basicinfo">
               <tr>
               	<th width="20%">단과대학</th>
               	<td width="30%">${soSelect.college }</td>
               	<th width="20%">학과</th>
               	<td width="30%">${soSelect.sdeptName }</td>
               </tr>
               
               <tr>
               	<th width="20%">학번</th>
               	<td>${soSelect.studentNo }</td>
               	<th width="20%">이름</th>
               	<td>${soSelect.kName }</td>
               </tr>
               
               <tr>
               	<th width="20%">신청일자</th>
               	<td>${soSelect.applyDate }</td>
               	<th width="20%">처리상태</th>
               	<td>${soSelect.offStatus }</td>
               </tr>
               
               <tr>
               	<th width="20%">휴학구분</th>
               	<td>${soSelect.offType }</td>
               	<th width="20%">휴학사유</th>
               	<td>${soSelect.offReason }</td>
               </tr>
               
               <tr>
               	<th width="20%">휴학시작학기</th>
               	<td>${soSelect.offStart }</td>
               	<th width="20%">복학예정학기</th>
               	<td>${soSelect.returnDate }</td>
               </tr>
               
            </table>

            <br><br>
            <div style="text-align:center">
            <button onclick="changeStatus();">승인</button>
            <button onclick="self.close();">닫기</button>
            </div>
         <br><br><br><br><br>
      </div>
      
      <script>
      	function changeStatus(){
      		
      		/* var code = $("#code").text();
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
      			
      		}) */
      		
      	}
      
      </script>
      
   </div>

</body>
</html>