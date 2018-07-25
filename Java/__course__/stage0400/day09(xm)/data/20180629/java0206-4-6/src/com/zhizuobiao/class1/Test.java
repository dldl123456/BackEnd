package com.zhizuobiao.class1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws IOException {

		// 跟DBUtil.class在同一路径下，获取属性文件路径
		// InputStream ins = DBUtil.class.getResourceAsStream("db.properties");
		// 属性文件在src的根路径下，获取输入流的路径
		InputStream ins = DBUtil.class.getResourceAsStream("/db.properties");
		Properties prop = new Properties();
		prop.load(ins);
		String username = prop.getProperty("db_username");
		String password = prop.getProperty("db_password");
		String url = prop.getProperty("db_url");

		System.out.println(username);
		System.out.println(password);
		System.out.println(url);
	}
}
