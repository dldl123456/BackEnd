<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>

	<form action="${ pageContext.request.contextPath}/upload.do" method="post"
		enctype="multipart/form-data">

		选择文件<input type="file" name="uploadImg" /> <br /> <input type="submit"
			value="start">
	</form>

</body>
</html>