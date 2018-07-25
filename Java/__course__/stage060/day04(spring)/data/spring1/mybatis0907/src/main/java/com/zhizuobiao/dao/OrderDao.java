package com.zhizuobiao.dao;

import java.util.List;

import com.zhizuobiao.entity.Orders;
import com.zhizuobiao.entity.OrdersUserCustom;

/**
 * 举例说明 不同接口的命名空间问题
 */
public interface OrderDao {

	// 需求：获取所有订单的同时，查询关联得用户信息
	List<OrdersUserCustom> getOrdersUserCustomList();

	// Orders --> [订单ID、订单状态、*用户*]
	List<Orders> getOrdersList();

	// Orders --> [订单ID、订单状态、*用户*、*订单详情*]
	List<Orders> getOrdersDetailList();
	
	// Orders --> [订单ID、订单状态、*用户*] 懒加载
	List<Orders> getOrdersLazyList();
	
	
	
}
