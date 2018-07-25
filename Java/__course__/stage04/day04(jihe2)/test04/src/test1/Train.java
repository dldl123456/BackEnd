package test1;

//线程类
public class Train implements Runnable {
	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "过山洞.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODOAuto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
