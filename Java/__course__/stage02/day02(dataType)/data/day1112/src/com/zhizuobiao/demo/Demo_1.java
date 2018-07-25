package com.zhizuobiao.demo;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//大转小会损失精度
		byte a=(byte)128;//数据类型强转
		System.out.println(a);
		int i=(int) 2.5;//赋值的是double
		System.out.println(i);
		//小转大 类型自动提升（往大的数据类型）
		i=127;
		System.out.println(i);
		double d=i;//i=127
		System.out.println(d);
		//思考1
		long l=9999999999L;
		System.out.println(l);
		float f=2.5f;
		System.out.println(f);
	}

}
