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

		// ������ʽ(�����ڵ��߼�)
		// UserDaoImpl dao = new UserDaoImpl();
		// User user = dao.getUser(12);
		// System.out.println(user);

		
		
		// mapper.xml ����涨������
		// <select id="getUser" parameterType="int"
		// resultType="com.zhizuobiao.entity.User">
		// select *
		// from user where id = #{id}
		// </select>

		// ------------------------------------------------------------------------
		// ͨ��mapper�ļ��У�ָ���Ľӿ��з���������
		String methodName = "getUser";

		// ����ķ�ʽ�������ڵ��߼���
		Class<?> userDaoImplClass = Class.forName("com.zhizuobiao.dao.impl.UserDaoImpl");
		// ����class�Ķ���
		Object daoObj = userDaoImplClass.newInstance();

		System.out.println(userDaoImplClass);
		// Ŀ�ģ�����getUser����
		// ����Ҫ��ȡ������getUser��
		Method getUserMethod = userDaoImplClass.getMethod(methodName, int.class);

		// �����࣬��Ҫ������ͷ���������
		User user2 = (User) getUserMethod.invoke(daoObj, 12);
		System.out.println("testReflec = " + user2);
		// ------------------------------------------------------------------------

		// ��ȡmapper�ӿڵĴ������
		// UserDao userDao = sqlSession.getMapper(UserDao.class);
		// sqlSession.getMapper(UserDao.class); --> ?????
		
		// ASM ��һ�� Java �ֽ�����ݿ�ܡ�������ֱ���Զ�������ʽ��̬������ stub ������������࣬������װ��ʱ��̬���޸��ࡣ
	}
}
