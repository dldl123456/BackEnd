/**
 *java.util.Arrays类
 *sort(Object[] objs):根据元素的自然顺序对指定对象数组按升序进行排序。数组中的所有元素都必须实现 Comparable接口 
 *
 */

package eg.oop.comparatorDemo_4;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        Student[] stus = new Student[5];//保存学生信息的数组
        stus[0]=new Student("aa",20,80);
        stus[1]=new Student("bb",22,78);
        stus[2]=new Student("cc",18,90);
        stus[3]=new Student("dd",25,82);
        stus[4]=new Student("ee",24,81);
        System.out.println("排序前:");
        for (Student student : stus) {
            System.out.println(student);
        }
        Arrays.sort(stus);
        System.out.println("排序后:");
        for (Student student : stus) {
            System.out.println(student);
        }

    }
}
