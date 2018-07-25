/*
 *  方法练习
 */

package video.note.methodDemo;

public class MethodDemo {
	int num = 30;
	
	public void method1(){
		System.out.println("返回类型为空且无参数的方法");
	}
	
	public String method2(){
		return "带有具体返回类型且无参数的方法";
	}
	
	public void method3(String name){
		System.out.println("返回类型为空且带有参数的方法，参数的值为" + name);
	}
	
	public String method4(String name, int age){
		return "带有具体返回类型，且带有多个参数的方法，参数的值为" + name + "," + age;
	}
	
	//传递基本数据类型的方法
	public void operatorData(int age){
		age++;
		System.out.println(age);
	}
	
	//传递引用数据类型
	public void operatorArr(int[] array){
		array[2] = 100;
		System.out.println(array[2]);
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		//创建对象
		MethodDemo demo = new MethodDemo();
		
		//调用方法
		demo.method1();  //方法1
		
		String str2 = demo.method2();  //方法2
		System.out.println(str2);  //（主方法调用，没接收）
		
		demo.method3("cmcc");  //方法3
		
		String str4 = demo.method2();  //方法4
		System.out.println(str4);  //（主方法调用，没接收）
		
		int age = 10;
		demo.operatorData(age);
		System.out.println(age);  //operatorData
		
		int[] array = {1,2,3,4};
		demo.operatorArr(array);
		System.out.println(array[2]);  //operatorArr
	}
}
