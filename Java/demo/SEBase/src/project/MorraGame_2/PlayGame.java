/*** 
 * @author 叶子竹 
 * @本程序是一个人机互动猜拳小游戏 
 */  

package project.MorraGame_2;

import java.util.InputMismatchException;  
import java.util.Scanner; 

public class PlayGame {
	public static void main(String[] args){  
        int juese;  
        int i;//i表示玩家出拳的数字  
        Game g=new Game();  
        g.init();  
        System.out.print("************************************\n");  
        System.out.print("**         欢迎进入猜拳游戏                 ***\n");  
        System.out.print("************************************\n");  
        System.out.println("出拳规则：1.剪刀  2.石头  3.布\n");  
        System.out.println("请选择角色：1.刘备  2.孙权  3.曹操");  
        Scanner input=new Scanner(System.in);  
        try{  
        juese=input.nextInt();  
        while(juese!=1&&juese!=2&&juese!=3){//输入内容必须是一个1~3的整数，否则重新输入  
            System.out.println("输入的内容应该是一个1~3的整数，请重新输入！");  
            juese=input.nextInt();  
        }  
        g.computerPlayer(juese);  
        System.out.println("请输入您的姓名：");  
        g.user(input.next());  
        System.out.println("出拳：（输入0退出）");  
        i=input.nextInt();  
        while(i!=0){//若用户不输入0，执行循环体，一直玩游戏  
            g.chuquan(i);  
            g.jisuan();  
            System.out.println("\n出拳：（输入0退出）");  
            i=input.nextInt();  
        }  
        System.out.println("游戏结束！");  
        g.result();  
        }catch(InputMismatchException e){  
            System.out.println("程序运行出错：输入非法字符！");  
        }finally{  
            System.out.println("\n谢谢使用！");  
        }  
        input.close();  
    }  
}
