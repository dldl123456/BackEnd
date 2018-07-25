/**
 * 该类继承了父类D并实现了接口A和接口B
 * 必须实现(重写)接口A和接口B的抽象方法
 *
 */

package note.oop.absinfDemo;

public class E extends D implements A,B {
    @Override
    public void m2() {
        System.out.println("实现了接口B中的m2抽象方法");
    }

    @Override
    public void m1() {
        System.out.println("实现了接口A中m1抽象方法");
    }
    
    //测试类
    public static void main(String[] args) {
        E  e = new E();//类本身进行new
        e.m1();
        e.m2();
        e.test();
        System.out.println("-------------------------");
        D  e2 = new E();//用父类new子类,向上转型,只能访问父类中的test方法
        e2.test();
        System.out.println("-------------------------");
        A  e3 = new E();//利用接口A创建实现类,向上转型,只能访问接口A中定义的m1方法
        e3.m1();
        System.out.println("--------------------------");
        B  e4 = new E();//利用接口B创建实现类,只能访问接口A中定义的m2方法
        e4.m2();
        
    }
}
