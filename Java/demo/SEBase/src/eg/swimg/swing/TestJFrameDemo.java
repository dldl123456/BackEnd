/*
 *  TestJFrameDemo 窗口
 */

package eg.swimg.swing;

import javax.swing.JFrame;  
import javax.swing.JLabel;  

public class TestJFrameDemo {
	public static void main(String[] args) {  
        //创建窗口  
        JFrame jf = new JFrame("这是第一个窗口");  
        //创建标签类  
        JLabel jl = new JLabel("hello world");  
        //将标签加入到窗口类中  
        jf.add(jl);  
        //设置当前窗口的 位置和大小  
        jf.setBounds(0, 0, 300, 300);//设置当前窗口的位置和大小x,y,width,height  
        //设置当前窗口可见  
        jf.setVisible(true);  
    }  
}
