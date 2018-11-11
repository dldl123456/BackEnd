package test;

import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.TestCollections;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//实例化spring容器===相当于工厂类,实例化很多对象.并且管理这些对象.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//加载TestCollections对象的
		TestCollections cs = (TestCollections) context.getBean("cs");
		
		//获取TestCollections对象的id属性值
		System.out.println(cs.getId());
		
		//获取TestCollections对象的数组的属性值
		for(String temp : cs.getArray()){
			System.out.print(temp + " ");
		}
		System.out.println();
		/*String arr[] = cs.getArray();
		for(int i=0; i<arr.length; i++){
			if(i<cs.getArray().length-1){
				System.out.print(arr[i] + "、");
			} else {
				System.out.print(arr[i]);
			}
		}*/
		
		//获取TestCollections对象的集合的属性值
		System.out.println(cs.getListValues());
		
		System.out.println(cs.getSetValues());
		
		//遍历map
		System.out.println(cs.getMapValues());
		Map<String, String> mapvalue = cs.getMapValues();
		Set<Entry<String, String>> mapentrys = mapvalue.entrySet();
		
		for (Entry<String, String> entry : mapentrys) {
			System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
		}
		System.out.println();
		
		//遍历属性文件（键值对）
		System.out.println(cs.getPropValues());
		Map<String, String> propValues = cs.getMapValues();
		Set<Entry<String, String>> propentrys = propValues.entrySet();
		
		for (Entry<String, String> entry : propentrys) {
			System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
		}
	}
}
