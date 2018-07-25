/*
 *  TestTextDemo 文本输入框
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
        //创建窗口  
        JFrame jf = new JFrame("这是第一个窗口");  
        JPanel jp = new JPanel();  
        //设置当前面板的布局  
        //设置成绝对定位  
        jp.setLayout(null);  
        JLabel jl = new JLabel("用户名");  
        jl.setBounds(0, 0, 60, 20);  
        //文本输入框  
        JTextField jt = new JTextField();  
        //jt.setSize(100, 20);  
        jt.setBounds(60, 0, 100, 20);  
        //添加密码框  
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
          
        //将标签加入到窗口类中  
        jf.add(jp);  
        //设置当前窗口的 位置和大小  
        jf.setBounds(0, 0, 300, 300);  
        //设置当前窗口可见  
        jf.setVisible(true);  
    }  
}
