<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
               
               <h4 id="basic">졸업 인증 관리</h4>
               <table class="basicinfo" id="Change">
                  <thead>
                     <tr>
                        <th style="text-align: center" id="t1">인증구분</th>
                        <th style="text-align: center" id="t1">인증명</th>
                        <th style="text-align: center" id="t1">인증기준</th>
                        <th style="text-align: center" id="t1">인증여부</th>
                        <th style="text-align: center" id="t1">학생인증내용</th>
                        
                     </tr>
                  </thead>
                  <tbody id="info">
                  <c:forEach var="list" items="${list }">
					<tr>
						<td><c:out value="${list.division }"/></td>
						<td><c:out value="${list.graduationName }"/></td>
						<td><c:out value="${list.graduationContent }"/></td>
						<td><c:out value="${list.check }"/></td>
						<td><c:out value="${list.graduationInfo }"/></td>
					</tr>
				</c:forEach>
                  </tbody>
               </table>
               
               
               
               
      			
               
               <br><br><br><br><br><br>
         
        
            

      </div>
      <div>
      <jsp:include page="../../common/menubar-student.jsp" />
   </div>
</div>
</body>
</html>