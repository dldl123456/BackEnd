package common;

import arrays.StudentArr;
import test.Page;

//排行榜
public class RankingList {
	public static void rankingList(int num) {		
		double[] sum = new double[StudentArr.stuu.length];
		String[] st = new String[StudentArr.stuu.length];//学生姓名
		//把所有学生的总成绩存到一个数组里
		for(int i=0;i<StudentArr.stuu.length;i++) {
			switch(num) {
			case 1:
				sum[i]=StudentArr.stuu[i].getSum();
				break;
			case 2:
				sum[i]=StudentArr.stuu[i].getChiness();
				break;
			case 3:
				sum[i]=StudentArr.stuu[i].getMath();
				break;
			case 4:
				sum[i]=StudentArr.stuu[i].getEnglish();
				break;
			default:
				System.exit(0);
				break;
			}
			st[i]=StudentArr.stuu[i].getName();
		}
		for(int x=0;x<sum.length-1;x++) {
			for(int y=0;y<sum.length-x-1;y++) {
				if(sum[y]<sum[y+1]) {
					double n = sum[y];
					String ss = st[y];
					sum[y] =sum[y+1];
					st[y] =st[y+1];
					sum[y+1]=n;
					st[y+1] = ss;
				}
			}
		}
		for(int i=0;i<StudentArr.stuu.length;i++) {
			System.out.println(st[i]+"\t\t"+sum[i]+"\t\t"+"第"+(i+1)+"名");
		}
	}
	/**
	 * 查看排行榜方法
	 */
	public static void sayRankingList() {
		a:while(true) {
			System.out.println("请输入您要查看的排行榜序号：");
			System.out.print("【1】、总成绩排行榜\t\t【2】、语文成绩排行榜\t\t【3】、数学成绩排行榜\t\t【4】、英语成绩排行榜\n");
			/**
			 * 处理输入异常
			 */
			int num = 0;
			num =HandleInputMismatchException.handleInputMismatchException(num);
			switch(num) {
			case 1:
				System.out.println("本次考试总成绩排行如下");
				System.out.println("姓名"+"\t\t"+"成绩"+"\t\t"+"排名");
				rankingList(1);	
				break;
			case 2:
				System.out.println("本次考试语文成绩排行如下");
				System.out.println("姓名"+"\t\t"+"成绩"+"\t\t"+"排名");
				rankingList(2);				
				break;
			case 3:
				System.out.println("本次考试数学成绩排行如下");
				System.out.println("姓名"+"\t\t"+"成绩"+"\t\t"+"排名");
				rankingList(3);				
				break;
			case 4:
				System.out.println("本次考试英语成绩排行如下");
				System.out.println("姓名"+"\t\t"+"成绩"+"\t\t"+"排名");
				rankingList(4);				
				break;
			default:
				System.out.println("您输入的指令有误，请重新输入：");
				continue a;
			}
			System.out.println("请选择下一步操作：");
			System.out.print("【1】、查看其它成绩排行榜\t\t【2】、返回上一步\t\t【3】、返回主页面\t\t【4】、退出系统\n");
			next();
			break;
		}
	}
	private static int next() {
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			sayRankingList();
			break;
		case 2:
			Page.loginSuccess();
			break;
		case 3:
			Page.homePage();
			break;
		case 4:
			Page.exit();
			break;
		default:
			System.out.println("您输入的指令有误，请重新输入：");
			next();
		}
		return choose;
	}
}
