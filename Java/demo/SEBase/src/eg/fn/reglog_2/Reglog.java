/*
 *  ��¼ע��
 */

package eg.fn.reglog_2;

import java.util.Scanner;
public class Reglog {
private static String loginName="",pwd="";//loginName�����洢ע��ĵ�¼����pwd�����洢ע�������
private static Scanner input = new Scanner(System.in);
//ע��ʱ��������ķ���
private static void inputPWD(){
String upwd,rpwd;
System.out.print("���������룺");
upwd = input.next();
System.out.print("������ȷ�����룺");
rpwd=input.next();
if (!upwd.equals(rpwd)) {
System.out.println("�����ȷ�����벻һ�£����������룡\n");
inputPWD();
}else {
System.out.println("ע��ɹ���");
pwd = upwd;
}
}
//ע���û���������ķ���
private static void region(){
System.out.print("�������û�����");
loginName = input.next();
inputPWD();
}
//��½�ķ���
private static void loign(){
String lname,lpwd;
System.out.print("�������û�����");
lname=input.next();
System.out.print("���������룺");
lpwd=input.next();
if (lname.equals(loginName)&&lpwd.equals(pwd)) {
System.out.println("��½�ɹ���");
}else{
System.out.println("�û���������������������룡\n");
loign();
}
}
//��ʾѡ��˵��ķ���
private static void showMenu(){
System.out.println("1.�û�ע��");
System.out.println("2.�û���½");
System.out.println("3.�˳�ϵͳ");
System.out.print("���������ѡ��");
String choose = input.next();
if (choose.equalsIgnoreCase("1")) {
region();
System.out.println("");
showMenu();
}else if (choose.equalsIgnoreCase("2")) {
if (loginName.equalsIgnoreCase("")) {
System.out.print("û���û�������ע�ᣡ\n\n");
showMenu();
}else{
loign();
}
}else if(choose.equalsIgnoreCase("3")){
System.out.println("ϵͳ�˳��ɹ���");
}else {
System.out.println("�Ƿ����룡\n");
showMenu();
}
}
public static void main(String[] args) {
showMenu();
}
}
