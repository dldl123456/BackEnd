package com.zhizuobiao.class2;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	public String update(String message) {

		System.out.println("收到消息：" + message);

		return "执行成功";
	}

	public void delete(String message) {

		System.out.println("删除内容：" + message);

	}
}
