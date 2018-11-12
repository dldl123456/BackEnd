package test;

import dao.RoleDao;
import dao.RoleDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import po.Role;
import po.User;
import proxy.UserProxy;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		Role role = new Role();
		
		UserDao userDaoImpl = new UserDaoImpl();
		RoleDao RoleDaoImpl = new RoleDaoImpl();
		
		//new一个代理对象，传进去一个委托类
		UserProxy userProxy = new UserProxy(userDaoImpl);
		//获得一个代理对象（上面传什么类，就代理什么）
		UserDao userDao = (UserDao) userProxy.getProxyInstance();
		
		userDao.addUser(user);
		
		
		UserProxy RoleProxy = new UserProxy(RoleDaoImpl);
		RoleDao roleDao = (RoleDao) RoleProxy.getProxyInstance();
		
		roleDao.addRole(role);
	}
}
