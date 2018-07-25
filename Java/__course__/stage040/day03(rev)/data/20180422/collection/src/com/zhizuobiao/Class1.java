package com.zhizuobiao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * collection -- arraylist 
 */
public class Class1 {

	public static void main(String[] args) {

		User user = new User();
		// ArrayList (����ṹ����)
		ArrayList arrayList = new ArrayList();
		// �ַ���
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("a");
		// user����
		arrayList.add(user); // User���࣬user�����ʵ�������󣩣�Object���࣬objʵ��������
		// booleanֵ
		arrayList.add(false);
		// float
		arrayList.add(3.1415926);
		// �����Ϸ��벻ͬ���������ݣ�ȡ��ʱ����object���ͣ�Ҳ����ʧȥԭ�����͡�{����Ĭ���ڲ���objectԪ������}
		// ���ȡԭ�����ݵ����ͣ��൱���ӣ���������ǿ��ת����

		// demo2(arrayList);
		// demo3(arrayList);
		demo5(arrayList);

	}

	/**
	 * ArrayList�����ص�
	 * 
	 * @param arrayList
	 */
	public static void demo5(ArrayList arrayList) {

		System.out.println("index_0 = " + arrayList.get(0)); // a
		arrayList.remove(0);
		System.out.println("index_0 = " + arrayList.get(0)); // b
		arrayList.add(0, "0_new");
		System.out.println("index_0 = " + arrayList.get(0)); // 0_new
		// ����洢�ṹͼ
		//  0,1,2,3,4,5,6
		// [a,b,c,a,user,false,3.1415926] --> remove(0);
		//  0,1,2,3,4,5
		// [b,c,a,user,false,3.1415926] --> ɾ��Ԫ�غ󣬺��������ݣ��Զ�ǰ��
		//  ɾ��Ч�ʣ� ��������Խ���ٶȻر���
		// ��ȡԪ�أ� ʹ��������±꣬һ�ξͿ����õ���eg��3--user[3]
		// ArrayList ��ѯ�죬���ɾ����

	}

	/**
	 * ��װ��
	 * 
	 * @param arrayList
	 */
	public static void demo4(ArrayList arrayList) {
		// ��װ�� �Զ����
		// int -- Integer
		int x = 10;
		Integer y = 20;
		double d1 = 1;
		Double d2 = 2d;
		// �����������ͣ���Ӧ�Ķ�����
		Byte b;
		Short s;
		Long l;
		Float f;
		Boolean bl;
		Character ct;

		// �����������ͣ�ת�ɶ�Ӧ�Ķ������� --> װ��
		Integer xObj = Integer.valueOf(x);
		// Double.valueOf(arg0)
		// Float.valueOf(arg0)
		// ...

		// �������ͣ�ת�ɻ����������� --> ����
		int xValue = xObj.intValue();

		// ����demo4_1
		demo4_1(10); // �Զ���װ��
	}

	public static void demo4_1(Integer value) {
	}

	/**
	 * foreach
	 * 
	 * @param arrayList
	 */

	public static void demo3(ArrayList arrayList) {
		for (Object obj : arrayList) {
			System.out.println(obj);
		}
	}

	/**
	 * ������
	 * 
	 * @param arrayList
	 */
	public static void demo2(ArrayList arrayList) {

		// ������
		Iterator iterator = arrayList.iterator();
		// System.out.println(iterator.next()); // a
		// System.out.println(iterator.next()); // b
		// System.out.println(iterator.next()); // c
		// System.out.println(iterator.next()); // a
		// System.out.println(iterator.next()); // user
		// System.out.println(iterator.next()); // java.util.NoSuchElementException

		// forѭ������Ҫ֪����ʼ�ͽ���
		// ������ ���ʺ�
		// while��booleanֵѭ��
		while (iterator.hasNext()) { // �����������Ԫ�أ��ͷ���true��û��Ԫ�ؾͷ���false
			System.out.println("��");
			// Object obj = iterator.next();
			// System.out.println("iterator = " + obj);
			iterator.next();
		}
	}

	/**
	 * ���Ϸ���
	 * 
	 * @param arrayList
	 */
	public static void demo(ArrayList arrayList) {
		// java ������������ 8��
		// byte short int long float double char boolean
		int[] arr = new int[10];

		// ���ϴ�ŵ������Ƕ���

		Collection collection;
		// collection ��Ԫ���Ͻ��е����ĵ�������
		// set list
		// set -- һ���������ظ�Ԫ�ص� collection
		// list -- ����� collection��Ҳ��Ϊ���У�,�����ظ���Ԫ��

		// ���ݽṹ
		// ��
		// ջ
		// ����
		// ����
	}

	/**
	 * ���ϻ�������
	 * 
	 * @param arrayList
	 */
	public static void demo1(ArrayList arrayList) {
		// 10 (x,x,x,x,x,x,x,x,x,x)
		// 10 (1,2,3,4,5,6,7,8,9,10)
		// 10 (1,2,3,4,5,6,7,8,9,10,x,x,x,x,x,x,x,x,x,x)
		for (int i = 0; i < 10000; i++) {
			// arrayList.add(i);
		}

		// ɾ�������ڣ��±�Ϊ0��Ԫ��
		// arrayList.remove(0);

		// ������ϵĴ�С
		System.out.println(arrayList.size());

		// ѭ����0-N���ϵĴ�С
		for (int i = 0; i < arrayList.size(); i++) {

			// get(int index) �����б���ָ��λ�õ�Ԫ�ء�
			// ��ȡ�����е�Ԫ��
			Object value = arrayList.get(i);

			System.out.println(value);
		}

		// arrayList.clear();

		System.out.println(arrayList.size());

		// ����
		boolean exist = arrayList.contains("c");

		System.out.println("exist = " + exist);
	}
}
