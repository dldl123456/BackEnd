/**
 *1：验证：用户名输入的字符串长度为8  不能只输入小黄
 *2：验证：密码不可为空
 *3：验证：密码只能输入数字
 *4：验证：两次密码是否相同 （1234 提示信息在控件后方或者下方显示）
 *5.性别：请默认选中男
 *6.爱好：请默认选中逛街
 *7：注册按钮点击事件  显示当前输入的所有信息（7提示信息弹出框显示）
 */

//表单验证
var checkForm = function(){
	var usernameReg = /[^(小黄)](.){8}/g,	//用户名
		passwordReg = /^\d+$/g,	//密码
		birthReg = /^(\d{2}|\d{4})-((0([1-9]{1}))|(1[1|2]))-(([0-2]([1-9]{1}))|(3[0|1]))$/g;	//生日(年-月-日)

	function checkLogin(id, reg){
		id.blur(function(){
			var wrapNode = $(this).parent();
			var txt = $(this).attr('placeholder').substring(3);

			if(reg.test($(this).val())){
				wrapNode.removeClass('error').addClass('success');
				wrapNode.find('span.info').html(txt + "输入正确");
			}else{
				wrapNode.removeClass('success').addClass('error');
				wrapNode.find('span.info').html(txt + "错误");
			}
		});

		id.focus(function(){
			$(this).val('');
		});
	}

	//用户姓名
	checkLogin($('#username'), usernameReg);
	//密码
	checkLogin($('#password'), passwordReg);
	//生日
	checkLogin($('#birth'), birthReg);

	$('#r-password').blur(function(){
		var wrapNode = $(this).parent();

		function succ(txt){
			wrapNode.removeClass('error').addClass('success');
			wrapNode.find('span.info').html(txt);
		}

		function err(txt){
			wrapNode.removeClass('success').addClass('error');
			wrapNode.find('span.info').html(txt);
		}

		if($(this).val() == ""){
			err("输入不能为空");
		}
		
		if($(this).val() != $('#password').val()){
			err("两次密码输入不一致");
		}

		if(($(this).val() != "") && ($(this).val() == $('#password').val())){
			succ("密码验证通过");
		}
	})

	subform();  //提交表单
}

//提交表单
var subform = function(){
	$('#userInfoBtn').click(function(){
		var serializeUrl = $('#userInfo').serialize();  //将该表单序列化
		alert(serializeUrl);
	});
}

//load
$(function(){
	checkForm();  //表单验证
});