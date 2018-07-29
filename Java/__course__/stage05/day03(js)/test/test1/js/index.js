/**
 * 使用正则表达式制作表单验证
 * 用户名 ==> 用户名长度为6-16位
 * Email ==> web@suhu.com
 * 手机号 ==> 手机号码
 * 登陆密码 ==> 用户名长度为6-16位
 * 密码确认 ==> 密码不能含有非法字符，长度在4-10之间
 */

//应用代码，立即执行函数
!function(){
	let $ = util.$;
	
	let addClass = util.addClass;
	let removeClass = util.removeClass;

	/**
	 * [checkForm 验证]
	 * @param  {[type]} test_reg [验证正则]
	 * @param  {[type]} id       [验证id]
	 * @param  {[type]} txt_err  [错误提示]
	 * @param  {[type]} txt_succ [正确提示]
	 * @return {[type]}          [description]
	 */
	let checkForm = function(test_reg, id, txt_err, txt_succ){
		id.onblur = function(){
			var wrapNode = this.parentNode;  //父节点
			var nextNode = this.nextSibling.nextElementSibling;  //下一个兄弟节点

			if(!test_reg.test(this.value)){
				removeClass(wrapNode, 'success');
				addClass(wrapNode, 'error');
				nextNode.innerHTML = txt_err;
			}else{
				removeClass(wrapNode, 'error');
				addClass(wrapNode, 'success');
				nextNode.innerHTML = txt_succ;
			}
		}

		id.onfocus = function(){
			this.value = "";
		}
	}

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		let usernameReg = /^[\w]{6,12}$/g,	//用户名长度为6-16位
			telphoneReg = /^1[358][0-9]{9}$/g;	//11位有效手机号码

		//验证
		checkForm(usernameReg, $('#username'), "用户名长度为6-16位", "用户名正确");
		checkForm(telphoneReg, $('#telphone'), "手机号码不正确", "手机号码正确");
	});
}();