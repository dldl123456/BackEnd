package com.zhizuobiao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Detail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhizuobiao.bean.User;

@Controller
public class JsonController {

	@RequestMapping("/json.do")
	@ResponseBody
	public User test1() {
		// 把user对象数据封装成json数据返回给浏览器
		User user = new User();
		user.setId(122);
		user.setUsername("服务器返回的json数据");

		return user;
	}

	// [{"id":11,"name":"first json"},{"id":12,"name":"second json"}]
	@RequestMapping("/json2.do")
	@ResponseBody
	public List<User> test2() {

		List<User> list = new ArrayList<User>();
		// 把user对象数据封装成json数据返回给浏览器
		User user = new User();
		user.setId(11);
		user.setUsername("first json");

		User user2 = new User();
		user2.setId(12);
		user2.setUsername("second json");

		list.add(user);
		list.add(user2);
		
		return list;
	}
	
	
    @RequestMapping("/json3.do")
    @ResponseBody
    // @RequestBody User user
    // 提交的json数据封装到对象
    public User testJson(@RequestBody User user) {

        System.out.println(user);

        User u = new User();
		u.setId(666);
		u.setUsername("测试json方式数据结果成功");
		
		return u;
    }
}
