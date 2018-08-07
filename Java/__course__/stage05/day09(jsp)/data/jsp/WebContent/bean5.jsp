<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <!-- 
                传值: page 表示当前页面有效
           request 请求范围有效 一次请求
           
           session 
           application 
           
     -->
     <jsp:useBean id="user" class="com.iotek.javabean.User" scope="request"></jsp:useBean>
  
     <jsp:setProperty property="userName" name="user" value="容儿"/>
     <jsp:getProperty property="userName" name="user"/>
     <jsp:forward page="bean6.jsp"></jsp:forward>
     
     
     
     
     
</body>
</html>