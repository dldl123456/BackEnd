/*
 *  (1)定义一个接口CanCry，描述会吼叫的方法public void cry()。
 *  (2)分别定义狗类（Dog）和猫类（Cat），实现CanCry接口。实现方法的功能分别为：     打印输出“我是狗，我的叫声是汪汪汪”、“我是猫，我的叫声是喵喵喵”。
 *  (3)定义一个主类G，  
 *  	①定义一个void makeCry(CanCry c)方法，其中让会吼叫的事物吼叫。 
 *  	②在main方法中创建狗类对象（dog）、猫类对象（cat）、G类对象（g），用调用makecry方法，让狗和猫吼叫。
 *  
 */

package test1;

//一个描述吼叫的接口
public interface CanCry {
	//声明抽象方法
	void cry();
}
