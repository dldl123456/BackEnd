package com.zhizuobiao;

/**
 * ͳһ�������ݸ�ʽ�� �������ṩ�����ݽӿڸ�ʽ {state,length,content{���ԡ��ֻ�������}}
 * 
 * ʹ���ߣ�ֱ��new�����ö����Ӧ�Ĳ���
 */
public class ResponseBody<T> {
	// {state,length,content{���ԡ��ֻ������ϡ�User}}
	private int state;
	private long length;

	// public abstract void setTTT(T t);

	// ��������
	public void setData(T t) { // User

	}

	/**
	 * ���ͷ���
	 */
	public <W> void setHead(W w) {
		System.out.println(w);
	}

	public static <Y> void staticMethod(Y y) {

	}
}
