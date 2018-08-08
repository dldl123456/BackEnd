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
      // pageContext.setAttribute("uname", "容儿");
        request.setAttribute("uname", "小花");
        session.setAttribute("uname", "小白");
        application.setAttribute("uname", "德华");
        /*按对象的作用范围查找
         page-request-session-application
        
        */
       System.out.println(pageContext.findAttribute("uname"));
       
     %>
     <%=pageContext.getAttribute("uname") %>
     <jsp:forward page="pageContextB.jsp"></jsp:forward>
</body>
</html>