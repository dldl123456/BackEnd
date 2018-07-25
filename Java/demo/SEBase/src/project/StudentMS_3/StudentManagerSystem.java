package project.StudentMS_3;

import java.util.Scanner;

public class StudentManagerSystem {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        School school = new School();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.age = 18 + i;
            student.name = "志玲" + i;
            if (i % 2 == 0) {
                student.sex = "女";
            } else {
                student.sex = "男";
            }
            student.math = 60 + i;
            student.computer = 70 + 3 * i;
            if (school.addStudent(student)) {
                System.out.println(student.name + "注册成功");
            } else {
                System.out.println(student.name + "注册失败");
            }
        }
        while (true) {
            System.out.println("********************");
            System.out.println("添加学生请按1||打印信息请按2||打印学生数量请3||删除学生请按4");
            System.out.println("********************");
            int num = in.nextInt();
            if (num == 1) {
                Student s = new Student();
                System.out.println("请输入姓名：");
                s.name = in.next();
                System.out.println("请输入年龄：");
                s.age = in.nextInt();
                System.out.println("请输入性别：");
                s.sex = in.next();
                System.out.println("请输入数学成绩：");
                s.math = in.nextInt();
                System.out.println("请输入计算机成绩：");
                s.computer = in.nextInt();
                school.addStudent(s);
            } else if (num == 2) {
                school.print();
            } else if (num == 3) {
                school.printCount();
            } else if (num == 4) {
                System.out.println("********************");
                System.out.println("按姓名删除添请按1||按照性别删除请按2");
                System.out.println("********************");
                int delNum = in.nextInt();
                switch (delNum) {
                case 1:
                    System.out.println("姓名");
                    school.delStudentByName(in.next());
                    break;

                case 2:
                    System.out.println("性别");
                    school.delStudentBySex(in.next());
                    break;
                default:
                    break;
                }
            }
        }
    }
}
