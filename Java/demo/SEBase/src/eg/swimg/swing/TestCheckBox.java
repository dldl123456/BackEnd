/*
 *  TestCheckBox ��ѡ��
 */

package eg.swimg.swing;

import java.util.Vector;  

import javax.swing.BorderFactory;  
/*import javax.swing.ButtonGroup;  
import javax.swing.JButton;  
import javax.swing.JCheckBox;*/  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
/*import javax.swing.JLabel;  */
import javax.swing.JPanel;  
/*import javax.swing.JPasswordField;  
import javax.swing.JRadioButton;  
import javax.swing.JTextField;*/

public class TestCheckBox{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {  
        JFrame jf = new JFrame("���ǵ�һ������");  
        JPanel jp = new JPanel();  
        jp.setBorder(BorderFactory.createTitledBorder("����"));  
        //���ö�ѡ��  
        /* 
        JCheckBox jc = new JCheckBox("fish"); 
        JCheckBox jc2 = new JCheckBox("football"); 
        JCheckBox jc3 = new JCheckBox("cooking"); 
         
        jp.add(jc); 
        jp.add(jc2); 
        jp.add(jc3);  
          
        //���õ�ѡ��ť 
        JRadioButton jr = new JRadioButton("��"); 
        JRadioButton jr2 = new JRadioButton("Ů"); 
        //ͨ����ť�����õ�ǰֻ��ѡ��һ�� 
        ButtonGroup jb = new ButtonGroup(); 
        jb.add(jr2); 
        jb.add(jr); 
         
        jp.add(jr); 
        jp.add(jr2);  
          
        //��ť  
        JButton jb = new JButton("�ύ"); 
        jp.add(jb);*/  
          
          
        //������  
        Vector data = new Vector();  
        data.add("��ɳ");  
        data.add("����");  
        data.add("��̶");  
        data.add("����");  
          
          
        JComboBox  jcb = new JComboBox(data);  
          
        jp.add(jcb);  
        //����ǩ���뵽��������  
        jf.add(jp);  
        //���õ�ǰ���ڵ� λ�úʹ�С  
        jf.setBounds(0, 0, 300, 300);  
        //���õ�ǰ���ڿɼ�  
        jf.setVisible(true);  
    }  
}
