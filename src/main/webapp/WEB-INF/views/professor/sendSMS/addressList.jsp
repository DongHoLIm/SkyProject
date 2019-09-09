<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="resources/css/main.css" />
</head>
<body>
	<div>
		<table id="searSubject">
			<tr>
				<td align="center">강의장명 :</td>
				<td><select name="demo-category" id="subject" style="width:120%;">
					<option value="">-강의명</option>
				</select></td>
				<td align="center"><button class="button small">Search</button></td>
			</tr>
		</table>
		 <table align="center">
			<thead>
				<tr>
					<th><input type="checkbox" value="selectAll" id="Allcheck"><label for="Allcheck"></label></th>									
					<th>학번</th>
					<th>이름</th>
					<th>핸드폰번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" value="selectAll" id="selectOne"><label for="selectOne"></label></td>
					<td></td>
					<td></td>
					<td></td>
					
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="center"><input type="button" class="button small" value="추가"/></td>
				</tr>
			</tfoot>
		</table>
		<hr />
		<table align="center">
			<thead>
				<tr>
					<th><input type="checkbox" value="selectAll" id="Allcheck"><label for="Allcheck"></label></th>									
					<th>학번</th>
					<th>이름</th>
					<th>핸드폰번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" value="selectAll" id="selectOne"><label for="selectOne"></label></td>
					<td></td>
					<td></td>
					<td></td>
					
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" align="center"><input type="button" class="button small" value="확인"/></td>
				</tr>
			</tfoot>
		</table>
	 </div>
</body>
</html>