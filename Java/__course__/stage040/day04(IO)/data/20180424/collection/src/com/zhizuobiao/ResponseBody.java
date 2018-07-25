package com.zhizuobiao;

/**
 * 统一返回内容格式： 服务器提供的数据接口格式 {state,length,content{电脑、手机、饮料}}
 * 
 * 使用者：直接new，设置对象对应的参数
 */
public class ResponseBody<T> {
	// {state,length,content{电脑、手机、饮料、User}}
	private int state;
	private long length;

	// public abstract void setTTT(T t);

	// 设置数据
	public void setData(T t) { // User

	}

	/**
	 * 泛型方法
	 */
	public <W> void setHead(W w) {
		System.out.println(w);
	}

	public static <Y> void staticMethod(Y y) {

	}
}
