/*
 * ���������������,ð��
 * N���������Ŷӣ������Ƚ�С��ǰ��
 * ���ѭ��N-1(��Ҫ�Ƚϵ�����)
 * �ڴ�ѭ��N-1-i(ÿ����Ҫ�ȽϵĴ���)
 */

package demo.arr.bubbleArrayDemo;

public class TestArray {
    public static void sort(Student[] stus){
        for(int i=0;i<stus.length-1;i++){
            for(int j=0;j<stus.length-1-i;j++){
                //�ȴ�ѧ�������л�ȡ��ѧ��������
                if(stus[j].getAge()>stus[j+1].getAge()){
                    //����λ��
                    Student temp=stus[j];
                    stus[j]=stus[j+1];
                    stus[j+1]=temp;
                }
            }
        }
    }
    
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
        sort(stus);//����
        System.out.println("�����:");
        for (Student student : stus) {
            System.out.println(student);
        }
    }
}
