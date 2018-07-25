/**
 * @fileoverview test commonJs
 * author zmx2321@163.com
 * data 2018/7/20
 */

//工具方法模块
util = {
	/**
	 * [$ 标签选择器]
	 * @param  {[type]} selector [选择器]
	 * @param  {[type]} node     [dom节点]
	 * @return {[type]}          [$('selector')]
	 */
	$: (selector, node) => (node || document).querySelector(selector)
};