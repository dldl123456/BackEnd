package video.note.TreeMap;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo1 {
	public static void main(String[] args) {
		TreeMap<String, String> tmap = new TreeMap<>();
		//默认安装键的自然顺序升序排序
		tmap.put("jack", "zhangsan");
		tmap.put("marry", "xiaohong");
		tmap.put("rock", "xiaozhang");
		tmap.put("free", "xiaoming");
		tmap.put("rock", "cmcc");  //重复会被替换
		
		System.out.println(tmap);
		
		//不替代
		Set<Entry<String, String>> entrys = tmap.entrySet();
		
		//遍历
		for(Entry<String, String> entry:entrys){
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
	}
}
