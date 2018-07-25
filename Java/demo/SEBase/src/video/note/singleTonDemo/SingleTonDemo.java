/*
 *  单例设计模式:多次实例化对象，只调用一次构造方法
 *  单例模式，不需要new对象，静态封装实例化对象，用类名调用取静态对象
 */

package video.note.singleTonDemo;

public class SingleTonDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//SingleTon st1 = new SingleTon();  //new一个st1对象（实例化SingleTon类,创建st1对象）
		SingleTon st1 = SingleTon.getInstance();
		SingleTon st2 = SingleTon.getInstance();
	}
}

/*class SingleTon{
 * 	//饿汉式
	//自己内部new一个对象，因为构造方法是私有的
	private static SingleTon singleTon = new SingleTon();
	
	//构造方法（因为不想让他每次实例化都调用，所以不能用public）
	//私有方法只能本类才能调用
	private SingleTon(){
		System.out.println("单例设计模式");
	}
	
	//返回类型是SingleTon，说明返回你构造出来的SingleTon对象，这个对象属于SingleTon类型
	public static SingleTon getInstance(){
		return singleTon;
	}
}*/

class SingleTon{
	//自己内部new一个对象，因为构造方法是私有的
	// private static SingleTon singleTon = new SingleTon();
	
	//先做一个声明
	private static SingleTon singleTon = null;
	
	//构造方法（因为不想让他每次实例化都调用，所以不能用public）
	//私有方法只能本类才能调用
	private SingleTon(){
		System.out.println("单例设计模式");
	}
	
	//返回类型是SingleTon，说明返回你构造出来的SingleTon对象，这个对象属于SingleTon类型
	//当你调用这个方法的时候，判断singleTon是否为空，空的话说明还没产生对象，再帮你产生这个对象，再返回
	//再次调用这个方法的时候，因为是静态的，是共享的，所以不再会是null，所以直接返回
	//这种叫懒汉式加载
	public static SingleTon getInstance(){
		if(singleTon == null){
			singleTon = new SingleTon();
		}
		return singleTon;
	}
}
