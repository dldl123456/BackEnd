<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%!
       int x=100;
       class Student{
    	   private String sno;
    	   public void setSno(String sno){
    		   this.sno=sno;
    	   }
    	   public String getSno(){
    		   return sno;
    	   }
       }
    %>
    
    <%
       int y=x;
       Student stu=new Student();
       stu.setSno("1001");
       
 
    
    %>
    <%=stu.getSno() %>
    
</body>
</html>