package eg.fn.reglog_1;

import java.util.Scanner;

public class UserLoginRegisterApp {

    public static final int maxUserNums = 3;// 设置最大用户数

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        // 初始化一个长度为3的UserData对象的数组
        UserDataArray userDataArray = new UserDataArray(maxUserNums);

        while (true) {
            System.out.println("欢迎来到乌托邦！");
            System.out.println("1.注册\t2.登陆\t3.退出");
            System.out.print("请选择你的操作:");

            Scanner scUserInput = new Scanner(System.in);
            String userOerator = scUserInput.nextLine();

            switch (userOerator) {
            case "1":// 注册环节
                if (userDataArray.getUserNums() == maxUserNums) {
                    System.out.println("不好意思，注册名额已经注册满了！");
                    System.out.println("现在将转向主界面！");
                } else {
                    UserData userData = new UserData();
                    System.out.print("请输入用户名:");
                    String userName = scUserInput.nextLine();
                    System.out.print("请输入密码:");
                    String userPwd = scUserInput.nextLine();
                    userData.setUsername(userName);
                    userData.setPassword(userPwd);

                    if (!userDataArray.findUserData(userData)) {
                        userDataArray.insertUserData(userData);
                        System.out.println("恭喜你注册成功！现在请重新登陆下！");
                    } else {
                        System.out.println("该用户已存在，请登陆或者更换用户名");
                    }

                    System.out.println("现在跳转到主界面。。。。");
                }
                break;

            case "2":// 登陆环节
                UserData userData = new UserData();
                System.out.print("请输入用户名:");
                String userName = scUserInput.nextLine();
                System.out.print("请输入密码:");
                String userPwd = scUserInput.nextLine();
                userData.setUsername(userName);
                userData.setPassword(userPwd);

                if (userDataArray.findUserData(userData)) {
                    System.out.println("恭喜登陆成功，开始尽情享受屌丝生活吧！");
                    System.exit(0);
                } else {
                    System.out.println("用户名和密码不匹配，请重新登陆或注册！");
                    System.out.println("现在跳转到主界面。。。。");
                }
                break;

            case "3":
                System.out.println("你确定要退出么？y or n?");
                String userChoose = scUserInput.nextLine();
                if ("y".equals(userChoose)) {
                    System.out.println("既然你决心离去，我也不好挽留！！！");
                    System.exit(0);
                } else {
                    System.out.println("我知道你是选错了。。。。");
                    System.out.println("请重新做出你的选择！！！！");
                }
                break;
            default:
                System.out.println("你输入了非法字符，我崩溃了！！！！！");
                System.exit(-1);
                break;
            }
        }
    }

}
