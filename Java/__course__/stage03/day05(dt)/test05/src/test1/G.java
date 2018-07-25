package test1;

public class G {
	//让会吼叫的事物吼叫的方法
	void makeCry(CanCry c){
        c.cry();
    }
	
	//主方法（程序入口）
	public static void main(String[] args) {
		Cat cat = new Cat();  //实例化Cat类，创建cat对象
        Dog dog = new Dog();  //实例化Dog类，创建dog对象
        G g = new G();  //实例化G类，创建g对象
        
        //调用makeCry实现让动物吼叫
        g.makeCry(cat);
        g.makeCry(dog);
	}
}
