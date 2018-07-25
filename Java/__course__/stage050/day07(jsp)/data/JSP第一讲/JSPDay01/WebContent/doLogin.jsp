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
		if("admin".equals(uname)&&"admin".equals(upass)){
			%>
			<jsp:forward page="index.jsp">
				<jsp:param value="<%=uname%>" name="uname1"/>
			</jsp:forward>
			
		<% }
		
		
		
	%>
</body>
</html>