package view;

import contro.TicketContro;
import util.Help;

/**
 * 
 * @param 影票界面
 * @author zmx2321
 * 
 */

public class TicketView {
	private static boolean flag = true;  //用于判断是否跳出循环
	
	public static void ticketMune(){
		System.out.println("欢迎进入订单管理界面：");
		
		do{
			System.out.println("*********************");
			System.out.println("1:查看全部影票");
			System.out.println("2:添加影票");
			System.out.println("3:删除影票");
			System.out.println("0:返回");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n请输入您需要的操作：");
			
			switch (ops){
				case 1:
					System.out.println("查看全部影票：\n");
					TicketContro.queryTicket();
					
					break;
				case 2: 
					System.out.println("添加影票：\n");
					TicketContro.addTicket();
					
					break;
				case 3: 
					System.out.println("删除影票：\n");
					TicketContro.deleteTicket();
					
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
		ticketMune();
	}
}
