package video.eg.synchronizedtest;

import java.util.LinkedList;

public class ProductorConsumerDemo {
	public static void main(String[] args) {
		//创建实现接口的实现类
		Basket basket = new Basket();
		//创建线程对象
		Productor productor = new Productor(basket);
		Consumer consumer = new Consumer(basket);
		
		productor.start();  //生产者生产
		consumer.start();  //消费者消费
	}
}

//消费者
class Consumer extends Thread{
	private Basket basket = null;

	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}
	
	@Override
	public void run() {
		basket.popApple();
	}
}

//生产者
class Productor extends Thread{
	private Basket basket = null;

	public Productor(Basket basket) {
		super();
		this.basket = basket;
	}
	
	@Override
	public void run() {
		basket.pushApple();
	}
}

//篮子类
class Basket{
	private LinkedList<Apple> basket = new LinkedList<>();
	
	//放4轮苹果(同步方法)放的时候不能吃
	public synchronized void pushApple(){
		for(int i=0; i<20; i++){
			Apple apple = new Apple(i);
			
			push(apple);
		}
	}
	
	//取4轮苹果
	public synchronized void popApple(){
		for(int i=0; i<20; i++){
			pop();
		}
	}
	
	//放苹果方法(本类使用)
	private void push(Apple apple){
		//当篮子中存放了5个苹果就等待并通知消费者来消费
		if(basket.size()==5){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //等待并释放当前对象的锁
		}
		
		//每隔0.5秒放一个苹果
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		basket.addFirst(apple);
		
		System.out.println("存放：" + apple.toString());
		
		notify();  //通知消费者来消费
	}
	
	//取苹果方法
	private void pop(){
		//当篮子中苹果味0时就等待并通知生产者生产
		if(basket.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //等待并释放当前对象的锁
		}
		
		//每隔0.5秒放一个苹果
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Apple apple = basket.removeFirst();
		
		System.out.println("吃掉：" + apple.toString());
		
		notify();  //通知生产者生产
	}
}

//苹果类
class Apple{
	private int id;
	
	public Apple(int id){
		this.id = id;
	}

	@Override
	public String toString() {
		return "苹果" + (id+1);
	}
}
