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

	@Test
	public void tesgGetOrdersLazyList() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 调用代理对象方法
		List<Orders> orderList = orderDao.getOrdersLazyList();
		System.out.println(orderList.size());

		orderList.forEach((Orders order) -> {
			System.out.println(order.getId());
			System.out.println(order.getState());
			System.out.println(order.getCreateTime());
			System.out.println(order.getUser());
		});

	}

	// 测试一级缓存
	@Test
	public void testSqlSession() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 第一次，从数据库获取
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println("第一次：" + orderList.size());
		
		// 关闭sqlSession，清空一级缓存
//		sqlSession.close();
		// 事务提交，也会清空一级缓存
		sqlSession.commit();
		
		System.out.println("数据从数据库获取成功！！！");
		System.out.println("================分隔符===================");
		
		// 再次开启sqlSession
//		sqlSession = sqlSessionFactory.openSession();
//		orderDao = sqlSession.getMapper(OrderDao.class);
		
		orderList = orderDao.getOrdersList();
		System.out.println("第二次：" + orderList.size());
	}

	// 测试二级缓存
	@Test
	public void testCacheEnabled() throws Exception {

		// 获取mapper接口的代理对象
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		// 第一次，从数据库获取
		List<Orders> orderList = orderDao.getOrdersList();
		System.out.println("第一次：" + orderList.size());
		
		// 关闭sqlSession，清空一级缓存
		sqlSession.close();
		
		System.out.println("数据从数据库获取成功！！！");
		System.out.println("================分隔符===================");
		// 二级缓存
		// 1.把List<Orders> orderList对象，保存在本地磁盘中，
		// 2.对象需要实现序列化，否则会报错。
		// 3.下次从本地磁盘中读取数据返回		
		
		// 再次开启sqlSession
		sqlSession = sqlSessionFactory.openSession();
		orderDao = sqlSession.getMapper(OrderDao.class);
		
		orderList = orderDao.getOrdersList();
		System.out.println("第二次：" + orderList.size());
	}
}
