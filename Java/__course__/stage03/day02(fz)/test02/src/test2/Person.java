/*
 *  依次完成以下功能代码:
 *  (1) 定义一个(Person)类,包含属性：姓名,年龄,性别；写好相关的方法,能够构造的时候初始化或者后续修改属性值。
 *  (2) 定义一个Employee类继承于Person类，包含新的属性：职位；写好相关的方法，
 *  能够构造的时候初始化或者后续修改属性值，重写equals方法，
 *  规则：当两个对象的姓名，年龄，性别，职位都相等时返回true，否则返回false。
 *  (3) 写一个测试类进行相关测试（要求可以打印对象的信息，能够比较对象是否"相等"）。
 *  
 *  效果：
 *  	两位职员信息如下：
 *  	name:Jim age:28 sex:男 position:软件工程师
 *  	name:Tom age:28 sex:男 position:软件工程师
 *  	判断两位职员是否“相等"
 *  	false
 */

package test2;

public class Person {
	//定义Person类私有属性
	private String name;  //姓名
	private int age;  //年龄
	private char sex;  //性别
	
	//用get,set方法给Person类私有属性开放接口
	//name
	public String getName() {  //获取name
		return name;
	}
	public void setName(String name) {  //定义name
		this.name = name;
	}
	//age
	public int getAge() {  //获取age
		return age;
	}
	public void setAge(int age) {  //定义age
		if(age>0){
			this.age = age;
		}
	}
	//sex
	public char getSex() {  //获取sex
		return sex;
	}
	public void setSex(char sex) {  //定义sex
		this.sex = sex;
	}

	//构造函数初始化变量
	public Person(String name, int age, char sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}
