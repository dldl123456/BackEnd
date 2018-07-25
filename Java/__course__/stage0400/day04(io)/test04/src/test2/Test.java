/*
	编一个程序，实现两个线程 A 和 B ，A 和 B 同时启动，A线程每隔5秒显示字符串”AAA”，B线程每隔 1秒显示字符‘B’。
 */

package test2;

public class Test {
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化线程类对象
		PrintA Pa = new PrintA();
		PrintB Pb = new PrintB();
		
		//创建线程并开启
		new Thread(Pa, "PrintA").start();
		new Thread(Pb, "PrintB").start();
	}
}