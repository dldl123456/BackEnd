package view;

import contro.HallContro;
import util.Help;

/**
 * 
 * @param 影厅界面
 * @author zmx2321
 * 
 */

public class HallView {
	private static boolean flag = true;  //用于判断是否跳出循环
	
	public static void hallMune(){
		System.out.println("欢迎进入影厅管理界面：");
		
		do{
			System.out.println("*********************");
			System.out.println("1:查看全部影厅");
			System.out.println("2:添加影厅");
			System.out.println("3:删除影厅");
			System.out.println("0:返回");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n请输入您需要的操作：");
			
			switch (ops){
				case 1:
					System.out.println("查看全部影厅：\n");
					HallContro.queryHall();
					
					break;
				case 2: 
					System.out.println("添加影厅：\n");
					HallContro.addHall();
					
					break;
				case 3: 
					System.out.println("删除影厅：\n");
					HallContro.deleteHall();
					
					break;
				case 0:
					System.out.println("返回\n");
					flag = false;
					
					break;
				default:
					System.out.println("输入错误,没有该选项\n");
					
					break;
			}
		}while(flag);
	}
	
	//test
	public static void main(String[] args) {
		hallMune();
	}
}
