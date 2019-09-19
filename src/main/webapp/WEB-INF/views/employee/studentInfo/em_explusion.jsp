<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	.basic {
		padding: 10px 0px 0px 100px;
	}
	
	.explusionInfo {
	   width: 85%;
	   text-align: center; 
	   margin: 0 auto;
	   border: 1px solid #dde1e3;
	}
	
	.enrollSpan:hover {
		cursor: pointer;
		color: red;
	}
	
	.pagingArea, .pagingArea2 {
		margin-top: 2%;
	}	
	
	.search {
		width: 85%;
		text-align: center;
		margin: 0 auto;
	}
	
	.searchArea {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.searchArea2 {
		width: 14%;
		float: right;
		margin-bottom: 1%;
	}
	
	.inputArea {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.inputArea2 {
		width: 20%;
		float: right;
		padding-left: 1%;
	}
	
	.btnArea {
		float: right;
		padding-left: 1%;
	}
	
	.btnArea2 {
		float: right;
		padding-left: 1%;
	}
	
	.h4Area {
		float: left;
		padding-left: 1%;
	}
	
</style>
<script>
	$(function(){
		$.ajax({
			url:"em_ExplusionList.si",
			type:"POST",
			success:function(data){				
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].collegeName);
					$td2.text(data.list[i].sdeptName);
					$td3.text(data.list[i].grade);
					$td4.text(data.list[i].studentNo);
					$td5.text(data.list[i].memberKName);	
					
					if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미등록");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo != '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미복학");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo != '')){
						$td6.text("학사경고 3회 초과");
					}
					
					$span1.text("처리");
					$span1.addClass("enrollSpan");					
					
					$td7.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var studentNo = $(this).parents("tr").children().eq(3).text();
					var explusionReason = $(this).parents("tr").children().eq(5).text();
					
					if(confirm("[학번 : " + studentNo + "] 제적 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_ExplusionEnroll.si",
							type:"POST",
							data:{
								"studentNo":studentNo,
								"explusionReason":explusionReason
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 첫 번째 ajax 끝
		
		$.ajax({
			url:"em_ExplusionList2.si",
			type:"GET",
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].explusionNo);
					$td2.text(data.list[i].collegeName);
					$td3.text(data.list[i].sdeptName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].studentNo);
					$td6.text(data.list[i].memberKName);	
					$td7.text(data.list[i].explusionReason);					
					$td8.text(data.list[i].explusionDate);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success function 끝
		}); // 두 번째 ajax 끝
	}); // onload funcion 끝
	
	function loadAjax(curr){
		var currentPage = curr;
		
		$.ajax({
			url:"em_ExplusionList.si",
			type:"POST",
			data:{"currentPage":currentPage},
			success:function(data){				
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].collegeName);
					$td2.text(data.list[i].sdeptName);
					$td3.text(data.list[i].grade);
					$td4.text(data.list[i].studentNo);
					$td5.text(data.list[i].memberKName);	
					
					if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미등록");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo != '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미복학");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo != '')){
						$td6.text("학사경고 3회 초과");
					}
					
					$span1.text("처리");
					$span1.addClass("enrollSpan");					
					
					$td7.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var studentNo = $(this).parents("tr").children().eq(3).text();
					var explusionReason = $(this).parents("tr").children().eq(5).text();
					
					if(confirm("[학번 : " + studentNo + "] 제적 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_ExplusionEnroll.si",
							type:"POST",
							data:{
								"studentNo":studentNo,
								"explusionReason":explusionReason
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 첫 번째 ajax 끝		
	} // loadAjax 끝
	
	function loadAjax2(curr){
		var currentPage = curr;
		$.ajax({
			url:"em_ExplusionList2.si",
			type:"GET",
			data:{"currentPage":currentPage},
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].explusionNo);
					$td2.text(data.list[i].collegeName);
					$td3.text(data.list[i].sdeptName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].studentNo);
					$td6.text(data.list[i].memberKName);	
					$td7.text(data.list[i].explusionReason);					
					$td8.text(data.list[i].explusionDate);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success function 끝
		}); // 두 번째 ajax 끝
	} // loadAjax2 끝
	
	function successList(){
		$.ajax({
			url:"em_ExplusionList.si",
			type:"POST",
			success:function(data){				
				var $tbody = $("#tbody");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $span1 = $("<span>")
					
					$td1.text(data.list[i].collegeName);
					$td2.text(data.list[i].sdeptName);
					$td3.text(data.list[i].grade);
					$td4.text(data.list[i].studentNo);
					$td5.text(data.list[i].memberKName);	
					
					if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미등록");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo != '') && (data.list[i].warnStudentNo == '')){
						$td6.text("미복학");
					}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo != '')){
						$td6.text("학사경고 3회 초과");
					}
					
					$span1.text("처리");
					$span1.addClass("enrollSpan");					
					
					$td7.html($span1);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea").children().remove();
				$(".pagingArea").append($ul);
				
				$(".enrollSpan").click(function(){
					var studentNo = $(this).parents("tr").children().eq(3).text();
					var explusionReason = $(this).parents("tr").children().eq(5).text();
					
					if(confirm("[학번 : " + studentNo + "] 제적 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_ExplusionEnroll.si",
							type:"POST",
							data:{
								"studentNo":studentNo,
								"explusionReason":explusionReason
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				}); // enrollSpan click 끝
			} // success 끝
		}); // 첫 번째 ajax 끝
	} // successList 끝
	
	function successList2(){
		$.ajax({
			url:"em_ExplusionList2.si",
			type:"GET",
			success:function(data){
				var $tbody = $("#tbody2");
				
				$tbody.children().remove();
				
				for(var i = 0; i < data.list.length; i++){
					var $tr = $("<tr>");
					var $td1 = $("<td style='text-align: center;'>");
					var $td2 = $("<td style='text-align: center;'>");
					var $td3 = $("<td style='text-align: center;'>");
					var $td4 = $("<td style='text-align: center;'>");
					var $td5 = $("<td style='text-align: center;'>");
					var $td6 = $("<td style='text-align: center;'>");
					var $td7 = $("<td style='text-align: center;'>");
					var $td8 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].explusionNo);
					$td2.text(data.list[i].collegeName);
					$td3.text(data.list[i].sdeptName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].studentNo);
					$td6.text(data.list[i].memberKName);	
					$td7.text(data.list[i].explusionReason);					
					$td8.text(data.list[i].explusionDate);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					
					$tbody.append($tr);
				}
				
				var currentPage = data.pi.currentPage;
				var listCount = data.pi.listCount;
				var limit = data.pi.limit;
				var maxPage = data.pi.maxPage;
				var startPage = data.pi.startPage;
				var endPage = data.pi.endPage;
				
				var $ul = $("<ul>");
				$ul.addClass("pagination");
				$ul.attr({
					"style":"justify-content: center; cursor: pointer;"
				});
				
				var $li1 = $("<li>");
				var $a1 = $("<a>");
				
				if(currentPage <= 1){
					$li1.addClass("page-item disabled");
					$a1.addClass("page-link");					
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);					
				}else if(currentPage > 1){
					$li1.addClass("page-item");
					$a1.addClass("page-link");
					$a1.attr({
						"onclick":"loadAjax2("+(currentPage-1)+")",
					});
					$a1.html("이전");
					$li1.append($a1);
					$ul.append($li1);
				}
				
				for(var p = startPage; p <= endPage; p++){
					var $li2 = $("<li>");
					var $a2 = $("<a>");		
					$li2.addClass("page-item");
					$a2.addClass("page-link");
					$a2.attr({
						"onclick":"loadAjax2("+p+")",
					});
					$a2.html(p);
					$li2.append($a2);
					$ul.append($li2);				
				}
				
				var $li3 = $("<li>");
				var $a3 = $("<a>");	
				
				if(currentPage < maxPage){
					$li3.addClass("page-item");
					$a3.addClass("page-link");
					$a3.attr({
						"onclick":"loadAjax2("+(currentPage+1)+")",
					});
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);	
				}else{
					$li3.addClass("page-item disabled");
					$a3.addClass("page-link");
					$a3.html("다음");
					$li3.append($a3);
					$ul.append($li3);
				}
				
				$(".pagingArea2").children().remove();
				$(".pagingArea2").append($ul);
			} // success function 끝
		}); // 두 번째 ajax 끝
	} // successList2 끝
