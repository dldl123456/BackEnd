/*
 *  “asdascveasrgdfsdf”获取该字符串中，每一个字母出现的次数。
 *  要求：打印结果是：a(2)b(1)... 
 */

package eg.fn.TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo3 {
	public static void main(String[] args) {
		String str = "asdascveasrgdfsdf";  
        str = getCharCount(str);  
        System.out.println(str);
	}
	
	public static String getCharCount(String s) {  
		TreeMap<Character, Integer> tmap = new TreeMap<>();  
        //将字符串变成字符数组  
        char[] chs=s.toCharArray();  
        //遍历数组，将数组中的每一个元素取出  
        for (int i = 0; i < chs.length; i++) {  
            if(chs[i]<'a'||chs[i]>'z')  
                continue;  
            //判断取出的元素作为键，是否在map集合中  
            Integer value=tmap.get(chs[i]);  
            if(value==null){  
            	tmap.put(chs[i], 1);  
            }  
            else{  
            	tmap.put(chs[i],value+1);  
            }     
              
              
        }  
        return myString(tmap);  
    }  
  
    private static String myString(Map<Character, Integer> mp) {  
        //用stringbuilder容器  
        StringBuilder sb=new StringBuilder();  
        Iterator<Map.Entry<Character,Integer>> it=mp.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<Character,Integer> me=it.next();  
            Character key=me.getKey();  
            Integer value=me.getValue();  
            sb.append(key+"("+value+")"+" ");  
        }  
          
        return sb.toString();  
    }  
}
