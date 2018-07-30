/**
 * 新增加的行显示在表格的最后，删除该行功能
 * 商品名称  数量  价格  操作
 * 防滑真皮休闲鞋 12 ￥568.50 删除
 * 抗疲劳神奇钛项圈 2 ￥49 删除
 * …………
 * 增加订单
 */

!function(){
	let $ = util.$;
	
	let addClass = util.addClass;
	let removeClass = util.removeClass;

	//删除节点
	let removeNode = function(){
		let trs = document.querySelectorAll('tbody tr');

		for(let i=0; i<trs.length; i++){
			let btnNode = trs[i].lastElementChild.firstElementChild;

			btnNode.onclick = function(){
				if(btnNode.id == 'del'){
					trs[i].remove();
				}
			}
		}
	}

	//添加节点
	let addNode = function(){
		$('#add').onclick = function(){
			let newTr = document.createElement("tr");

			let str = `
				<td><input type="text" name="commodity" placeholder="商品名称" /></td>
				<td><input type="text" name="num" placeholder="数量" /></td>
				<td><input type="text" name="price" placeholder="价格" /></td>
				<td>
					<button id="confirm">确定</button>
				</td>
			`;

			newTr.innerHTML = str;

			$('tbody tr').before(newTr);

			$('#confirm').onclick = function(){
				let wrapNode = this.parentNode.parentNode;
				let commodity = wrapNode.getElementsByTagName("input")[0].value;
				let num = wrapNode.getElementsByTagName("input")[1].value;
				let price = wrapNode.getElementsByTagName("input")[2].value;

				wrapNode.innerHTML = `
					<td>${commodity}</td>
					<td>${num}</td>
					<td>${price}</td>
					<td>
						<button id="del">删除</button>
					</td>
				`;
			}

			//removeNode();  //删除节点
		}
	}

	//load
	document.addEventListener('DOMContentLoaded', function(e){
		removeNode();  //删除节点
		addNode();  //添加节点
	});
}();