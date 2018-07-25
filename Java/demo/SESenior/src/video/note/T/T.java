package video.note.T;

public class T {
	public static void main(String[] args) {
		//List<E> -> E表示元素element
		//Map<K, V>
		
		//用Object可以接收任意数据类型的数据
		Test2 t2 = new Test2();
		t2.setData(123);
		t2.setData("aa");
		t2.setData(12.5);
		System.out.println(t2.getData());
		
		//Object缺点
		//用Object转换会造成ClassCastException异常
		//double不能转String
		//要用instanceof
		//System.out.println((String)t2.getData());
		
		//泛型类
		Test3<String> t3 = new Test3<String>();
		Test3<Integer> t3_1 = new Test3<Integer>();
		t3.setData("aaa");
		t3_1.setData(132);
		System.out.println(t3.getData());
		System.out.println(t3_1.getData());
		
		//泛型方法
		@SuppressWarnings("unused")
		Test4 t4 = new Test4();
	}
}

@SuppressWarnings("hiding")
class  Test1<T> {} //泛型类

//Object接收任意数据类型
class  Test2 {
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

//泛型接收任意数据类型
@SuppressWarnings("hiding")
class Test3<T>{
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

//泛型方法
@SuppressWarnings("hiding")
class Test4{
	//普通方法
	//public void show(String name){}
	
	//泛型基本用法
	public <T> void show(T obj){}
	
	//限制泛型只能是他的子类
	//public <T extends Test3> void show(T obj){}
}


