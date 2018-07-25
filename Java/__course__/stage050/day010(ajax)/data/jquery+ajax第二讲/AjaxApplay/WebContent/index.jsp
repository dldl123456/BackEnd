<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		$("#lid").click(function(){
			$.ajax({
				url:"loginServlet",
				type:"get",
				dataType:"html",
				data:{"uname":$("[name=uname]").val(),
					"upass":$("[name=upass]").val()},
				success:function(data){
					if(data==0){
						alert("登录成功!!!!");
						window.setTimeout(function(){
							window.location.href="success.jsp?data="+data;
						},2000);
					}else{
						alert("用户名或者密码错误~~~");
					}
				}
			})
		});
		$("#json_btn").click(function(){
			$.ajax({
				url:"jsonServlet",
				dataType:"json",
				type:"post",
				success:function(data){
					var temp="";
					for(var i=0;i<data.length;i++){
						temp+=
						"<tr>"+
							"<td>"+data[i].id+"</td>"+
							"<td>"+data[i].uname+"</td>"+
							"<td>"+data[i].upass+"</td>"+
							"<td>"+data[i].sex+"</td>"+
							"<td>"+data[i].address+"</td>"+
						"</tr>"
					}
					$("#t_json").html(temp);
				}
			})
		});
		
		$("#xml_btn").click(function(){
			$.ajax({
				url:"xmlServlet",
				dataType:"xml",
				type:"post",
				success:function(data){
					//得到xml对象数据集合
					var list=$(data).find("user");
					var temp="";
					for(var i=0;i<list.length;i++){
						temp+=
						"<tr>"+
							"<td>"+list[i].getAttribute("id")+"</td>"+
							"<td>"+list[i].getAttribute("uname")+"</td>"+
							"<td>"+list[i].getAttribute("upass")+"</td>"+
							"<td>"+list[i].getAttribute("address")+"</td>"+
						"</tr>"
					}
					$("#t_xml").html(temp);
				}
			})
		});
		
		
	});
</script>
</head>
<body>
		<p>
			用户名:<input type="text" name="uname">
		</p>
		<p>
			密码:<input type="password" name="upass">
		</p>
		<input type="button" value="提交数据" id="lid">
		<hr>
		<h1>请求json数据</h1>
		<input type="button" id="json_btn" value="获取json数据列表">
		<hr>
		<table style="border-collapse:collapse;" width="600px" border="1px" id="t_json">
		
		</table>
		<hr>
		<hr>
		<input type="button" id="xml_btn" value="获取xml数据列表">
		<table style="border-collapse: collapse;" width="600px" border="1px" id="t_xml">
		
		</table>
		
		
		
		
		
		
		
</body>
</html>