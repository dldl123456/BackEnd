/*
 *  TestUNEditeTable 不可编辑的表格
 */

package eg.swimg.swing;

import java.util.Vector;  

import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableModel;

public class TestUNEditeTable {
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public static <vector> void main(String[] args) {  
        JFrame jf = new JFrame("显示");  
          
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
          
        DefaultTableModel mode = new DefaultTableModel(data,title){  
  
            @Override  
            public boolean isCellEditable(int row, int column) {  
                  
                return false;  
            }  
              
        };  
          
          
        JTable jt = new JTable(mode);  
        JScrollPane jp = new JScrollPane(jt);  
          
        jp.setBorder(BorderFactory.createTitledBorder("用户信息"));  
          
        jf.add(jp);  
        jf.setBounds(200, 200, 400, 400);  
        jf.setVisible(true);  
    }  
}
