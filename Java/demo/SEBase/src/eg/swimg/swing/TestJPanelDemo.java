/*
 *  TestJPanelDemo ���
 */

package eg.swimg.swing;

import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  

public class TestJPanelDemo {
    public static void main(String[] args) {  
        JFrame jf = new JFrame("xx");  
        //����һ���������  
        JPanel jp = new JPanel();  
        jp.setBorder(BorderFactory.createTitledBorder("��һ����Ϣ"));  
          
        JLabel jl = new JLabel("hello");  
        jp.add(jl);  
        jf.add(jp);  
        //jf.setSize(width, height)  
        //jf.setLocation(x, y)  
        jf.setBounds(200, 200, 300, 300);  
        jf.setVisible(true);  
    }  
}
