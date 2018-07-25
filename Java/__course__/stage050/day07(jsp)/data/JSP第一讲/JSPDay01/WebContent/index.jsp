<%@ page language="java" 
    pageEncoding="UTF-8"
   %>
<!DOCTYPE>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<!--  -->
	<jsp:include page="top.jsp"></jsp:include>
	<h1>hello JSP!!!!大家好</h1>
	<!--html注释-->
	<%--jsp注释 --%>
	<!--java脚本的使用(声明，小脚本，表达式 都是有java代码组成的片段)-->
	<!--1.声明(一般定义全局变量的时候用到)-->
	<%!
		int age=18;
	%>
	<!--2.小脚本：等价于在service里面写java代码-->
	<%
		for(int i=0;i<10;i++){
			out.write(i+"<br>");
		}
	%>
	<!--3.表达式:等价于在service方法中的输出语句 out.write(age)-->
	<%=age%><br>
	<% 
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				%>
				<%=j+"*"+i+"="+i*j%>
			<%}%>
			<br>
		<%}
	%>
	<hr>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>