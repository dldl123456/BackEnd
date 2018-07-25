/**
 * HashSet去重
 */

package course.demo.linklistdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetDemo {
	public static void main(String[] args) {
		//实例化List容器获得其对象
		List<String> list = new ArrayList<>();
		
		//往该容器中添加数据
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("张三");
		list.add("aaa");
		list.add("aaa");
		list.add("bbb");
		
		HashSet<String> other = new HashSet<>(list);
		
		for(String value : other){
			System.out.println(value);
		}
	}
}
