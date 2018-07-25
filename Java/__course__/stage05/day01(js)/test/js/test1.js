/**
 * @fileoverview String Opation
 * 写一个函数，实现去除字符串左右空格；
 * author zmx2321@163.com
 * data 2018/7/20
 */

//名字空间模块
var app = {
	test1: {}
};

//工具方法模块
app.test1 = {
	/**
	 * [strFun 去除字符串左右空格]
	 * @param  {[type]} String str [字符串]
	 *  ^   ==> 匹配的首字符
	 *  \s  ==> 匹配一个单个white空格符，包括空格，tab，form feed，换行符，等价于[ \f\n\r\t\v]
	 *  *   ==> 表示前面出现的字符(\s)出现0到任意次
	 *  x|y ==> 匹配 x 或 y
	 *  $   ==> 匹配的末尾字符
	 * @return {[type]} [str]
	 */
	strFun: str => str.replace(/(^\s*)|(\s*$)/g, "")
};

//应用代码，立即执行函数
!function(test1){
	let $ = util.$;
	let strFun = test1.strFun;

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		let strOld = " 123456asdcas   ";
		str = strFun(strOld);

		$(".box").innerHTML = `
			<ul>
				<li>原字符串：<b>${strOld}</b></li>
				<li>新字符串：<b>${str}</b></li>
			</ul>
		`;
	});
}(app.test1);