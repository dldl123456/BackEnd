package com.zhizuobiao.day3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhizuobiao.day3.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringTransTest {

	@Autowired
	@Qualifier("accountServiceImplTemplate")
	private AccountService accountServiceTemplate;

	@Resource(name = "accountServiceImplTx")
	private AccountService accountServiceTx;

	@Resource(name = "accountServiceImplAnno")
	private AccountService accountServiceAnno;

	@Test
	public void test1() { // 手动

		boolean result = accountServiceTemplate.transferAccount("A", "B", 500);
		System.out.println(result);
	}

	@Test
	public void test2() { // aop 自动
		boolean result = accountServiceTx.transferAccount("A", "B", 700);

		System.out.println(result);
	}

	@Test
	public void test3() { // 事物 注解
		boolean result = accountServiceAnno.transferAccount("A", "B", 200);

		System.out.println(result);
	}
}
