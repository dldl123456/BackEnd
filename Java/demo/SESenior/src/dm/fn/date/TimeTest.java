package dm.fn.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
        Date date = new Date();  
         
//      一、获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println(dateTime);  // 2017-09-24 23:33:20
         
//      二、Date转换为Datetime
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        System.out.println(timestamp); // 2017-09-24 23:33:20.655
         
//      三、String转换为Date
        String strTime = "2017-09-24 12:00:01";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = sdf1.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1); // Sun Sep 24 12:00:01 CST 2017
         
//      四、Date转换为String
        Date date2 = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str1 = format.format(date2);
        System.out.println(str1); // 2017-09-24
         
//      五、String转化为java.sql.Date
        String str2 = "2018-04-02 00:00:00.0";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sDate = null;
        try {
            java.util.Date date3 = sdf2.parse(str2);
            sDate = new java.sql.Date(date3.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sDate); // 2017-12-01
         
    }
}
