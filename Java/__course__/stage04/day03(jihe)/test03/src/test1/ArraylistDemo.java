/*
 *   ��Arraylist�д���������ݣ�
 *   ���������������ġ��������塱��������������aaa������aaa������bbb��
 *   Ҫ��ȥ��ArrayList�е��ظ�Ԫ�ء�
 */

package test1;

import java.util.ArrayList;
import java.util.List;

public class ArraylistDemo {
	public static void main(String[] args) {
		//ʵ����List������������
		List<String> list = new ArrayList<>();
		
		//�����������������
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("aaa");
		list.add("aaa");
		list.add("bbb");
		
		//ʵ����һ�����������������ȥ�غ�ļ���
		List<String> newList = new  ArrayList<String>(); 
		
		//����,���ж�
		for(String name:list){
			//�������жϣ��������Ƿ����ǰ���������ֵ�����û�У�����ӣ��������
			if(!newList.contains(name)){
				//��������������жϺ������
                newList.add(name);
            }
		}
		
		//���
		System.out.println("ȥ��ǰ�ļ��ϣ�" + list);  //��ʼ����
		System.out.println("ȥ�غ�ļ��ϣ�" + newList);  //������
	}
}
