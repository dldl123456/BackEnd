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
</body>
</html>