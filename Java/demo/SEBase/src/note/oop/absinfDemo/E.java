/**
 * ����̳��˸���D��ʵ���˽ӿ�A�ͽӿ�B
 * ����ʵ��(��д)�ӿ�A�ͽӿ�B�ĳ��󷽷�
 *
 */

package note.oop.absinfDemo;

public class E extends D implements A,B {
    @Override
    public void m2() {
        System.out.println("ʵ���˽ӿ�B�е�m2���󷽷�");
    }

    @Override
    public void m1() {
        System.out.println("ʵ���˽ӿ�A��m1���󷽷�");
    }
    
    //������
    public static void main(String[] args) {
        E  e = new E();//�౾�����new
        e.m1();
        e.m2();
        e.test();
        System.out.println("-------------------------");
        D  e2 = new E();//�ø���new����,����ת��,ֻ�ܷ��ʸ����е�test����
        e2.test();
        System.out.println("-------------------------");
        A  e3 = new E();//���ýӿ�A����ʵ����,����ת��,ֻ�ܷ��ʽӿ�A�ж����m1����
        e3.m1();
        System.out.println("--------------------------");
        B  e4 = new E();//���ýӿ�B����ʵ����,ֻ�ܷ��ʽӿ�A�ж����m2����
        e4.m2();
        
    }
}
