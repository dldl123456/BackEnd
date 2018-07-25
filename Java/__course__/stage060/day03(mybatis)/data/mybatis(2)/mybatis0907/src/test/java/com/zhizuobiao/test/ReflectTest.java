package com.zhizuobiao.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.dao.impl.UserDaoImpl;
import com.zhizuobiao.entity.User;

public class ReflectTest {

	@Test
	public void testReflec() throws Exception {

		// 正常方式(编译期的逻辑)
		// UserDaoImpl dao = new UserDaoImpl();
		// User user = dao.getUser(12);
		// System.out.println(user);

		
		
		// mapper.xml 里面规定的内容
		// <select id="getUser" parameterType="int"
		// resultType="com.zhizuobiao.entity.User">
		// select *
		// from user where id = #{id}
		// </select>

		// ------------------------------------------------------------------------
		// 通过mapper文件中，指定的接口中方法的名字
		String methodName = "getUser";

		// 反射的方式（运行期的逻辑）
		Class<?> userDaoImplClass = Class.forName("com.zhizuobiao.dao.impl.UserDaoImpl");
		// 创建class的对象
		Object daoObj = userDaoImplClass.newInstance();

		System.out.println(userDaoImplClass);
		// 目的：调用getUser方法
		// 首先要获取方法（getUser）
		Method getUserMethod = userDaoImplClass.getMethod(methodName, int.class);

		// 调用类，需要【对象和方法参数】
		User user2 = (User) getUserMethod.invoke(daoObj, 12);
		System.out.println("testReflec = " + user2);
		// ------------------------------------------------------------------------

		// 获取mapper接口的代理对象
		// UserDao userDao = sqlSession.getMapper(UserDao.class);
		// sqlSession.getMapper(UserDao.class); --> ?????
		
		// ASM 是一个 Java 字节码操纵框架。它可以直接以二进制形式动态地生成 stub 类或其他代理类，或者在装载时动态地修改类。
	}
}
