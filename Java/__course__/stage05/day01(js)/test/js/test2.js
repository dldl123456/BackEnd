/**
 * @fileoverview String Opation
 * 写一个实现字符串首字母大写的函数；
 * author zmx2321@163.com
 * data 2018/7/20
 */

//名字空间模块
let app = {
	test2: {}
};

//工具方法模块
app.test2 = {
	/**
	 * [upperCase 字符串首字母大写]
	 * 截取第一个位置变成大写，然后从第一个位置截取所有
	 * @param  {[type]} str [字符串]
	 * @return {[type]}     [str]
	 */
	upperCase: str => 
		str.charAt(0).toUpperCase() + str.substring(1)
};

//应用代码，立即执行函数
!function(test2){
	let $ = util.$;
	let upperCase = test2.upperCase;

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		let str = "hjuhio";
		str = upperCase(str);

		$(".box span").innerHTML = str;
	});
}(app.test2);