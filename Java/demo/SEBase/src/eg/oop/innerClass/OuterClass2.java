/*
 *静态内部类:使用static修饰的内部类。静态内部只能访问外部的静态成员。
 *
 */

package eg.oop.innerClass;

//外部类
public class OuterClass2 {
  //外部类的成员
  private static String name="zhangsan";
  private static int num=10;
  //外部类的方法
  public void outerMethod(){
//      System.out.println(a);//外部类不能访问内部类的成员
  }
  //内部类
  public static class InnerClass{
      //内部类的成员
      private int num=20;
      @SuppressWarnings("unused")
	private int a=30;
      //内部类的方法
      public void innerMethod(){
          System.out.println("OuterClass--->name="+name);//内部类可以访问外部类的成员
          System.out.println("OuterClass--->num="+OuterClass2.num);//外部类的成员
          System.out.println("InnerClass--->num="+this.num);//内部类的成员
      }
  }
  
  public static void main(String[] args) {
      /*
       * 创建静态内部类的实例:
       * 外部类.内部类 对象名 = new 外部类.内部类();
       */
      OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
      innerClass.innerMethod();
      
  }
  
}
