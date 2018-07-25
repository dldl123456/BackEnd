<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.itzzb.pojo.Student"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> list=(ArrayList<Student>)session.getAttribute("list");
	%>
	<table border="1px" width="600px" style="border-collapse: collapse;">
			<% 
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getUname()%></td>
						<td><%=list.get(i).getUpass()%></td>
						<td><%=list.get(i).getAddress()%></td>
						<td><a href="delServlet?id=<%=list.get(i).getId()%>">删除学生</a></td>
					</tr>
				<% }
			%>
	</table>
	
	
	
	
	
	
	
	
</body>
</html>