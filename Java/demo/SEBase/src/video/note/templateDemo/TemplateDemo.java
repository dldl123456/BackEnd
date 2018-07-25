package video.note.templateDemo;

public class TemplateDemo {
	public static void main(String[] args) {
		Teacher t1 = new DBTeacher();
		t1.work();
		
		System.out.println("====================");
		
		Teacher t2 = new CTeacher();
		t2.work();
	}
}

//抽象类（有抽象方法的类叫抽象类）
//父类
abstract class Teacher{
	//授课前准备（每个老师都一样）
	public void prepared(){
		System.out.println("准备白板笔");
		System.out.println("打开投影仪");
	}
		
	//授课结束（每个老师都一样）
	public void end(){
		System.out.println("关闭投影仪");
		System.out.println("锁教室门");
	}
	
	//方法的声明，抽象方法，授课不同的老师不一样
	public abstract void teaching();
	
	//老师工作的方法（他是一个流程）
	//模板方法
	public void work(){
		//1、授课前准备
		prepared();
		//2、进行授课
		teaching();
		//3、授课结束
		end();
	}
}

//子类
class DBTeacher extends Teacher{
	//对抽象父类的抽象方法的实现
	public void teaching(){
		System.out.println("打开Oracle");
		System.out.println("书写pl-sql指令");
		System.out.println("优化sql指令");
	}
}

//子类
class CTeacher extends Teacher{
	//对抽象父类的抽象方法的实现
	public void teaching(){
		System.out.println("打开VM");
		System.out.println("书写C指令");
		System.out.println("调试C程序");
	}
}