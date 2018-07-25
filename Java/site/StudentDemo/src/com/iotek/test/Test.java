package com.iotek.test;
import com.iotek.view.MainMune;

/**
 *  学生的管理系统, 
 *  实现学生登录和注册 
 *  登录 -- 从数据库中取出数据,,判断用户名和密码是否正确 
 *  注册-- 非重的判断
 *  
 * mvc 模式
 * m --model 模型对象    实体层 
 * 底层的实现 dao -- daoimplement 
 * v -- view 视图层
 * c -controller 控制层  逻辑处理层
 */
public class Test {
	public static void main(String[] args) {
		new MainMune().mune();
	}

}
