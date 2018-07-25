<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
	%>
	用户名:<%=uname%><br>
	密码:<%=upass%><br>
	
	<h1>EL表达式获取表单数据</h1>
	EL用户名:${param.uname}<br>
	EL密码：${param.upass}<br>
	EL爱好:${paramValues.hobby[0]},${paramValues.hobby[1]}<br>
	EL城市:${param.city}<br>
	
	
	
	
	
	
</body>
</html>