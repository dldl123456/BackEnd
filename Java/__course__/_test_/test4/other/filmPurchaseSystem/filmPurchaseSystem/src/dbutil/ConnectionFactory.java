package dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 数据库连接工厂
 * @author Administrator
 *
 */
public class ConnectionFactory {
	protected static String DRIVER;
	protected static String URL;
	protected static String USER;
	protected static String PASSWORD;
	
	static {
		Properties props = new Properties();//properties中存放的是键值对，是一个之久的属性集，可以保存在流中或从流中加载
		//将配置文件读取到流中
		InputStream is =
				ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties");
		try {
			props.load(is);//load方法表示从流中读取属性列表
			DRIVER =props.getProperty("mysql.driver");//getProperty方法是用指定的键在属性列表中搜索属性（属性列表已经被load方法读取到了props中）
			URL =props.getProperty("mysql.url");
			USER = props.getProperty("mysql.user");
			PASSWORD = props.getProperty("mysql.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
