package com.zhizuobiao.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zhizuobiao.exception.Test2Exception;
import com.zhizuobiao.exception.TestException;

/**
 * 需要在springmvc中注册
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception e) {

		ModelAndView mv = new ModelAndView();
		if (e instanceof TestException) {
			mv.setViewName("runError");
		} else if (e instanceof Test2Exception) {
			mv.setViewName("notRunError");
		} else {
			mv.setViewName("error");
		}

		return mv;
	}

}
