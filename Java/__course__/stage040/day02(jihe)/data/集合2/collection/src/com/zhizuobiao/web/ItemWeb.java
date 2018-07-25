package com.zhizuobiao.web;

import com.zhizuobiao.Item;
import com.zhizuobiao.ResponseBody;

public class ItemWeb {
	
	public static void demo3() { //
		ResponseBody body = new ResponseBody();
//		body.setData(new User()); // ÷ªƒ‹…Ë÷√User
		body.setData(new Item()); 
	}
}
