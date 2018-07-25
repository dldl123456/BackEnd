package video.eg.synchronizedtest;

public class SingleTonDemo {
	public static void main(String[] args) {
		//单线程(主线程)模式下调用2次getInstance方法
		//只产生一个对象
		/*SingleTon.getInstance();
		SingleTon.getInstance();*/
		
		//产生一个实现Runnable接口的实现类对象
		SThread sThread = new SThread();
		
		//产生3个线程类对象,接收实现Runnable接口的实现类
		Thread t1 = new Thread(sThread);
		Thread t2 = new Thread(sThread);
		Thread t3 = new Thread(sThread);
		
		//开启线程
		t1.start();
		t2.start();
		t3.start();
	}
}

//线程类(实现Runnable接口)
class SThread implements Runnable{
	@Override
	public void run() {
		SingleTon.getInstance();
	}
}

class SingleTon{
	//声明一个SingleTon类的引用变量
	//静态方法只能访问外部的静态变量
	private static SingleTon singleTon = null;
	
	/*
	 *  单例模式不能由外部new出来，只能由内部
	 *  构造一个单例模式对象出来，供外部其他的类
	 *  调用，所以他的构造方法是私有的
	 *  
	 *  当一个类，构造方法只被执行一次的时候，
	 *  说明他只产生了一个对象
	 */
	//显式声明私有的构造方法
	private SingleTon(){
		System.out.println("单例");
	}
	
	/*
	 *  外部无法new单例类对象(因为构造方法私有)
	 *  所以只能由内部公开的方法来返回内部所构造出来
	 *  的单例对象
	 *  
	 *  因为不能产生外部对象，所以不能产生类中的方法
	 *  如果把方法设为静态，则说明这个方法属于类，可以
	 *  直接访问该方法(类方法而不是对象方法)
	 */
	//对外提供一个方法
	public static SingleTon getInstance(){
		//当第一个线程进来，第二个线程就没必要再进行判断
		if(singleTon==null){
			//用同步块锁住该方法，让他依次执行
			//多个线程共同获得的对象锁
			//SingleTon.class
			/*
			 *  每一个类都有唯一的class对象，
			 *  所以SingleTon对象也有他的class对象
			 *  
			 *  当第一个线程过来的时候，获得了
			 *  SingleTon.class这个对象的锁，执行
			 *  第二个线程因为锁，只能等待，
			 *  第一个线程执行完毕，自动释放锁，
			 *  第二个线程执行，不符合
			 */
			synchronized (SingleTon.class) {
				if(singleTon==null){  //如果这个引用变量为null（没有经过实例化[new]）说明还未产生这个单例对象
					singleTon = new SingleTon();  //产生一个对象
				}
			}
		}
		
		return singleTon;  //如果已经产生对象则返回
	}
	
}
