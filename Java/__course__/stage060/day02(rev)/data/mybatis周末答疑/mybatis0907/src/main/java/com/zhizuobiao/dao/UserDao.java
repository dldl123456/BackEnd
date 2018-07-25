package com.zhizuobiao.dao;

import java.util.List;

import com.zhizuobiao.entity.User;

//dao动态接口开发
//条件：dao实现类是框架帮我们自动生成
//
//eg: 	
//<select id="getUserList2" parameterType="string"
//	resultType="com.zhizuobiao.entity.User">
//	select * from user where username like "${value}%"
//</select>
//
//满足如下条件：
//1.接口名是mapper文件中的标签的id
//2.参数类型？接口的形参要和标签的参数类型一致
//3.返回结果？接口的返回结果要和标签的返回结果的【类型】一致
//4.命名空间：接口的全类名（包名+类名）

public interface UserDao {

	int insertUser(User user);

	// 举例说明问题
	// int insert(User user);
	// int insert(Order order);

	// mybatis加载映射文件--> mapper.xml
	// user.xml
	// order.xml
	// order.xml,user.xml -> 同名的insert标签
	// sqlsession.insert() --> 调用哪个？
	// 要有个办法区分不同的dao，同名的方法
	// 接口的全类名（包名+类名）
	// com.zhizuobiao.dao.UserDao -> insert
	// com.zhizuobiao.dao.OrderDao -> insert

	int updateUser(User user);

	int deleteUser(int id);

	User getUser(int id);

	List<User> getUserList();
}
