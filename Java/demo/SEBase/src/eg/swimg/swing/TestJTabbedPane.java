/*
 *  TestJTabbedPane 标签面板
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
        j1.add(new JLabel("第一个"));  
        j1.setBorder(BorderFactory.createTitledBorder("员工"));  
        JPanel j2 = new JPanel();  
        j2.add(new JLabel("第二个"));  
        jtp.add("员工信息表",j1);  
        jtp.add("部门信息表",j2);  
        jf.add(jtp);  
        jf.setBounds(200, 200, 300, 300);  
        jf.setVisible(true);  
          
    }  
}
