package com.zhizuobiao.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhizuobiao.bean.RequestBean;
import com.zhizuobiao.bean.User;

@Controller
public class ParamController {

	// http://localhost:8080/springmvc0907-2/demo1.do?name=abc&age=11
	@RequestMapping("/demo1.do")
	public void demo1(HttpServletResponse resp, String name, int age) throws IOException {

		StringBuilder builder = new StringBuilder();
		builder.append(name).append(",").append(age);

		resp.setContentType("text/html;charset=utf8");
		resp.getWriter().print(builder.toString());
	}

	// http://localhost:8080/springmvc0907-2/demo2.do?version=v1.2.3&source=zzb&user.id=99&user.name=china
	@RequestMapping("/demo2.do")
	public void demo2(HttpServletResponse resp, RequestBean requestBean) throws IOException {

		StringBuilder builder = new StringBuilder();
		builder.append(requestBean.getSource()).append(",");
		builder.append(requestBean.getVersion()).append(",");
		builder.append(requestBean.getUser()).append(",");

		resp.setContentType("text/html;charset=utf8");
		resp.getWriter().print(builder.toString());
	}

	@RequestMapping("/demo3.do")
	public String demo3(@ModelAttribute("requestBean") RequestBean requestBean) throws IOException {

		// @ModelAttribute("requestBean")���£�
		// model.addObject(RequestBean,RequestBean);

		StringBuilder builder = new StringBuilder();
		builder.append(requestBean.getSource()).append(",");
		builder.append(requestBean.getVersion()).append(",");
		builder.append(requestBean.getUser()).append(",");

		System.out.println(builder.toString());

		return "requestParam"; // �߼���ͼ���֣���ת����Ӧ��jspҳ��
	}

	// http://localhost:8080/springmvc0907-2/demo4.do?values=1&values=2
	@RequestMapping("/demo4.do")
	public String demo4(String[] values) {

		System.out.println(Arrays.toString(values));

		return "requestParam"; // �߼���ͼ���֣���ת����Ӧ��jspҳ��
	}

	/**
	 * ע�����Ա༭��(�ַ���ת��Ϊ����)��ֻ�ڵ�ǰcontroller����ã�����ȫ�ֵġ�
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	// http://localhost:8080/springmvc0907-2/demo5.do?date=2018-05-07
	@RequestMapping("/demo5.do")
	public String demo5(Date date) {

		System.out.println(date);

		return "requestParam"; // �߼���ͼ���֣���ת����Ӧ��jspҳ��
	}

	// ÿ������֮ǰ����ִ��
	@ModelAttribute("user")
	public User requestBeanTest() {

		System.out.println("==userTest==");

		User user = new User();
		user.setId(1);
		user.setUsername("pubic user");
		return user;
	}

	
	// ���ռ��϶�����������List<User> userList
	// http://localhost:8080/springmvc0907-2/demo6.do?userList[0].id=1&userList[0].name=abc&userList[1].name=qqppe
	@RequestMapping("/demo6.do")
	public String demo6(RequestBean requestBean) {

		System.out.println(requestBean);

		return "requestParam"; // �߼���ͼ���֣���ת����Ӧ��jspҳ��
	}

}
