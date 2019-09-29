<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	#basic {
		padding: 10px 0px 0px 100px;
	}
	
	th {
		width: 10%;
		background: #E5E6E7;
	}
	
	td {
		background: white;
		text-align: center;
	}
	.updateSpan	{
		padding-left: 10px;
	}
	
	.deleteSpan:hover, .updateSpan:hover{
		cursor: pointer;
		color: black;
	}
</style>	
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
			</div>
			<h4 id="basic">자유게시판</h4>
			<hr style="width: 88.5%; margin: 0 auto;">
			<br>
				<div align="right" style="margin: 0 auto; width:88.5%;">
					<div style="margin-bottom: 10px">
					<c:if test="${sessionScope.loginUser.memberId == b.memberId}">
						<button onclick="updateBoard()">수정</button>
						<button onclick="deleteBoard()">삭제</button>				
					</c:if>
						<button onclick="st_freeBoardList()">목록</button>
					</div>
				</div>
			<input type="hidden" id="boardNo" name="boardNo" value="${b.boardNo}">
			<table style="width: 88.5%; margin: 0 auto;">				
				<tbody id="tbody">
					<tr>
						<th style="text-align: center;">글번호</th>
						<td>${b.boardNo}</td>
						<th style="text-align: center;">제목</th>
						<td colspan="4">${b.title}</td>
					</tr>
					<tr>
						<th style="text-align: center;">작성자</th>
						<td>${b.writer}</td>
						<th style="text-align: center;">작성일자</th>
						<td>
							<fmt:parseDate value="${b.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${enrollDate}" pattern="yyyy/MM/dd"/>
						</td>
						<th style="text-align: center;">조회수</th>
						<td>${b.count}</td>
					</tr>
					<tr>
						<td colspan="6" style="text-align: left; height: 100px;">
							<c:if test="${!empty uf}">
								<div align="center">
									<img src="${uf.path}" width="50%" height="70%">
								</div>
							</c:if>
							<pre>${b.content}</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="hidden" name="cWriter" id="cWriter" value="${sessionScope.loginUser.memberKName}">
							<textarea id="cContent" name="cContent" style="resize: none;" rows="3" cols="80" placeholder="댓글을 작성하세요."></textarea>
						</td>
						<td colspan="2" style="margin: 0 auto; vertical-align: middle;">
							<button onclick="insertReply()">작성</button>
						</td>					
					</tr>
					<tr id="replyArea">
					
					</tr>
				</tbody>									
			</table>
		</div>
		<div>
		<jsp:include page="/WEB-INF/views/common/menubar-student.jsp" />
	</div>
	<script>
		function st_freeBoardList(){
			location.href="st_freeBoardList.bo";
		}
		
		function deleteBoard() {
			var boardNo = ${b.boardNo};
			
			alert("게시글을 삭제하시겠습니까?");
			
			location.href="st_deletefreeBoard.bo?boardNo="+boardNo;
		}
		
		function updateBoard(){
			var boardNo = ${b.boardNo};			
			
			location.href="st_showUpdatefreeBoard.bo?boardNo="+boardNo;
		}
		
		function insertReply(){
			var boardNo = ${b.boardNo};	
			var cWriter = $("#cWriter").val();
			var cContent = $("#cContent").val();
			
			console.log("boardNo :::: " + boardNo);
			console.log("cWriter :::: " + cWriter);
			console.log("cContent :::: " + cContent);
			
			$.ajax({
				url:"insertfreeBoardRP.rp",
				type:"POST",
				data:{
					"boardNo":boardNo,
					"cWriter":cWriter,
					"cContent":cContent
				},
				success:function(data){
					alert("댓글이 등록되었습니다!");
					$("#cContent").val("");		
					
					loadAjax();
					
				}
			});
		}
		
		$(function(){
			var boardNo = $("#boardNo").val();
			var replyWriter = $("#cWriter").val();
			
			$.ajax({
				url:"selectfreeBoardRP.rp",
				type:"get",
				data:{
					"boardNo":boardNo
				},
				success:function(data){
					console.log("연결성공!");
					console.log("data :::: " + data.list[0].cContent);
					console.log("data.list.length :::: " + data.list.length);					
					console.log("replyWriter :::: " + replyWriter);
					
					$tbody = $("#tbody");
					
					$tbody.children("#replyArea").remove();				
					
					for(var i = 0; i < data.list.length; i++){
						
						var $tr = $("<tr id='replyArea'>");
						var $th = $("<th style='text-align: center; text-align: center; vertical-align: middle;'>");
						var $td1 = $("<td colspan='4' style='text-align: center; vertical-align: middle;'>");
						var $td2 = $("<td style='text-align: center; vertical-align: middle; border-right: 1px solid #E5E6E7;'>");
						var $span1 = $("<span>");
						var $span2 = $("<span>");
						var $input = $("<input type='hidden' name='cNo' class='cNo'>");
						
						
						$th.text(data.list[i].cWriter);
						
						$td1.text(data.list[i].cContent);
						$td1.addClass('cContentTd');
						
						$input.val(data.list[i].cNo);
						
						var cNo = $input.val();
						
						$span1.addClass('deleteSpan');
						$span2.addClass('updateSpan');
						
						$span1.text('삭제');
						$span2.text('수정');
						
						$span1.attr({
							"onclick":"deleteReply("+cNo+")"
						});						
						
						if(replyWriter == $th.text()){
							$td2.append($span1);
							$td2.append($span2);
						}
						
						$tr.append($input);
						$tr.append($th);
						$tr.append($td1);			
						$tr.append($td2);	
						
						$tbody.append($tr);
					}
					
					$(".updateSpan").click(function(){
						var beforeContent = $(this).parent().parent().children().eq(2).text();
						var cNo2 = $(this).parent().parent().children().eq(0).val();						
						
						$(this).parent().parent().children().eq(2).text("");
						
						$(this).parent().parent().children().eq(2).append("<input type='text' class='newcContent' name='newcContent' value='"+beforeContent+"'>");
						
						$(this).hide();
						
						$span3 = $("<span>");
						$span3.addClass('updateSpan');
						$span3.text("완료");
						
						$span3.attr({
							"onclick":"updateReply("+cNo2+")"
						});
						
						$(this).parent().append($span3);
						
					});	
				}
			});
		});
		
		function loadAjax(){
			var boardNo = $("#boardNo").val();
			var replyWriter = $("#cWriter").val();
			
			$.ajax({
				url:"selectfreeBoardRP.rp",
				type:"get",
				data:{
					"boardNo":boardNo
				},
				success:function(data){
					console.log("연결성공!");
					console.log("data :::: " + data.list[0].cContent);
					console.log("data.list.length :::: " + data.list.length);					
					console.log("replyWriter :::: " + replyWriter);
					
					$tbody = $("#tbody");
					
					$tbody.children("#replyArea").remove();				
					
					for(var i = 0; i < data.list.length; i++){
						
						var $tr = $("<tr id='replyArea'>");
						var $th = $("<th style='text-align: center; text-align: center; vertical-align: middle;'>");
						var $td1 = $("<td colspan='4' style='text-align: center; vertical-align: middle;'>");
						var $td2 = $("<td style='text-align: center; vertical-align: middle; border-right: 1px solid #E5E6E7;'>");
						var $span1 = $("<span>");
						var $span2 = $("<span>");
						var $input = $("<input type='hidden' name='cNo' class='cNo'>");
						
						$th.text(data.list[i].cWriter);
						
						$td1.text(data.list[i].cContent);
						$td1.addClass('cContentTd');
						
						$input.val(data.list[i].cNo);
						
						var cNo = $input.val();
						
						$span1.addClass('deleteSpan');
						$span2.addClass('updateSpan');
						
						$span1.text('삭제');
						$span2.text('수정');
						
						$span1.attr({
							"onclick":"deleteReply("+cNo+")"
						});						
						
						if(replyWriter == $th.text()){
							$td2.append($span1);
							$td2.append($span2);
						}
						
						$tr.append($input);
						$tr.append($th);
						$tr.append($td1);			
						$tr.append($td2);	
						
						$tbody.append($tr);
					}
					
					$(".updateSpan").click(function(){
						var beforeContent = $(this).parent().parent().children().eq(2).text();
						var cNo2 = $(this).parent().parent().children().eq(0).val();						
						
						$(this).parent().parent().children().eq(2).text("");
						
						$(this).parent().parent().children().eq(2).append("<input type='text' class='newcContent' name='newcContent' value='"+beforeContent+"'>");
						
						$(this).hide();
						
						$span3 = $("<span>");
						$span3.addClass('updateSpan');
						$span3.text("완료");
						
						$span3.attr({
							"onclick":"updateReply("+cNo2+")"
						});
						
						$(this).parent().append($span3);
						
					});	
				}
			});
		}
		
		function deleteReply(cNo){			
			$.ajax({
				url:"deletefreeBoardRP.rp",
				type:"POST",
				data:{
					"cNo":cNo
				},
				success:function(data){
					alert("댓글이 삭제되었습니다!");
					
					loadAjax();
				}
			});
		};
	
		function updateReply(cNo2){		
			var cContent = $("input[name=newcContent]").val();
			var cNo = cNo2;
			
			console.log("cNo :::: " + cNo);
			console.log("cContent :::: " + cContent);
			
			 $.ajax({
				url:"updatefreeBoardRP.rp",
				type:"POST",
				data:{
					"cNo":cNo,
					"cContent":cContent
				},
				success:function(data){
					alert("댓글이 수정되었습니다!");
					
					loadAjax();
				}
			}); 
		}	
	</script>
</div>
</body>
</html>