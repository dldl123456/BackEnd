package com.iotek.view;

import com.iotek.entity.Student;
import com.iotek.service.StudentBiz;
import com.iotek.service.impl.StudentBizImpl;
import com.iotek.util.Util;

/**
 * 功能页面
 * @author Administrator
 *
 */
public class StudentView {
	
	private StudentBiz stuBiz;
	public StudentView() {
		stuBiz = new StudentBizImpl();
	}

	/**
	 * 注册的方法
	 */

	public void regist() {
		while (true) {
			// 注册时要先去判断用户名是否存在
			String name = Util.getString("请输入你要输入的用户名:");
			if (stuBiz.isExistName(name)) {
				System.out.println("你输入的用户名已经存在,请换一个进行注册");
			} else {
				// 不存在则可以输入密码,, 往数据库里面插入语这条数据
				String psw = Util.getString("请输入密码:");
				// 创建一个带有用户名和密码的学生对象
				Student student = new Student(name, psw);
				if (stuBiz.addStudent(student) != 0) {
					System.out.println("ok ..注册成功.....");

					break;
				} else {
					System.out.println("sorry,失败");
				}

			}
		}

	}

	/**
	 * 根据用户名和密码进行登录
	 */
	public void login() {
		while (true) {

			String name = Util.getString("请输入要登录的用户名:");
			if (stuBiz.isExistName(name)) {
				boolean flag =true;
				// ok 输入密码
				while (flag  ) {
					String psw = Util.getString("请输入密码:");
					if (stuBiz.judgeNameAndPsw(name, psw) ) {
						System.out.println("登录成功!");
						flag  = false;//
					}else{
						System.out.println("密码输入错误请重新输入..");
					}
					
				}

				break;
			} else {
				System.out.println("用户名不存在,请检查");
			}
		}
	}

}
