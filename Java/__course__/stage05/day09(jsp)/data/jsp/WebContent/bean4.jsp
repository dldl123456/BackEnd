<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.iotek.javabean.User"></jsp:useBean>
   <form action="bean4.jsp" method="get">
     用户名:<input type="text" name="userNames"/><br>
          密码:<input type="text" name="password"/><br>
        <input type="submit" value="提交">
   </form>
   <jsp:setProperty property="*" name="user"/>
    <jsp:getProperty property="userName" name="user"/>
    <jsp:getProperty property="password" name="user"/>
</body>
</html>