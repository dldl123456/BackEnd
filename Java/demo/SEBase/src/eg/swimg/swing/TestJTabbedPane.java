/*
 *  TestJTabbedPane ��ǩ���
 */

package eg.swimg.swing;

import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JTabbedPane; 

public class TestJTabbedPane {
	public static void main(String[] args) {  
        JFrame jf = new JFrame();  
        JTabbedPane jtp = new JTabbedPane();  
        JPanel j1 = new JPanel();  
        j1.add(new JLabel("��һ��"));  
        j1.setBorder(BorderFactory.createTitledBorder("Ա��"));  
        JPanel j2 = new JPanel();  
        j2.add(new JLabel("�ڶ���"));  
        jtp.add("Ա����Ϣ��",j1);  
        jtp.add("������Ϣ��",j2);  
        jf.add(jtp);  
        jf.setBounds(200, 200, 300, 300);  
        jf.setVisible(true);  
          
    }  
}
