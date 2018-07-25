package com.zhizuobiao.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhizuobiao.exception.Test2Exception;
import com.zhizuobiao.exception.TestException;

@Controller
public class TestController {

	// http://localhost:8080/springmvc0907-2/test1.do?date=2018-05-07
	@RequestMapping("/test1.do")
	public String test1(Date date) {

		System.out.println(date);

		return "requestParam"; // 逻辑视图名字，跳转到对应的jsp页面
	}

	@RequestMapping("/test2.do")
	@ResponseBody
	public String test2(int code) throws Test2Exception {

		if (code == 1) {
			throw new TestException("haha 测试异常");
		} else if (code == 2) {
			throw new Test2Exception(" haha 测试异常 非运行");
		}

		return "test exception"; // 逻辑视图名字，跳转到对应的jsp页面
	}
}
