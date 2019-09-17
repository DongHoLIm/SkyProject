<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#addressList{
		width: 100%;
		height: 450px;		
		overflow: auto;
		background: white;
	}
	#addressStuList{
		width: 100%;
		margin: 0 auto;
		background: white;
		
	}		
	.SMSbtn{
		display: inline-block;
	}
	#addressStuList tr{
		text-align: center;
	}
	#addressStuList tr td{
		text-align: center;
	}
	#addressStuList tr th{
		text-align:  center;
	}
</style>
</head>
<body>
<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>			
						<h3 id="title" class="SMSbtn">SMS 보내기</h3>
					<div class="titleInDiv" style="float: right;">
						<button class="SMSbtn" id="addressListget">주소록</button>						
						<button class="SMSbtn" id="sendSMS">보내기</button>				
					</div>
				
				<br />			
				<hr />				
				<textarea cols="30" rows="10" id="message" style="resize: none;border-radius: 30px;border:3px solid lightgray;"></textarea>
				<br />
				<br />			
				<div id="addressList">									
					<table id="addressStuList">
						<thead>
							<tr>								
								<th>학번</th>
								<th>학생이름</th>
								<th>핸드폰 번호</th>
								<th>학과</th>
								<th>학년</th>
							</tr>
						</thead>
						<tbody>							
						</tbody>						
					</table>
			
				</div>
				<br />				
					
			</div>
		</div>
		<div>			
			<jsp:include page="../../common/menubar-professor.jsp" />
		</div>
	</div>
	<c:if test="${empty loginUser}">		
		<jsp:forward page="Login.jsp"/>
	</c:if>
	
	<script>
		function addressList(url){
			var name = "주소록";
			var specs = "width='150px'";
			window.open(url,name,specs);
		}
		
		function getReturnValue(returnValue){
			var memberlist = $.parseJSON(returnValue);
			
			for(var i = 0;i<memberlist.length;i++){
				var $tr = $("<tr>");
				var $td =$("<td>");
				var $td1 = $("<td>");
				var $td2 = $("<td>");
				var $td3 = $("<td>");
				var $td4 =$("<td>");
				
				$td.text(memberlist[i].memberId);
				$td1.text(memberlist[i].memberKName);
				$td2.text(memberlist[i].phone);
				$td3.text(memberlist[i].sdeptName);
				$td4.text(memberlist[i].grade);
				$tr.append($td);
				$tr.append($td1);
				$tr.append($td2);
				$tr.append($td3);
				$tr.append($td4);
				$("#addressStuList tbody").append($tr);
			}
		}
		$("#addressListget").click(function(){
			addressList("addressStudent.pro");
		});
		$("#sendSMS").click(function(){			
			var sendMember = new Object();
			var sendMemberlist = new Array();
			var message = $("#message").val();
			var tr = $("#addressStuList tbody tr");
			 for(var i =0;i<tr.length;i++){
					 var memberId = tr.eq(i).children().eq(0).text();
					 var memberKName = tr.eq(i).children().eq(1).text();
					 var phone = tr.eq(i).children().eq(2).text();
					 var sdeptName = tr.eq(i).children().eq(3).text();
					 var grade = tr.eq(i).children().eq(4).text();
					 sendMember={
							 	message : message,
	 							memberId:memberId,
	 							memberKName:memberKName,
	 							phone:phone,
	 							sdeptName:sdeptName,
	 							grade:grade
	 					}
				sendMemberlist.push(sendMember);
			 }
			 var send = JSON.stringify(sendMemberlist);
			 $.ajax({
				 url:"sendSMSResult.pro",
				 type:"post",
				 data:{"send": send},
				 success:function(data){
					 console.log(data);
					 alert("메세지가 전송되었습니다.");
					 $.ajax({
						url:"sendMessage.ac",
						type:"post",
						data:{"msg":data.msg,"phoneNumber":data.phoneNumber,"checkPoint":"0"},
						success:function(data){
							
						}
						});
				 }
			 });
		});
	</script>
</body>
</html>