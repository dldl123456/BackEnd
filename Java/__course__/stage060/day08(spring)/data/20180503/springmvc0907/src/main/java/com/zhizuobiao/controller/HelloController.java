package com.zhizuobiao.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * springmvc hellowolrd
 *
 */
public class HelloController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		System.out.println("HelloController");

		ModelAndView mv = new ModelAndView();
		// mv.setViewName("/hello.jsp");
		// 真实页面地址
		// mv.setViewName("/WEB-INF/jsp/manager.jsp");
		// 逻辑视图名 --> 需要视图解析器支持，解析
		mv.setViewName("manager");
		mv.addObject("mobile", "10010");

		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("iphone");
		list.add("mac");
		list.add("huawei");
		
		mv.addObject("itemList", list);
		
		return mv;
	}

}
