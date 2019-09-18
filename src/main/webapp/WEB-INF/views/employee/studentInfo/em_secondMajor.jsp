<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다전공 신청 관리</title>
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
	
	.secondMajorInfo {
	   width: 85%;
	   text-align: center; 
	   margin: 0 auto;
	   border: 1px solid #dde1e3;
	}
	
	.enrollSpan:hover {
		cursor: pointer;
		color: black;
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
		width: 12%;
		float: right;
		margin-bottom: 1%;
	}
	
	.searchArea2 {
		width: 12%;
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
			url:"em_SecondMajorList.si",
			type:"GET",
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
					var $td8 = $("<td style='text-align: center;'>");
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					var $td11 = $("<td style='text-align: center;'>");
					var $span = $("<span>")
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].applyDate);
					$td10.text(data.list[i].majorStatus);
					
					$span.text("등록");
					$span.addClass("enrollSpan");
					$td11.html($span);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					$tr.append($td11);
					
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
					var applyCode = $(this).parents("tr").children().eq(0).text();
					var studentNo = $(this).parents("tr").children().eq(1).text();
					
					if(confirm("[신청번호 : " + applyCode + "] 등록 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_SecondMajorUpdate.si",
							type:"POST",
							data:{
								"applyCode":applyCode,
								"studentNo":studentNo
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				});
			}
		});
		
		$.ajax({
			url:"em_SecondMajorList2.si",
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
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].majorStatus);
					$td10.text(data.list[i].successDate);									
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					
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
			}
		});		
	});
	
	function loadAjax(curr){
		var currentPage = curr;
		
		$.ajax({
			url:"em_SecondMajorList.si",
			type:"GET",
			data:{currentPage:currentPage},
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
					var $td8 = $("<td style='text-align: center;'>");
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					var $td11 = $("<td style='text-align: center;'>");
					var $span = $("<span>")
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].applyDate);
					$td10.text(data.list[i].majorStatus);
					
					$span.text("등록");
					$span.addClass("enrollSpan");
					$td11.html($span);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					$tr.append($td11);
					
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
					var applyCode = $(this).parents("tr").children().eq(0).text();
					var studentNo = $(this).parents("tr").children().eq(1).text();
					
					if(confirm("[신청번호 : " + applyCode + "] 등록 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_SecondMajorUpdate.si",
							type:"POST",
							data:{
								"applyCode":applyCode,
								"studentNo":studentNo
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				});
			}
		});	
	};	
	
	function loadAjax2(curr){
		var currentPage = curr;
		
		$.ajax({
			url:"em_SecondMajorList2.si",
			type:"GET",
			data:{currentPage:currentPage},
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
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].majorStatus);
					$td10.text(data.list[i].successDate);									
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					
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
			}
		});
	}
	
	function successList(){
		$.ajax({
			url:"em_SecondMajorList.si",
			type:"GET",
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
					var $td8 = $("<td style='text-align: center;'>");
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					var $td11 = $("<td style='text-align: center;'>");
					var $span = $("<span>")
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].applyDate);
					$td10.text(data.list[i].majorStatus);
					
					$span.text("등록");
					$span.addClass("enrollSpan");
					$td11.html($span);
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					$tr.append($td11);
					
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
					var applyCode = $(this).parents("tr").children().eq(0).text();
					var studentNo = $(this).parents("tr").children().eq(1).text();
					
					if(confirm("[신청번호 : " + applyCode + "] 등록 처리 하시겠습니까?") == true){
						$.ajax({
							url:"em_SecondMajorUpdate.si",
							type:"POST",
							data:{
								"applyCode":applyCode,
								"studentNo":studentNo
							},
							success:function(data){
								successList();
								successList2();
							}
						})
					}
				});
			}
		});
	}
	
	function successList2(){
		$.ajax({
			url:"em_SecondMajorList2.si",
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
					var $td9 = $("<td style='text-align: center;'>");
					var $td10 = $("<td style='text-align: center;'>");
					
					$td1.text(data.list[i].applyCode);
					$td2.text(data.list[i].studentNo);
					$td3.text(data.list[i].memberKName);
					$td4.text(data.list[i].grade);
					$td5.text(data.list[i].avgScore);
					$td6.text(data.list[i].originSdept);
					$td7.text(data.list[i].majorCheck);
					$td8.text(data.list[i].sdeptName);
					$td9.text(data.list[i].majorStatus);
					$td10.text(data.list[i].successDate);									
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$tr.append($td10);
					
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
			}
		});
	}
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
					<h4>다전공 신청 내역</h4>
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
						<option value="studentNo">학번</option>
						<option value="majorCheck">다전공구분</option>
						<option value="sdeptName">신청학과</option>
					</select>		
				</div>				
			</div>
			<table class="secondMajorInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">신청번호</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학점</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">다전공 구분</th>
						<th style="text-align: center">다전공 신청 학과</th>
						<th style="text-align: center">신청일</th>
						<th style="text-align: center">처리상태</th>
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
					<h4>다전공 등록 완료 내역</h4>
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
						<option value="studentNo">학번</option>
						<option value="majorCheck">다전공구분</option>
						<option value="sdeptName">신청학과</option>
					</select>		
				</div>
			</div>
			<table class="secondMajorInfo">
				<thead id="thead">
					<tr>
						<th style="text-align: center">신청번호</th>
						<th style="text-align: center">학번</th>
						<th style="text-align: center">이름</th>
						<th style="text-align: center">학년</th>
						<th style="text-align: center">학점</th>
						<th style="text-align: center">학과</th>
						<th style="text-align: center">다전공 구분</th>
						<th style="text-align: center">다전공 신청 학과</th>
						<th style="text-align: center">처리상태</th>
						<th style="text-align: center">처리일</th>
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
					
				}else if(searchCondition == "studentNo"){
					$(".btnArea").show();
					$(".inputArea").show();
				}else if(searchCondition == "majorCheck"){
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
						url:"searchSecondMajorApply.si",
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
								var $td8 = $("<td style='text-align: center;'>");
								var $td9 = $("<td style='text-align: center;'>");
								var $td10 = $("<td style='text-align: center;'>");
								var $td11 = $("<td style='text-align: center;'>");
								var $span = $("<span>")
								
								$td1.text(data.list[i].applyCode);
								$td2.text(data.list[i].studentNo);
								$td3.text(data.list[i].memberKName);
								$td4.text(data.list[i].grade);
								$td5.text(data.list[i].avgScore);
								$td6.text(data.list[i].originSdept);
								$td7.text(data.list[i].majorCheck);
								$td8.text(data.list[i].sdeptName);
								$td9.text(data.list[i].applyDate);
								$td10.text(data.list[i].majorStatus);
								
								$span.text("등록");
								$span.addClass("enrollSpan");
								$td11.html($span);
								
								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);
								$tr.append($td7);
								$tr.append($td8);
								$tr.append($td9);
								$tr.append($td10);
								$tr.append($td11);
								
								$tbody.append($tr);
							}							
							
							$(".enrollSpan").click(function(){
								var applyCode = $(this).parents("tr").children().eq(0).text();
								var studentNo = $(this).parents("tr").children().eq(1).text();
								
								if(confirm("[신청번호 : " + applyCode + "] 등록 처리 하시겠습니까?") == true){
									$.ajax({
										url:"em_SecondMajorUpdate.si",
										type:"POST",
										data:{
											"applyCode":applyCode,
											"studentNo":studentNo
										},
										success:function(data){
											successList();
											successList2();
										}
									})
								}
							});
							
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
				}else if(searchCondition == "studentNo"){
					$(".btnArea2").show();
					$(".inputArea2").show();
				}else if(searchCondition == "majorCheck"){
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
						url:"searchSecondMajorApply2.si",
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
								var $td9 = $("<td style='text-align: center;'>");
								var $td10 = $("<td style='text-align: center;'>");
								
								$td1.text(data.list[i].applyCode);
								$td2.text(data.list[i].studentNo);
								$td3.text(data.list[i].memberKName);
								$td4.text(data.list[i].grade);
								$td5.text(data.list[i].avgScore);
								$td6.text(data.list[i].originSdept);
								$td7.text(data.list[i].majorCheck);
								$td8.text(data.list[i].sdeptName);
								$td9.text(data.list[i].majorStatus);								
								$td10.text(data.list[i].successDate);
								
								$tr.append($td1);
								$tr.append($td2);
								$tr.append($td3);
								$tr.append($td4);
								$tr.append($td5);
								$tr.append($td6);
								$tr.append($td7);
								$tr.append($td8);
								$tr.append($td9);
								$tr.append($td10);
								
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