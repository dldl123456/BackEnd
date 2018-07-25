package dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * ���ݿ����ӹ���
 * @author Administrator
 *
 */
public class ConnectionFactory {
	protected static String DRIVER;
	protected static String URL;
	protected static String USER;
	protected static String PASSWORD;
	
	static {
		Properties props = new Properties();//properties�д�ŵ��Ǽ�ֵ�ԣ���һ��֮�õ����Լ������Ա��������л�����м���
		//�������ļ���ȡ������
		InputStream is =
				ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties");
		try {
			props.load(is);//load������ʾ�����ж�ȡ�����б�
			DRIVER =props.getProperty("mysql.driver");//getProperty��������ָ���ļ��������б����������ԣ������б��Ѿ���load������ȡ����props�У�
			URL =props.getProperty("mysql.url");
			USER = props.getProperty("mysql.user");
			PASSWORD = props.getProperty("mysql.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
