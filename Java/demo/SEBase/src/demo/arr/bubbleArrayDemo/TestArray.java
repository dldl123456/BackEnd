/*
 * 按照年龄进行排序,冒泡
 * N个数字来排队，两两比较小靠前，
 * 外层循环N-1(需要比较的轮数)
 * 内存循环N-1-i(每轮需要比较的次数)
 */

package demo.arr.bubbleArrayDemo;

public class TestArray {
    public static void sort(Student[] stus){
        for(int i=0;i<stus.length-1;i++){
            for(int j=0;j<stus.length-1-i;j++){
                //先从学生对象中获取该学生的年龄
                if(stus[j].getAge()>stus[j+1].getAge()){
                    //交换位置
                    Student temp=stus[j];
                    stus[j]=stus[j+1];
                    stus[j+1]=temp;
                }
            }
        }
    }
    
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
        sort(stus);//排序
        System.out.println("排序后:");
        for (Student student : stus) {
            System.out.println(student);
        }
    }
}
