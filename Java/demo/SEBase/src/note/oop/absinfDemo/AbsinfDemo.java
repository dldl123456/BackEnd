/*
	* *接口定义:使用interface关键字
	* [修饰符] interface 接口名 [extends 父接口1,父接口2...]{
	* //常量的声明
	* //方法的声明
	* }
	*接口成员的特点:
	*1.接口中所有的成员变量是常量，默认修饰符为public static final 
	*2.接口中所有的方法都是抽象方法，默认修饰符为:public abstract
	*3.接口不能实例化，接口不能构造方法(抽象类不能实例化，但可以有构造方法)
	*4.java类是单继承，但接口可以是多继承
	*5.一个非抽象类实现实现接口，必须重写接口中的抽象方法，抽象类实现接口可以重写部分抽象方法。
	*6.一个类只能继承一个父类，但可以实现多个接口
	*7.接口中被重写N次的方法，最后调用，调用的都是最后一次被重写的方法。
	*如果一个类继承父类并实现了接口如何编写?
	* [修饰符] class 类名 [extends 父类名 implements 接口名1,接口名2..]{
	* }
	* eg:
	* public class E extends D implements A,B{
	* 
	* }
 */

package note.oop.absinfDemo;

public class AbsinfDemo {

}
