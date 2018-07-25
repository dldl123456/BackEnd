<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* window.onload=function(){
		var uname="${cookie.uname.value}";
		alert(uname);
	} */
</script>
</head>
<body>
	<!--EL表达式运算符号的测试-->
	<h1>算数运算符的测试</h1>
	
	加法:${2+3}-----2+3<br>
	减法:${2-3}-----2-3<br>
	乘法:${2*3}-----2*3<br>
	除法:${2/3}-----2/3<br>
	<h1>关系运算符</h1>
	等等判断:${2==3}  
	<hr>
	<!--EL表达式获取表单数据的操作-->
	<form method="get" action="doForm.jsp">
		<p>
			用户名:<input type="text" name="uname">
		</p>
		<p>
			密码:<input type="password" name="upass">
		</p>
		<p>
			性别:
			<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女
		</p>
		<p>
			爱好:
			<input type="checkbox" name="hobby" value="玩游戏">玩游戏
			<input type="checkbox" name="hobby" value="看视频">看视频
			<input type="checkbox" name="hobby" value="写代码">写代码
		</p>
		<p>
			所在城市:
			<select name="city">
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="广州">广州</option>
				<option value="深圳">深圳</option>
			</select>
		</p>
		<input type="submit" value="提交数据">
	</form>
	<hr>
	<h1>通过EL表达式获取cookie数据</h1>
	用户名为:${cookie.uname.value}<br>
	<form action="loginServlet">
		<p>
			用户名:<input type="text" name="uname" value="${cookie.uname.value}">
		</p>
		<p>
			密码:<input type="password" name="upass">
		</p>
		<input type="submit" value="登录">
	</form>
	<hr>
	<h1>4个作用域对象的测试</h1>
	<%
		pageContext.setAttribute("uname1","page_scope");
		request.setAttribute("uname2","request_scope");
		session.setAttribute("uname3","session_scope");
		application.setAttribute("uname4", "application_scope");
	%>
	${uname1};<br>
	${uname2};<br>
	${uname3};<br>
	${uname4};<br>
	<hr>
	<a href="shoppingServlet">查询订单</a>
	商品数量:${count}<br>
	商品价格:￥${price}<br>
	商品总金额:￥${count*price}<br>
	<br>
	<h1>jstl标签的学习</h1>
	<!--set:设置变量  var 变量的名称  value：变量的值，scope:变量保存的作用域对象
		page,request,session,application
	-->
	<c:set var="uname" value="cpage_scope" scope="page"></c:set>
	<c:set var="uname" value="crequest_scope" scope="request"></c:set>
	<c:set var="uname" value="csession_scope" scope="session"></c:set>
	<c:set var="uname" value="capplication_scope" scope="application"></c:set>
	<!--输出变量
		value:要求输出的变量，
		escapeXml:是否解析value里面标签 false解析  true:不解析
		default：如果这样的变量${uname}不存在  则输出default里面的值
	-->
	<c:out value="${uname}" escapeXml="false" default="用户名不存在!!!"></c:out>
	<!--  remove 不指定作用域范围  默认删除所有作用域对象中的uname变量-->
	<c:remove var="uname"  scope="page"/>
	<br>
	删除之后:<c:out value="${uname}" escapeXml="false" default="用户名不存在!!!"></c:out>
	<hr>
	
	<form action="index.jsp">
		请输入测评分数:<input type="text" name="score">
		<input type="submit" value="开始测评">
	</form>
	本次测评等级为:
	<!--test是判断条件（EL表达式表示）-->
	<%-- <c:if test="${param.score<=100&&param.score>=90}">
		A
	</c:if>
	
	<c:if test="${param.score<90&&param.score>=80}">
		B
	</c:if>
	
	<c:if test="${param.score<80&&param.score>=60}">
		C
	</c:if>
	
	<c:if test="${param.score<60}">
		<span style="color:red">D</span>
	</c:if> --%>
	<hr>
	<c:choose>
		<c:when test="${param.score<=100&&param.score>=90}">
			A
		</c:when>
		<c:when test="${param.score<90&&param.score>=80}">
			B
		</c:when>
		<c:when test="${param.score<80&&param.score>=60}">
			C
		</c:when>
		<c:otherwise>
			D
		</c:otherwise>
	</c:choose>
	<!--字符串处理-->
	
	<c:forTokens items="qw;ert,yuu/iio" delims=";,/" var="index">
		${index}<br>
	</c:forTokens>
	<br>
	<!--import 类似于include包含-->
	<%-- <c:import url="top.jsp"></c:import> --%>
	<%-- <c:import url="https://www.baidu.com/index.php" charEncoding="UTF-8"></c:import> --%>
	<br>
	<%-- <c:url value="https://www.baidu.com/index.php" var="myUrl"></c:url> --%>
	<%-- <c:import url="${myUrl}" charEncoding="UTF-8"></c:import> --%>
	<!--等价于重定向-->
	<%-- <c:redirect url="${myUrl}"></c:redirect> --%>
	<!--i18n-->
	<!--时间格式化-->
	<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss" var="nowTime"/>
	当前系统时间为:${nowTime}<br>
	<fmt:formatNumber type="number" pattern="0.0000" value="123.456" var="num"></fmt:formatNumber>
	数字格式化:${num}<br>
	<hr>
	<!--servlet调用dao层查询所有用户信息   返回list集合于Servlet上   通过request对象返回数据于index上面显示-->
	<form action="queryServlet">
		<input type="submit" value="查询所用用户信息">
	</form>
	<table border="1px" width="600px" style="border-collapse: collapse;">
		<tr>
			<td>id</td>
			<td>用户名</td>
			<td>性别</td>
			<td>地址</td>
			<td>用户操作</td>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.uname}</td>
				<td>${user.sex}</td>
				<td>${user.address}</td>
				<td>
					<a href="deleteServlet?id=${user.id}">删除</a>
				</td>
			</tr>	
		</c:forEach>
	</table>


	
	
	
	
	
</body>
</html>