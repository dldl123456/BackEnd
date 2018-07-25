/**
 * �����ڲ���:û�����Ƶ��ڲ���
 * �����ڲ������ʵ��һ���ӿڻ�̳�һ������.
 */

package eg.oop.innerClass;

public class TestAnonymous {
    public static void main(String[] args) {
        //ʵ��һ���ӿڵ������ڲ���
        /*
         *  class MyClass implements MyInterface{
         *      public void test(){
         *          ..
         *      }
         *  }
         *  MyClass myClass = new MyClass();
         *  myClass.test();
         */
        new MyInterface() {
            public void test() {
                System.out.println("���������ڲ���test����....");
            }
        }.test();
        /*
         * �̳е������ࡣ
         * class MyThread extends Thread{
         *      public void run(){
         *      .... 
         *   }
         * }
         * MyThread myThread = new MyThread();
         * myThread.start();
         */
        new Thread(){
            public void run() {
                System.out.println("Thread....run����...");
            }
        }.start();
    }
}

interface MyInterface{
	void test();
}