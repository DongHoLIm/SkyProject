<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#basic {
   padding: 10px 0px 0px 100px;
    
}

table.basicinfo td{
   background: #FFF;

}
td.td   {
   text-align: center;
   background: #c7c5b7 !important;
   color:black;
   width:100px !important;
   
}


table.basicinfo{
   width:85%;
   border: 1px solid #dde1e3;
   margin-left: auto;
   margin-right: auto;
}

#modified {
	margin-left: 80%;
}

#Change {
   text-align: center;
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
            
            <jsp:include page="../info/common.jsp" />
               
               <table class="basicinfo" id="Change">
                  <h4 id="basic">졸업 인증 내역</h4>

                  <thead>
                     <tr>
                        <th style="text-align: center" id="t1">인증 구분</th>
                        <th style="text-align: center" id="t1">인증명</th>
                        <th style="text-align: center" id="t1">인증 여부</th>
                        <th style="text-align: center" id="t1">학생 인증 내용</th>
                        
                     </tr>
                  </thead>
                  <tobody>
                  <tr>
                     <td>인증</td>
                     <td>인증 대기</td>
                     <td></td>
                  	 <td></td>
                  </tr>
                  </tobody>
               </table>
               
      			<div class="basicinfo">
      			<button id="modified">졸업 조건 확인 하기</button>
               </div> 
         
            

      </div>
      <div>
      <jsp:include page="../../common/menubar-student.jsp" />
   </div>
</div>
</body>
</html>