package com.zhizuobiao;

import com.zhizuobiao.controller.UserController;

public class Run {

	public static void main(String[] args) {

		UserController userController = new UserController();
		userController.start();
	}
}
