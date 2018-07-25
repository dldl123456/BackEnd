/**
 *   有5辆火车要过山洞,但确保山洞同时只能有一辆火车通过（过山洞需要2秒），打印输出火车通过的顺序。
 *   （过山洞的顺序是不可控的，只要保证同一时间只有一辆火车能通过山洞即可）
 *   提示：使用线程同步 
 */

package test1;

public class TrainTest {
	public static void main(String[] args) {
		//创建一个接口的实现类对象
		Train train = new Train();
		
		//产生线程类对象
		Thread t1 = new Thread(train, "第一辆火车");
		Thread t2 = new Thread(train, "第二辆火车");
		Thread t3 = new Thread(train, "第三辆火车");
		Thread t4 = new Thread(train, "第四辆火车");
		Thread t5 = new Thread(train, "第五辆火车");
		
		//开启线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}