package video.note.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		//实例化一个容器
		List<String> nList = new ArrayList<>();
		
		//添加
		//list有序可重复
		nList.add("zhangsan");
		nList.add("lisi");
		nList.add("wangwu");
		nList.add("zhaoliu");
		
		//遍历
		System.out.println("初始：");
		for(String name:nList){
			System.out.print(name + " ");
		}
		
		System.out.println("\n***");
		
		//交换顺序
		System.out.println("交换顺序：");
		Collections.swap(nList, 1, 2);
		for(String name:nList){
			System.out.print(name + " ");
		}
		
		System.out.println("\n***");
		
		//交换顺序
		System.out.println("自然排序：");
		Collections.sort(nList);
		for(String name:nList){
			System.out.print(name + " ");
		}
		
		System.out.println("\n***");
		
		//二分法查找
		System.out.println("二分法查找：");
		//Collections.sort(nList);  必须先排序才能使用二分法查找
		System.out.println(Collections.binarySearch(nList, "zhaoliu"));
		
		System.out.println("\n***");
		
		//打乱顺序
		System.out.println("打乱顺序：");
		Collections.shuffle(nList);
		for(String name:nList){
			System.out.print(name + " ");
		}
		
		System.out.println("\n***");
		
		//填充(所有)
		System.out.println("填充：");
		Collections.fill(nList, "333");
		for(String name:nList){
			System.out.print(name + " ");
		}
	}
}
