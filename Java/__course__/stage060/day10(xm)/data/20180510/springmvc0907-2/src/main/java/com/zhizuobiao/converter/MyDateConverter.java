package com.zhizuobiao.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 全局的日期转换器
 *
 */
public class MyDateConverter implements Converter<String, Date> {

	// 请求参数日期格式定义：yyyy-MM-dd
	public Date convert(String dateString) {

		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

}
