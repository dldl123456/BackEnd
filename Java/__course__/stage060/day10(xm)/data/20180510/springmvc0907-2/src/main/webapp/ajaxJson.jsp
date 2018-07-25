<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Ajax</title>

<script type="application/javascript"
	src="http://www.w3school.com.cn/jquery/jquery-1.11.1.min.js"></script>
<script type="application/javascript">
	
        	// 获取服务器的json数据，并显示
			function getJson(){ 
     	    		$.ajax({
     	                url: "http://localhost:8080/springmvc0907-2/json.do",
     	                type: "post",
     	                success: function (data) {

     	                    alert("name= " + data.name);
     	                    alert("id = " + data.id);

     	                },
     	                error: function () {
     	                    alert("error");
     	                }
     	            });
     	    	}
        	
        	// 发送json数据，给服务器。
 			function sendJson(){
        	    		$.ajax({
        	                url: "http://localhost:8080/springmvc0907-2/json3.do",
        	                dataType: "json",
        	                type: "post",
        	                contentType:"application/json;charset=utf-8",
        	                data: '{ "name":"hello name json","id":888}',
        	                success: function (data) {

        	                    alert("name= " + data.name);
        	                    alert("id = " + data.id);

        	                },
        	                error: function () {
        	                    alert("error");
        	                }
        	            });
        	    	} 

</script>
</head>
<body>
	<form>

		<button id="btn1" onclick="getJson()">接收json</button>
		<button id="btn2" onclick="sendJson()">发送json</button>
	</form>
</body>
</html>
