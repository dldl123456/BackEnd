<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test</h1>
     <jsp:useBean id="user" class="com.iotek.javabean.User" scope="request"></jsp:useBean>
     <jsp:getProperty property="userName" name="user"/>
</body>
</html>