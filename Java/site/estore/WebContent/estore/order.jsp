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
									  <!-- 订单列表 -->
									  <!-- 1号订单 -->
									    <div>订单编号：123123123122131</div>
										<div>订单金额：<span style="color:red;">100</span></div>
										<div>下单用户：张三</div>
										<div>下单时间：2014-04-20</div>
										<div>支付状态：
											<font color="red">未支付</font> <a href="#">取消订单</a>
											<a href="pay.jsp?orderid=${order.id }&money=${order.money}">在线付款</a>
										</div>
										<div>收货人信息 ：北京西三旗金燕龙办公楼2层 小丽收</div>
									  <div class="shopping_list_top">订单包含以下商品</div>
									  <br/>
									  <div class="shopping_list_border">
									  <table width="100%" border="0" cellspacing="0" cellpadding="0">
									     <tr class="shopping_list_title">
									       <td class="shopping_list_title_1">商品名</td>
									       <td class="shopping_list_title_2">单品积分</td>
									       <td class="shopping_list_title_3">市场价</td>
									       <td class="shopping_list_title_4">Estore打折价</td>
									       <td class="shopping_list_title_5">数量</td>
									    </tr>
									    </table>
									    <table width="100%" border="0" cellspacing="0" cellpadding="0">
									   <tr class="shopping_product_list" id="shoppingProduct_01">
									       <td class="shopping_product_list_1"><a href="#" class="blue">私募（首部披露资本博弈秘密的金融...</a></td>
									       <td class="shopping_product_list_2">189</td>
									       <td class="shopping_product_list_3">￥32.00</td>
									       <td class="shopping_product_list_4">￥18.90 (59折)</td>
									       <td class="shopping_product_list_5">1</td>
									   </tr>
									   <tr class="shopping_product_list" id="shoppingProduct_02">
									       <td class="shopping_product_list_1"><a href="#" class="blue"> 小团圆（张爱玲最神秘小说遗稿）</a></td>
									       <td class="shopping_product_list_2">173</td>
									       <td class="shopping_product_list_3">￥28.00</td>
									       <td class="shopping_product_list_4">￥17.30 (62折)</td>
									       <td class="shopping_product_list_5">1</td>
									   </tr> 
									   </table>  
									     <div class="shopping_list_end">
									      <ul>
									       <li class="shopping_list_end_1"></li>
									       <li class="shopping_list_end_2">￥626.90</li>
									       <li class="shopping_list_end_3">商品金额总计：</li>
									       <li class="shopping_list_end_4">您共节省：<label class="shopping_list_end_yellow">￥233.70</label></li>
									      </ul>
									     </div>
									  </div>
									  <!-- 1号订单结束 -->
									  <hr/>
									  <!-- 2号订单 -->
									  <div>订单编号：12312323424234</div>
										<div>订单金额：<span style="color:red;">999</span></div>
										<div>下单用户：李四</div>
										<div>下单时间：2014-05-01</div>
										<div>支付状态：
											<font color="green">已经支付</font>
										</div>
										<div>收货人信息 ：上海闵行区联航路xxx办公楼一层 小龙龙收</div>
									  <div class="shopping_list_top">订单包含以下商品</div>
									  <br/>
									  <div class="shopping_list_border">
									  <table width="100%" border="0" cellspacing="0" cellpadding="0">
									     <tr class="shopping_list_title">
									       <td class="shopping_list_title_1">商品名</td>
									       <td class="shopping_list_title_2">单品积分</td>
									       <td class="shopping_list_title_3">市场价</td>
									       <td class="shopping_list_title_4">Estore打折价</td>
									       <td class="shopping_list_title_5">数量</td>
									    </tr>
									    </table>
									    <table width="100%" border="0" cellspacing="0" cellpadding="0">
										  <tr class="shopping_product_list" id="shoppingProduct_05">
										       <td class="shopping_product_list_1"><a href="#" class="blue">PHP和MySQL Web开发 （原书第4版）</a></td>
										       <td class="shopping_product_list_2">712</td>
										       <td class="shopping_product_list_3">￥95.00</td>
										       <td class="shopping_product_list_4">￥71.20 (75折)</td>
										       <td class="shopping_product_list_5">1</td>
										   </tr>   
										  <tr class="shopping_product_list" id="shoppingProduct_06">
										       <td class="shopping_product_list_1"><a href="#" class="blue">法布尔昆虫记</a>（再买￥68.30即可参加“满199元减10元现金”活动）</td>
										       <td class="shopping_product_list_2">10</td>
										       <td class="shopping_product_list_3">￥198.00</td>
										       <td class="shopping_product_list_4">￥130.70 (66折)</td>
										       <td class="shopping_product_list_5">1</td>
										   </tr> 
									   </table>  
									     <div class="shopping_list_end">
									      <ul>
									       <li class="shopping_list_end_1"></li>
									       <li class="shopping_list_end_2">￥626.90</li>
									       <li class="shopping_list_end_3">商品金额总计：</li>
									       <li class="shopping_list_end_4">您共节省：<label class="shopping_list_end_yellow">￥233.70</label></li>
									      </ul>
									     </div>
									  </div>
									  <!-- 2号订单结束 -->
									  <!-- 订单列表结束 -->                        
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