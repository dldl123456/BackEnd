/*
 *��̬�ڲ���:ʹ��static���ε��ڲ��ࡣ��̬�ڲ�ֻ�ܷ����ⲿ�ľ�̬��Ա��
 *
 */

package eg.oop.innerClass;

//�ⲿ��
public class OuterClass2 {
  //�ⲿ��ĳ�Ա
  private static String name="zhangsan";
  private static int num=10;
  //�ⲿ��ķ���
  public void outerMethod(){
//      System.out.println(a);//�ⲿ�಻�ܷ����ڲ���ĳ�Ա
  }
  //�ڲ���
  public static class InnerClass{
      //�ڲ���ĳ�Ա
      private int num=20;
      @SuppressWarnings("unused")
	private int a=30;
      //�ڲ���ķ���
      public void innerMethod(){
          System.out.println("OuterClass--->name="+name);//�ڲ�����Է����ⲿ��ĳ�Ա
          System.out.println("OuterClass--->num="+OuterClass2.num);//�ⲿ��ĳ�Ա
          System.out.println("InnerClass--->num="+this.num);//�ڲ���ĳ�Ա
      }
  }
  
  public static void main(String[] args) {
      /*
       * ������̬�ڲ����ʵ��:
       * �ⲿ��.�ڲ��� ������ = new �ⲿ��.�ڲ���();
       */
      OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
      innerClass.innerMethod();
      
  }
  
}
