/**
 * 6-30位字母、数字或"_",字母开头
 * 密码长度不能少于6个字符
 * 确认密码与原密码不同
 */

var checkForm = function(){
	function check(reg, id, txt){
		id.blur(function(){
			var wrapNode = $(this).parent().parent();

			if(reg.test($(this).val())){
				wrapNode.removeClass('error').addClass('success');
				wrapNode.find('dd:last').html(txt);
			}else{
				wrapNode.removeClass('success').addClass('error');
				$(this).parent().parent().find('dd:last').html(txt);
			}
		
		});

		id.focus(function(){
			$(this).val('');
		});
	}

	//正则
	var usernameReg = /^[a-zA-Z]([\w]{6,30})$/g,
		passwordReg = /.{6,}/g;

	//验证
	check(usernameReg, $('#username'), "6-30位字母、数字或\"_\",字母开头");
	check(passwordReg, $('#password'), "密码长度不能少于6个字符");
	
	$('#r-password').blur(function(){
		var wrapNode = $(this).parent().parent();

		function succ(txt){
			wrapNode.removeClass('error').addClass('success');
			wrapNode.find('dd:last').html(txt);
		}

		function err(txt){
			wrapNode.removeClass('success').addClass('error');
			wrapNode.find('dd:last').html(txt);
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
}

$(function(){
	checkForm();
});