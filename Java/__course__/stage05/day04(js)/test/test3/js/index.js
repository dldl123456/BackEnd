/**
 * 点击页面中的“开始”按钮在页面中的数字开始倒数十秒，点击“停止”按钮或倒数为0时弹出“倒计时结束”的提示框
 */

//时间
var timeoption = function(){
	var timer = null;
	var num = $('.time_wrap').text();

	//开始
	$('#start').click(function(){
		var count = 10;

		function attrnum(){
			if(count > 0){
				num --;
				count --;

				$('.time_wrap').text(num);
			}

			if(count <= 0){
				clearInterval(timer);
			}
		}

		timer = setInterval(attrnum, 1000);
	});

	//结束
	$('#stop').click(function(){
		clearInterval(timer);
	});
}

//load
$(function(){
	timeoption();  //时间
});