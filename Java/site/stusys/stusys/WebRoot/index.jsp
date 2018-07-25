<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>javaEE(servlet)练习</title>
</head>
<body>
	<h4>请输入学生编号</h4>
	<form action="queryScore" method="get">
		学号：<input type="text" name="studentId">
		<input type="submit" value="立即查询">
	</form>
	<hr>
	${s}
	<table>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>数学</td>
			<td>语文</td>
			<td>英语</td>
		</tr>
		<tr>
			<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.math}</td>
			<td>${s.chinese}</td>
			<td>${s.english}</td>
		</tr>
	</table>
</body>
</html>