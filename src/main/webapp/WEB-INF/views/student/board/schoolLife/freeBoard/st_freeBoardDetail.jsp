<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<c:if test="${sessionScope.loginUser.memberId == b.memberId}">
				<div align="right" style="margin: 0 auto; width:88.5%;">
					<div style="margin-bottom: 10px">
						<button onclick="updateBoard()">수정</button>
						<button onclick="deleteBoard()">삭제</button>				
					</div>
				</div>
			</c:if>
			<table style="width: 88.5%; margin: 0 auto;">				
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
						${b.content}
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
				<tr>
					<th>
						<span>작성자</span>
					</th>
					<td colspan="3" style="border-right: 1px solid #E5E6E7;">
						<span>댓글내용</span>
					</td>
					<td colspan="2" style="border-right:  1px solid #E5E6E7;">
						<button>수정</button>
						<button>삭제</button>
					</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: right;">
						<button onclick="st_freeBoardList()">목록으로</button>
					</td>
				</tr>									
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
				url:"st_insertfreeBoardRP.rp",
				type:"POST",
				data:{
					"boardNo":boardNo,
					"cWriter":cWriter,
					"cContent":cContent
				},
				success:function(data){
					alert("댓글이 등록되었습니다!");
					$("#cContent").val("");
				}
			});
		}
		
		
	</script>
</div>
</body>
</html>