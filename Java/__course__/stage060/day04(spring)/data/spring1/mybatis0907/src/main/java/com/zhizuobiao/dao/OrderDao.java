package com.zhizuobiao.dao;

import java.util.List;

import com.zhizuobiao.entity.Orders;
import com.zhizuobiao.entity.OrdersUserCustom;

/**
 * ����˵�� ��ͬ�ӿڵ������ռ�����
 */
public interface OrderDao {

	// ���󣺻�ȡ���ж�����ͬʱ����ѯ�������û���Ϣ
	List<OrdersUserCustom> getOrdersUserCustomList();

	// Orders --> [����ID������״̬��*�û�*]
	List<Orders> getOrdersList();

	// Orders --> [����ID������״̬��*�û�*��*��������*]
	List<Orders> getOrdersDetailList();
	
	// Orders --> [����ID������״̬��*�û�*] ������
	List<Orders> getOrdersLazyList();
	
	
	
}
