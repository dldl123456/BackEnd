/*
 *  方法内部类：
 *  1.在方法中定义的内部类。
 *  2.如果该内部类需要访问方法中局部变量，该局部变量前必须加final。
 *  3.方法内部类就是内部类定义在外部类的方法中，方法内部类只在该方法的内部可见，即只在该方法内可以使用。
 *  由于方法内部类不能在外部类的方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符。
 */

package eg.oop.innerClass;

//外部类  
public class HelloWorld {  
    
  private String name = "考试课程";  
    
  // 外部类中的show方法  
  public void show() {   
      // 定义方法内部类  
      class MInner {  
          int score = 78;  
          public int getScore() {  
              return score + 10;  
          }  
      }  
        
      // 创建方法内部类的对象  
      MInner mi = new MInner();  
        
      // 调用内部类的方法  
      int newScore = mi.getScore();  
        
      System.out.println("姓名：" + name + "\n加分后的成绩：" + newScore);  
  }  
    
  // 测试方法内部类  
  public static void main(String[] args) {  
        
      // 创建外部类的对象  
        
      HelloWorld mo = new HelloWorld();  
      // 调用外部类的方法  
      mo.show();  
  }  
}  
