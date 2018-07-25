<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Estore购物商城</title>

    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->
    
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<div id="art-main">
        <div class="art-sheet">
            <div class="art-sheet-tl"></div>
            <div class="art-sheet-tr"></div>
            <div class="art-sheet-bl"></div>
            <div class="art-sheet-br"></div>
            <div class="art-sheet-tc"></div>
            <div class="art-sheet-bc"></div>
            <div class="art-sheet-cl"></div>
            <div class="art-sheet-cr"></div>
            <div class="art-sheet-cc"></div>
            <div class="art-sheet-body">
                <%@include file="header.jsp" %>
                <div class="art-content-layout">
                    <div class="art-content-layout-row">
                        <div class="art-layout-cell art-content">
                            <div class="art-post">
                                <div class="art-post-tl"></div>
                                <div class="art-post-tr"></div>
                                <div class="art-post-bl"></div>
                                <div class="art-post-br"></div>
                                <div class="art-post-tc"></div>
                                <div class="art-post-bc"></div>
                                <div class="art-post-cl"></div>
                                <div class="art-post-cr"></div>
                                <div class="art-post-cc"></div>
                                <div class="art-post-body">
									  <!-- 注册表单 -->
									    <div class="register_content">
										    <div class="register_title_bg"><h3>欢迎注册Estore商城</h3>您所提供的资料不会做其他用途，敬请安心填写。</div>
										    <div class="register_dotted_bg"></div>
										    <div class="register_message">
										    <form action="#" method="post">
										     <dl class="register_row">
										        <dt>Email地址：</dt>
										        <dd><input id="email" type="text" class="register_input" name="email"/></dd>
										      </dl>
										      <dl class="register_row">
										         <dt>设置昵称：</dt>
										         <dd><input id="nickName" type="text" class="register_input" name="nickname"/></dd>
										         <dd></dd>
										      </dl>
										     <dl class="register_row">
										         <dt>设定密码：</dt>
										         <dd><input id="pwd" type="password" class="register_input" name="password"/></dd>
										     </dl> 
										     <dl class="register_row"> 
										         <dt>再输入一次密码：</dt>
										         <dd><input id="repwd" type="password" class="register_input" name="repassword"/></dd>
										     </dl>
										     <dl class="register_row">
										        <dt>验证码：</dt>
										        <dd><input name="checkcode" class="register_input" type="text" /> </dd>
										        <dd><img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
													onclick="javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath }/validatecode.jsp?'+Math.random();" /></dd>
										     </dl>
										      <div class="registerBtn"><input id="registerBtn" type="image" src="images/register_btn_out.gif" /></div>
										   </form>
										    </div>
										  </div>
									  <!-- 注册表单结束 -->                        
                           			<div class="cleared"></div>
                                </div>
                            </div>
                        </div> 
                        <%@include file="sidebar.jsp" %>
                    </div>
                </div>
                <div class="cleared"></div>
                <%@include file="footer.jsp" %> 
        		<div class="cleared"></div>
            </div>
        </div>
        <div class="cleared"></div>
    </div>
    
</body>
</html>