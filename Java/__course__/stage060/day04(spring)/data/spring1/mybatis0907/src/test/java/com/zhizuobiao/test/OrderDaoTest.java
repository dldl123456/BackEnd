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

	@Test
	public void tesgGetOrdersLazyList() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ���ô�����󷽷�
		List<Orders> orderList = orderDao.getOrdersLazyList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order.getId());
			System.out.println(order.getState());
			System.out.println(order.getCreateTime());
			System.out.println(order.getUser());
		});

	}

	// ����һ������
	@Test
	public void testSqlSession() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ��һ�Σ������ݿ��ȡ
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println("��һ�Σ�" + orderList.size());
		
		// �ر�sqlSession�����һ������
//		sqlSession.close();
		// �����ύ��Ҳ�����һ������
		sqlSession.commit();
		
		System.out.println("���ݴ����ݿ��ȡ�ɹ�������");
		System.out.println("================�ָ���===================");
		
		// �ٴο���sqlSession
//		sqlSession = sqlSessionFactory.openSession();
//		orderDao = sqlSession.getMapper(OrderDao.class);
		
		orderList = orderDao.getOrdersList();
		System.out.println("�ڶ��Σ�" + orderList.size());
	}

	// ���Զ�������
	@Test
	public void testCacheEnabled() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// ��һ�Σ������ݿ��ȡ
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println("��һ�Σ�" + orderList.size());
		
		// �ر�sqlSession�����һ������
		sqlSession.close();
		
		System.out.println("���ݴ����ݿ��ȡ�ɹ�������");
		System.out.println("================�ָ���===================");
		// ��������
		// 1.��List<Orders> orderList���󣬱����ڱ��ش����У�
		// 2.������Ҫʵ�����л�������ᱨ��
		// 3.�´δӱ��ش����ж�ȡ���ݷ���		
		
		// �ٴο���sqlSession
		sqlSession = sqlSessionFactory.openSession();
		orderDao = sqlSession.getMapper(OrderDao.class);
		
		orderList = orderDao.getOrdersList();
		System.out.println("�ڶ��Σ�" + orderList.size());
	}
}
