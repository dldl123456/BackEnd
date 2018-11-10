package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Utils {
	//一个会话工厂
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		try {
			//读取xml配置文件
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			//会话工厂类（字符流的方式）
			//从sqlSession从SqlSessionFaction工厂类获取sqlsession对象
			//sqlSession对象封装对sql语句的所有操作
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
