/*
 *  “asdascveasrgdfsdf”获取该字符串中，每一个字母出现的次数。
 *  要求：打印结果是：a(2)b(1)... 
 */

package test3;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class AccountStringDemo {
	public static void main(String[] args) {
		String str = "asdascveasrgdfsdf";  //初始字符串
		
		//实例化一个map容器
		HashMap<String, Integer> hmap = new HashMap<>();
		
		//遍历字符串
		for (int i=0; i<str.length(); i++) {
			//charAt返回字符串指定索引处的 char 值
			//valueOf(char c)表示返回 char 参数的字符串表示形式
			//分割字符串并将其分别存入字符串key中
			String key = String.valueOf(str.charAt(i));
			
			//判断map容器中是否存在key，如果不存在则加入，
			//如果存在则返回该键所映射的值，并且加1
			if (!hmap.containsKey(key)) {
				hmap.put(key, 1);
			} else {
				int val = hmap.get(key);
				hmap.put(key, val + 1);
			}
		}

		//实例化一个Entry对象
		Set<Entry<String, Integer>> entrys = hmap.entrySet();

		//遍历Entry对象中的所有键值对，并按格式输出
		for (Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
		}
	}
}
