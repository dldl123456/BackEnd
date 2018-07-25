package dm.fn.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateDemo {
	public static void now(){
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		String str = df.format(now); 
		System.out.println(str);
	}
	
	//main
	public static void main(String[] args) {
		now();
	}
}
