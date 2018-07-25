package video.note.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {
	public static void main(String[] args) {
		//实例化一个map容器
		//键和值都是字符串
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("yay", "张三");
		map.put("yay", "李四");
		map.put("rose", "玫瑰");
		
		//默认toString方法格式{...}
		//键相同值会被覆盖
		System.out.println(map);
		
		//获取map中所有键
		//只要是继承了collection类都能用iterable迭代器或者增强for循环遍历
		//获取map中所有的键
		/*Set<String> keys = map.keySet();
		for(String key:keys){
			System.out.println(key);
		}*/
		
		//获取map中所有的值
		Collection<String> values = map.values();
		for(String value:values){
			System.out.println(value);
		}
		
		//得到key的同时得到key所对应的值
		Set<String> keys = map.keySet();
		for(String key:keys){
			System.out.println(key + "--" + map.get(key));
		}
		
		//size(判断键值对的个数)
		System.out.println(map.size());
		
		//判断是否为空
		System.out.println(map.isEmpty());
		
		//map.entry返回的是 此映射所包含的映射关系的set视图
		/**
		 * 当我们调用put(key, value)方法的时候，首先会把key
		 * 和value封装到Entry这个静态内部类对象中，把Entry对象
		 * 再添加到数组中，所以我们想获取map中的所有键值对，我们只要获取
		 * 数组中的所有Entry对象，接下来调用Entry对象中的getKey和
		 * getValue方法就能获取键值对
		*/
		Set<Entry<String, String>> entrys = map.entrySet();
		
		for(Entry<String, String> entry:entrys){
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		
		/**
		 *  hashmap调用默认构造方法会产生一个底层是长度为16的Entry数组，
		 *  int hash = hash(key.hashCode());----Object对象中
		 *  首先调用key的hashCode方法来得到一个整数--哈希码
		 *  把哈希码作为参数传到hash函数中来进行运算--散列运算--
		 *  得到了一个整型--散列值
		 *  int i = indexFor(hash, table, length);  计算出数组下标
		 *  把散列值和数组的长度来进行运算，最终得到Entry对象要存放到数组的位置(下标)
		 *  
		 *  hash内部结构是数组链表结构
		 *  因为不同的key有可能算出来是相同的散列值，根据散列值计算出存放到数组的下标
		 *  会冲突,
		 */
	}
}
