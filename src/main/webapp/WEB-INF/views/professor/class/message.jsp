<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.inputbox {
	border: none;
	box-shadow: none !important;
	width: 100%;
}

body {
	background-color: beige;
}

.contact {
	padding: 4%;
	height: 400px;
}

.col-md-3 {
	background: #f44336;
	padding: 4%;
	border-top-left-radius: 0.5rem;
	border-bottom-left-radius: 0.5rem;
}

.contact-info {
	margin-top: 10%;
}

.contact-info img {
	margin-bottom: 15%;
}

.contact-info h2 {
	margin-bottom: 10%;
}

.col-md-9 {
	background: #fff;
	padding: 3%;
	border-top-right-radius: 0.5rem;
	border-bottom-right-radius: 0.5rem;
}

.contact-form label {
	font-weight: 600;
}

.contact-form button {
	background: #25274d;
	color: #fff;
	font-weight: 600;
	width: 25%;
}

.contact-form button:focus {
	box-shadow: none;
}
.btn btn-secondary {
	background: #25274d;
	color: #fff;

}
</style>
</head>
<body>
	<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Message</h2>
				<h4>보내기</h4>
			</div>
		</div>
		<div class="col-md-9">
			<div class="contact-form">
				<div class="form-group">
				 	<div style="overflow:auto; width: 500px; height: 150px; border: 1px solid #00000042;">
						<table>
							<c:forEach var="member" items="${memberList }">
								<tr>
									<td>${ member.memberKName }(${ member.memberId })</td>
									<td><input name="memberIdCheck" class="memberIdCheck" type="checkbox" value=${ member.memberId }></td>
								</tr>
							</c:forEach>
						</table>
				 		
				 			
				 		
				 	</div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="people">받는사람</label>
				  <div class="col-sm-10">          
					<input type="text" class="form-control" id="people" placeholder="받는사람의 아이디를 입력하세요" name="people" readonly>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">제목</label>
				  <div class="col-sm-10">          
					<input type="text" class="form-control" id="lname" placeholder="제목을 입력하세요." name="lname">
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">내용</label>
				  <div class="col-sm-10">
					<textarea class="form-control" rows="5" id="comment"></textarea>
				  </div>
				</div>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default" onclick="sendMessage()">보내기</button>
				  </div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$(".memberIdCheck").change(function() {
			var items = [];
			$('input:checkbox[name=memberIdCheck]:checked').each(function() {
				items.push($(this).val());
			});
			var tmp = items.join(',');
			$("#people").val(tmp);
			var title = $("#lname").val()
			var content = $("#comment").val()
			console.log($("#comment").val());
			

		});

	});
	
	function sendMessage() {
		var tmp = $("#people").val();
		var title = $("#lname").val();
		var comment = $("#comment").val();
		$.ajax({
			url : '/finalProject/sendMessage',
			type : 'post',
			data : {
				'tmp' : tmp,
				'title' : title,
				'comment' : comment
			},
			dataType : 'json',
			success : function(result) {
				alert("쪽지를 보내었습니다.")
				window.close();
			},
			error : function(err) {
				alert('쪽지 보내기에 실패하였습니다..');

			}
		});
	}
</script>
</html>