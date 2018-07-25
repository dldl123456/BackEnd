package eg.fn.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {  
        String str = "asdascveasrgdfsdf";  
        Map map = new TreeMap();  
        for (int i = 0; i < str.length(); i++) {  
            char temp = str.charAt(i);  
            if (map.containsKey(temp)) {  
                int t = (int) map.get(temp);  
                map.put(temp, t + 1);  
            } else {  
                map.put(temp, 1);  
            }  
        }  
          
        for (Object o : map.keySet()) {  
            char t = (char) o;  
            int j = (int) map.get(t);  
            System.out.print(t+"("+j+")");  
        }  
    } 
}
