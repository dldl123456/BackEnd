/*
 *  �����ڲ��ࣺ
 *  1.�ڷ����ж�����ڲ��ࡣ
 *  2.������ڲ�����Ҫ���ʷ����оֲ��������þֲ�����ǰ�����final��
 *  3.�����ڲ�������ڲ��ඨ�����ⲿ��ķ����У������ڲ���ֻ�ڸ÷������ڲ��ɼ�����ֻ�ڸ÷����ڿ���ʹ�á�
 *  ���ڷ����ڲ��಻�����ⲿ��ķ�������ĵط�ʹ�ã���˷����ڲ��಻��ʹ�÷��ʿ��Ʒ��� static ���η���
 */

package eg.oop.innerClass;

//�ⲿ��  
public class HelloWorld {  
    
  private String name = "���Կγ�";  
    
  // �ⲿ���е�show����  
  public void show() {   
      // ���巽���ڲ���  
      class MInner {  
          int score = 78;  
          public int getScore() {  
              return score + 10;  
          }  
      }  
        
      // ���������ڲ���Ķ���  
      MInner mi = new MInner();  
        
      // �����ڲ���ķ���  
      int newScore = mi.getScore();  
        
      System.out.println("������" + name + "\n�ӷֺ�ĳɼ���" + newScore);  
  }  
    
  // ���Է����ڲ���  
  public static void main(String[] args) {  
        
      // �����ⲿ��Ķ���  
        
      HelloWorld mo = new HelloWorld();  
      // �����ⲿ��ķ���  
      mo.show();  
  }  
}  
