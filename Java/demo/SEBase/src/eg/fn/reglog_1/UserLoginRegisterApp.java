package eg.fn.reglog_1;

import java.util.Scanner;

public class UserLoginRegisterApp {

    public static final int maxUserNums = 3;// ��������û���

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        // ��ʼ��һ������Ϊ3��UserData���������
        UserDataArray userDataArray = new UserDataArray(maxUserNums);

        while (true) {
            System.out.println("��ӭ�������а");
            System.out.println("1.ע��\t2.��½\t3.�˳�");
            System.out.print("��ѡ����Ĳ���:");

            Scanner scUserInput = new Scanner(System.in);
            String userOerator = scUserInput.nextLine();

            switch (userOerator) {
            case "1":// ע�ỷ��
                if (userDataArray.getUserNums() == maxUserNums) {
                    System.out.println("������˼��ע�������Ѿ�ע�����ˣ�");
                    System.out.println("���ڽ�ת�������棡");
                } else {
                    UserData userData = new UserData();
                    System.out.print("�������û���:");
                    String userName = scUserInput.nextLine();
                    System.out.print("����������:");
                    String userPwd = scUserInput.nextLine();
                    userData.setUsername(userName);
                    userData.setPassword(userPwd);

                    if (!userDataArray.findUserData(userData)) {
                        userDataArray.insertUserData(userData);
                        System.out.println("��ϲ��ע��ɹ������������µ�½�£�");
                    } else {
                        System.out.println("���û��Ѵ��ڣ����½���߸����û���");
                    }

                    System.out.println("������ת�������档������");
                }
                break;

            case "2":// ��½����
                UserData userData = new UserData();
                System.out.print("�������û���:");
                String userName = scUserInput.nextLine();
                System.out.print("����������:");
                String userPwd = scUserInput.nextLine();
                userData.setUsername(userName);
                userData.setPassword(userPwd);

                if (userDataArray.findUserData(userData)) {
                    System.out.println("��ϲ��½�ɹ�����ʼ�������܌�˿����ɣ�");
                    System.exit(0);
                } else {
                    System.out.println("�û��������벻ƥ�䣬�����µ�½��ע�ᣡ");
                    System.out.println("������ת�������档������");
                }
                break;

            case "3":
                System.out.println("��ȷ��Ҫ�˳�ô��y or n?");
                String userChoose = scUserInput.nextLine();
                if ("y".equals(userChoose)) {
                    System.out.println("��Ȼ�������ȥ����Ҳ��������������");
                    System.exit(0);
                } else {
                    System.out.println("��֪������ѡ���ˡ�������");
                    System.out.println("�������������ѡ�񣡣�����");
                }
                break;
            default:
                System.out.println("�������˷Ƿ��ַ����ұ����ˣ���������");
                System.exit(-1);
                break;
            }
        }
    }

}
