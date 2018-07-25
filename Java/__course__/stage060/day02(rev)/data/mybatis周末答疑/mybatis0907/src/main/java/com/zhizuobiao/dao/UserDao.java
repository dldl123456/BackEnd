package com.zhizuobiao.dao;

import java.util.List;

import com.zhizuobiao.entity.User;

//dao��̬�ӿڿ���
//������daoʵ�����ǿ�ܰ������Զ�����
//
//eg: 	
//<select id="getUserList2" parameterType="string"
//	resultType="com.zhizuobiao.entity.User">
//	select * from user where username like "${value}%"
//</select>
//
//��������������
//1.�ӿ�����mapper�ļ��еı�ǩ��id
//2.�������ͣ��ӿڵ��β�Ҫ�ͱ�ǩ�Ĳ�������һ��
//3.���ؽ�����ӿڵķ��ؽ��Ҫ�ͱ�ǩ�ķ��ؽ���ġ����͡�һ��
//4.�����ռ䣺�ӿڵ�ȫ����������+������

public interface UserDao {

	int insertUser(User user);

	// ����˵������
	// int insert(User user);
	// int insert(Order order);

	// mybatis����ӳ���ļ�--> mapper.xml
	// user.xml
	// order.xml
	// order.xml,user.xml -> ͬ����insert��ǩ
	// sqlsession.insert() --> �����ĸ���
	// Ҫ�и��취���ֲ�ͬ��dao��ͬ���ķ���
	// �ӿڵ�ȫ����������+������
	// com.zhizuobiao.dao.UserDao -> insert
	// com.zhizuobiao.dao.OrderDao -> insert

	int updateUser(User user);

	int deleteUser(int id);

	User getUser(int id);

	List<User> getUserList();
}
