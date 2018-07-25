package com.zhizuobiao.class1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhizuobiao.class2.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringJunitTest {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;

	@Test
	public void demo1() {
		System.out.println(userDao);
	}

	@Test
	public void demo2() {
		orderDao.delete("demo");
	}
	
	@Test
	public void demo3() {
		orderDao.update("demo2");
	}
}
