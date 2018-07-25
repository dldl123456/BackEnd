package demo.oop.sleep;

import java.util.Scanner;

public class Sleep {
	public static void main(String[] args) {	
		int n = (int)(Math.random()*3+1);
		
		switch(n){
			case 1:
				SleepProcess slp1 = new SleepWay1();
				slp1.beginSleep();
				slp1.sleeping();
				slp1.doomsday();
			case 2:
				SleepProcess slp2 = new SleepWay2();
				slp2.beginSleep();
				slp2.sleeping();
				slp2.doomsday();
			case 3:
				SleepProcess slp3 = new SleepWay3();
				slp3.beginSleep();
				slp3.sleeping();
				slp3.doomsday();
		}
	}
}

abstract class SleepProcess{
	public int n = 0;  //你的小羊
	public int i;  //我是一个小循环
	public int myRadom;  //随机
	
	@SuppressWarnings("resource")
	public void beginSleep(){
		System.out.println("哇咔咔，我要睡觉了，我的被窝想我了");
		System.out.println("==*  一个被窝和枕头的故事   *== \n");
		System.out.print("嗯……数几只羊好呢？  ");
		
		//到底几只羊了
		myRadom = (int)(Math.random()*5+1);
		
		//你要干什么
		Scanner in = new Scanner(System.in);
		n = in.nextInt() + myRadom;
		
		for(i=0; i<n; i++){
			if(i<n-1){
				System.out.print((i+1) + "只羊" + ",");
			}else{
				System.out.print((i+1) + "只羊…………\n");
			}
		}
		System.out.println("\n（模糊眼）好像不太对，重新数吧。。。");
		System.out.println("呼噜噜，呼噜噜Zzzz");
		System.out.println("Zzzz");
		System.out.println("Zz..");
		System.out.println("......\n");
	}
	
	//声明睡觉方法
	public abstract void sleeping();
	
	@SuppressWarnings("resource")
	public void doomsday(){
		String answer = "";  //y/n
		
		System.out.println("\n^*)%$@~");
		System.out.println("什么？要起床！\n");
		System.out.println("#$!/*+#%&");
		System.out.println("纳尼，卧槽，什么，世界末日了\n");
		System.out.println("…………………………");
		System.out.println("可是宝宝还想睡，宝宝不想起床\n");
		System.out.print("//*-&(翻译：到底起不起床) y/n：  ");
		
		Scanner in = new Scanner(System.in);
		answer = in.nextLine();
		
		if(answer.equals("n")){
			System.out.println("\n(决心脸)我要睡到天长地久，我要睡到海枯石烂！");
			System.out.println("呼噜噜，呼噜噜Zzz..");
			System.out.println("...............\n");
			System.out.println("嘭！！!!!");
			System.out.println("end~   ^_^");
		}else{
			System.out.println("\n(慌张脸)救命啊，救命啊，世界末日啦！！！");
			System.out.println("...............\n");
			System.out.println("嘭！！!!!");
			System.out.println("end~   ^_^");
		}
		
		System.out.println("------------------------------------\n");
		
		return;
	}
	
	//睡觉睡觉
	public void sleep(){
		//开始睡觉啦
		beginSleep();
		//你想怎么睡就怎么睡
		sleeping();
		//宝宝不想起床
		doomsday();
	}
}

//侧着睡
class SleepWay1 extends SleepProcess{
	public void sleeping(){
		System.out.println("我要侧着睡");
		System.out.println("敖！搁到肩膀了");
		System.out.println("呼呼……");
	}
}

//仰着睡
class SleepWay2 extends SleepProcess{
	public void sleeping(){
		System.out.println("我要仰着睡");
		System.out.println("面壁思过ing……");
		System.out.println("我在修行，练气，不，已经化神了");
	}
}

//我想怎么睡就怎么睡
class SleepWay3 extends SleepProcess{
	public void sleeping(){
		System.out.println("我想怎么睡就怎么睡");
		System.out.println("闭关修炼ing");
		System.out.println("嗯哼……好爽");
	}
}