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
									<!-- 确认支付表单 -->
									<!-- 通过form的隐藏域，提交参数给易宝 -->
									<form action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
										<h3>订单号：Estore111231231231,付款金额 ：100</h3>
										<input type="hidden" name="pd_FrpId" value="${pd_FrpId }" />
										<input type="hidden" name="p0_Cmd" value="${p0_Cmd }" />
										<input type="hidden" name="p1_MerId" value="${p1_MerId }" />
										<input type="hidden" name="p2_Order" value="${p2_Order }" />
										<input type="hidden" name="p3_Amt" value="${p3_Amt }" />
										<input type="hidden" name="p4_Cur" value="${p4_Cur }" />
										<input type="hidden" name="p5_Pid" value="${p5_Pid }" />
										<input type="hidden" name="p6_Pcat" value="${p6_Pcat }" />
										<input type="hidden" name="p7_Pdesc" value="${p7_Pdesc }" />
										<input type="hidden" name="p8_Url" value="${p8_Url }" />
										<input type="hidden" name="p9_SAF" value="${p9_SAF }" />
										<input type="hidden" name="pa_MP" value="${pa_MP }" />
										<input type="hidden" name="pr_NeedResponse" value="${pr_NeedResponse }" />
										<input type="hidden" name="hmac" value="${hmac }" />
										<input type="submit" value="确认支付" />
									</form>
									<!-- 确认支付表单结束 -->                        
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