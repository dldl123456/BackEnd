package com.demo.dao;

import org.springframework.stereotype.Component;

import com.demo.bean.User;


//@Component(value="userDaoImpl")  //bean的组件（用注解实例化）
//加了这个标识说明给UserDaoImpl实例化了(取个名)
//不写名字默认（userDaoImpl）
/*
 *  Spring的框架中提供了与@Component注解等效的三个注解
 *  @Repository(仓库)用于对Dao实现类进行标注
 *  @Service用于对Service实现类进行标注
 *  @Controller用于对Controller实现类进行标注
 */


/*
 * 	private UserDao userDao
 *  @Autowired
	@Qualifier(value="userDao")
	
	等价于
	
	private UserDao userDao
	@Resource(name="userDao")
 */


@Component(value="userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		System.out.println("UserDao的实现");
	}

}
