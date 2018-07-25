package step3.course.note.l171215;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) throws Exception {
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		//只能使用系统给我们提供的，不能自定义
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);//.getInstance();
		System.out.println(df.format(date));
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sf.format(date));
		
		String da = "2017年12月15日 22:20:36";
		Date da2 = sf.parse(da);
		System.out.println(da2);
		
		
		Calendar rn = Calendar.getInstance();
		System.out.println(rn.get(Calendar.YEAR));
		System.out.println(rn.get(Calendar.MONTH)+1);
		System.out.println(rn.get(Calendar.DATE));
		
	}

}
