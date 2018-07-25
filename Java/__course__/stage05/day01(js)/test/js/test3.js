/**
 * @fileoverview num Opation
 *
 * 现有一个数字为1539，使用"/"与"%"运算符获取该数字各个位数上的数字
 * 将各个位上的数字求和
 *
 * 使用parseInt()函数转为整数
 *
 * 数字1539的个位数字：9
 * 十位数字：3
 * 百位数字：5
 * 千位数字：1
 * 总和为：18
 * 
 * author zmx2321@163.com
 * data 2018/7/20
 */

//名字空间模块
let app = {
	test3: {}
};

//工具方法模块
app.test3 = {
	/**
	 * [intFun 四位数数字拆分]
	 * @param  {[type]} num [数字]
	 * @return {[type]}     [num]
	 */
	intFun: function(num) {
		numArr = new Array();
		let sum = 0;

		numArr[0] = parseInt(num / 1000);  //千位
		numArr[1] = parseInt(num / 100 % 10);  //百位
		numArr[2] = parseInt(num / 10 % 10);  //十位
		numArr[3] = parseInt(num % 10);  //个位
		
		for(var i=0; i<numArr.length; i++){
			sum += numArr[i];
		}

		numArr[4] = sum;

		return numArr;
	}
};

//应用代码，立即执行函数
!function(test3){
	let $ = util.$;
	let intFun = test3.intFun;

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		let num = 1539;
		numArr = new Array();
		numArr = intFun(num);

		$(".box").innerHTML = `
			<span class="f-fs2 span_t3">拆分：${num}</span>
			<ul>
				<li>千位：${numArr[0]}</li>
				<li>百位：${numArr[1]}</li>
				<li>十位：${numArr[2]}</li>
				<li>个位：${numArr[3]}</li>
				<li>总和：${numArr[4]}</li>
			</ul>
		`;
	});
}(app.test3);
