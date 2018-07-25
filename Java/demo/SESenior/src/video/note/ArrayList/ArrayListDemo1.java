package video.note.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		//alt+/ --> 快速导包 (ctrl+shift+o)
		//ArrayList泛型类的一个对象
		//创建一个ArrayList容器
		//ArrayList<String> nList = new ArrayList<String>();  //import java.util.ArrayList;
		//也可以用接口的引用变量引用实现的对象
		/**
		 * 当我们调用无参构造方法来构造一个ArrayList对象的时候，他会在
		 * 内部分配一个初始大小为10的一个object类型数组
		 * 当添加的数据容量超过数组的大小的时候，会产生一个新的数组，
		 * 新的数组大小为原来数组大小的1.5倍，接着，把原数组中的数据
		 * 拷贝到新的数组中
		 */
		List<String> nList = new ArrayList<String>();  //要导入包import java.util.List;
		//添加字符串(上面限定了)
		nList.add("张三");
		nList.add("lisi");
		nList.add("ZMX");
		nList.add("zmx");
		//插入(插入到指定位置)
		nList.add(0, "132"); //第一个参数(0)表示下标
		nList.add(1, "123");
		//替换
		nList.set(0, "wangwu");  //第一个参数(0)表示下标
		
		//用迭代器对象对容器内容进行遍历(子类继承了父类)
		System.out.println("使用迭代器对象进行统一的遍历");
		Iterator<String> it = nList.iterator();
		
		//判断有没有下一个元素，有的话返回true
		while(it.hasNext()){
			String name = it.next();  //next表示取出下一个元素
			System.out.println(name);
		}
		
		//用增强for循环进行遍历
		System.out.println("用增强for循环进行遍历");
		for(String name:nList){
			System.out.println(name);
		}
		
		//其他方法
		System.out.println("*******");
		//indexOf(返回此列表中首次出现的指定元素的索引，找不到返回-1)
		System.out.println(nList.indexOf("lisi"));
		//删除首次出现的字符串
		System.out.println(nList.remove("lisi"));  //返回布尔
		System.out.println(nList.remove(0)); //根据索引（返回字符串）
		//返回元素数量
		System.out.println(nList.size());
		//查看是否包含指定元素
		System.out.println(nList.contains("zmx"));
		//返回列表指定位置的元素
		System.out.println(nList.get(0));
		//清空
		nList.clear();
		//判断是否为空
		System.out.println(nList.isEmpty());
	}
}
