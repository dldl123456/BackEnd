/*
 * 动态代理(实现InvocationHandler接口)
 * 代理类（实现代理接口）
 * 通过代理类访问目标
 */

package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {
	//可以代理任意的委托对象
	private Object object;
	
	public UserProxy() {}

	public UserProxy(Object object) {
		this.object = object;
	}

	//创建代理对象
	//返回一个代理对象
	public Object getProxyInstance(){
		//传一个委托类的类加载器
		//loder是类加载器
		//代理委托类（是哪个委托）委托类里面的所有接口
		//代理类的实例(当前代理对象)
		//类加载器、接口、当前代理对象（反射）
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	//在代理实例上处理方法，并调用返回结果
	//invoke(委托类)
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName());
		
		check();
		
		//拿到委托类中所有的东西
		//反射中的动态调用
		Object obj = method.invoke(object, args);
		
		printLog();
		
		return obj;
	}
	
	//打印日志
	public void printLog(){
		System.out.println("打印日志");
	}
	
	//检察权限
	public void check(){
		System.out.println("检查权限");
	}

}
