package com.zhizuobiao.homework;

//eg
//
//public static void sum(int number) {
//	if (number != 0) {
//		sum(--number);
//		System.out.println(number);
//	}
//}
//
//
//number=5
//��һ�Σ��ж�����������sum��number=4 ��(->print()) 4 ^
//�ڶ��Σ��ж�����������sum��number=3 ��(->print()) 3 ^
//�����Σ��ж�����������sum��number=2 ��(->print()) 2 ^
//���ĴΣ��ж�����������sum��number=1 ��(->print()) 1 ^
//����Σ��ж�����������sum��number=0 ��(->print()) 0 ^
//�����Σ��ж������������㡣����������������һ����^

public class DiGui {

	public static void main(String[] args) {
		// 1��2��3��4��.....��10 ���

//		int result = sum(5);
//		System.out.println("result=" + result);
		
		System.out.println("result2=" + sum2(5));
	}

	public static int sum2(int number) {

		if (number == 0) {
			return 0;
		}

		return number + sum2(--number);
	}
	
	// number + sum2(--number) --> 5 + {number=4} ; 5 + (4 + (3 + (2 + (1+0))))
	// number + sum2(--number) --> 4 + {number=3} ; 4 + (3 + (2 + (1+0)))
	// number + sum2(--number) --> 3 + {number=2} ; 3 + (2 + (1+0))
	// number + sum2(--number) --> 2 + {number=1} ; 2 + (1+0)
	// number + sum2(--number) --> 1 + {number=0} ; 1 + 0
	// number + sum2(--number) --> 0 ���� ;
	

	static int count = 0;

	public static int sum(int number) {

		if (number != 0) {

			// System.out.println(number);
			sum(--number);
			// 0 = 0 + number;
			count = count + number;

			System.out.println(number);
			System.out.println("count=" + count);
		}

		return count;
	}
}
