/*
 *  TestJPanelDemo 面板
 */

package eg.swimg.swing;

import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  

public class TestJPanelDemo {
    public static void main(String[] args) {  
        JFrame jf = new JFrame("xx");  
        //创建一个面板容器  
        JPanel jp = new JPanel();  
        jp.setBorder(BorderFactory.createTitledBorder("第一个信息"));  
          
        JLabel jl = new JLabel("hello");  
        jp.add(jl);  
        jf.add(jp);  
        //jf.setSize(width, height)  
        //jf.setLocation(x, y)  
        jf.setBounds(200, 200, 300, 300);  
        jf.setVisible(true);  
    }  
}
