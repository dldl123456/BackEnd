package project.MorraGame_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * 人机猜拳
 * @author ASUS
 *
 */
@SuppressWarnings("unused")
public class Login {
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {
		String answer=null;//声明是否继续的接收answer 
		boolean choice=false;
		int winner=0;
		User user=new User();//实例化User对象;
	    List< Integer> first = new ArrayList<Integer>(); //胜利数 
	    first.add(5);
	    first.add(18);
	    first.add(3);
	    first.add(11);
		do {
			/*程序主界面*/
			System.out.println("人VS电脑,猜拳游戏~~!");
			System.out.println("********************");
			System.out.println("1.新游戏");
			System.out.println("2.英雄排行榜");
			System.out.println("0.返回");
			System.out.println("********************");
			System.out.println("====>请输入选项(0-2)");
			Scanner input=new Scanner(System.in);//扫描器实例化
			int number=input.nextInt();
			/*开始判断*/
			switch (number) {
			case 1:
				do {
					System.out.println("请输入您的昵称");
					user.setUser(input.next());
					System.out.println("请输入您的对手  1.孙权    2.曹操   3.刘备");
					user.setOpponent(input.next());//接收用户输入的对手名
					do {
						System.out.println("请用户出拳"+"1.剪刀  2.石头  3布");
						boolean istrue=input.hasNextInt();//判断是否为数字
						while (!istrue) {//不是数字进入
							String str =  input.next();
							System.out.println("您输入的是:"+str+"臣妾做不到啊！");
							System.out.println("请重新出拳+"+"1.剪刀  2.石头  3布");
							istrue=input.hasNextInt();//判断是否为数字,如果不是，继续循环
						}
						number=input.nextInt();//取出数字
						while (number>3||number<0) {
							System.out.println("您输入的格式,不符合您的口味哦");
							System.out.println("请重新输入："+"请用户出拳"+"1.剪刀  2.石头  3布");
							number=input.nextInt();//判断是否在1~3内,否则继续循环
						}
						int computer=new Random().nextInt(3)+1;//计算机自动返回值(1-3)
						first=Filtering_Method.getlist(first, number, winner, computer, user);
						System.out.println("是否继续游戏(y/n)");
						answer=input.next();//接收用户输入是否需要继续游戏
						if (answer.equals("y")) {
							choice=true;
						}else {
							choice=false;
						}
					} while (choice);
					System.out.println(winner);
				} while (choice);
				
				break;
			case 2:
				/**
				 * 显示排行榜
				 */
				try {
					Collections.sort(first);
					System.out.println("排行榜如下：");
		        for (int i = first.size()-1; i >=0; i--) {
					System.out.println(first.get(i));
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				break;
			case 0:
				System.out.println("程序结束");
				return;
				
			default:
				System.out.println("您输入有误！");
				break;
			}
			System.out.println("是否需要返回游戏界面(y/n)");
			answer=input.next();
			if (answer.equals("y")) {
				choice=true;
			}else {
				choice=false;
			}
		} while (choice);
		System.out.println("程序结束");
	}
}
