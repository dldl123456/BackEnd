/*
	����һ��Worker�࣬�������� name sex salary level
	����һ��linkedlist��Ϊ����������Դ������main������
	д��һ�·�����
	1.¼��5��������Ϣ
	2.������й�����Ϣ
	3.���ݹ��˵�idͨ�������ڲ���������򣬲��������Ҫ���˵�����Ӱ��Դ����˳��
	ͨ�������һ���µ�arraylist�н�������
	4.�������Թ��˵Ĺ�����ԭ�л����ϼ�200
	5.ͨ��ʹ��listiterator�޸����й��ʳ���5000��Ա������ΪH
 */

package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Test.linkedListTest();
	}
	
	public static void linkedListTest(){
		//ʵ�������worker�����LinkedList�ͼ���
		List<Worker> sList = new LinkedList<>();
		List<Worker> aryList = new ArrayList<>();
		
		Worker worker1 = new Worker(4, "����", "�߼�", '��', 6000);
		Worker worker2 = new Worker(5, "����", "�м�", '��', 2500);
		Worker worker3 = new Worker(3, "����", "����", '��', 1235);
		Worker worker4 = new Worker(1, "����", "�߼�", '��', 9000);
		Worker worker5 = new Worker(2, "*��", "�м�", '��', 5000);
		
		//¼��5��������Ϣ
		sList.add(worker1);
		sList.add(worker2);
		sList.add(worker3);
		sList.add(worker4);
		sList.add(worker5);
		
		System.out.println("δ����");
		
		//ʵ��Iterator�ӿ�������й�����Ϣ
		Iterator<Worker> it = sList.iterator();
		while(it.hasNext()){
			Worker works = it.next();
			System.out.println(works);
		}
		
		//linkedlist����arraylist
		aryList.addAll(sList);
		
		//���ݹ��˵�idͨ�������ڲ���������򣬲��������Ҫ���˵�����Ӱ��Դ����˳��
		Collections.sort(aryList, new Comparator<Worker>(){
			@Override
			public int compare(Worker o1, Worker o2) {
				if(o1.getId() - o2.getId()<0){
					return -1;
				}else{
					return 1;
				}
			}
		});
		
		System.out.println("�����");
		
		//��foreach��������Ĺ���
		for(Worker work : aryList){
			System.out.println(work);
			
		}
		
		System.out.println("�������200��");
		
		//�������200
		for(Worker worker : aryList){
			worker.setSalary(worker.getSalary()+200);
			
			System.out.println(worker);
		}
		
		System.out.println("���ó�������5000��Ա������ΪH:");
		
		//���ó�������5000��Ա������ΪH
		Iterator<Worker> iter = sList.listIterator();
		while(iter.hasNext()){
			Worker worker = iter.next();
			if(worker.getSalary()>=5000){
				worker.setLevel("H");
			}
			
			System.out.println(worker);
        } 
	}
}