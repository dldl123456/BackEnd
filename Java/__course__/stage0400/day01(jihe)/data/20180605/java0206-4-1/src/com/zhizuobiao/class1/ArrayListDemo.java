package com.zhizuobiao.class1;

import java.util.ArrayList;

/**
 * ����-ArrayList
 */
public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		User user = new User();

		// ����
		list.add(user);
		list.add("zhizuobiao");

		// ��ȡ
		Object obj0 = list.get(0);
		User u = (User) obj0;
		System.out.println(obj0);
		System.out.println(u.getId());

		Object obj1 = list.get(1);
		System.out.println(obj1);

		// ��objectǿת��User��Ȼ�����user���еķ���
		// 1 ����ת��
		// 2 ��������
		((User) list.get(0)).getName();
		// �������£�
		// 1����list�����л�ȡ��0��Ԫ�أ����͡�Object��--> ��������
		// 2��������ֵǿת��User���� Object --> User
		// 3������User���е�getName()����

		// ɾ��
		Object removeEle = list.remove(0);
		System.out.println("ɾ����Ԫ�أ�" + removeEle);
		
		System.out.println("ɾ��������飬0��Ԫ�أ�"+list.get(0));
		
		// ��ռ���
		list.clear();
		// ���ϴ�С
		list.size();
		// �жϼ����Ƿ�Ϊ��
		list.isEmpty();

		
	}
}
