/*
 *  TestJFrameDemo ����
 */

package eg.swimg.swing;

import javax.swing.JFrame;  
import javax.swing.JLabel;  

public class TestJFrameDemo {
	public static void main(String[] args) {  
        //��������  
        JFrame jf = new JFrame("���ǵ�һ������");  
        //������ǩ��  
        JLabel jl = new JLabel("hello world");  
        //����ǩ���뵽��������  
        jf.add(jl);  
        //���õ�ǰ���ڵ� λ�úʹ�С  
        jf.setBounds(0, 0, 300, 300);//���õ�ǰ���ڵ�λ�úʹ�Сx,y,width,height  
        //���õ�ǰ���ڿɼ�  
        jf.setVisible(true);  
    }  
}
