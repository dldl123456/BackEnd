package course.note.treemap;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * treemap
 * 有序
 */

public class Treemap {
	public static void main(String[] args) {
		//实例化
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		//添加数据
		map.put("a", "132");
		map.put("b", "456");
		map.put("12", "www");
		
		//遍历
		Set<Entry<String, String>> set = map.entrySet();
		
		for(Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + "--" + entry.getValue());;
		}
		
	}
}
