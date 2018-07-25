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
		// ��user�������ݷ�װ��json���ݷ��ظ������
		User user = new User();
		user.setId(122);
		user.setUsername("���������ص�json����");

		return user;
	}

	// [{"id":11,"name":"first json"},{"id":12,"name":"second json"}]
	@RequestMapping("/json2.do")
	@ResponseBody
	public List<User> test2() {

		List<User> list = new ArrayList<User>();
		// ��user�������ݷ�װ��json���ݷ��ظ������
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
    // �ύ��json���ݷ�װ������
    public User testJson(@RequestBody User user) {

        System.out.println(user);

        User u = new User();
		u.setId(666);
		u.setUsername("����json��ʽ���ݽ���ɹ�");
		
		return u;
    }
}
