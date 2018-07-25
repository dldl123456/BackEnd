/*
 *  登录注册
 */

package eg.fn.reglog_2;

import java.util.Scanner;
public class Reglog {
private static String loginName="",pwd="";//loginName用来存储注册的登录名，pwd用来存储注册的密码
private static Scanner input = new Scanner(System.in);
//注册时输入密码的方法
private static void inputPWD(){
String upwd,rpwd;
System.out.print("请输入密码：");
upwd = input.next();
System.out.print("请输入确认密码：");
rpwd=input.next();
if (!upwd.equals(rpwd)) {
System.out.println("密码和确认密码不一致，请重新输入！\n");
inputPWD();
}else {
System.out.println("注册成功！");
pwd = upwd;
}
}
//注册用户名和密码的方法
private static void region(){
System.out.print("请输入用户名：");
loginName = input.next();
inputPWD();
}
//登陆的方法
private static void loign(){
String lname,lpwd;
System.out.print("请输入用户名：");
lname=input.next();
System.out.print("请输入密码：");
lpwd=input.next();
if (lname.equals(loginName)&&lpwd.equals(pwd)) {
System.out.println("登陆成功！");
}else{
System.out.println("用户名或密码错误，请重新输入！\n");
loign();
}
}
//显示选择菜单的方法
private static void showMenu(){
System.out.println("1.用户注册");
System.out.println("2.用户登陆");
System.out.println("3.退出系统");
System.out.print("请输入你的选择：");
String choose = input.next();
if (choose.equalsIgnoreCase("1")) {
region();
System.out.println("");
showMenu();
}else if (choose.equalsIgnoreCase("2")) {
if (loginName.equalsIgnoreCase("")) {
System.out.print("没有用户，请先注册！\n\n");
showMenu();
}else{
loign();
}
}else if(choose.equalsIgnoreCase("3")){
System.out.println("系统退出成功！");
}else {
System.out.println("非法输入！\n");
showMenu();
}
}
public static void main(String[] args) {
showMenu();
}
}
