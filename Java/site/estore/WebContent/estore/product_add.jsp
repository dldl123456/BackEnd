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
    <script type="text/javascript">
     	var msg = {
    		"name" : "商品名称",
    		"fixed_price" : "市场价格",
    		"sale_price" : "打折价格",
    		"pnum":"商品数量",
    		"product_img":"商品图片"
    	};
    
		function validateRequired(fieldname){
			var objval = document.getElementById(fieldname).value;
			if(objval.match("^\\s*$")!=null){
				document.getElementById(fieldname+"_msg").innerHTML = "<span style='color:red'>"+msg[fieldname]+"不能为空！</span>";
				return false;
			}else{
				document.getElementById(fieldname+"_msg").innerHTML = "";
				return true;
			}
		}
	
		function validateForm(){
			var isNameValid = validateRequired("name");
			var isfixedPriceValid = validateRequired("fixed_price");
			var isSalePriceValid = validateRequired("sale_price");
			var isPnumValid = validateRequired("pnum");
			var isProductImgValid =  validateRequired("product_img");
	
			if(!isNameValid || !isfixedPriceValid|| isSalePriceValid || !isPnumValid || !isProductImgValid){
				return false;
			}
		} 
	</script>
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
									  <!-- 添加商品表单 -->
									  	<form method="post" enctype="multipart/form-data" action="#" onsubmit="return validateForm();">
											<table>
												<tr>
													<td>商品名称</td>
													<td><input type="text" name="name" id="name"/></td>
													<td id="name_msg"></td>
												</tr>
												<tr>
													<td>市场价格</td>
													<td><input type="text" name="fixed_price" id="fixed_price"/></td>
													<td id="fixed_price_msg"></td>
												</tr>
												<tr>
													<td>Estore打折价格</td>
													<td><input type="text" name="sale_price" id="sale_price"/></td>
													<td id="sale_price_msg"></td>
												</tr>
												<tr>
													<td>商品分类</td>
													<td>
														<select name="category" id="category">
															<option value="图书、电子书刊、音像">图书、电子书刊、音像</option>
															<option value="家用电器">家用电器</option>
															<option value="手机数码">手机数码</option>
															<option value="电脑、办公">电脑、办公</option>
															<option value="家居、家具、家装、厨具">家居、家具、家装、厨具</option>
														</select>
													</td>
													<td id="category_msg"></td>
												</tr>
												<tr>
													<td>商品数量</td>
													<td><input type="text" name="pnum" id="pnum"/></td>
													<td id="pnum_msg"></td>
												</tr>
												<tr>
													<td>图片</td>
													<td><input type="file" name="product_img" id="product_img"/></td>
													<td id="product_img_msg"></td>
												</tr>
												<tr>
													<td>描述</td>
													<td><textarea rows="5" cols="80" name="description" id="description"></textarea> </td>
													<td id="description_msg"></td>
												</tr>
												<tr>
													<td colspan="3">
														<input type="submit" value="添加商品" />
													</td>
												</tr>
											</table>
										</form>
									  <!-- 添加商品表单结束 -->                        
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