/*
 *  猜拳游戏 
 *  编写一个猜拳游戏，进入新游戏需要输入用户的昵称，
 *  选择对手（对手随机出拳），然后进行游戏，
 *  游戏可以多局的形式，游戏中胜利分数加1，平局和输了不加分不减分，
 *  游戏结束告知游戏中的成绩返回游戏主界面，
 *  用户可以通过排行榜查看前10的分数（需要排序），
 *  通过退出可以结束游戏。
 *  
 */

package MorraGame;

import java.util.Scanner;

public class MorraGame {
	public static void main(String[] args) {
		// 定义变量
		boolean isTurn = false;  //判断是否重新输入
		String user = "";  //用户
		String computer = "";  //计算机
		String answer = "";  //保存重新输入的y/n
		int[] score = {2,6,4,9,0};
		int index=4;
		int win = 0;  //声明获得胜利的场数
		int num = 0;  //用户选择的游戏项
		int computerNum = 0;  //选择对手
		int punchesUser = 0;  //用户的出拳数字
		int punchesComputer = 0;  //计算机的出拳数字
		Scanner in = new Scanner(System.in);  //获取输入
		
		do{
			// 主界面
			System.out.println("**********猜拳游戏**********");
			System.out.println("1.新游戏");
			System.out.println("2.英雄排行榜");
			System.out.println("0.返回");
			System.out.println("***************************");
			System.out.println("====>请输入选项(0-2)");
			
			//判断用户选择界面输入是否正确
			num = in.nextInt();  //获取用户选择的游戏项
			while(num<0 || num>2){
				System.out.print("您的输入不正确，请重新输入：");
				num = in.nextInt();
			}
			
			//选择游戏类型
			switch(num){
				//新游戏 
				case 1:
					System.out.println("新游戏 ");
					System.out.print("请输入您的昵称：");
					user = in.next();  //获取用户的昵称
					System.out.println("您的昵称是：" + user + "\n");
					
					//开始游戏
					System.out.print("请选择您的对手（1.孙权    2.曹操   3.刘备）：");
					computerNum = in.nextInt();  //获取您将要选择的计算机角色
					while(computerNum<=0 || computerNum>=4){
						System.out.print("您的输入不正确，请重新输入：");
						computerNum = in.nextInt();
					}
					
					//判断角色，并输出角色名称
					switch(computerNum){
			            case 1:
			            	computer="孙权";
			                break;
			            case 2:
			            	computer="曹操";
			                break;
			            case 3:
			            	computer="刘备";
			                break;
			            default:
			            	break;
		            }
					System.out.println("您选择的角色是：" + computer + "\n");
					
					//出拳
					System.out.println(user + "  VS  " + computer);
					System.out.println("请出拳（1.剪刀    2.石头   3.布  0:退出）");
					
					//保存用户出拳
					punchesUser = in.nextInt();
					while(punchesUser<1 || punchesUser>3){
						if(punchesUser == 0){
							System.out.println("程序结束！");
							break;
						}
						System.out.print("您的输入不正确，请重新输入：");
						punchesUser = in.nextInt();
					}
					
					//判断
					while(punchesUser!=0 && punchesUser<4){
						punchesComputer = (int)(Math.random()*3+1); //保存计算机出拳
						//用户出拳
						switch (punchesUser){
				        	case 1:
				        		System.out.println("你出的:剪刀！");
				        		break;
				        	case 2:
				        		System.out.println("你出的:石头！");
				        		break;
				        	case 3:
				        		System.out.println("你出的:布！");
				        		break;
						}
						
						//计算机出拳
						switch (punchesComputer){
							case 1:
						        System.out.println("电脑出的:剪刀！");
						        break;
							case 2:
						        System.out.println("电脑出的:石头！");
						        break;
							case 3:
						        System.out.println("电脑出的:布！");
						        break;
						}
						
						//判断
						/**
						 * 原理
						 *     {计算机[C](punchesComputer)}  {用户[U](punchesUser)}      {胜  负}     {计算机-用户[C-U]}     {用户-计算机[U-C]}
						 *      1 ==> (剪刀)                  1 ==> (剪刀)                 平                  0                     0
						 *      1 ==> (剪刀)                  2 ==> (石头)               用户赢              -1                     1
						 *      1 ==> (剪刀)                  3 ==> (布)                计算机赢            -2                     2
						 *      2 ==> (石头)                  1 ==> （剪刀）                          计算机赢              1                    -1
						 *      2 ==> (石头)                  2 ==> (石头)                 平                   0                     0
						 *      2 ==> (石头)                  3 ==> (布)                 用户赢              -1                     1
						 *      3 ==> (布)                    1 ==> (剪刀)               用户赢                2                    -2
						 *      3 ==> (布)                    2 ==> (石头)              计算机赢               1                    -1
						 *      3 ==> (布)                    3 ==> (布)                   平                   0                     0
						 *      
						 *      得出结论，当计算机赢时：C-U=-2(U-C=2) 或 C-U=1 即 punchesComputer-punchesUser==1 || punchesUser-punchesComputer==2
						 *      		 当用户赢时：   C-U=-1(U-C=1) 或 C-U=2 即 punchesComputer-punchesUser==2 || punchesUser-punchesComputer==1
						 *      		 当平局时：       C-U=0
						 */
						if(punchesUser == punchesComputer){
						     System.out.println("平！");
						}else if(punchesComputer-punchesUser==1 || punchesUser-punchesComputer==2){
							System.out.println("电脑赢了！");
						}else if(punchesComputer-punchesUser==2 || punchesUser-punchesComputer==1){
						     System.out.println("你赢了！");
						     win++;
						}
						
						//重新出拳
						System.out.println("请出拳（1.剪刀    2.石头   3.布  0:退出）");
						punchesUser = in.nextInt();
					}
					
					//统计赢的次数
					System.out.println("赢了:" + win + "次！");
					
					break;
				//英雄排行榜
				case 2:
					System.out.println("英雄排行榜 ");
					score[index]=win;
					//N个数比较的轮数为N-1
					for(int i=0; i<score.length-1; i++){
						//每一轮比较的次数为N-1-i次
						for(int j=0; j<score.length-1-i; j++){
							//比较相邻的两个数
							if(score[j]<score[j+1]){
								//两个数交换，通过临时变量
								int temp = score[j];
								score[j] = score[j+1];
								score[j+1] = temp;
							}
						}
					}
					//把排好序的数组输出
					for(int j=0; j<score.length; j++){
						System.out.println("得分：\t" + score[j]);
					}
					
					break;
				//程序结束
				default:
					//程序结束
					System.out.println("程序结束");
					break;
			}  //switch结束
			
			//switch跳出之后直接到这里循环
			System.out.println("是否返回主界面?(y/n)");
			answer = in.next();

			if (answer.equals("y")){  //“==”比较两个变量本身的值，即两个对象在内存中的首地址；“equals()”比较字符串中所包含的内容是否相同。
				isTurn=true;
			}else {
				isTurn=false;
			}
		}while(isTurn);
		
		//关闭键盘
		in.close();
		
		//程序结束
		System.out.println("游戏结束了，你回家吧");
	}
}
