<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
		var focus_width=632;
        var focus_height=242;
		var picPath;
		var linkUrl="";
		var swfPath="adImage.swf";
		var sp="|";
		var banners =new Array("images/screen1.jpg","images/screen2.jpg","images/screen3.jpg","images/screen4.jpg","images/screen5.jpg","images/screen6.jpg","images/fuli1.jpg","images/fuli2.jpg");
		var links =new Array("#","#","#","#","#","#");

		for(var i=0;i<banners.length;i++){
			if(i==banners.length-1){
				sp="";
			}
			picPath+=banners[i]+sp;
		 	var index = picPath.indexOf("undefined");
		 	if(index!=-1){
		 		picPath = picPath.substr(index+9,picPath.length);
		 	}
			linkUrl+=links[i]+sp;			
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
                            <div class="art-post-inner art-article">
                                            <div class="art-postmetadataheader">
                                                <h2 class="art-postheader">
                                                    商品促销信息
                                                </h2>
                                            </div>
                                            <div class="art-postcontent">
                                                <!-- article-content -->
                                                <script type="text/javascript" src="mutilpleFlash.js"></script>                   
                                                <!-- /article-content -->
                                            </div>
                                            <div class="cleared"></div>
                            </div>
                            
                            <div class="cleared"></div>
                                </div>
                            </div>
							
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
                            <div class="art-post-inner art-article">
                                            <div class="art-postmetadataheader">
                                                <h2 class="art-postheader">
                                                    热卖商品销售中
                                                </h2>
                                            </div>
                                            <div class="art-postcontent">
                                                <!-- article-content -->
                                                <p>
                                                	<span class="art-button-wrapper">
                                                		<span class="l"> </span>
                                                		<span class="r"> </span>
                                                		<a class="art-button" href="javascript:void(0)">更多商品...</a>
                                                	</span>
                                                </p>
                                                <div class="cleared"></div>
                                                <div class="art-content-layout overview-table">
                                                	<div class="art-content-layout-row">
                                                		<div class="art-layout-cell">
                                                      <div class="overview-table-inner">
                                                	      <h4>保温水杯</h4>
                                                		  <img src="images/pic1.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                       </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>黑宝石手链</h4>
                                                		  <img src="images/pic2.jpg" width="55px" height="55px" alt="an image" class="image" />
														  <p>价格: ￥139</p>
														  <p>速速抢购</p>
												    </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>LV名牌包包</h4>
														  <img src="images/pic3.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>名牌夹克</h4>
														  <img src="images/pic4.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>大容量冰箱</h4>
														  <img src="images/pic5.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
<!-- 														<div class="art-layout-cell"> -->
<!--                                                     <div class="overview-table-inner"> -->
<!--                                                 		  <h4>可爱的挂链</h4> -->
<!-- 														  <img src="images/pic6.jpg" width="55px" height="55px" alt="an image" class="image" /> -->
<!--                                                 		  <p>价格: ￥139</p> -->
<!-- 														  <p>速速抢购</p> -->
<!--                                                      </div> -->
<!--                                                 		</div>end cell -->
                                                	</div><!-- end row -->
													<div class="art-content-layout-row">
                                                		<div class="art-layout-cell">
                                                      <div class="overview-table-inner">
                                                	      <h4>保温水杯</h4>
                                                		  <img src="images/pic1.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                       </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>黑宝石手链</h4>
                                                		  <img src="images/pic2.jpg" width="55px" height="55px" alt="an image" class="image" />
														  <p>价格: ￥139</p>
														  <p>速速抢购</p>
												    </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>LV名牌包包</h4>
														  <img src="images/pic3.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>名牌夹克</h4>
														  <img src="images/pic4.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>大容量冰箱</h4>
														  <img src="images/pic5.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>可爱的挂链</h4>
														  <img src="images/pic6.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
                                                	</div><!-- end row -->
													<div class="art-content-layout-row">
                                                		<div class="art-layout-cell">
                                                      <div class="overview-table-inner">
                                                	      <h4>保温水杯</h4>
                                                		  <img src="images/pic1.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                       </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>黑宝石手链</h4>
                                                		  <img src="images/pic2.jpg" width="55px" height="55px" alt="an image" class="image" />
														  <p>价格: ￥139</p>
														  <p>速速抢购</p>
												    </div>
                                                		</div><!-- end cell -->
                                                		<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>LV名牌包包</h4>
														  <img src="images/pic3.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>名牌夹克</h4>
														  <img src="images/pic4.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>大容量冰箱</h4>
														  <img src="images/pic5.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
														<div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                		  <h4>可爱的挂链</h4>
														  <img src="images/pic6.jpg" width="55px" height="55px" alt="an image" class="image" />
                                                		  <p>价格: ￥139</p>
														  <p>速速抢购</p>
                                                     </div>
                                                		</div><!-- end cell -->
                                                	</div><!-- end row -->
                                                </div><!-- end table -->
                                                    
                                                <!-- /article-content -->
                                            </div>
                                            <div class="cleared"></div>
                            </div>
                            
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

