/**
 * @fileoverview num Opation
 * 使用for循环求100以内的质数（只能整除1和自身的数是质数），以及求质数的和
 * author zmx2321@163.com
 * data 2018/7/20
 */

//名字空间模块
let app = {
	test4: {}
};

//工具方法模块
app.test4 = {
	//求100以内的质数，以及求质数的和
	primeNumber: function(){
		primeArr = new Array();
		let sum = 0;

	    for (let i = 2; i < 100; i++){
	        for (j = 2; j*j <= i; j++){
	            if (i%j == 0){
	            	break;
	            }
	        }
	        
	        if(j*j > i){
	        	primeArr.push(i);
	            sum += i;
	        }
	    }

	    primeArr.push(sum);

		return primeArr;
	}
};

//应用代码，立即执行函数
!function(test4){
	let $ = util.$;
	let primeNumber = test4.primeNumber;

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		primeArr = new Array();
		primeArr = primeNumber();
		let primeSum = primeArr.pop();

	$(".box").innerHTML = `
		<ul>
			<li>
				<dl>
					<dt>100以内的质数为：</dt>
					<dd>${primeArr}</dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>100以内的质数和为：</dt>
					<dd>${primeSum}</dd>
				</dl>
			</li>
		</ul>
	`;
	});
}(app.test4);