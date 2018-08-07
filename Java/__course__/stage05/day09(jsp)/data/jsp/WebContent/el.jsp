<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     ${ 20 mod 3 }
     ${ 20 % 3 }
     
     ${10>20 }
     
     ${not(10>20&& 20>10) }
     
     ${empty temp }
     ${empty "" }
     ${not empty temp }
     
     <Hr>
     <%
     pageContext.setAttribute("user", "容儿1");
     request.setAttribute("user", "容儿2");
     session.setAttribute("user", "容儿3");
     application.setAttribute("user", "容儿4");

     %>
     ${user}/${pageScope.user}/<%=pageContext.getAttribute("user")%>
     ${requestScope.user}/<%=request.getAttribute("user")%>
     ${sessionScope.user}/<%=session.getAttribute("user")%>
     ${applicationScope.user}/<%=application.getAttribute("user")%>
     <hr>
     <!-- 当对象的键值相同,又省略隐式对象,比如 pageScope/requestScope,
       按对象作用范围查找 page,request,session,application -->
   <%
      session.setAttribute("css", "css");
      application.setAttribute("css", "css2");
   %>
   ${css}
   <h1>与请求相关</h1>
   <hr>
    ${param.user}/  <%=request.getParameter("user") %>
    ${paramValues.user[0]}/ <%=request.getParameterValues("user")[1] %>
</body>
</html>