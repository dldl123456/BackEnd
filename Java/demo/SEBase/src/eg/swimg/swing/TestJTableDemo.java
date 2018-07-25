/*
 *  TestJTabbedPane 标签面板
 */

package eg.swimg.swing;

import java.util.Vector;  

import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
//import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
//import javax.swing.table.DefaultTableModel;  

public class TestJTableDemo {  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <vector> void main(String[] args) {  
        JFrame jf = new JFrame("显示");  
        //JPanel jp = new JPanel();  
          
        /*String[] title = {"empno","ename","job"}; 
        String[][] data = { 
                {"123","hello","salesman"}, 
                {"234","hello","salesman"}, 
                {"345","hello","salesman"}, 
                {"456","hello","salesman"} 
                };*/  
          
        Vector title = new Vector();  
        title.add("empno");  
        title.add("ename");  
        title.add("job");  
          
        Vector<vector> data = new Vector<vector>();  
          
        Vector row1 = new Vector();  
        row1.add("123");  
        row1.add("xxx");  
        row1.add("salesman");  
          
        data.add((vector) row1);  
          
        JTable jt = new JTable(data,title);  
        JScrollPane jp = new JScrollPane(jt);  
          
        jp.setBorder(BorderFactory.createTitledBorder("用户信息"));  
          
        jf.add(jp);  
        jf.setBounds(200, 200, 400, 400);  
        jf.setVisible(true);  
          
          
    }  
}  
