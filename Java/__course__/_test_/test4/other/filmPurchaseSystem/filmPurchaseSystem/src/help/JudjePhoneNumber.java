package help;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ж��绰�����Ƿ���ȷ
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
