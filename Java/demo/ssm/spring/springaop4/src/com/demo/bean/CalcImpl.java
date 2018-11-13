package com.demo.bean;

import org.springframework.stereotype.Component;

//实例化（委托类）
@Component(value="calc")
public class CalcImpl implements Calc {

	@Override
	public int add(int x, int y) {
		System.out.println("add....");
		return x+y;
	}

	@Override
	public int div(int x, int y) {
		System.out.println("div....");
		return x/y;
	}

	@Override
	public void mul(int x, int y) {
		System.out.println("x*y=...."+(x*y));
	}

}
