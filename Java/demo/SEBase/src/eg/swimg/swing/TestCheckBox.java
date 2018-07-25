/*
 *  TestCheckBox 多选框
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
        JFrame jf = new JFrame("这是第一个窗口");  
        JPanel jp = new JPanel();  
        jp.setBorder(BorderFactory.createTitledBorder("城市"));  
        //设置多选框  
        /* 
        JCheckBox jc = new JCheckBox("fish"); 
        JCheckBox jc2 = new JCheckBox("football"); 
        JCheckBox jc3 = new JCheckBox("cooking"); 
         
        jp.add(jc); 
        jp.add(jc2); 
        jp.add(jc3);  
          
        //设置单选按钮 
        JRadioButton jr = new JRadioButton("男"); 
        JRadioButton jr2 = new JRadioButton("女"); 
        //通过按钮组设置当前只能选中一个 
        ButtonGroup jb = new ButtonGroup(); 
        jb.add(jr2); 
        jb.add(jr); 
         
        jp.add(jr); 
        jp.add(jr2);  
          
        //按钮  
        JButton jb = new JButton("提交"); 
        jp.add(jb);*/  
          
          
        //下拉框  
        Vector data = new Vector();  
        data.add("长沙");  
        data.add("株洲");  
        data.add("湘潭");  
        data.add("益阳");  
          
          
        JComboBox  jcb = new JComboBox(data);  
          
        jp.add(jcb);  
        //将标签加入到窗口类中  
        jf.add(jp);  
        //设置当前窗口的 位置和大小  
        jf.setBounds(0, 0, 300, 300);  
        //设置当前窗口可见  
        jf.setVisible(true);  
    }  
}
