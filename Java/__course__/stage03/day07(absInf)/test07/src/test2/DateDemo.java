/*
 *  编写代码获取当前日期时间并转换成相应的格式输出(如：2015-09-09 12:52:23)
 */

package test2;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();  //调用系统默认时间
		DateFormat df = null;  //日期格式化类
		df = DateFormat.getDateTimeInstance();  //时间格式化类
		System.out.println(df.format(date));  //输出
	}
}