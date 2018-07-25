package com.zhizuobiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhizuobiao.dao.OrderDao;
import com.zhizuobiao.entity.Orders;
import com.zhizuobiao.entity.OrdersUserCustom;

/**
 * 测试动态接口绑定
 */
public class OrderDaoTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 数据库会话实例
	private SqlSession sqlSession;

	@Before
	public void createSqlSessionFactory() throws IOException {
		// 配置文件
		String resource = "mybatis-config.xml";
		// 读取配置文件，转换成输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建数据库会话实例sqlSession
		sqlSession = sqlSessionFactory.openSession();

	}

	@After
	public void destory() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void testGetOrdersUserCustomList() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 调用代理对象方法
		List<OrdersUserCustom> orderList = orderDao.getOrdersUserCustomList();
		System.out.println(orderList.size());

		orderList.forEach((OrdersUserCustom order) -> {
			System.out.println(order);
			System.out.println(order.getUsername());
		});
	}
	

	@Test
	public void testGetOrdersList() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 调用代理对象方法
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order);
		});
	}
	
	@Test
	public void testGetOrdersDetailList() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 调用代理对象方法
		List<Orders> orderList = orderDao.getOrdersDetailList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order);
		});
	}


}
