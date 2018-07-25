package eg.oop.innerClass;

public class Outclass {//外部类
    private String name="name";
    private int num1=1;
    public void show1(){
        System.out.println("外部方法");
    }
     public class intclass{//内部类
        private int num1=2;
        public void show(){
            System.out.println("内部方法");
            System.out.println(num1);
            System.out.println(name);//访问外部类的不同名成员
            System.out.println(Outclass.this.num1);//访问外部类的同名成员
            show1();//访问外部类的方法
        }
    }
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        Outclass o=new Outclass();
        /*
         * 创建内部类的实例:
         * 外部类.内部类 对象名 = new 外部类().new 内部类();
         */
        Outclass.intclass i=new Outclass().new intclass();
        
//        i.show1();  不能调用外部类的成员和方法
        i.show();
    }
}
