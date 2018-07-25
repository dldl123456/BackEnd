package com.zhizuobiao.class1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	
	public static void main(String[] args) throws IOException {
		
		InputStream ins = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(ins);
		
		System.out.println(ins);
	}
}
