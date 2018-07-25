/**
 *java.util.Arrays��
 *sort(Object[] objs):����Ԫ�ص���Ȼ˳���ָ���������鰴����������������е�����Ԫ�ض�����ʵ�� Comparable�ӿ� 
 *
 */

package eg.oop.comparatorDemo_4;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        Student[] stus = new Student[5];//����ѧ����Ϣ������
        stus[0]=new Student("aa",20,80);
        stus[1]=new Student("bb",22,78);
        stus[2]=new Student("cc",18,90);
        stus[3]=new Student("dd",25,82);
        stus[4]=new Student("ee",24,81);
        System.out.println("����ǰ:");
        for (Student student : stus) {
            System.out.println(student);
        }
        Arrays.sort(stus);
        System.out.println("�����:");
        for (Student student : stus) {
            System.out.println(student);
        }

    }
}
