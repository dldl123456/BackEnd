package com.zhizuobiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ����
 *
 */
public class Class5 {

	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User());

		demo4(list);
	}

	// ���Խ���UserDao���ͻ���UserDao�ĸ�����
	public static void demo5(List<? super UserDao> list) { //

	}

	// ���Խ���UserDao���ͺ�UserDao�������͡�
	public static void demo4(List<? extends UserDao> list) { //

	}

	public static void demo3() { //
		ResponseBody body = new ResponseBody();
		body.setData(new User()); // ֻ������User
	}

	public static void demo2() {
		Tool<User> tool = new Tool<User>();
		tool.setObject(new User());
		User user = tool.getObject();
	}

	public static void demo1() {
		ArrayList<User> list = new ArrayList<User>();

		HashSet<User> set = new HashSet<User>();

		set.add(new User());

		list.add(new User());

		User value = list.get(0);
	}

}
