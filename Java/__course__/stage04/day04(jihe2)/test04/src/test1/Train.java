package test1;

//�߳���
public class Train implements Runnable {
	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "��ɽ��.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODOAuto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
