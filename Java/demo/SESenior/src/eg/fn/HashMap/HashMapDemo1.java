/*
 *  “asdascveasrgdfsdf”获取该字符串中，每一个字母出现的次数。
 *  要求：打印结果是：a(2)b(1)... 
 */

package eg.fn.HashMap;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDemo1 {
	public static void main(String[] args) {
		String str = "asdascveasrgdfsdf";
		HashMap<String, Integer> maps = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String key = String.valueOf((str.charAt(i)));
			if (!maps.containsKey(key)) {
				maps.put(key, 1);
			} else {
				int val = maps.get(key);
				maps.put(key, val + 1);
			}
		}

		Set<Entry<String, Integer>> entrys = maps.entrySet();

		for (Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
		}
	}
}
