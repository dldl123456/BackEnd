var margin = 10;	//间距
var li = $('#picList li');	//获得地是一个数据 集合
var li_W = li[0].offsetWidth + margin;

function PuBu(n){	//n代表一行有多少张图片
	var h = [];	//记录每个li的高度

	var n = n;	//第一个n就是一个变量接受或者保存第二个n的值

	for(var i= 0; i<li.length; i++){
		var li_H = li[i].offsetHeight;

		if(i < n){	//n表示一行放多少li
			h[i] = li_H;
			li.eq(i).css("top", 0);
			li.eq(i).css("left", li_W*i);
		} else {
			var min_H = Math.min.apply(null, h);	//Math.min(1,3,5,7),找到h数组中值最小的那个值
			var minKey = getArrayKey(h, min_H);

			h[minKey] += li_H + margin;
			li.eq(i).css('top', min_H + margin);
			li.eq(i).css('left', minKey*li_W);
		}
	}

}

function getArrayKey(s, v){	//得到数组中与值相对的键（下标）
	for(var k in s){
		if(s[k] == v){
			return k;
		}
	}
}

window.onload = function(){
	PuBu(5);
}