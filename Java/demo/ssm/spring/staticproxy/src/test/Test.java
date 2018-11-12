package test;

import dao.UserDao;
import dao.UserDaoImpl;
import po.User;
import proxy.UserProxy;

public class Test {
	public static void main(String[] args) {
		//如果没有代理可以直接访问目标对象
		/*UserDao userDaoImpl = new UserDaoImpl();
		User user = new User();
		
		userDaoImpl.addUser(user);*/
		
		//通过中间的代理类(UserProxy)来访问目标资源
		//通过代理对象委托，对象委托UserDao
		//通过代理类访问目标对象
		UserDao userDaoImpl = new UserDaoImpl();
		UserProxy userProxy = new UserProxy(userDaoImpl);
		User user = new User();
		
		userProxy.addUser(user);
		userProxy.deleteUser(user);
		
		//代理对象不能代理roleDao
		//静态代理，就是设计的时候写死了
		/*RoleDao roleDao = new RoleDaoImpl();
		UserProxy proxy = new UserProxy(roleDao);*/
	}
}
