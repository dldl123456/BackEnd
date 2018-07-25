package video.eg.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountStringDemo {
	public static void main(String[] args) {
		String[] strs = {"aa", "aa", "bb", "cc"};
		
		AccountUtil.printData(AccountUtil.account(strs));
	}
}

class AccountUtil{
	//只为外部类服务，用静态类
	public static Map<String, Integer> account(String[] strs){
		//产生一个容器
		Map<String, Integer> data = new HashMap<String, Integer>();
		
		//循环
		for(int i=0; i<strs.length; i++){
			String str = strs[i];
			if(data.get(str)==null){
				data.put(str, 1);
			}else{
				//取出key所对应的值加1
				data.put(str, data.get(str) + 1);
			}
		}
		return data;
	} 
	
	public static void printData(Map<String, Integer> data){
		Set<Entry<String, Integer>> entrys = data.entrySet();
		
		for(Entry<String, Integer> entry:entrys){
			System.out.println(entry.getKey() + "出现的次数为" + entry.getValue());
		}
	}
}