package com.zhizuobiao.exception;

/**
 * 自定义异常
 */
public class TestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TestException(String message) {
		super(message);
	}

}
