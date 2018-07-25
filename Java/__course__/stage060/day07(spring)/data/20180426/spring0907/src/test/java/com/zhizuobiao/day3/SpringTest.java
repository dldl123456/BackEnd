package com.zhizuobiao.day3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhizuobiao.day3.dao.AccountDao;
import com.zhizuobiao.day3.entity.Account;
import com.zhizuobiao.day3.entity.User;
import com.zhizuobiao.day3.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringTest {

	@Autowired
	private UserService userService;

//	@Resource(name = "myProxyFactory")
//	private UserService userServiceProxy;

	@Resource
	private AccountDao accountDao;

	@Test
	public void demo1() {
		User user = new User();
		user.setId(99);
		user.setName("aoptest");
		int code = userService.insertUser(user);
		System.out.println(code);
	}

	/**
	 * 测试注解配置aop
	 */
	@Test
	public void demo2() {
		User user = userService.getUser(1);
		System.out.println(user);
	}

	/**
	 * 代理工厂aop
	 */
	@Test
	public void demo3() {
//		int code = userServiceProxy.deleteUser(1);
//		System.out.println(code);
//		userServiceProxy.getUser(1);
	}

	/**
	 * 测试springtemplate
	 */
	@Test
	public void demo4() {
		Account ac = new Account();
		ac.setAmount(9000);
		ac.setName("xiaowang");

		accountDao.insertAccount(ac);
	}
}
