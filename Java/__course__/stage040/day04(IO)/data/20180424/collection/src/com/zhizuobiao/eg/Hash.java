package com.zhizuobiao.eg;

public class Hash {
	// 伪代码
	// User
	// hash值 == 算法（算出一个值，有可能冲突（一样）），一旦冲突 它再去判断equlas是否相同。如果在相同就是同一对象，不同就是不同带对象。
	// new User(1,姚明，32，上海) -- abcd
	// new User(2,刘德华，52，香港) -- ab12（相同）
	// new User(3,刘德华，12，香港) -- ab12（相同）
}
