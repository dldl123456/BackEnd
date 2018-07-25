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
 * ���Զ�̬�ӿڰ�
 */
public class OrderDaoTest {

	// �Ự����
	private SqlSessionFactory sqlSessionFactory;

	// ���ݿ�Ựʵ��
	private SqlSession sqlSession;

	@Before
	public void createSqlSessionFactory() throws IOException {
		// �����ļ�
		String resource = "mybatis-config.xml";
		// ��ȡ�����ļ���ת����������
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// �������ݿ�Ựʵ��sqlSession
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

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ���ô�����󷽷�
		List<OrdersUserCustom> orderList = orderDao.getOrdersUserCustomList();
		System.out.println(orderList.size());

		orderList.forEach((OrdersUserCustom order) -> {
			System.out.println(order);
			System.out.println(order.getUsername());
		});
	}
	

	@Test
	public void testGetOrdersList() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ���ô�����󷽷�
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order);
		});
	}
	
	@Test
	public void testGetOrdersDetailList() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ���ô�����󷽷�
		List<Orders> orderList = orderDao.getOrdersDetailList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order);
		});
	}


}
