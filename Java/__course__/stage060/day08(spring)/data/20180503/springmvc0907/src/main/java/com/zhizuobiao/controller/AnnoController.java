package com.zhizuobiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Repository
//@Service
@Controller
public class AnnoController {

	@RequestMapping(value = "/haha.do", method = RequestMethod.POST)
	public ModelAndView paramsView(String name, Integer age, String address) {

		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("address = " + address);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager");
		return mv;
	}

	@RequestMapping("/login.do")
	public ModelAndView loginView() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/manager.do", method = RequestMethod.GET)
	public ModelAndView managerView() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager");
		return mv;
	}

}
