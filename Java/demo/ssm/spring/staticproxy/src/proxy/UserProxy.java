/*
 * 代理类（实现代理接口）
 * 通过代理类访问目标
 */

package proxy;

import dao.UserDao;
import po.User;

public class UserProxy implements UserDao {
	//只能代理这个委托类
	private UserDao userDaoImpl;  //代理类代理userDao的实现

	//构造方法
	public UserProxy() {}
	
	public UserProxy(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
	@Override
	public void addUser(User user) {
		//如果每个方法前都加，维护麻烦
		check();  //横向的动态插入代码块
		System.out.println("add User...");
		userDaoImpl.addUser(user);
		printLog();
	}
	
	@Override
	public void deleteUser(User user) {
		check();
		System.out.println("delete User...");
		userDaoImpl.deleteUser(user);
		printLog();
	}
	
	//切片代码（横向的动态插入代码块）
	//打印日志
	public void printLog(){
		System.out.println("打印日志");
	}
	
	//检察权限
	public void check(){
		System.out.println("检查权限");
	}
}
