/**
 * 匿名内部类:没有名称的内部类
 * 匿名内部类可以实现一个接口或继承一个父类.
 */

package eg.oop.innerClass;

public class TestAnonymous {
    public static void main(String[] args) {
        //实现一个接口的匿名内部类
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
                System.out.println("测试匿名内部的test方法....");
            }
        }.test();
        /*
         * 继承的匿名类。
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
                System.out.println("Thread....run方法...");
            }
        }.start();
    }
}

interface MyInterface{
	void test();
}