package com.zhizuobiao.other;

public class Test {

	public static void main(String[] args) {

		Item mainItem = null;

		// ��������
		Order order = new Order();
		order.setDesc("��������");
		order.setId(1);

		// mainItem = ���������ڵ���Ʒ
		mainItem = order.getItem();
		
		// �����������
		order = null;
		
		// ���mainItem
		System.out.println(mainItem);
		
		// Order���� ���ܱ���������
		mainItem = null;
	}
}