</script>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
			</div>
			<br><br>
			<div class="search">
				<div class="h4Area">
					<h4>제적 대상자</h4>
				</div>
				<div class="btnArea">
					<button id="firstBtn">검색</button>
				</div>
				<div class="inputArea">
					<input type="text" id="searchValue" name="searchValue">	
				</div>
				<div class="searchArea">
					<select id="searchCondition" name="searchCondition">
						<option value="all">전체보기</option>
						<option value="sdeptName">학과</option>
						<option value="memberKName">이름</option>
					</select>		
				</div>				
			</div>
			<table class="explusionInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">단과대학</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">사유</th>
						<th style="text-align: center">관리</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagingArea">
			
			</div>	
			
			<br><br>
					
			<div class="search">
				<div class="h4Area">
					<h4>제적 처리 내역</h4>
				</div>
				<div class="btnArea2">
					<button id="secondBtn">검색</button>
				</div>
				<div class="inputArea2">
					<input type="text" id="searchValue2" name="searchValue2">	
				</div>
				<div class="searchArea2">
					<select id="searchCondition2" name="searchCondition2">
						<option value="all">전체보기</option>
						<option value="sdeptName">학과</option>
						<option value="memberKName">이름</option>
					</select>		
				</div>
			</div>
			<table class="explusionInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">제적번호</th>
						<th style="text-align: center">단과대학</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">제적 사유</th>
						<th style="text-align: center">제적일</th>
					</tr>
				</thead>
				<tbody id="tbody2">
					
				</tbody>
			</table>
			<div class="pagingArea2">
			
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-employee.jsp" />
		</div>
	</div>
	
	<script>
		$(function(){
			$(".btnArea").hide();
			$(".inputArea").hide();
			$(".btnArea2").hide();
			$(".inputArea2").hide();
			
			$("#searchCondition").change(function(){
				var searchCondition = $(this).val();
				
				if(searchCondition == "all"){
					$(".btnArea").hide();
					$(".inputArea").hide();
					
					successList();
					
				}else if(searchCondition == "memberKName"){
					$(".btnArea").show();
					$(".inputArea").show();
				}else if(searchCondition == "sdeptName"){
					$(".btnArea").show();
					$(".inputArea").show();
				}
				
				$("#firstBtn").click(function(){
					var searchCondition = $("#searchCondition").val();
					var searchValue = $("#searchValue").val();					
					
					$.ajax({
						url:"searchExplusion.si",
						type:"GET",
						data:{
							"searchCondition":searchCondition,
							"searchValue":searchValue
						},
						success:function(data){
							$("#searchValue").val("");
							
							var $tbody = $("#tbody");
							
							$tbody.children().remove();
							
							for(var i = 0; i < data.list.length; i++){
								var $tr = $("<tr>");
								var $td1 = $("<td style='text-align: center;'>");
								var $td2 = $("<td style='text-align: center;'>");
								var $td3 = $("<td style='text-align: center;'>");
								var $td4 = $("<td style='text-align: center;'>");
								var $td5 = $("<td style='text-align: center;'>");
								var $td6 = $("<td style='text-align: center;'>");
								var $td7 = $("<td style='text-align: center;'>");
								var $span1 = $("<span>")
								
								$td1.text(data.list[i].collegeName);
								$td2.text(data.list[i].sdeptName);
								$td3.text(data.list[i].grade);
								$td4.text(data.list[i].studentNo);
								$td5.text(data.list[i].memberKName);	
								
								if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo == '')){
									$td6.text("미등록");
								}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo != '') && (data.list[i].warnStudentNo == '')){
									$td6.text("미복학");
								}else if((data.list[i].seStudentNo != '') && (data.list[i].osStudentNo == '') && (data.list[i].warnStudentNo != '')){
									$td6.text("학사경고 3회 초과");
								}
								
								$span1.text("처리");
								$span1.addClass("enrollSpan");					
								
								$td7.html($span1);
								
								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);
								$tr.append($td7);
								
								$tbody.append($tr);
							}		
							
							$(".enrollSpan").click(function(){
								var studentNo = $(this).parents("tr").children().eq(3).text();
								var explusionReason = $(this).parents("tr").children().eq(5).text();
								
								if(confirm("[학번 : " + studentNo + "] 제적 처리 하시겠습니까?") == true){
									$.ajax({
										url:"em_ExplusionEnroll.si",
										type:"POST",
										data:{
											"studentNo":studentNo,
											"explusionReason":explusionReason
										},
										success:function(data){
											successList();
											successList2();
										}
									})
								}
							}); // enrollSpan click 끝						
							
							$(".pagingArea").children().remove();						
						}
					});
				});
			});
			
			$("#searchCondition2").change(function(){
				var searchCondition = $(this).val();
				
				if(searchCondition == "all"){
					$(".btnArea2").hide();
					$(".inputArea2").hide();
					
					successList2();
					
				}else if(searchCondition == "memberKName"){
					$(".btnArea2").show();
					$(".inputArea2").show();
				}else if(searchCondition == "sdeptName"){
					$(".btnArea2").show();
					$(".inputArea2").show();
				}
				
				$("#secondBtn").click(function(){
					var searchCondition = $("#searchCondition2").val();
					var searchValue = $("#searchValue2").val();					
					
					$.ajax({
						url:"searchExplusion2.si",
						type:"GET",
						data:{
							"searchCondition":searchCondition,
							"searchValue":searchValue
						},
						success:function(data){
							$("#searchValue2").val("");
							
							var $tbody = $("#tbody2");
							
							$tbody.children().remove();
							
							for(var i = 0; i < data.list.length; i++){
								var $tr = $("<tr>");
								var $td1 = $("<td style='text-align: center;'>");
								var $td2 = $("<td style='text-align: center;'>");
								var $td3 = $("<td style='text-align: center;'>");
								var $td4 = $("<td style='text-align: center;'>");
								var $td5 = $("<td style='text-align: center;'>");
								var $td6 = $("<td style='text-align: center;'>");
								var $td7 = $("<td style='text-align: center;'>");
								var $td8 = $("<td style='text-align: center;'>");
								
								$td1.text(data.list[i].explusionNo);
								$td2.text(data.list[i].collegeName);
								$td3.text(data.list[i].sdeptName);
								$td4.text(data.list[i].grade);
								$td5.text(data.list[i].studentNo);
								$td6.text(data.list[i].memberKName);	
								$td7.text(data.list[i].explusionReason);					
								$td8.text(data.list[i].explusionDate);
								
								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);
								$tr.append($td7);
								$tr.append($td8);
								
								$tbody.append($tr);
							}						
							
							$(".pagingArea2").children().remove();						
						}
					});
				});
			});
		});
	</script>
</body>
</html>