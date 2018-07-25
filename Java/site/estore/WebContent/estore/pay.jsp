<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCtype html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
    <title>Estore购物商城</title>

    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->
    
    <script type="text/javascript" src="script.js"></script>
    <style type="text/css">
    	table tr td input{
    		position: relative;
    		top: -15px;
    	}
    </style>
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
									  <!-- 在线支付 -->
									  <form action="confirm.jsp" method="post">
								      	<table width="100%">
											<tr>  
												<td bgcolor="#F7FEFF" colspan="3">
											 		<!-- param.orderid 等价于 request.getParameter("orderid") -->
											 		<div>订单号：111 <input type="hidden" name="orderid" value="111"/> </div>
											 		<div>支付金额：100<input type="hidden" name="money" size="6" value="100"/>元</div>
											 	</td>
											</tr>
											<tr><td><br/></td></tr>
											<tr>
												<td>请您选择在线支付银行</td>
											</tr>
											<tr>
											  <td><input type="radio" name="pd_FrpId" value="CMBCHINA-NET"/><img src="banklogo/CMBCHINA-NET.png" alt="招商银行" /> </td>
											  <td><input type="radio" name="pd_FrpId" value="ICBC-NET"/><img src="banklogo/ICBC-NET.png" alt="工商银行" /></td>
											  <td><input type="radio" name="pd_FrpId" value="ABC-NET"/><img src="banklogo/ABC-NET.png" alt="农业银行" /></td>
											</tr>
											<tr>
											  <td><input type="radio" name="pd_FrpId" value="CCB-NET"/><img src="banklogo/CCB-NET.png" alt="建设银行" /> </td>
											  <td><input type="radio" name="pd_FrpId" value="CMBC-NET"/><img src="banklogo/CMBC-NET.png" alt="中国民生银行总行" /></td>
											  <td><input type="radio" name="pd_FrpId" value="CEB-NET" /><img src="banklogo/CEB-NET.png" alt="光大银行 " /></td>
											</tr>
											<tr>
											  <td><input type="radio" name="pd_FrpId" value="BOCO-NET"/><img src="banklogo/BOCO-NET.png" alt="交通银行" /></td>
											  <td><input type="radio" name="pd_FrpId" value="SDB-NET"/><img src="banklogo/SDB-NET.png" alt="深圳发展银行" /></td>
											  <td><input type="radio" name="pd_FrpId" value="BCCB-NET"/><img src="banklogo/BCCB-NET.png" alt="北京银行" /></td>
											</tr>
											<tr>
											  <td><input type="radio" name="pd_FrpId" value="CIB-NET"/><img src="banklogo/CIB-NET.png" alt="兴业银行" /> </td>
											  <td><input type="radio" name="pd_FrpId" value="SPDB-NET"/><img src="banklogo/SPDB-NET.png" alt="上海浦东发展银行" /></td>
											  <td><input type="radio" name="pd_FrpId" value="ECITIC-NET"/><img src="banklogo/ECITIC-NET.png" alt="中信银行" /></td>
											</tr>
											<tr><td><br/></td></tr>
											<tr>
											  <td><input type="submit" value="确定支付" /></td>
											</tr>
								     	</table>
   									  </form>
									  <!-- 在线支付结束 -->                        
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