package com.zhizuobiao.class1;

/**
 * �߳�ͬ��
 */
public class Demo1 {

	// (Demo1.class) �ǹؼ�������жϺ�ѡ��
	// �����̶߳��ԣ�ִ��ͬһ�����������̣߳�����ͬ�Ķ��󣬲���ͬ����

	public static void main(String[] args) throws ClassNotFoundException {

		// Class.forName("");

		// ���ַ�ʽͬ��
		// 1��ͬ�������
		synchronized (Demo1.class) {

		}

		StringBuffer buffer = null; // ��ȫ
		StringBuilder builder = null; // ����ȫ
	}

	// 2��ͬ������
	public synchronized void play() { // ��=this

	}
}
