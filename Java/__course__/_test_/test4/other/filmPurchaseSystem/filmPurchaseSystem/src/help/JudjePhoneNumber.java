package help;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判读电话号码是否正确
 * @author Administrator
 *
 */
public class JudjePhoneNumber {
	 public static boolean isMobileNO(String mobiles) {  
	        boolean flag = false;  
	        try {  
	  
	            // 13********* ,15********,18*********  
	            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
	  
	            Matcher m = p.matcher(mobiles);  
	            flag = m.matches();  
	  
	        } catch (Exception e) {  
	            flag = false;  
	        }  
	  
	        return flag;  
	    }  
}
