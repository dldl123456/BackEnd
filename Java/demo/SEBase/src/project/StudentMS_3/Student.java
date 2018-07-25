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
        System.out.println("姓名：" + name);
        System.out.println("性别：" + sex);
        System.out.println("年龄：" + age);
        System.out.println("数学：" + math);
        System.out.println("计算机：" + computer);
        System.out.println("总分：" + sum());
        System.out.println("平均分：" + average());
    }
}