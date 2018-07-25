/*
 *  TestJLabelDemo ±Í«©
 */

package eg.swimg.swing;

import java.awt.Container;  

import javax.swing.JFrame;  
import javax.swing.JLabel;  

public class TestJLabelDemo {
	public static void main(String[] args) {  
        JFrame jf = new JFrame();  
        Container c = jf.getContentPane();  
        JLabel jl = new JLabel("xsdssf");  
        c.add(jl);  
        jf.setBounds(200, 200, 400, 400);  
        jf.setVisible(true);  
    }  
}
