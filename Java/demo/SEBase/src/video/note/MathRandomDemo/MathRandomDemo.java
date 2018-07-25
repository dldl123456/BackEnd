package video.note.MathRandomDemo;

import java.util.Random;

public class MathRandomDemo {
	public static void main(String[] args) {
		//Math
		System.out.println(Math.floor(10.55));  //返回最大的double值，该值小于等于参数，并等于某个整数
		System.out.println(Math.ceil(-10.55));  //向上取整(比他大的第一个整数，再转化成double类型)
		System.out.println(Math.pow(2, 3));  //2的3次方
		System.out.println(Math.round(10.6));  //四舍五入
		System.out.println(Math.random());  //0-1之间的随机数
		
		//Random
		Random random1 = new Random();
		System.out.println(random1.nextInt());  //在整数区间里面取随机数
		
		Random random2 = new Random(10);  //Random(10)中10是种子，所以每次结果都一样
		System.out.println(random2.nextInt());
		
		Random random3 = new Random(System.currentTimeMillis());  //种子是毫秒数的话，也不一样，毫秒数随时在变
		System.out.println(random3.nextInt());  //在整数区间里面取随机数
		
		Random random4 = new Random();
		System.out.println(random4.nextInt(5));  //在0-4之间产生随机数
		
		Random random5 = new Random();
		System.out.println(random5.nextBoolean());  //true和false随机
		
		Random random6 = new Random();
		System.out.println(random6.nextFloat());
		System.out.println(random6.nextDouble());
	}
}
