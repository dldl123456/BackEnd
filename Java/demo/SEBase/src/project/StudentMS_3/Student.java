package project.StudentMS_3;

public class Student {
    int age;
    String name;
    String sex;

    double math;
    double computer;

    double sum() {
        return math + computer;
    }

    double average() {
        return (math + computer) / 2;
    }

    void speak() {
        System.out.println("������" + name);
        System.out.println("�Ա�" + sex);
        System.out.println("���䣺" + age);
        System.out.println("��ѧ��" + math);
        System.out.println("�������" + computer);
        System.out.println("�ܷ֣�" + sum());
        System.out.println("ƽ���֣�" + average());
    }
}