/*
 *  使用内部类开发一个存放数据的容器
 */

package video.note.entryDemo;

import java.util.Arrays;

public class EntryDemo {
	public static void main(String[] args) {
		MyContainer container = new MyContainer();
		container.put("jas", "aa");
		container.put("j2s", "er");
		container.put("fsa", "bf");
		container.put("bgf", "ds");
		container.put("kuy", "sa");
		
		MyContainer.Entry[] entrys = container.entryArrays();
		
		for(int i=0; i<entrys.length; i++){
			MyContainer.Entry entry = entrys[i];
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
	}
}

//容器类
class MyContainer{
	//存放entry对象的数组，默认大小为5
	private Entry[] entrys = new Entry[5];
	
	private int count = 0;  //下标
	
	//对外提供一个接口向容器中存放封装好的数据(Entry)
	public void put(String key, String value){
		Entry entry = new Entry();
		entry.setKey(key);
		entry.setValue(value);
		
		entrys[count++] = entry;  //存放entry对象到数组中
		
		//数组的扩容
		if(count>=entrys.length){
			int newCapacity = entrys.length * 2;  //扩容后的新数组的大小
			//把老数组(entrys)的数据拷贝到新数组(newCapacity)中
			//最后将数组名字换成entrys
			entrys = Arrays.copyOf(entrys, newCapacity);
		}
	}
	
	//把容器中有数据的内容返回
	public Entry[] entryArrays(){
		return Arrays.copyOfRange(entrys, 0, count);
	}
	
	//静态内部类
	//把键值对封装在Entry对象中
	public static class Entry{
		private String key;
		private String value;
		
		//key
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		//value
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
