package demo.oop.sleep;

public class Sleep2 {
	//有一个会让人睡觉的东西
	void sleepSth(SplleWay slp){
		slp.speepWay();
    }
	
	//主方法（程序入口）
	public static void main(String[] args) {
		SplleWay01 slpy1 = new SplleWay01();  //实例化第一种睡觉方法类，创建slpy1对象
		SplleWay02 slpy2 = new SplleWay02();  //实例化第二种睡觉方法类，创建slpy2对象
		SplleWay03 slpy3 = new SplleWay03();  //实例化第三种睡觉方法类，创建slpy3对象
		
        Sleep2 slp2 = new Sleep2();  //实例化睡觉类，创建slp2对象
        
        //调用会让人睡觉的方法
        slp2.sleepSth(slpy1);
        slp2.sleepSth(slpy2);
        slp2.sleepSth(slpy3);
	}
}

//一个描述睡觉的接口接口
interface SplleWay {
	//声明抽象方法
	public void speepWay();
}

//第一种睡觉方法类调用接口
class SplleWay01 implements SplleWay {
	//对接口中的抽象方法进行具体实现
  public void speepWay() {
      System.out.println("我要侧着睡");
  }
}

//第二种睡觉方法类调用接口
class SplleWay02 implements SplleWay {
	//对接口中的抽象方法进行具体实现
	public void speepWay() {
		System.out.println("我要仰着睡");
  }
}

//第二种睡觉方法类调用接口
class SplleWay03 implements SplleWay {
	//对接口中的抽象方法进行具体实现
	public void speepWay() {
		System.out.println("我想怎么睡就怎么睡");
	}
}