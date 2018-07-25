package com.zhizuobiao.other;

public class Test {

	public static void main(String[] args) {

		Item mainItem = null;

		// 创建订单
		Order order = new Order();
		order.setDesc("订单描述");
		order.setId(1);

		// mainItem = 订单对象内的商品
		mainItem = order.getItem();
		
		// 订单对象清空
		order = null;
		
		// 输出mainItem
		System.out.println(mainItem);
		
		// Order对象 才能被垃圾回收
		mainItem = null;
	}
}
