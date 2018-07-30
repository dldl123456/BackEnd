//全选
var checkAll = function(){
	selist = $('[name=items]:checkbox');

	$('#selAll').change(function(){
		if($(this).is(':checked')){
			selist.attr('checked', true);
		}else{
			selist.attr('checked', false);
		}
	});
}

//删除当前
var del = function(){
	$('.del').click(function(){
		var wrapNode = $(this).parent().parent().parent();

		$(wrapNode).remove();

		total();
	});
}

//删除选中
var delAll = function(){
	$('#delAll').click(function(){
		var selist = $('[name=items]:checkbox:checked');
		var wrapNode = selist.parent().parent().parent();
		
		$(wrapNode).remove();

		total();
	});
}

//数量
var opstionNum = function(){
	//减
	$('.reduce').click(function(){
		var numNode = $(this).next();
		var num = $(this).next().text();
		var wrapNode = $(this).parent().parent().parent();

		var unitPrice = wrapNode.find('.unit_price').text().substring(1);
		var totalPrice = 0;

		num --;
		numNode.html(num);

		if(num < 0){
			var info = confirm("数量不得小于0；是否在订单中删除该产品");
			if(info == true){
				wrapNode.remove();
			}else{
				numNode.html("0");
			}
		}

		totalPrice = unitPrice * num;
		wrapNode.find('.total_price').html("$" + totalPrice);

		total();
	});

	//加
	$('.plus').click(function(){
		var num = $(this).prev().text();
		var wrapNode = $(this).parent().parent().parent();

		var unitPrice = wrapNode.find('.unit_price').text().substring(1);
		var totalPrice = 0;
		
		num ++;
		$(this).prev().html(num);

		totalPrice = unitPrice * num;
		wrapNode.find('.total_price').html("$" + totalPrice);

		total();
	});
}

//总数
var total = function(){
	var sum = 0;
	$('.pudlist').each(function(i, e){
		totalNum = $(e).find('.total_price').text().substring(1);
		sum += +totalNum;  //+表示把 字符串的数字转换为 number的数字
	});

	$('#total').html("$" + sum);
}

//增加一行
var addRow = function(){
	$('#addRow').click(function(){
		var str = `
			<div class="pudlist">
				<ul class="flex_list">
					<li>
						<input name="items" type="checkbox">
					</li>
					<li>
						<img src="images/pic1.jpg" alt="">
					</li>
					<li>
						<dl>
							<dd class="reduce">-</dd>
							<dd class="num">1</dd>
							<dd class="plus">+</dd>
						</dl>
					</li>
					<li>
						<span class="f-fwb f-fs2 unit_price">$2000</span>
					</li>
					<li>
						<span class="f-fwb f-fs2">植物活力</span>
					</li>
					<li>
						<span class="f-fwb f-fs2 total_price">$2000</span>
					</li>
					<li>
						<button class="del">删除</button>
					</li>
				</ul>
			</div>
		`;

		$('.cot_b').append(str);

		total();
	});
}

$(function() {
	total();  //总数
	checkAll();  //全选
	del();  //删除当前
	delAll();  //删除选中
	opstionNum();  //数量
	addRow();  //增加一行
});