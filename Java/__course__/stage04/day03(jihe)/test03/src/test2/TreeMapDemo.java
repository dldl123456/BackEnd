/*
 *  ʹ��TreeMap����һ��ѧ��(���ա�ѧ������/ѧ�š���ֵ�Դ洢,����ѧ��������������)��
 *  �������ѧ������ѧ��
 */

package test2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapDemo {
	public static void main(String[] args) {
		//����һ��TreeMap����,�������ڲ�����ݷ�����������(С����)
		TreeMap<Student, Integer> pdata = new TreeMap<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int) (o1.getGrades() - o2.getGrades());
			}
		});
		
		//���������������
		pdata.put(new Student(1, "����", 18, '��', 56), 1);
		pdata.put(new Student(2, "����", 15, '��', 33), 2);
		pdata.put(new Student(3, "����", 22, 'Ů', 98), 3);
		
		//�������key��value
		Set<Entry<Student, Integer>> entrys = pdata.entrySet();
		for(Entry<Student, Integer> entry:entrys){
			System.out.println(entry.getKey() + "  -  " + entry.getValue());
		}
	}
}
