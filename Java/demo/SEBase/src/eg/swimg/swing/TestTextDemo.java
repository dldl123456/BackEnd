/*
 *  TestTextDemo �ı������
 */

package eg.swimg.swing;

import javax.swing.JCheckBox;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JPasswordField;  
import javax.swing.JTextField; 

public class TestTextDemo {
	public static void main(String[] args) {  
        //��������  
        JFrame jf = new JFrame("���ǵ�һ������");  
        JPanel jp = new JPanel();  
        //���õ�ǰ���Ĳ���  
        //���óɾ��Զ�λ  
        jp.setLayout(null);  
        JLabel jl = new JLabel("�û���");  
        jl.setBounds(0, 0, 60, 20);  
        //�ı������  
        JTextField jt = new JTextField();  
        //jt.setSize(100, 20);  
        jt.setBounds(60, 0, 100, 20);  
        //��������  
        JPasswordField jpwd = new JPasswordField();  
        //jpwd.setSize(100, 20);  
        jpwd.setBounds(160, 0, 100, 20);  
          
        JCheckBox jc = new JCheckBox("fish");  
        JCheckBox jc2 = new JCheckBox("football");  
        JCheckBox jc3 = new JCheckBox("cooking");  
          
        jc.setBounds(0, 30, 50, 20);  
          
        jp.add(jl);  
        jp.add(jt);  
        jp.add(jpwd);  
          
        jp.add(jc);  
        jp.add(jc2);  
        jp.add(jc3);  
          
        //����ǩ���뵽��������  
        jf.add(jp);  
        //���õ�ǰ���ڵ� λ�úʹ�С  
        jf.setBounds(0, 0, 300, 300);  
        //���õ�ǰ���ڿɼ�  
        jf.setVisible(true);  
    }  
}
