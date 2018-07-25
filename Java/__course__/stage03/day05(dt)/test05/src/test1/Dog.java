package test1;

//Dog类调用接口
public class Dog implements CanCry {
	//对接口中的抽象方法进行具体实现
    public void cry() {
        System.out.println("狗，叫声是汪汪汪");
    }
}
