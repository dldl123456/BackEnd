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
            student.name = "־��" + i;
            if (i % 2 == 0) {
                student.sex = "Ů";
            } else {
                student.sex = "��";
            }
            student.math = 60 + i;
            student.computer = 70 + 3 * i;
            if (school.addStudent(student)) {
                System.out.println(student.name + "ע��ɹ�");
            } else {
                System.out.println(student.name + "ע��ʧ��");
            }
        }
        while (true) {
            System.out.println("********************");
            System.out.println("���ѧ���밴1||��ӡ��Ϣ�밴2||��ӡѧ��������3||ɾ��ѧ���밴4");
            System.out.println("********************");
            int num = in.nextInt();
            if (num == 1) {
                Student s = new Student();
                System.out.println("������������");
                s.name = in.next();
                System.out.println("���������䣺");
                s.age = in.nextInt();
                System.out.println("�������Ա�");
                s.sex = in.next();
                System.out.println("��������ѧ�ɼ���");
                s.math = in.nextInt();
                System.out.println("�����������ɼ���");
                s.computer = in.nextInt();
                school.addStudent(s);
            } else if (num == 2) {
                school.print();
            } else if (num == 3) {
                school.printCount();
            } else if (num == 4) {
                System.out.println("********************");
                System.out.println("������ɾ�����밴1||�����Ա�ɾ���밴2");
                System.out.println("********************");
                int delNum = in.nextInt();
                switch (delNum) {
                case 1:
                    System.out.println("����");
                    school.delStudentByName(in.next());
                    break;

                case 2:
                    System.out.println("�Ա�");
                    school.delStudentBySex(in.next());
                    break;
                default:
                    break;
                }
            }
        }
    }
}
