<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="u" class="com.iotek.javabean.User"></jsp:useBean>
    
    <jsp:setProperty property="userName" name="u" value="容儿"/>
    
    <jsp:getProperty property="userName" name="u"/>
    
    <%=u.getUserName() %>
</body>
</html>